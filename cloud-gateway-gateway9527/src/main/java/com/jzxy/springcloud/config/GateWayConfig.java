package com.jzxy.springcloud.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Description
 * @Author zch
 * @Date 2021/1/12 10:32
 */
@Configuration
public class GateWayConfig {
    /**
     * 配置了一个id为route-name的路由规则
     * 当访问地址http:localhost:9527/guonei时会自动转发到地址http://news.baidu.com/guonei
     **/
    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder routeLocatorBuilder){
        RouteLocatorBuilder.Builder routes = routeLocatorBuilder.routes();
        routes.route("path_route_izxy1",
                r -> r.path("/guoji")
                        .uri("http://news.baidu.com"));
        return routes.build();
    }
}
