package com.example.springcloudconsumer;

import com.example.springcloudconsumer.order.Order;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import javax.ws.rs.GET;

@SpringBootApplication
@EnableEurekaClient
@Controller
@Configuration
public class SpringCloudConsumerApplication {

    @Bean
    @LoadBalanced
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }

    @RequestMapping(value = "/toPage")
    public String toList(){
        return "index";
    }

    @RequestMapping(value = "/order")
    @ResponseBody
    public String result(){
        RestTemplate rtp = getRestTemplate();
        String result = rtp.getForObject("http://spring-provider/call",String.class);
        return result;
    }


    public static void main(String[] args) {
        SpringApplication.run(SpringCloudConsumerApplication.class, args);
    }

}

