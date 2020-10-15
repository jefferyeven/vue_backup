package com.example.vue_backup.controller;

import com.example.vue_backup.service.UploadAndDownService;
import com.example.vue_backup.utlil.UploadAndDownUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@RestController
@CrossOrigin // 设置跨域支持
public class UploadAndDownController {
    @Autowired
    UploadAndDownService uploadAndDownService;
    @PostMapping("upload")
    public Map<String,Object> uploadfile(@RequestParam("file") MultipartFile file)
    {
        Map<String,Object> map=uploadAndDownService.upload(file);
        System.out.println(map.get("flag"));
        if((Boolean) map.get("flag"))
        {
            map.put("code",200);
            map.put("msg","上传成功");
        }else {
            map.put("code",500);
            map.put("msg","上传失败");
        }
        return map;
    }
    @RequestMapping("down")
    public Map<String,Object> downfile(HttpServletResponse response, String filename)
    {
        Map<String,Object> map=new HashMap<>();
        try {
            uploadAndDownService.download(response,filename);
            map.put("code",200);
            map.put("msg","下载成功");
        } catch (Exception e) {
            e.printStackTrace();
            map.put("code",500);
            map.put("msg","下载失败");
        }
        return map;
    }

}
