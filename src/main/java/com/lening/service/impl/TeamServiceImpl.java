package com.lening.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

import com.lening.entity.Team;
import com.lening.entity.TeamExample;
import com.lening.mapper.TeamMapper;
import com.lening.service.TeamService;
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
public class TeamServiceImpl implements TeamService {

	@Autowired
	private TeamMapper teamMapper;
	
	/**
	 * 查询全部
	 */
	@Override
	public List<Team> findAll() {
		return teamMapper.selectByExample(null);
	}

	/**
	 * 按分页查询
	 */
	@Override
	public PageResult findPage(int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);		
		Page<Team> page=   (Page<Team>) teamMapper.selectByExample(null);
		return new PageResult(page.getTotal(), page.getResult());
	}

	/**
	 * 增加
	 */
	@Override
	public void add(Team team) {
		teamMapper.insert(team);		
	}

	
	/**
	 * 修改
	 */
	@Override
	public void update(Team team){
		teamMapper.updateByPrimaryKey(team);
	}	
	
	/**
	 * 根据ID获取实体
	 * @param id
	 * @return
	 */
	@Override
	public Team findOne(Integer id){
		return teamMapper.selectByPrimaryKey(id);
	}

	/**
	 * 批量删除
	 */
	@Override
	public void delete(Integer[] ids) {
		for(Integer id:ids){
			teamMapper.deleteByPrimaryKey(id);
		}		
	}
	
	
		@Override
	public PageResult findPage(Team team, int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		
		TeamExample example=new TeamExample();
		TeamExample.Criteria criteria = example.createCriteria();
		
		if(team!=null){			
						if(team.getName()!=null && team.getName().length()>0){
				criteria.andNameLike("%"+team.getName()+"%");
			}
			if(team.getArea()!=null && team.getArea().length()>0){
				criteria.andAreaLike("%"+team.getArea()+"%");
			}
	
		}
		
		Page<Team> page= (Page<Team>)teamMapper.selectByExample(example);
		return new PageResult(page.getTotal(), page.getResult());
	}
	
}
