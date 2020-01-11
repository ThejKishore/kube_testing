package com.kish.learning.kubegateway;

//import io.dekorate.kubernetes.annotation.*;
//import io.dekorate.prometheus.annotation.EnableServiceMonitor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.discovery.ReactiveDiscoveryClient;
import org.springframework.cloud.gateway.discovery.DiscoveryClientRouteDefinitionLocator;
import org.springframework.cloud.gateway.discovery.DiscoveryLocatorProperties;
import org.springframework.context.annotation.Bean;


//@KubernetesApplication (
		/*ports = {
				@Port(name="kubegatewayservice",containerPort = 9002,hostPort = 39002,protocol = Protocol.TCP)
		},
		serviceType = ServiceType.NodePort,
		envVars = {
				@Env(name = "key1", configmap = "my-config", value = "key1"),
				@Env(name = "key2", secret="my-secret", value = "key2")
		}*/

//)
//@EnableServiceMonitor(port = "http", path="/prometheus", interval=20)
@SpringBootApplication
@EnableDiscoveryClient
public class KubegatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(KubegatewayApplication.class, args);
	}


	@Bean
	public DiscoveryClientRouteDefinitionLocator discoveryClientRouteLocator(ReactiveDiscoveryClient discoveryClient, DiscoveryLocatorProperties discoveryLocatorProperties) {
		return new DiscoveryClientRouteDefinitionLocator(discoveryClient,discoveryLocatorProperties);
	}

}
