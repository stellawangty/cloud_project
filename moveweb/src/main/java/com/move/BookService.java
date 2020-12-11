package com.move;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {
	
	@Autowired
	private BookDao bookDao;
	
	public List<Map<String,Object>> getCategorys(){
		return bookDao.getCategorys();
	}
	
	public List<Map<String,Object>> getTopRate(){
		return bookDao.getTopRate();
	}
	
	public List<Map<String,Object>> getMoreMove(){
		return bookDao.getMoreMove();
	}
	
	public List<Map<String,Object>> getCountry() {
		List<Map<String,Object>> list = bookDao.getCountry();
 
		return list;
	}

}
