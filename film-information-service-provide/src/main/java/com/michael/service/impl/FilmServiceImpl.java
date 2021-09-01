package com.michael.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.michael.group.FilmGroup;
import com.michael.mapper.FilmDescMapper;
import com.michael.mapper.FilmMapper;
import com.michael.pojo.Film;
import com.michael.pojo.FilmDesc;
import com.michael.pojo.FilmDescExample;
import com.michael.pojo.FilmExample;
import com.michael.service.FilmService;
import entity.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 服务实现层
 * @author Administrator
 *
 */
@Service
public class FilmServiceImpl implements FilmService {

	@Autowired
	private FilmMapper filmMapper;

	@Autowired
	private FilmDescMapper filmDescMapper;
	
	/**
	 * 查询全部
	 */
	@Override
	public List<Film> findAll() {
		return filmMapper.selectByExample(null);
	}

	/**
	 * 按分页查询
	 */
	@Override
	public PageResult findPage(int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);		
		Page<Film> page=  (Page<Film>) filmMapper.selectByExample(null);
		return new PageResult(page.getTotal(), page.getResult());
	}

	/**
	 * 增加
	 */
	@Override
	public void add(Film film) {
		filmMapper.insert(film);

		FilmDesc filmDesc = new FilmDesc();
		filmDesc.setFilmId(film.getFilmId());
		filmDescMapper.insert(filmDesc);
	}

	
	/**
	 * 修改
	 */
	@Override
	public void update(Film film){
		filmMapper.updateByPrimaryKey(film);
	}	
	
	/**
	 * 根据ID获取实体
	 * @param id
	 * @return
	 */
	@Override
	public Film findOne(Long id){
		return filmMapper.selectByPrimaryKey(id);
	}

	/**
	 * 批量删除
	 */
	@Override
	public void delete(Long[] ids) {
		for(Long id:ids){
			filmMapper.deleteByPrimaryKey(id);

			filmDescMapper.deleteByFilmId(id);
		}		
	}
	
	
		@Override
	public PageResult findPage(Film film, int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		
		FilmExample example=new FilmExample();
		FilmExample.Criteria criteria = example.createCriteria();
		
		if(film!=null){			
						if(film.getChineseName()!=null && film.getChineseName().length()>0){
				criteria.andChineseNameLike("%"+film.getChineseName()+"%");
			}
			if(film.getForeignName()!=null && film.getForeignName().length()>0){
				criteria.andForeignNameLike("%"+film.getForeignName()+"%");
			}
			if(film.getOtherName()!=null && film.getOtherName().length()>0){
				criteria.andOtherNameLike("%"+film.getOtherName()+"%");
			}
			if(film.getDirector()!=null && film.getDirector().length()>0){
				criteria.andDirectorLike("%"+film.getDirector()+"%");
			}
			if(film.getScreenwriter()!=null && film.getScreenwriter().length()>0){
				criteria.andScreenwriterLike("%"+film.getScreenwriter()+"%");
			}
			if(film.getToStar()!=null && film.getToStar().length()>0){
				criteria.andToStarLike("%"+film.getToStar()+"%");
			}
			if(film.getFilmType()!=null && film.getFilmType().length()>0){
				criteria.andFilmTypeLike("%"+film.getFilmType()+"%");
			}
			if(film.getProductionCountry()!=null && film.getProductionCountry().length()>0){
				criteria.andProductionCountryLike("%"+film.getProductionCountry()+"%");
			}
			if(film.getLanguage()!=null && film.getLanguage().length()>0){
				criteria.andLanguageLike("%"+film.getLanguage()+"%");
			}
			if(film.getHref()!=null && film.getHref().length()>0){
				criteria.andHrefLike("%"+film.getHref()+"%");
			}
	
		}
		
		Page<Film> page= (Page<Film>)filmMapper.selectByExample(example);
		return new PageResult(page.getTotal(), page.getResult());
	}

	@Override
	public PageResult findPage(FilmGroup filmGroup, int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);

		FilmExample example1=new FilmExample();
		FilmExample.Criteria criteria1 = example1.createCriteria();


		Film film = filmGroup.getFilm();

		if(film!=null){
			if(film.getChineseName()!=null && film.getChineseName().length()>0){
				criteria1.andChineseNameLike("%"+film.getChineseName()+"%");
			}
			if(film.getForeignName()!=null && film.getForeignName().length()>0){
				criteria1.andForeignNameLike("%"+film.getForeignName()+"%");
			}
			if(film.getOtherName()!=null && film.getOtherName().length()>0){
				criteria1.andOtherNameLike("%"+film.getOtherName()+"%");
			}
			if(film.getDirector()!=null && film.getDirector().length()>0){
				criteria1.andDirectorLike("%"+film.getDirector()+"%");
			}
			if(film.getScreenwriter()!=null && film.getScreenwriter().length()>0){
				criteria1.andScreenwriterLike("%"+film.getScreenwriter()+"%");
			}
			if(film.getToStar()!=null && film.getToStar().length()>0){
				criteria1.andToStarLike("%"+film.getToStar()+"%");
			}
			if(film.getFilmType()!=null && film.getFilmType().length()>0){
				criteria1.andFilmTypeLike("%"+film.getFilmType()+"%");
			}
			if(film.getProductionCountry()!=null && film.getProductionCountry().length()>0){
				criteria1.andProductionCountryLike("%"+film.getProductionCountry()+"%");
			}
			if(film.getLanguage()!=null && film.getLanguage().length()>0){
				criteria1.andLanguageLike("%"+film.getLanguage()+"%");
			}
			if(film.getHref()!=null && film.getHref().length()>0){
				criteria1.andHrefLike("%"+film.getHref()+"%");
			}

		}


		FilmDescExample example2 = new FilmDescExample();
		FilmDescExample.Criteria criteria2 = example2.createCriteria();

		FilmDesc filmDesc = filmGroup.getFilmDesc();



		if(filmDesc!=null){
			if(filmDesc.getFilmImage()!=null && filmDesc.getFilmImage().length()>0){
				criteria2.andFilmImageEqualTo("%"+filmDesc.getFilmImage()+"%");
			}
		}

		return null;
	}

}
