package ru.gb.spring_boot_hw2;

import lombok.Data;

@Data //анатация lombok (делает get, set полям и переопределён метод toString)
public class Student {
    private static long curId = 1;
    private final long id;
    private final String name;
    private String nameGroup;

    public Student(String name, String nameGrup) {
        this.id = curId++;
        this.name = name;
        this.nameGroup = nameGrup;
    }
}
