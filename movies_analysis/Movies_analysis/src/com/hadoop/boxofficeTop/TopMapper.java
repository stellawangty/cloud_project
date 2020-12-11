package com.hadoop.boxofficeTop;

import java.io.IOException;
import java.util.HashMap;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
public class TopMapper  extends Mapper<LongWritable, Text, Text, IntWritable>{
		 
		HashMap<String,Integer> map = new HashMap<String,Integer>(); 
		
		
		protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
		 
			String[] words = value.toString().split(","); 
			if(words.length == 9) {//等于10表明数据长度正常
				try {
					String name = words[0];
					int boxoffice = Integer.parseInt(words[1]);
					if(boxoffice >= 500000) {
						
				context.write(new Text(name),new IntWritable(boxoffice));
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
