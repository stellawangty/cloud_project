package com.hadoop.boxoffice.rate;

import java.io.IOException;

import org.apache.hadoop.io.FloatWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;


public class RateReducer extends Reducer<Text, FloatWritable, ReceiveTable, NullWritable> {
 
	
	protected void reduce(Text key, Iterable<FloatWritable> values,
			Reducer<Text, FloatWritable, ReceiveTable, NullWritable>.Context context)
			throws IOException, InterruptedException {
		
		for(FloatWritable v : values) {
			ReceiveTable receiveTable = new ReceiveTable(key.toString(),v.get());
			context.write(receiveTable, null);
		}
	  
	}
}