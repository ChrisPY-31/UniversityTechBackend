package com.example.nexustechuniversity.service;

import com.example.nexustechuniversity.Dto.RegisterRequest;
import com.example.nexustechuniversity.service.Impl.IMailSender;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

@Service

public class MailSenderService implements IMailSender {

    private final JavaMailSender mailSender;
    private final TemplateEngine templateEngine;

    public MailSenderService(JavaMailSender mailSender, TemplateEngine templateEngine) {
        this.mailSender = mailSender;
        this.templateEngine = templateEngine;
    }

    @Override
    public void sendWelcomeEmail(RegisterRequest request) {
        try {
            MimeMessage message = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true, "UTF-8");

            helper.setTo(request.getEmail());
            helper.setSubject("Bienvenido a Nexus Tech University");

            Context context = new Context();
            context.setVariable("nombreUsuario", request.getName() + " " + request.getLastName());
            context.setVariable("usuario", request.getUsername());
            context.setVariable("contrasena", request.getPassword());
            context.setVariable("urlPlataforma", "http://localhost:8080");

            String html = templateEngine.process("index", context);
            helper.setText(html, true);

            mailSender.send(message);
        } catch (MessagingException e) {
            throw new RuntimeException("Error al enviar correo de bienvenida", e);
        }
    }
}
