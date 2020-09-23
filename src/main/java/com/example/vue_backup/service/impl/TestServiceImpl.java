package com.example.vue_backup.service.impl;

import com.example.vue_backup.service.TestService;
import org.springframework.stereotype.Service;

@Service
public class TestServiceImpl implements TestService {
    @Override
    public String getmessage(String msg) {
        return msg;
    }
}
