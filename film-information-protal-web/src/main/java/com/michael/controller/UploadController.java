package com.michael.controller;

import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import com.michael.util.FastDFSClient;

import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

@RestController
public class UploadController {

    @Value("${FILE_SERVER_URL}")
    private String FILE_SERVER_URL;

    @RequestMapping("/upload")
    public void upload(@RequestParam("imgFile")MultipartFile[] imgFile,HttpServletResponse response){
        try {
            PrintWriter out = response.getWriter();
            FastDFSClient client = new FastDFSClient("classpath*:config/fdfs_client.conf");

            for(MultipartFile file:imgFile){

               String fileName= file.getOriginalFilename();

               String extName = fileName.substring(fileName.lastIndexOf(".")+1);

                String path=client.uploadFile(file.getBytes(),extName);

                Map map=new HashMap();
                map.put("error",0);
                map.put("url",FILE_SERVER_URL+path);
                out.print(JSON.toJSONString(map));

            }

            out.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
