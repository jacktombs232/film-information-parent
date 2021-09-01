package com.michael.controller;

import com.michael.service.EvaluateService;
import com.michael.service.FilmService;
import com.michael.service.FilmTypeService;
import com.michael.service.UserService;
import com.michael.util.testUtil;
import entity.Result;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.List;

@Controller
@RequestMapping("/file")
public class FileController {

    @Autowired
    private UserService userService;
    @Autowired
    private FilmService filmService;
    @Autowired
    private FilmTypeService typeService;
    @Autowired
    private EvaluateService evaluateService;

    @RequestMapping("/userDownload")
    public Result userDownload(String name,HttpServletRequest request, HttpServletResponse response){
        XSSFWorkbook excel =null;
        if(name.equals("评论详情")){
           excel =testUtil.export(evaluateService.findAll());
        }if (name.equals("影视信息")){
            excel =testUtil.export(filmService.findAll());
        }if (name.equals("类型信息")){
            excel =testUtil.export(typeService.findAll());
        }if(name.equals("用户信息")){
            excel =testUtil.export(userService.findAll());
        }

        try{
        //创建输出流，用于从服务器写数据到客户端浏览器
        ServletOutputStream out = response.getOutputStream();
        response.setContentType("application/vnd.ms-excel");
        response.setHeader("content-Disposition", "attachment;filename="+URLEncoder.encode(name, "UTF-8")+".xlsx");
        excel.write(out);
        out.flush();
        out.close();
        excel.close();

        return new Result(true, "导出成功");
    }catch (Exception e){
        e.printStackTrace();
        return new Result(false, "导出失败");
    }
    }
}
