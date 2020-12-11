package com.hadoop.boxoffice.country;

import java.io.IOException;
import java.util.HashMap;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Mapper.Context;

public class CountryMapper  extends Mapper<LongWritable, Text, Text, IntWritable>{
	 
	HashMap<String,Integer> map = new HashMap<String,Integer>(); 
	
	
	protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
	 
		String[] words = value.toString().split(","); 
		if(words.length == 9) {//等于10表明数据长度正常
			try {
				String name = words[0];
				int boxoffice = Integer.parseInt(words[1]);
				String country = words[3];
				if(boxoffice >= 100000) {
			if(country.contains("中国大陆")) {
				context.write(new Text("China"),new IntWritable(1));				
			}else {
				if(country.contains("韩国")) {
					context.write(new Text("Korea"),new IntWritable(1));	
				}else {
					if(country.contains("加拿大")) {
						context.write(new Text("Canada"),new IntWritable(1));	
					}else {
						if(country.contains("意大利")) {
							context.write(new Text("Italy"),new IntWritable(1));	
						}else {
							if(country.contains("新西兰")) {
								context.write(new Text("New Zealand"),new IntWritable(1));	
							}else {
								if(country.contains("法国")) {
									context.write(new Text("France"),new IntWritable(1));	
								}else {
									if(country.contains("澳大利亚")) {
										context.write(new Text("Australia"),new IntWritable(1));	
									}else {
										if(country.contains("德国")) {
											context.write(new Text("Germany"),new IntWritable(1));	
										}
									}
								}
							}
						}
						}
					
				}
			}
				}
			}catch (NumberFormatException e) {
				// TODO: handle exception
				System.out.println("have error about NumberFormat");
			}
		}
	}
	@Override
	protected void cleanup(Context context)
			throws IOException, InterruptedException {
		} 
	}
