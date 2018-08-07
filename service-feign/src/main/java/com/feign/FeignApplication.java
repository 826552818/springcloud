package com.feign;

import com.common.ExcludeFromComponentScan;
import com.feign.configuration.FeignConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;

/**
 * <p/>
 * <li>Description: feign的启动类 </li>
 * <li>@author: LiuDun </li>
 * <li>Date: 2017/11/27 10:21</li>
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients //开启feign
@RibbonClient(name = "server-hi", configuration = FeignConfig.class) //设置 ribbon的负载信息
@ComponentScan(basePackages = "com.feign.*", excludeFilters = { @ComponentScan.Filter(type = FilterType.ANNOTATION, value = ExcludeFromComponentScan.class) })
public class FeignApplication {

    public static void main ( String[] args ) {

        SpringApplication.run( FeignApplication.class, args );
    }

}
