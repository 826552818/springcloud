package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * <p/>
 * <li>Description: TODO </li>
 * <li>@author: LiuDun </li>
 * <li>Date: 2017/11/20 15:57</li>
 */
@SpringBootApplication
@EnableEurekaClient
public class EurekaClientApplication {

    public static void main ( String[] args ) {

        SpringApplication.run( EurekaClientApplication.class, args );
    }

}
