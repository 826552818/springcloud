package com.feign.controller;

import com.feign.service.HiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p/>
 * <li>Description: TODO </li>
 * <li>@author: LiuDun </li>
 * <li>Date: 2017/11/27 10:19</li>
 */
@RestController
public class FeignController {

    @Autowired
    private HiService hiService;


    @RequestMapping("/home")
    public String home ( @RequestParam String name ) {

        return hiService.home( name );
    }


}
