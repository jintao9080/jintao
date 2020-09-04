package com.lening.controller;


import com.lening.entity.School;
import com.lening.service.SchoolService;
import com.lening.utils.PageResult;
import com.lening.utils.Result;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;


@RestController
@RequestMapping("/school")
public class SchoolController {

	@Resource
	private SchoolService schoolService;
	

	@RequestMapping("/findAll")
	public List<School> findAll(){
		return schoolService.findAll();
	}
	
	

	@RequestMapping("/findPage")
	public PageResult findPage(int page, int rows){
		return schoolService.findPage(page, rows);
	}
	


	@RequestMapping("/add")
	public Result add(@RequestBody School school){
		try {
			schoolService.add(school);
			return new Result(true, "增加成功");
		} catch (Exception e) {
			e.printStackTrace();
			return new Result(false, "增加失败");
		}
	}

	@RequestMapping("/update")
	public Result update(@RequestBody School school){
		try {
			schoolService.update(school);
			return new Result(true, "修改成功");
		} catch (Exception e) {
			e.printStackTrace();
			return new Result(false, "修改失败");
		}
	}	

	@RequestMapping("/findOne")
	public School findOne(Integer id){
		return schoolService.findOne(id);		
	}
	

	@RequestMapping("/delete")
	public Result delete(Integer [] ids){
		try {
			schoolService.delete(ids);
			return new Result(true, "删除成功"); 
		} catch (Exception e) {
			e.printStackTrace();
			return new Result(false, "删除失败");
		}
	}
	

	@RequestMapping("/search")
	public PageResult search(@RequestBody School school, int page, int rows  ){
		return schoolService.findPage(school, page, rows);		
	}
	
}
