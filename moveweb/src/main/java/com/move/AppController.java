package com.move;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class AppController {
		
	@Autowired
	private BookService bookService;
	
	//不同类别电影分析
	@RequestMapping(value = "/getCategory")
	public List<Map<String,Object>> getCategorys(){
		List<Map<String,Object>> list = bookService.getCategorys();

		return list;
	}
	
	// 电影评分分析
	@RequestMapping(value = "/getTopRate")
	public Map getTopRating(){
		
		List<Map<String,Object>> list = bookService.getTopRate();
		List key = new ArrayList();
		List val = new ArrayList();
		Map returnMap = new HashMap<String, List>();
		for(Map<String,Object> m:list) {
			key.add(m.get("name"));
			val.add(m.get("rate"));
		}
		returnMap.put("key", key);
		returnMap.put("val", val);
		return returnMap;
	}
	
	// 电影超过50亿
	@RequestMapping(value = "/getMoreMove")
	public Map getMoreMove(){
		List<Map<String,Object>> list = bookService.getMoreMove();
		List key = new ArrayList();
		List val = new ArrayList();
		Map returnMap = new HashMap<String, List>();
		for(Map<String,Object> m:list) {
			key.add(m.get("name"));
			val.add(m.get("boxoffice"));
		}
		returnMap.put("key", key);
		returnMap.put("val", val);
		return returnMap;
	}

	// 世界范围内电影分布情况
	@RequestMapping(value = "/getCountry")
	public List<Map<String,Object>> getCountry(){

		return bookService.getCountry();
	}
}
