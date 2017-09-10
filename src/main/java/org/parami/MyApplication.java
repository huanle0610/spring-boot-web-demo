package org.parami;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
@RestController
public class MyApplication {
	protected static org.slf4j.Logger logger = LoggerFactory.getLogger(MyApplication.class);

	@RequestMapping("home")
	public List<String> showData() {
		List<String> list = Arrays.asList("Ram", "Shyam", "Mohan");
		return list;     
 	}

	public static void main(String[] args) {
		SpringApplication.run(MyApplication.class, args);
	}
}