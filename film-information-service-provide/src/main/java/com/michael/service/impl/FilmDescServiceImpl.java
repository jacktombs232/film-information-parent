package com.michael.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.michael.mapper.FilmDescMapper;
import com.michael.pojo.FilmDesc;
import com.michael.pojo.FilmDescExample;
import com.michael.service.FilmDescService;
import entity.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FilmDescServiceImpl implements FilmDescService {

    @Autowired
    private FilmDescMapper filmDescMapper;

    @Override
    public List<FilmDesc> findAll() {
        return filmDescMapper.selectByExample(null);
    }

    @Override
    public PageResult findPage(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        Page<FilmDesc> page=  (Page<FilmDesc>) filmDescMapper.selectByExample(null);
        return new PageResult(page.getTotal(), page.getResult());
    }


    @Override
    public void update(FilmDesc film) {
        filmDescMapper.updateByFilmDesc(film);
    }

    @Override
    public FilmDesc findOne(Long id) {
        return filmDescMapper.selectByFilmId(id);
    }


    @Override
    public PageResult findPage(FilmDesc film, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);

        FilmDescExample example=new FilmDescExample();
        FilmDescExample.Criteria criteria = example.createCriteria();

        if(film!=null){
            if(film.getFilmImage()!=null && film.getFilmImage().length()>0){
                criteria.andFilmImageEqualTo("%"+film.getFilmImage()+"%");
            }
            if(film.getIntroduce()!=null && film.getIntroduce().length()>0){
                criteria.andIntroduceEqualTo("%"+film.getIntroduce()+"%");
            }
        }

        Page<FilmDesc> page= (Page<FilmDesc>)filmDescMapper.selectByExample(example);
        return new PageResult(page.getTotal(), page.getResult());
    }
}
