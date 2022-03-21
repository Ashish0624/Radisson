package com.myworkspace;

import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

//@EnableScheduling
@SpringBootApplication
public class RedissonApplication {
	
//	@Value("${redis.IP}")
//    private String redisIP;

	
//	@Autowired
//	DataFeeding dataFeeding;
	
	public static void main(String[] args) {
		SpringApplication.run(RedissonApplication.class, args);
	}
	
//	@Scheduled(fixedRate = 300000)
//	public void callingMain() throws Exception {
////		List<MasterSurveyType> list = dataFeeding.getSurveyType();
////		dataFeeding.redisGet(list);
////		dataFeeding.getSurveyList();
//	}
//	@Bean
//    RedissonClient redisson()
//    {
//        Config config = new Config();
//        // use single Redis server
//        config.useSingleServer().setAddress( "redis://" + "localhost:6379" );
//        RedissonClient redisson = Redisson.create( config );
//        System.out.println("Redis Configured");
//        return redisson;
//    }
}
