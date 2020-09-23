# vue_backup
这个是一个vue使用的spring boot demo

# 后端

## 创建SpringBoot项目

**设置****server.port**=**8443**

```java
package com.example.vue_backup.controller;

import com.example.vue_backup.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin // 设置跨域支持
@RestController
@RequestMapping("api")
public class TestController {
    @Autowired
    private TestService testService;
    @RequestMapping("test")
    public String getmessage()
    {
        return testService.getmessage("hello my name is liang rui");
    }
}
```

# 