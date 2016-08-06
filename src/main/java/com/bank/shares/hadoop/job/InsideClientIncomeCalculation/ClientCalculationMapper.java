package com.bank.shares.hadoop.job.InsideClientIncomeCalculation;


import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

/**
 * Created by tomasz on 3/28/16.
 */
public class ClientCalculationMapper extends Mapper<LongWritable,Text,LongWritable,Text>{

    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        String line = value.toString();

        String[] keyValues = line.split(" ");

        long id = Integer.parseInt(keyValues[0].toString());
        String nameAndSurname = keyValues[3].toString() +" "+ keyValues[5].toString();

        context.write(new LongWritable(id),new Text(nameAndSurname));
    }
}
