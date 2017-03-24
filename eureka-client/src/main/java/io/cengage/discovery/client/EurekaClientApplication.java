import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.PropertiesPropertySource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.ZoneId;
import java.util.Properties;

@Configuration
@EnableAutoConfiguration
//@EnableEurekaClient
@EnableDiscoveryClient
@RestController
@SpringBootApplication
public class EurekaClientApplication {

	@RequestMapping("/")
	public String home() {
		return "Hello World";
	}

	@RequestMapping("/one")
	public String one() {
		return "Hello World - One";
	}

	@RequestMapping("/two ")
	public String two() {
		return "Hello World - Two";
	}

	@RequestMapping("/three")
	public String three() {
		return "Hello World - Three";
	}

	@RequestMapping("/four")
	public String four() {
		return "Hello World - four";
	}

	public static void main(String[] args) {
		SpringApplication.run(EurekaClientApplication.class, args);
	}


}