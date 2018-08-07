package com.feign.service;

import com.feign.service.impl.HiServerImpl;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * <p/>
 * <li>Description: feign自带断由器 </li>
 * <li>@author: LiuDun </li>
 * <li>Date: 2017/11/27 10:43</li>
 */
@FeignClient(value = "server-hi", fallback = HiServerImpl.class)
public interface HiService {

    @RequestMapping("/home")
    public String home ( @RequestParam(value = "name") String name );
}
