package com.jd.batch.squartz;

import org.springframework.batch.core.*;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.launch.support.SimpleJobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by majinxin1 on 2017/12/22.
 */
import java.util.Date;

public class SpringQtz {
    private static Long counter = 0L;
    private static ApplicationContext context ;

//    @Autowired
//    JobLauncher jobLauncher;
//
//    @Autowired
//    Job accountLoginJob;

//    public void execute() throws JobParametersInvalidException, JobExecutionAlreadyRunningException, JobRestartException, JobInstanceAlreadyCompleteException {
//        long ms = System.currentTimeMillis();
//        System.out.println("\t\t" + new Date(ms));
//        System.out.println("(" + counter++ + ")");
//        jobLauncher.run(accountLoginJob, new JobParametersBuilder()
//                .addLong("token", System.currentTimeMillis()).toJobParameters());
//    }

    public void archiveDate(){
        System.out.println("start.......");
        JobLauncher jobLauncher = context.getBean("jobLauncher", SimpleJobLauncher.class);
        Job job = context.getBean("myJobDemo39", Job.class);
        try {
            JobExecution result = jobLauncher.run(job,new JobParameters());
            System.out.println(result.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
        System.out.println("start.......");
        context= new ClassPathXmlApplicationContext("spring-config.xml");
        try {
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}