package com.lening.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

import com.lening.entity.School;
import com.lening.entity.SchoolExample;
import com.lening.mapper.SchoolMapper;
import com.lening.service.SchoolService;
import com.lening.utils.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 服务实现层
 * @author Administrator
 *
 */
@Service
public class SchoolServiceImpl implements SchoolService {

	@Autowired
	private SchoolMapper schoolMapper;
	
	/**
	 * 查询全部
	 */
	@Override
	public List<School> findAll() {
		return schoolMapper.selectByExample(null);
	}

	/**
	 * 按分页查询
	 */
	@Override
	public PageResult findPage(int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		Page<School> page=   (Page<School>) schoolMapper.selectByExample(null);
		return new PageResult(page.getTotal(), page.getResult());
	}

	/**
	 * 增加
	 */
	@Override
	public void add(School school) {
		schoolMapper.insert(school);		
	}

	
	/**
	 * 修改
	 */
	@Override
	public void update(School school){
		schoolMapper.updateByPrimaryKey(school);
	}	
	
	/**
	 * 根据ID获取实体
	 * @param id
	 * @return
	 */
	@Override
	public School findOne(Integer id){
		return schoolMapper.selectByPrimaryKey(id);
	}

	/**
	 * 批量删除
	 */
	@Override
	public void delete(Integer[] ids) {
		for(Integer id:ids){
			schoolMapper.deleteByPrimaryKey(id);
		}		
	}
	
	
		@Override
	public PageResult findPage(School school, int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		
		SchoolExample example=new SchoolExample();
		SchoolExample.Criteria criteria = example.createCriteria();
		
		if(school!=null){			
						if(school.getName()!=null && school.getName().length()>0){
				criteria.andNameLike("%"+school.getName()+"%");
			}
	
		}
		
		Page<School> page= (Page<School>)schoolMapper.selectByExample(example);
		return new PageResult(page.getTotal(), page.getResult());
	}
	
}
