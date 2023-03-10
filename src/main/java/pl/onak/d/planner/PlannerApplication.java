package pl.onak.d.planner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
/**
 * Schedule planner program implements an application that
 * generates schedule for diffrent applications.
 *
 * @author  Dawid Onak
 * @version 1.0
 * @since   2023-03-07
 */
@SpringBootApplication
public class PlannerApplication {

	public static void main(String[] args) {
		SpringApplication.run(PlannerApplication.class, args);
	}

}
