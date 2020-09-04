package com.lening.controller;


import com.lening.entity.Player;
import com.lening.service.PlayerService;
import com.lening.utils.PageResult;
import com.lening.utils.Result;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;


@RestController
@RequestMapping("/player")
public class PlayerController {

	@Resource
	private PlayerService playerService;

	@RequestMapping("/findAll")
	public List<Player> findAll(){
		return playerService.findAll();
	}
	

	@RequestMapping("/findPage")
	public PageResult findPage(int page, int rows){
		return playerService.findPage(page, rows);
	}
	

	@RequestMapping("/add")
	public Result add(@RequestBody Player player){
		try {
			playerService.add(player);
			return new Result(true, "增加成功");
		} catch (Exception e) {
			e.printStackTrace();
			return new Result(false, "增加失败");
		}
	}
	

	@RequestMapping("/update")
	public Result update(@RequestBody Player player){
		try {
			playerService.update(player);
			return new Result(true, "修改成功");
		} catch (Exception e) {
			e.printStackTrace();
			return new Result(false, "修改失败");
		}
	}	
	

	@RequestMapping("/findOne")
	public Player findOne(Integer id){
		return playerService.findOne(id);		
	}
	

	@RequestMapping("/delete")
	public Result delete(Integer [] ids){
		try {
			playerService.delete(ids);
			return new Result(true, "删除成功"); 
		} catch (Exception e) {
			e.printStackTrace();
			return new Result(false, "删除失败");
		}
	}
	

	@RequestMapping("/search")
	public PageResult search(@RequestBody Player player, int page, int rows  ){
		return playerService.findPage(player, page, rows);		
	}
	
}
