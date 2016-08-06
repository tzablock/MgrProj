package com.bank.shares.hadoop.job.InsideClientIncomeCalculation;

import com.bank.shares.hadoop.mapper.TestMapper;
import com.bank.shares.hadoop.reducer.TestReducer;
import com.bank.shares.hadoop.spring.Config;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.lib.IdentityReducer;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.input.MultipleInputs;
import org.apache.hadoop.mapreduce.lib.input.TextInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.IOException;

/**
 * Created by tomasz on 3/28/16.
 */
public class BindCalculationJob {
    public static ApplicationContext springContext = new AnnotationConfigApplicationContext(Config.class);

    public  static void main(String[] args) throws IOException, ClassNotFoundException, InterruptedException {
        if(args.length != 6){
            System.err.println("-wej3 arg1 -wej4 arg1 -wyj3 arg2");
            System.exit(-1);
        }

        Job job = new Job();
        job.setJarByClass(BindCalculationJob.class);
        job.setJobName("Bind Calculation");

        FileOutputFormat.setOutputPath(job, new Path(args[5]));

        MultipleInputs.addInputPath(job,new Path(args[3]),TextInputFormat.class, BindClientCalculationMapper.class);
        MultipleInputs.addInputPath(job,new Path(args[1]),TextInputFormat.class, BindTransferCalculationMapper.class);

        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(DoubleWritable.class);

        System.exit(job.waitForCompletion(true)?0:1);
    }
}
