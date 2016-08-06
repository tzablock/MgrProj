package com.bank.shares.hadoop.reducer;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;

/**
 * Created by tomasz on 3/30/16.
 */
public class CalculateFlowForEachDateReducer extends Reducer<Text,IntWritable,Text, IntWritable> {
    @Override
    protected void reduce(Text key, Iterable<IntWritable> values, Context context) throws IOException, InterruptedException {
        int maxId = Integer.MIN_VALUE;

        for (IntWritable value:values) {
            maxId = Math.max(value.get(),maxId);
        }

        context.write(key,new IntWritable(maxId));
    }
}
