package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * <p/>
 * <li>Description: TODO </li>
 * <li>@author: LiuDun </li>
 * <li>Date: 2017/11/23 11:00</li>
 */
@RestController
public class RibbonController {

    @Autowired
    RestTemplate restTemplate;


    @RequestMapping("/hi")
    public String hi ( @RequestParam String name ) {

        /*ApplicationContext annotationContext = new AnnotationConfigApplicationContext( RibbonRuleConfig.class );

        IRule rule = annotationContext.getBean( RandomRule.class );
        System.out.println( rule );*/

        return restTemplate.getForObject( "http://server-hi/hi?name=" + name, String.class );
    }


}
