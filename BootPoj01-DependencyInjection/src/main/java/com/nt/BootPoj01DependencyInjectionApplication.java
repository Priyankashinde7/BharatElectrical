package com.nt;
import java.time.LocalDate;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import com.nt.beans.SeasonFinder;

@SpringBootApplication
public class BootPoj01DependencyInjectionApplication {
	
	@Bean(name="id")
	public LocalDate createDate() {
		return LocalDate.now();
	}
	public static void main(String[] args) {
		//get IOC container
		ApplicationContext ctx=SpringApplication.run(BootPoj01DependencyInjectionApplication.class, args);
		//get tareget spring bean class obj
		SeasonFinder finder = ctx.getBean("sf",SeasonFinder.class);
		//invoke the b.methods
		String seasonName=finder.findSeason();
		System.out.println("Season Name :: "+seasonName);
		
		//close the IOC container
		((ConfigurableApplicationContext)ctx).close();
	}

}
