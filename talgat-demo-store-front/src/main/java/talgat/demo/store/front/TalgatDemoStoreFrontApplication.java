package talgat.demo.store.front;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import talgat.demo.store.front.model.Cart;
import talgat.demo.store.front.model.Order;
//import talgat.demo.store.front.model.User;
//import talgat.demo.store.front.repository.UserRepository;
import talgat.demo.store.front.repository.UserRepository;
import talgat.demo.store.front.services.CheckoutServices;
import talgat.demo.store.front.services.ItemServices;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@Slf4j
@SpringBootApplication
public class TalgatDemoStoreFrontApplication {

	public static void main(String[] args) {
		SpringApplication.run(TalgatDemoStoreFrontApplication.class, args);
	}

	@Bean
	public ApplicationRunner dataLoader(ItemServices itemServices,
										CheckoutServices checkoutServices,
										UserRepository userRepo){
		return (ApplicationArguments s) ->{
			System.out.println(itemServices.getItemById("301"));
			System.out.println(userRepo.findByUsername("natalie").block().toString());
//			itemServices.getAllItems().doOnNext(item -> System.out.println(item)).subscribe();
//			System.out.println(itemServices.getAllItems().toString());
//			Order order1 =  new Order();
//			order1.setDeliveryAddress("54545454");
//			Set<Long> set1 = new HashSet<>();
//			set1.add(133L);
//			set1.add(134L);
//			order1.setItemIds(set1);
////			checkoutServices.saveOrder(order1).subscribe();
//			System.out.println(order1.toString());

//			User user1 = new User("talim", "talim", "talim", "talim", "talim");
//			userRepo.save(user1).subscribe();
		};
	}

}
