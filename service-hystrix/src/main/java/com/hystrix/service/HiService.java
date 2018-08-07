package com.hystrix.service;

import com.hystrix.service.impl.HiServiceImpl;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * <p/>
 * <li>Description: TODO </li>
 * <li>@author: LiuDun </li>
 * <li>Date: 2017/11/27 14:20</li>
 */
@FeignClient(name = "server-hi", fallback = HiServiceImpl.class)
public interface HiService {

    @RequestMapping("/home")
    public String home ( @RequestParam(name = "name") String name );


}
