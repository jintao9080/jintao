package com.lening.service;


import com.lening.entity.Team;
import com.lening.utils.PageResult;


import java.util.List;
/**
 * 服务层接口
 * @author Administrator
 *
 */
public interface TeamService {

	/**
	 * 返回全部列表
	 * @return
	 */
	public List<Team> findAll();
	
	
	/**
	 * 返回分页列表
	 * @return
	 */
	public PageResult findPage(int pageNum, int pageSize);
	
	
	/**
	 * 增加
	*/
	public void add(Team team);
	
	
	/**
	 * 修改
	 */
	public void update(Team team);
	

	/**
	 * 根据ID获取实体
	 * @param id
	 * @return
	 */
	public Team findOne(Integer id);
	
	
	/**
	 * 批量删除
	 * @param ids
	 */
	public void delete(Integer[] ids);

	/**
	 * 分页
	 * @param pageNum 当前页 码
	 * @param pageSize 每页记录数
	 * @return
	 */
	public PageResult findPage(Team team, int pageNum, int pageSize);
	
}
