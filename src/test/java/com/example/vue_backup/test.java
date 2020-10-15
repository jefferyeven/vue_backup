package com.example.vue_backup;

import com.example.vue_backup.utlil.ImageUtil;
import org.junit.jupiter.api.Test;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class test {
    @Test
    void test() throws IOException {
        String folderupload="D:\\upload\\";
        String folderdown="D:\\down\\";
        String imagesrc="0aad0810-1a54-4fee-a7c7-0ac77a141912SharedScreenshot.jpg";
        File file = new File(folderupload+imagesrc);
        BufferedImage image = ImageIO.read(file);
        for (int i = 0; i < image.getHeight(); i++) {
            for (int j = 0; j < image.getWidth(); j++) {
                int color = image.getRGB(j, i);
                // convert the color to a readable format\
                int colorInt = 0x5590ec;
                image.setRGB(j,i,colorInt);
            }
        }
        ImageIO.write(image,imagesrc.substring(imagesrc.length()-3), new File(folderdown + imagesrc));
    }
    @Test
    void testtwo()
    {
        String imagesrc="0aad0810-1a54-4fee-a7c7-0ac77a141912SharedScreenshot.jpg";
        ImageUtil imageUtil=new ImageUtil();
        imageUtil.insteadcolor(imagesrc,"#ffffff","#000000");
    }


}
