package ru.gb.spring_boot_hw2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(Application.class, args);
//		StudentRepository studentRepository = context.getBean(StudentRepository.class);
//		System.out.println(studentRepository.getAll());
//		System.out.println(context.getBean("studentRepository", StudentRepository.class).getAll()); //указываем имя бина и класс
	}
}
