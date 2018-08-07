package com;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * <p/>
 * <li>Description: TODO </li>
 * <li>@author: LiuDun </li>
 * <li>Date: 2017/11/20 17:27</li>
 */
@RestController
public class EurekaController {

    @Value("${server.port}")
    String port;

    @RequestMapping("/home")
    @ResponseBody
    public String home ( @RequestParam String name ) {

        return "hi " + name + ", hello " + port;
    }

    @RequestMapping("/hi")
    @ResponseBody
    public String hi ( @RequestParam String name ) {

        return "hi " + name + ", hello d1 d " + port;
    }

    @RequestMapping("/ajax")
    @ResponseBody
    public RestResult< ResultBean > ajax ( @RequestBody PageParamBean bean ) {

        long dateTime = bean.getDateTime();



        ResultBean resultBean = new ResultBean();
        resultBean.setDateTime( dateTime );

        List< ResultDataBean > dataBean = new ArrayList<>();
        List< String > ids = bean.getIds();

        Random random = new Random();


        for ( String id : ids ) {
            ResultDataBean resultDataBean = new ResultDataBean();
            resultDataBean.setId( id );
            resultDataBean.setValue( Math.abs( random.nextInt() % 3 ) + "" );
            dataBean.add( resultDataBean );
        }
        resultBean.setValues( dataBean );


        return new RestResult< ResultBean >( resultBean );
    }


}
