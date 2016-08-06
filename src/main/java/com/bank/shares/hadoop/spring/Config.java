package com.bank.shares.hadoop.spring;

import com.bank.shares.hadoop.job.InsideClientIncomeCalculation.BindCalculationJob;
import com.bank.shares.hadoop.job.InsideClientIncomeCalculation.IdToNameCache;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Created by tomasz on 5/10/16.
 */
@Configuration
@ComponentScan(basePackageClasses = BindCalculationJob.class)
public class Config {
    @Bean
    public IdToNameCache idToNameCache(){
        return new IdToNameCache();
    }
}
