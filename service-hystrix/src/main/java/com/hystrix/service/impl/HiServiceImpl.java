package com.hystrix.service.impl;

import com.hystrix.service.HiService;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * <p/>
 * <li>Description: TODO </li>
 * <li>@author: LiuDun </li>
 * <li>Date: 2017/11/27 14:21</li>
 */
@Component
public class HiServiceImpl implements HiService {

    @Override
    public String home ( @RequestParam(name = "name") String name ) {

        return "error";
    }
}
