package com.bank.shares.hadoop.job.InsideClientIncomeCalculation;

import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;

/**
 * Created by tomasz on 3/30/16.
 */
public class TransferCalculationReducer extends Reducer<LongWritable,DoubleWritable,LongWritable, DoubleWritable> {
    @Override
    protected void reduce(LongWritable key, Iterable<DoubleWritable> values, Context context) throws IOException, InterruptedException {
       Double moneySum = 0.0;
        for (DoubleWritable value:values) {
            moneySum += new Double(String.valueOf(value));
        }

        context.write(key,new DoubleWritable(moneySum));
    }
}
