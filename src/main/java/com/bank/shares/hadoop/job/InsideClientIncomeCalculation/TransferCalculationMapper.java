package com.bank.shares.hadoop.job.InsideClientIncomeCalculation;


import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

/**
 * Created by tomasz on 3/28/16.
 */
public class TransferCalculationMapper extends Mapper<LongWritable,Text,LongWritable,DoubleWritable>{

    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        String line = value.toString();

        String[] keyValues = line.split(" ");

        String transactionType = keyValues[7].toString();
        double money = transactionType.equals("obciazenie") ? -Double.parseDouble(keyValues[4]) : Double.parseDouble(keyValues[4]);

        context.write(new LongWritable(Long.parseLong(keyValues[9])),new DoubleWritable(money));
    }
}
