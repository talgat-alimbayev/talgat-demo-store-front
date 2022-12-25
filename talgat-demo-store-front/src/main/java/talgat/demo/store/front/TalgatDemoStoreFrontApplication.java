package talgat.demo.store.front;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import talgat.demo.store.front.services.ItemServices;

import java.util.Arrays;
@Slf4j
@SpringBootApplication
public class TalgatDemoStoreFrontApplication {

	public static void main(String[] args) {
		SpringApplication.run(TalgatDemoStoreFrontApplication.class, args);
	}

	@Bean
	public ApplicationRunner dataLoader(ItemServices itemServices){
		return (ApplicationArguments s) ->{
			itemServices.getAllItems().doOnNext(item -> System.out.println(item)).subscribe();
//			System.out.println(itemServices.getById("122").block());
		};
	}

}
