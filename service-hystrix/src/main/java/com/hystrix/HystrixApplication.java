package com.hystrix;

import com.common.ExcludeFromComponentScan;
import com.hystrix.configuration.HyConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;

/**
 * <p/>
 * <li>Description: TODO </li>
 * <li>@author: LiuDun </li>
 * <li>Date: 2017/11/27 14:25</li>
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
@RibbonClient(name = "server-hi", configuration = HyConfig.class)
@EnableHystrix
@EnableHystrixDashboard
@ComponentScan(basePackages = "com.hystrix.*", excludeFilters = { @ComponentScan.Filter(type = FilterType.ANNOTATION, value = ExcludeFromComponentScan.class) })
public class HystrixApplication {

    public static void main ( String[] args ) {

        SpringApplication.run( HystrixApplication.class, args );
    }
}
