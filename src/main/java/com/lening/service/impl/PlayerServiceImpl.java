package com.lening.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

import com.lening.entity.Player;
import com.lening.entity.PlayerExample;
import com.lening.entity.School;
import com.lening.entity.Team;
import com.lening.mapper.PlayerMapper;
import com.lening.mapper.SchoolMapper;
import com.lening.mapper.TeamMapper;
import com.lening.service.PlayerService;
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
public class PlayerServiceImpl implements PlayerService {

	@Autowired
	private PlayerMapper playerMapper;

	@Autowired
	private SchoolMapper schoolMapper;

	@Autowired
	private TeamMapper teamMapper;
	
	/**
	 * 查询全部
	 */
	@Override
	public List<Player> findAll() {
		List<Player> players = playerMapper.selectByExample(null);
		for (Player player : players) {
			School school = schoolMapper.selectByPrimaryKey(player.getSid());
			player.setSname(school.getName());
			Team team = teamMapper.selectByPrimaryKey(player.getTid());
			player.setTname(team.getName());
		}
		return players;
	}

	/**
	 * 按分页查询
	 */
	@Override
	public PageResult findPage(int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		Page<Player> page=   (Page<Player>) playerMapper.selectByExample(null);
		return new PageResult(page.getTotal(), page.getResult());
	}

	/**
	 * 增加
	 */
	@Override
	public void add(Player player) {
		playerMapper.insert(player);		
	}

	
	/**
	 * 修改
	 */
	@Override
	public void update(Player player){
		playerMapper.updateByPrimaryKey(player);
	}	
	
	/**
	 * 根据ID获取实体
	 * @param id
	 * @return
	 */
	@Override
	public Player findOne(Integer id){
		return playerMapper.selectByPrimaryKey(id);
	}

	/**
	 * 批量删除
	 */
	@Override
	public void delete(Integer[] ids) {
		for(Integer id:ids){
			playerMapper.deleteByPrimaryKey(id);
		}		
	}
	
	
		@Override
	public PageResult findPage(Player player, int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		
		PlayerExample example=new PlayerExample();
		PlayerExample.Criteria criteria = example.createCriteria();
		
		if(player!=null){			
						if(player.getName()!=null && player.getName().length()>0){
				criteria.andNameLike("%"+player.getName()+"%");
			}
			if(player.getAge()!=null && player.getAge().length()>0){
				criteria.andAgeLike("%"+player.getAge()+"%");
			}
			if(player.getBirthday()!=null && player.getBirthday().length()>0){
				criteria.andBirthdayLike("%"+player.getBirthday()+"%");
			}
	
		}
		
		Page<Player> page= (Page<Player>)playerMapper.selectByExample(example);
		return new PageResult(page.getTotal(), page.getResult());
	}
	
}
