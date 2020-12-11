package com.move;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface BookDao {
	
	//不同类别电影占比
	@Select("select style name,num value from boxoffice_style_num")
	public List<Map<String,Object>> getCategorys();
	
	// 电影评分评分分析
	@Select("select name,rate from boxoffice_rate limit 10")
	public List<Map<String,Object>> getTopRate();

	// 电影超过50亿
	@Select("select name,boxoffice from boxoffice_top")
	public List<Map<String,Object>> getMoreMove();

	// 世界范围内电影分布情况
	@Select("select country name,num value from boxoffice_country")
	public List<Map<String,Object>> getCountry();


}
