package hello.servlet;

import hello.servlet.basic.web.springmvc.v1.SpringMemberFormControllerV1;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@ServletComponentScan // 서블릿 스캔
@SpringBootApplication
public class ServletApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServletApplication.class, args);
	}

//	@Bean // SpringMemberFormControllerV1에서 @Controller 안해도 직접 스프링 빈 등록하면 찾을 수 있음
//	SpringMemberFormControllerV1 springMemberFormControllerV1() {
//		return new SpringMemberFormControllerV1();
//	}

//	@Bean
//	InternalResourceViewResolver internalResourceViewResolver() {
//		return new InternalResourceViewResolver("/WEB-INF/views", ".jsp");
//	}
}
