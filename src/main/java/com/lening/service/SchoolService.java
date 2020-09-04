package com.lening.service;


import com.lening.entity.School;
import com.lening.utils.PageResult;


import java.util.List;
/**
 * 服务层接口
 * @author Administrator
 *
 */
public interface SchoolService {

	/**
	 * 返回全部列表
	 * @return
	 */
	public List<School> findAll();
	
	
	/**
	 * 返回分页列表
	 * @return
	 */
	public PageResult findPage(int pageNum, int pageSize);
	
	
	/**
	 * 增加
	*/
	public void add(School school);
	
	
	/**
	 * 修改
	 */
	public void update(School school);
	

	/**
	 * 根据ID获取实体
	 * @param id
	 * @return
	 */
	public School findOne(Integer id);
	
	
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
	public PageResult findPage(School school, int pageNum, int pageSize);
	
}
