package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@EnableWebMvc
@EnableAutoConfiguration
@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
}

@Controller
 class Test{
	@RequestMapping("/html")
	public /*@ResponseBody*/ String greeting(Model model) {

		model.addAttribute("name", "Kakaha");
		return "test";
	}

}


@Controller
 class Testu{
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public /*@ResponseBody*/ String greeting(Model model, @RequestParam String login) {

		model.addAttribute("login", login);
		return "after_login";
	}

//	@RequestMapping(value = "/login", method = RequestMethod.GET)
//	public  String greeting() {
//
//		return "login";
//	}
}

@RestController
 class Test1 {
	@RequestMapping("/rest")
	public @ResponseBody User greeting() {

		return new User();
	}

}

class User {
	private String name = "Gosha";
	private String age = "21";

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}
}
