package team.spring.aqs;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("team.spring.aqs.mapper")
public class AQSApplication {
	public static void main(String[] args) {
		SpringApplication.run(AQSApplication.class, args);
	}

}
