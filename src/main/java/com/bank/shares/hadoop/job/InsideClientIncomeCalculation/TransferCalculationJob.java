package com.bank.shares.hadoop.job.InsideClientIncomeCalculation;

import com.bank.shares.hadoop.mapper.TestMapper;
import com.bank.shares.hadoop.reducer.TestReducer;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

import java.io.IOException;

/**
 * Created by tomasz on 3/28/16.
 */
public class TransferCalculationJob {
    public  static void main(String[] args) throws IOException, ClassNotFoundException, InterruptedException {
        if(args.length != 4){
            System.err.println("-wej1 arg1 -wyj1 arg2");
            System.exit(-1);
        }

        Job job = new Job();
        job.setJarByClass(TransferCalculationJob.class);
        job.setJobName("Transfer Calculation");

        FileInputFormat.addInputPath(job, new Path(args[1]));
        FileOutputFormat.setOutputPath(job, new Path(args[3]));

        job.setMapperClass(TransferCalculationMapper.class);
        job.setReducerClass(TransferCalculationReducer.class);

        job.setOutputKeyClass(LongWritable.class);
        job.setOutputValueClass(DoubleWritable.class);

        System.exit(job.waitForCompletion(true)?0:1);
    }
}
