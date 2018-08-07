package com.feign.service.impl;

import com.feign.service.HiService;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * <p/>
 * <li>Description: 实现hiService接口  断路器 </li>
 * <li>@author: LiuDun </li>
 * <li>Date: 2017/11/27 14:04</li>
 */
@Component
public class HiServerImpl implements HiService {

    @Override
    public String home ( @RequestParam(value = "name") String name ) {

        return "请求错误";
    }
}
