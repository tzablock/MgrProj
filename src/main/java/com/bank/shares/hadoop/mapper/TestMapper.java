package com.bank.shares.hadoop.mapper;


import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

/**
 * Created by tomasz on 3/28/16.
 */
public class TestMapper extends Mapper<LongWritable,Text,Text,IntWritable>{

    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        String line = value.toString();

        String[] keyValues = line.split(" ");

        int id = Integer.parseInt(keyValues[1]);

        context.write(new Text(keyValues[0]),new IntWritable(id));
    }
}
