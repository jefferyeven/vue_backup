package com.example.vue_backup.service;

        import org.springframework.web.multipart.MultipartFile;

        import javax.servlet.http.HttpServletResponse;
        import java.util.Map;

public interface UploadAndDownService {
    Map<String,Object> upload(MultipartFile multipartFile);
    void  download(HttpServletResponse response, String fileName);
}
