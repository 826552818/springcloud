package com.example;

import com.common.ExcludeFromComponentScan;
import com.example.rule.RibbonRuleConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.web.client.RestTemplate;

/**
 * <p/>
 * <li>Description: ribbon的服务类 </li>
 * <li>@author: LiuDun </li>
 * <li>Date: 2017/11/23 9:40</li>
 */
@SpringBootApplication
@EnableDiscoveryClient
@RibbonClient(configuration = RibbonRuleConfig.class, name = "server-hi")
@ComponentScan(basePackages = "com.example.*", excludeFilters = { @ComponentScan.Filter(type = FilterType.ANNOTATION, value = ExcludeFromComponentScan.class) })
public class RibbonApplication {

    public static void main ( String[] args ) {

        SpringApplication.run( RibbonApplication.class, args );
    }

    @Bean
    @LoadBalanced
    RestTemplate restTemplate () {

        return new RestTemplate();
    }

}
