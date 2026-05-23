package com.example.nexustechuniversity.service;

import com.example.nexustechuniversity.Dto.CourseDto;
import com.example.nexustechuniversity.Dto.CourseResponseDto;
import com.example.nexustechuniversity.Model.Course;
import com.example.nexustechuniversity.Model.Person;
import com.example.nexustechuniversity.mapper.CourseMapper;
import com.example.nexustechuniversity.mapper.CourseResponseMapper;
import com.example.nexustechuniversity.repository.CursoRepository;
import com.example.nexustechuniversity.repository.PersonRepository;
import com.example.nexustechuniversity.service.Impl.ICourseService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class CourseService implements ICourseService {

    private final CursoRepository cursoRepository;
    private final PersonRepository personRepository;

    public CourseService(CursoRepository cursoRepository, PersonRepository personRepository) {
        this.cursoRepository = cursoRepository;
        this.personRepository = personRepository;
    }

    @Override
    public Page<CourseResponseDto> getPaginatedCursos(int pageNumber, int pageSize) {
        Pageable page = PageRequest.of(pageNumber, pageSize, Sort.by("idCourse").descending());
        return cursoRepository.findAll(page).map(CourseResponseMapper.INSTANCE::toCourseResponseDto);
    }

    @Override
    public CourseDto getCursoById(long idCurso) {
        return cursoRepository.findById(idCurso)
                .map(CourseMapper.INSTANCE::toCursoDto)
                .orElseThrow(() -> new NoSuchElementException("Curso no encontrado: " + idCurso));
    }

    @Override
    public CourseDto createCurso(CourseDto cursoDto) {
        Course course = CourseMapper.INSTANCE.toCurso(cursoDto);
        resolveInstructor(course, cursoDto.getInstructorId());
        return CourseMapper.INSTANCE.toCursoDto(cursoRepository.save(course));
    }

    @Override
    public CourseDto updateCurso(CourseDto cursoDto) {
        cursoRepository.findById(cursoDto.getIdCourse())
                .orElseThrow(() -> new NoSuchElementException("Curso no encontrado: " + cursoDto.getIdCourse()));
        Course course = CourseMapper.INSTANCE.toCurso(cursoDto);
        resolveInstructor(course, cursoDto.getInstructorId());
        return CourseMapper.INSTANCE.toCursoDto(cursoRepository.save(course));
    }

    @Override
    public void deleteCurso(long idCurso) {
        Course course = cursoRepository.findById(idCurso)
                .orElseThrow(() -> new RuntimeException("Error curso no encontrado"));
        cursoRepository.delete(course);
    }

    @Override
    public Page<CourseResponseDto> getCoursesByInstructor(Long instructorId, int pageNumber, int pageSize) {
        personRepository.findById(instructorId)
                .orElseThrow(() -> new NoSuchElementException("Instructor no encontrado: " + instructorId));
        Pageable page = PageRequest.of(pageNumber, pageSize, Sort.by("idCourse").descending());
        return cursoRepository.findByInstructor_IdPerson(instructorId, page)
                .map(CourseResponseMapper.INSTANCE::toCourseResponseDto);
    }

    private void resolveInstructor(Course course, Long instructorId) {
        if (instructorId != null) {
            Person instructor = personRepository.findById(instructorId)
                    .orElseThrow(() -> new NoSuchElementException("Instructor no encontrado: " + instructorId));
            course.setInstructor(instructor);
        }
    }
}
