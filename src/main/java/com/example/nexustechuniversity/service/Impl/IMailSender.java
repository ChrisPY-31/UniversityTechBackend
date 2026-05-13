package com.example.nexustechuniversity.service.Impl;

import com.example.nexustechuniversity.Dto.RegisterRequest;

public interface IMailSender {

    void sendWelcomeEmail(RegisterRequest request);
}
