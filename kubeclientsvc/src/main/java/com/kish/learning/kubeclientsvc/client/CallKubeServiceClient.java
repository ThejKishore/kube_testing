package com.kish.learning.kubeclientsvc.client;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.PrintWriter;
import java.io.StringWriter;

@Service
public class CallKubeServiceClient {

    @Autowired
    private RestTemplate restTemplate;

    public String doOtherStuff() {
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
