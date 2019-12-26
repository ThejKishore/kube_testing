package com.kish.learning.kubeclientsvc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

@SpringBootApplication
@EnableDiscoveryClient
@RibbonClient(name = "kubeservice")
public class KubeclientsvcApplication {

  public static void main(String[] args) {
    SpringApplication.run(KubeclientsvcApplication.class, args);
  }
}
