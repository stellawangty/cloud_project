package com.hadoop.boxofficeTop;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class TopReducer extends Reducer<Text, IntWritable, ReceiveTable, NullWritable> {
 
	
	protected void reduce(Text key, Iterable<IntWritable> values,
			Reducer<Text, IntWritable, ReceiveTable, NullWritable>.Context context)
			throws IOException, InterruptedException {
		
		for(IntWritable v : values) {
			ReceiveTable receiveTable = new ReceiveTable(key.toString(),v.get());
			context.write(receiveTable, null);
		}
	  
	}
}