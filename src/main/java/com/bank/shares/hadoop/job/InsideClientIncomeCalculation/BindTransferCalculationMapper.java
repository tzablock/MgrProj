package com.bank.shares.hadoop.job.InsideClientIncomeCalculation;


import com.bank.shares.hadoop.spring.Config;
import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


import java.io.IOException;
import java.util.Map;

/**
 * Created by tomasz on 3/28/16.
 */
public class BindTransferCalculationMapper extends Mapper<LongWritable,Text,Text,DoubleWritable>{

    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {

        String line = value.toString();
        String[] keyValue = line.split(" ");

        Map<Long, String> idToNames = ((IdToNameCache)BindCalculationJob.springContext.getBean("idToNameCache")).getIdToNames();
        long id = Long.parseLong(keyValue[0]);

        context.write(new Text(idToNames.get(id)),new DoubleWritable(Double.parseDouble(keyValue[1])));
    }
}
