package com.michael.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.michael.mapper.EvaluateMapper;
import com.michael.mapper.FilmMapper;
import com.michael.mapper.UserMapper;
import com.michael.pojo.*;
import com.michael.service.EvaluateService;
import entity.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class evaluateServiceImpl implements EvaluateService {

    @Autowired
    private EvaluateMapper evaluateMapper;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private FilmMapper filmMapper;

    @Override
    public List<Evaluate> findAll() {
        return evaluateMapper.selectByExample(null);
    }

    @Override
    public PageResult findPage(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        Page<Evaluate> page=   (Page<Evaluate>) evaluateMapper.selectByExample(null);
        return new PageResult(page.getTotal(), page.getResult());
    }

    @Override
    public void add(Evaluate evaluate) {
        evaluateMapper.insert(evaluate);
    }


    @Override
    public Evaluate  findOne(Long evaluate_id) {
        return evaluateMapper.selectByPrimaryKey(evaluate_id);
    }


    @Override
    public void delete(Long[] ids) {
        for(Long id:ids){
            evaluateMapper.deleteByPrimaryKey(id);
        }
    }

    @Override
    public PageResult findPage(Evaluate evaluate, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);

        EvaluateExample example=new EvaluateExample();
        EvaluateExample.Criteria criteria = example.createCriteria();

        if(evaluate!=null){
            if(evaluate.getComment()!=null && evaluate.getComment().length()>0){
                criteria.andCommentEqualTo("%"+evaluate.getComment()+"%");
            }
            if(evaluate.getGrade()!=null){
                criteria.andGradeEqualTo(evaluate.getGrade());
            }

            if(evaluate.getFilmId()!=null){
                criteria.andFilmIdEqualTo(evaluate.getFilmId());
            }
            if(evaluate.getUserId()!=null){
                criteria.andUserIdEqualTo(evaluate.getUserId());
            }
        }
            Page<Evaluate> page= (Page<Evaluate>)evaluateMapper.selectByExample(example);
        return new PageResult(page.getTotal(), page.getResult());
    }

    @Override
    public Long countNumber() {
        return evaluateMapper.countByExample(null);
    }
}
