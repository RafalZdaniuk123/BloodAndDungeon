package pl.rafal.bloodindungeon.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "pl.rafal.bloodindungeon")
public class BloodindungeonApplication {

	public static void main(String[] args) {
		SpringApplication.run(BloodindungeonApplication.class, args);
	}

}
