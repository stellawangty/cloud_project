package com.hadoop.boxoffice.rate;

import java.io.IOException;
import java.util.HashMap;

import org.apache.hadoop.io.FloatWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Mapper.Context;

public class RateMapper  extends Mapper<LongWritable, Text, Text, FloatWritable>{
	protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
		 
		String[] words = value.toString().split(","); 
		if(words.length == 9) {//等于10表明数据长度正常
			try {
				String name = words[0];
				int boxoffice = Integer.parseInt(words[1]);
				Float rating = Float.valueOf(words[7]); 
				if(boxoffice >= 500000) {
					
			context.write(new Text(name),new FloatWritable(rating));
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
