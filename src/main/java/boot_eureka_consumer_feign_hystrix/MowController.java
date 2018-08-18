package boot_eureka_consumer_feign_hystrix;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;

@RestController
public class MowController {

	private PrzykladowyKlientMS przykladowyKlientMS;

	@Autowired
	public MowController(PrzykladowyKlientMS przykladowyKlientMS) {
		this.przykladowyKlientMS = przykladowyKlientMS;
	}
	
	@HystrixCommand(fallbackMethod="metodaFallback",
			 commandProperties = {
					    @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "20000"),
					    @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "5000"),
					    @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "10")
					}
			)
	@GetMapping("/mowcos")
	public String mowCos(){
		return przykladowyKlientMS.mow();
	}
	
	
	@HystrixCommand(fallbackMethod="metodaFallback",
			 commandProperties = {
					    @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "20000"),
					    @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "5000"),
					    @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "10")
					}
			)
	@GetMapping("/mowDlugo")
	public String mowDlugo(){
		return przykladowyKlientMS.mowDlugo();
	}
	
	public String metodaFallback(){
		return "To mowi metoda fallback";
	}
	
	
}
