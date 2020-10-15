package com.example.vue_backup.controller;

import com.example.vue_backup.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.Map;

@RestController
@CrossOrigin
public class ImageController {
    @Autowired
    ImageService imageService;
    @RequestMapping("insteadImageColor")
    public Map<String,Object> insteadImageColor(String imagesrc, String colorfrom, String colorto)
    {
        Map<String,Object> map=new HashMap<>();
        if(imageService.changeImageColor(imagesrc,colorfrom,colorto))
        {
            map.put("code",200);
            map.put("msg","替换成功");
        }else {
            map.put("code",500);
            map.put("msg","替换失败");
        }
        return map;
    }
}
