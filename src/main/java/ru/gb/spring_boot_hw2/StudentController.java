package ru.gb.spring_boot_hw2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.awt.*;
import java.util.List;


//@Controller //методы при запросах web
@RestController //автоматически все методы помечены @ResponseBody
@RequestMapping("students")
public class StudentController {
    StudentRepository studentRepository;

//  @RequestMapping(path = "all", method = RequestMethod.GET) //http://localhost:8180/all
//  @ResponseBody //вернёт ответ:return
    @GetMapping(path = "all") //заменяет запрос get - @RestController //, produces = MediaType.APPLICATION_NDJSON_VALUE
    public List<Student> getAll(){
        //return List.of(new Student("andrey", "developer on java"), new Student("anna", "developer on java"));
        return studentRepository.getAll();
    }

    @Autowired
    public StudentController(@Qualifier("studentRepository") StudentRepository repository) {
        this.studentRepository = repository;
    }

    @GetMapping("{id}")
    public Student getById(@PathVariable long id){
        return studentRepository.getById(id);
    }

//    @GetMapping("name")
//    public Student getByName(@RequestParam String name){
//        return studentRepository.getByName(name);
//    }
    @GetMapping("search") //localhost:8180/students/search?name=Andrey
    public List<Student> getByNames(@RequestParam String name){
        return studentRepository.getByNames(name);
    }

    //GET /group/{groupName}/student - получить всех студентов группы

    @GetMapping("/group/{groupName}") //http://localhost:8180/students/group/developer%20on%20Python
    public List<Student> getStudentsByGroupName(@PathVariable String groupName) {
        return studentRepository.getStudentsByGroupName(groupName);
    }


}
