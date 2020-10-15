package com.example.vue_backup.utlil;

import lombok.SneakyThrows;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ImageUtil {
    private static final String folderupload="D:\\upload\\";
    private static final String folderdown="D:\\down\\";
    @SneakyThrows
    //替换颜色
    public boolean insteadcolor(String imagesrc, String colorfrom, String colorto)
    {
        try {
            int colorfromInt= toColorFromString(colorfrom).getRGB();//将字符串转为int
            int colortoInt= toColorFromString(colorto).getRGB();;
            File file = new File(folderupload+imagesrc);
            BufferedImage image = ImageIO.read(file);
            for (int i = 0; i < image.getHeight(); i++) {
                for (int j = 0; j < image.getWidth(); j++) {
                    int color = image.getRGB(j, i);
                    if(color==colorfromInt)
                    {
                        image.setRGB(j,i,colortoInt);
                    }
                }
            }
            ImageIO.write(image,imagesrc.substring(imagesrc.length()-3), new File(folderdown + imagesrc));
        }catch (IOException e)
        {
            return false;
        }

        return true;
    }
    //将string 转为color型
    public static Color toColorFromString(String colorStr){
        String str1 = colorStr.substring(1, 3);
        String str2 = colorStr.substring(3, 5);
        String str3 = colorStr.substring(5, 7);
        int red = Integer.parseInt(str1, 16);
        int green = Integer.parseInt(str2, 16);
        int blue = Integer.parseInt(str3, 16);
        Color color =  new Color(red,green,blue) ;
        //java.awt.Color[r=0,g=0,b=255]
        return color;
    }
}
