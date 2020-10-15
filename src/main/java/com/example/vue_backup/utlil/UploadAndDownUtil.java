package com.example.vue_backup.utlil;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;


import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;


public class UploadAndDownUtil {
    private static final String filePath = "d:/upload/"; // 文件上传路径
    private static final String folderdown="D:\\down\\";//文件下载路径
    public Map<String,Object> upload (MultipartFile file) {
        Map<String,Object> map=new HashMap<>();
        // 获取原始名字
        String fileName = file.getOriginalFilename();
        // 获取后缀名
        // String suffixName = fileName.substring(fileName.lastIndexOf("."));
        // 文件重命名，防止重复
        fileName = UUID.randomUUID() + fileName;
        // 文件对象
        File dest = new File(filePath+fileName);
        // 判断路径是否存在，如果不存在则创建
        if(!dest.getParentFile().exists()) {
            dest.getParentFile().mkdirs();
        }
        try {
            map.put("flag",true);
            map.put("fileName",fileName);
            // 保存到服务器中
            file.transferTo(dest);
            return map;
        } catch (Exception e) {
            e.printStackTrace();
        }
        map.put("flag",false);
        return map;
    }
    public void download(HttpServletResponse response, String fileName) throws Exception {
        // 文件地址，真实环境是存放在数据库中的
        File file = new File(folderdown+fileName);
        // 穿件输入对象
        FileInputStream fis = new FileInputStream(file);
        // 设置相关格式
        response.setContentType("application/force-download");
        // 设置下载后的文件名以及header
        response.addHeader("Content-disposition", "attachment;fileName=" + fileName);
        // 创建输出对象
        OutputStream os = response.getOutputStream();
        // 常规操作
        byte[] buf = new byte[1024];
        int len = 0;
        while((len = fis.read(buf)) != -1) {
            os.write(buf, 0, len);
        }
        fis.close();
    }
}
