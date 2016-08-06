package com.bank.shares.hadoop.job.InsideClientIncomeCalculation;


import com.bank.shares.hadoop.spring.Config;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by tomasz on 3/28/16.
 */
public class BindClientCalculationMapper extends Mapper<LongWritable,Text,Text,IntWritable>{


    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        String line = value.toString();
        String[] keyValues = line.split(" ");

        ((IdToNameCache)BindCalculationJob.springContext.getBean("idToNameCache")).getIdToNames().put(Long.parseLong(keyValues[0]), keyValues[1]+ " "+ keyValues[2]);
    }

}
