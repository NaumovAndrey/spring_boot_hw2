package ru.gb.spring_boot_hw2;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration //файл конфигурации
/*
Описываем методы которые возвращают бины
 */
public class AplicationConf {
    @Bean
    StudentRepository MystudentRepository(){
        return new StudentRepository();
    }
}
