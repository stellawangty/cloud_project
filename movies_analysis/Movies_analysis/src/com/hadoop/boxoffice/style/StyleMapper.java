package com.hadoop.boxoffice.style;

import java.io.IOException;
import java.util.HashMap;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Mapper.Context;

public class StyleMapper  extends Mapper<LongWritable, Text, Text, IntWritable>{
	 
	HashMap<String,Integer> map = new HashMap<String,Integer>(); 
	
	
	protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
	 
		String[] words = value.toString().split(","); 
		if(words.length == 9) {//等于10表明数据长度正常
			try {
				String name = words[0];
				int boxoffice = Integer.parseInt(words[1]);
				String style = words[2];
				if(boxoffice >= 500000) {
				if(style.contains("爱情")) {
				context.write(new Text("爱情"),new IntWritable(1));
				}else {
					if(style.contains("喜剧")) {
						context.write(new Text("喜剧"),new IntWritable(1));
						}else {
							if(style.contains("动作")) {
								context.write(new Text("动作"),new IntWritable(1));
								}else {
									if(style.contains("犯罪")) {
										context.write(new Text("犯罪"),new IntWritable(1));
										}else {
											if(style.contains("剧情")) {
												context.write(new Text("剧情"),new IntWritable(1));
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
