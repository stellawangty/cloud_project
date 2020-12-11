package com.hadoop.boxoffice.style;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import com.hadoop.boxoffice.country.ReceiveTable;

public class StyleReducer extends Reducer<Text,IntWritable, ReceiveTable, NullWritable> {
 
	
	protected void reduce(Text key, Iterable<IntWritable> values,
			Reducer<Text, IntWritable, ReceiveTable, NullWritable>.Context context)
			throws IOException, InterruptedException {
		    int sum = 0;
		for(IntWritable v : values) {
			 sum++;
		}
		ReceiveTable receiveTable = new ReceiveTable(key.toString(),sum);
		context.write(receiveTable, null);
	  
	}
}
