package boot_eureka_consumer_feign_hystrix;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MowController {

	private PrzykladowyKlientMS przykladowyKlientMS;

	@Autowired
	public MowController(PrzykladowyKlientMS przykladowyKlientMS) {
		this.przykladowyKlientMS = przykladowyKlientMS;
	}
	
	@GetMapping("/mowcos")
	public String mowCos(){
		return przykladowyKlientMS.mow();
	}
	
	
	
}
