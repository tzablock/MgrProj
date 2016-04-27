package com.bank.shares.generator.start;

import com.bank.shares.generator.SpringConfig;
import com.bank.shares.generator.data.PayService;
import com.bank.shares.generator.exceptions.NoArgumentException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by tomasz on 4/15/16.
 */
public class Generator {
    private static ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);

    public static void main(String[] args) throws Exception {
        if(args.length != 4){
            throw new NoArgumentException();
        }


        long numberOfGenClients = args[0].equals("-nc") ? Long.valueOf(args[1]) : -1;
        long maxNumberOfGenTransfers = args[2].equals("-mnt") ? Long.valueOf(args[3]) : -1;

        if(maxNumberOfGenTransfers == -1 || numberOfGenClients == -1)
            throw  new NoArgumentException();

        PayService payService = (PayService) context.getBean("payService");

        payService.createRecordsToDB(maxNumberOfGenTransfers, numberOfGenClients);

    }
}
