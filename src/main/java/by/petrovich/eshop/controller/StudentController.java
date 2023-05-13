package by.petrovich.eshop.controller;

import by.petrovich.eshop.model.Student;
import by.petrovich.eshop.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
//@RequestMapping
public class StudentController {
    StudentService studentService;

    @Autowired
    private StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/index")
    public ResponseEntity<List<Student>> receiveAll(@RequestParam(required = false)String title) {
        try {
            List<Student> students = studentService.findAll();
            return new ResponseEntity<>(students, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
