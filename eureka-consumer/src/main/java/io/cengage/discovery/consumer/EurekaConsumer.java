package io.cengage.discovery.consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.logging.Logger;

/**
 * Hello world!
 *
 */
@SpringBootApplication
@EnableDiscoveryClient
@RestController
public class EurekaConsumer
{
    Logger logger = Logger.getLogger(EurekaConsumer.class.getName());
    @Autowired
    private DiscoveryClient discoveryClient;

//    @RequestMapping("/")
//    public String consume() {
//        InstanceInfo instance =  discoveryClient.getInstances("HELLOWORKSERVICE");  //getNextServerFromEureka("PRODUCER", false);
//
//        RestTemplate restTemplate = new RestTemplate();
//        String response = restTemplate.getForObject(instance.getHomePageUrl(), String.class);
//
//        return String.format("{\"value\": %s}", response);
//    }

    @RequestMapping("/")
    public String root(){
        return "Hello Anand";
    }

//    @RequestMapping("/service-instances/{applicationName}")
    @RequestMapping("/a")
    public List<ServiceInstance> serviceInstancesByApplicationName(

            @PathVariable String applicationName) {
        logger.info("Trying to run get  the instances ");

        List<ServiceInstance> instances = null;
        try {
            instances = this.discoveryClient.getInstances("HELLOWORLDSERVICE");
            logger.info("Extracted the instances ");
        } catch (Exception e) {
            logger.info("Error extracting instances");
        }
        return instances;


    }

    public static void main( String[] args )
    {
        SpringApplication.run(EurekaConsumer.class, args);
    }
}
