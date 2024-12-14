package com.sindero.DnD.config;

import com.sindero.DnD.OneLineLogger;
import feign.Logger;
import jakarta.persistence.criteria.Order;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.testcontainers.shaded.org.checkerframework.checker.mustcall.qual.CreatesMustCallFor;

@Configuration
public class FeignClientConfig {

    @Bean
    Logger.Level feignLoggerLevel() {
        return Logger.Level.FULL;
    }

    @Bean
    public Logger logger() {
        return new OneLineLogger();
    }
}

@FeignClient(name = "your-service", configuration = FeignClientConfig.class)
public interface YourServiceClient {
    @GetMapping("/your-endpoint")
    String getYourEndpoint();

}

@FeignClient(name = "Order-Service", fallback = OrderClientFallback.class)
public interface OrderClient {
    @GetMapping("/orders/{userId}")
    List<Order> getOrdersByUserId(@PathVariable("userId") String userId);

}

@Component
public class OrderClientFallback implements OrderClient {
    @Override
    public List<Order> getOrdersByUserId(String userId) {
        return Collections.emptyList();
    }
}

@FeignClient("Order-Service")
public interface CustomOrderClient {
    @GetMapping("/orders")
    List<Order> getOrdersByStatus(@RequestParam("status") String orderStatus);
}

@RestController
public class UserController {
    @Autowired
    private OrderClient orderClient;

    @GetMapping("/user/{id}/orders")
    public List<Order> getUserOrders(@PathVariable("id") String id) {
        return orderClient.getOrdersByUserId(id);
    }
}

@FeignClient("Order-Service")
public interface OrderClient {
    @GetMapping("/orders/{userId}")
    CreatesMustCallFor.List<Order> getOrdersByUserId(@PathVariable("userId") String userId);
}
