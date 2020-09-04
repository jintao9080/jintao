package com.lening.controller;

import com.lening.entity.Team;
import com.lening.service.TeamService;
import com.lening.utils.PageResult;
import com.lening.utils.Result;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/team")
public class TeamController {

	@Resource
	private TeamService teamService;
	

	@RequestMapping("/findAll")
	public List<Team> findAll(){
		return teamService.findAll();
	}
	
	

	@RequestMapping("/findPage")
	public PageResult findPage(int page, int rows){
		return teamService.findPage(page, rows);
	}
	

	@RequestMapping("/add")
	public Result add(@RequestBody Team team){
		try {
			teamService.add(team);
			return new Result(true, "增加成功");
		} catch (Exception e) {
			e.printStackTrace();
			return new Result(false, "增加失败");
		}
	}
	

	@RequestMapping("/update")
	public Result update(@RequestBody Team team){
		try {
			teamService.update(team);
			return new Result(true, "修改成功");
		} catch (Exception e) {
			e.printStackTrace();
			return new Result(false, "修改失败");
		}
	}	
	

	@RequestMapping("/findOne")
	public Team findOne(Integer id){
		return teamService.findOne(id);		
	}
	

	@RequestMapping("/delete")
	public Result delete(Integer [] ids){
		try {
			teamService.delete(ids);
			return new Result(true, "删除成功"); 
		} catch (Exception e) {
			e.printStackTrace();
			return new Result(false, "删除失败");
		}
	}

	@RequestMapping("/search")
	public PageResult search(@RequestBody Team team, int page, int rows  ){
		return teamService.findPage(team, page, rows);		
	}
	
}
