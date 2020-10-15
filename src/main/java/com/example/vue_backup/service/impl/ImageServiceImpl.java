package com.example.vue_backup.service.impl;

import com.example.vue_backup.service.ImageService;
import com.example.vue_backup.utlil.ImageUtil;
import org.springframework.stereotype.Service;

@Service
public class ImageServiceImpl implements ImageService {
    ImageUtil imageUtil=new ImageUtil();
    @Override
    public Boolean changeImageColor(String imagesrc, String colorfrom, String colorto) {
        return imageUtil.insteadcolor(imagesrc,colorfrom,colorto);
    }
}
