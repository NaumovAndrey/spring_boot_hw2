package ru.gb.spring_boot_hw2;

import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
//@Scope(ConfigurableListableBeanFactory.SCOPE_PROTOTYPE) //Тип бина: возвращает один и тот же бин
public class StudentRepository {
    private final List<Student> list;

    public StudentRepository() {
        list = new ArrayList<>();
        list.add(new Student("Andrey", "developer on C++"));
        list.add(new Student("Alena", "developer on Java"));
        list.add(new Student("Anna", "developer on Python"));
        list.add(new Student("Andrey", "developer on Java"));
        list.add(new Student("Ivan", "developer on C++"));
        list.add(new Student("Danil", "developer on Java"));
        list.add(new Student("Elena", "developer on Python"));
        list.add(new Student("Vladimir", "developer on C#"));
        list.add(new Student("Vlad", "developer on C#"));
    }

    public Student getById(long id){
        return list.stream().filter(e -> e.getId() == id).findFirst().orElse(null);
    }

    public List<Student> getAll(){
        return List.copyOf(list);
    }

//    public Student getByName(String name){
//        return list.stream()
//              .filter(e -> e.getName().equals(name)).findFirst().orElse(null);
//    }

    public List<Student> getByNames(String name){
        return list.stream()
                .filter(e -> e.getName().equals(name))
                .collect(Collectors.toList());
    }

    public List<Student> getStudentsByGroupName(String groupName) {
        List<Student> studentsInGroup = new ArrayList<>();
        for (Student student : list) {
            if (student.getNameGroup().equals(groupName)) {
                studentsInGroup.add(student);
            }
        }
        return studentsInGroup;
    }
}
