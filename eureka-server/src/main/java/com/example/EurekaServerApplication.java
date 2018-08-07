package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.context.annotation.ComponentScan;

/**
 * <p/>
 * <li>Description: TODO </li>
 * <li>@author: LiuDun </li>
 * <li>Date: 2017/11/20 15:18</li>
 */
@EnableEurekaServer
@SpringBootApplication
@ComponentScan(basePackages = "com.example.*")
public class EurekaServerApplication {

    public static void main ( String[] args ) {

        SpringApplication.run( EurekaServerApplication.class, args );
    }
}
