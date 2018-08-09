package boot_eureka_consumer_feign_hystrix;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient("boot-eureka-client")
public interface PrzykladowyKlientMS {

	@RequestMapping("/mow")
	public String mow();
	
}
