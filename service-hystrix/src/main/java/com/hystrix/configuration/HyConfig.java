package com.hystrix.configuration;

import com.common.ExcludeFromComponentScan;
import com.netflix.loadbalancer.DummyPing;
import com.netflix.loadbalancer.IPing;
import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * <p/>
 * <li>Description: TODO </li>
 * <li>@author: LiuDun </li>
 * <li>Date: 2017/11/27 14:22</li>
 */
@Configuration
@ExcludeFromComponentScan
public class HyConfig {

    protected final Log logger = LogFactory.getLog( this.getClass() );

    @Bean
    @ConditionalOnMissingBean
    public IRule ribbonRule () {

        logger.info( "进入自定义规则" );
        return new RandomRule();
    }

    @Bean
    @ConditionalOnMissingBean
    public IPing ribbonPing () {

        logger.info( "进入自定义Ping" );

        // PingUrl 真实的去ping 某个url，判断其是否alive
        // PingConstant 固定返回某服务是否可用，默认返回true，即可用
        // NoOpPing 不去ping,直接返回true,即可用。
        // DummyPing 直接返回true，并实现了initWithNiwsConfig方法。
        // NIWSDiscoveryPing，根据DiscoveryEnabledServer的InstanceInfo的InstanceStatus去判断，如果为InstanceStatus.UP，则为可用，否则不可用。

        //BaseLoadBalancer 基础负载均衡处理类, 需要注意 canSkipPing()方法
        //  setServersList 该方法中 如果canSkipPing()方法返回为false则需要不会刷新类中的upServerList
        //  就会照成上线的服务没有 从而运行的时候报错

        return new DummyPing();
    }
}
