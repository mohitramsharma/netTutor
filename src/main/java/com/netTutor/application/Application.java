package com.netTutor.application;

import com.opentok.OpenTok;
import com.opentok.exception.OpenTokException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.*;
import org.springframework.context.annotation.*;
import org.springframework.data.jpa.repository.config.*;
import org.springframework.orm.jpa.vendor.*;

import javax.persistence.*;

@SpringBootApplication
@Configuration
@ComponentScan("com.netTutor.application")
@EnableJpaRepositories(basePackages = {"com.netTutor.application.repository"})
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Bean
	public HibernateJpaSessionFactoryBean sessionFactory(EntityManagerFactory emf) {
		HibernateJpaSessionFactoryBean factory = new HibernateJpaSessionFactoryBean();
		factory.setEntityManagerFactory(emf);
	//	generateOTSession();
		return factory;
	}

	private static void generateOTSession() {
		// A session that attempts to stream media directly between clients:
		try {
			int apiKey = 46056512; // YOUR API KEY
			String apiSecret = "1c7a7a3c42c0adb454fe2029eff94ec1e947a0d2";
			OpenTok opentok = new OpenTok(apiKey, apiSecret);

			// A Session with a location hint:
			com.opentok.Session session = opentok.createSession();

			String sessionId = session.getSessionId();
			String token = opentok.generateToken(sessionId);

			System.out.println("sessionId :"+sessionId+" Token: "+token);


		} catch (OpenTokException e) {
			e.printStackTrace();
		}



	}

}
