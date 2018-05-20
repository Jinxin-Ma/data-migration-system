package com.jd.batch;


import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.launch.support.SimpleJobLauncher;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.lang.management.ManagementFactory;
import java.lang.management.MemoryMXBean;

/**
 * Created by majinxin1 on 2017/8/27.
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("start.......");
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-batch.xml");
        JobLauncher jobLauncher = context.getBean("jobLauncher", SimpleJobLauncher.class);
        Job job = context.getBean("myJobDemo39", Job.class);

        try {
            JobExecution result = jobLauncher.run(job,new JobParameters());
            System.out.println(result.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void getMemory(){
        MemoryMXBean memorymbean = ManagementFactory.getMemoryMXBean();
        long usedMemory = memorymbean.getHeapMemoryUsage().getUsed();
        long totalMemory = memorymbean.getHeapMemoryUsage().getMax();
    }
}

