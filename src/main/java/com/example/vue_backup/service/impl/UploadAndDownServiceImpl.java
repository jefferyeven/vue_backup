package com.example.vue_backup.service.impl;

import com.example.vue_backup.service.UploadAndDownService;
import com.example.vue_backup.utlil.UploadAndDownUtil;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.util.Map;
@Service
public class UploadAndDownServiceImpl implements UploadAndDownService {
    UploadAndDownUtil uploadAndDownUtil=new UploadAndDownUtil();
    @Override
    public Map<String, Object> upload(MultipartFile multipartFile) {
        return uploadAndDownUtil.upload(multipartFile);
    }

    @Override
    public void download(HttpServletResponse response, String fileName) {
        try {
            uploadAndDownUtil.download(response,fileName);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
