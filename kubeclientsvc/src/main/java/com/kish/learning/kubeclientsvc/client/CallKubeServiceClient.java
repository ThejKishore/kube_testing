package com.kish.learning.kubeclientsvc.client;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.PrintWriter;
import java.io.StringWriter;

@Service
@Slf4j
public class CallKubeServiceClient {

    @Autowired
    private DiscoveryClient discoveryClient;


    @Autowired
    private RestTemplate restTemplate;

    public String doOtherStuff() {
        log.info(" Service Details {} ",discoveryClient.getInstances("kubeservice"));
        try{
            String results = restTemplate.getForObject("http://kubeservice/greet/guest", String.class);
            return results;
        }catch(Exception e){
            StringWriter stringWriter = new StringWriter();
            e.printStackTrace(new PrintWriter(stringWriter));
            return  stringWriter.toString();
        }
    }
}
