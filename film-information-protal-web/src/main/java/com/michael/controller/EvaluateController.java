package com.michael.controller;

import com.michael.pojo.Evaluate;
import com.michael.service.EvaluateService;
import entity.PageResult;
import entity.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/evaluate")
public class EvaluateController {

    @Autowired
    private EvaluateService evaluateService;


    /**
     * 返回全部列表
     * @return
     */
    @RequestMapping("/findAll")
    public List<Evaluate> findAll(){
        return evaluateService.findAll();
    }


    /**
     * 返回全部列表
     * @return
     */
    @RequestMapping("/findPage")
    public PageResult  findPage(int page,int rows){
        return evaluateService.findPage(page, rows);
    }

    /**
     * 增加
     * @param evaluate
     * @return
     */
    @RequestMapping("/add")
    public Result add(@RequestBody Evaluate evaluate){
        try {
            evaluateService.add(evaluate);
            return new Result(true, "增加成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, "增加失败");
        }
    }



    /**
     * 获取实体
     * @param evaluate_id
     * @return
     */
    @RequestMapping("/findOne")
    public Evaluate findOne(Long evaluate_id){
        return evaluateService.findOne(evaluate_id);
    }

    /**
     * 批量删除
     * @param ids
     * @return
     */
    @RequestMapping("/delete")
    public Result delete(Long [] ids){
        try {
            evaluateService.delete(ids);
            return new Result(true, "删除成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, "删除失败");
        }
    }

    /**
     * 查询+分页
     * @param evaluate
     * @param page
     * @param rows
     * @return
     */
    @RequestMapping("/search")
    public PageResult search(@RequestBody Evaluate evaluate, int page, int rows  ){
        return evaluateService.findPage(evaluate, page, rows);
    }

}
