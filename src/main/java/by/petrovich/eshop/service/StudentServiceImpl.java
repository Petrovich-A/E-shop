package by.petrovich.eshop.service;

import by.petrovich.eshop.repository.StudentRepository;
import by.petrovich.eshop.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    StudentRepository studentRepository;
    @Autowired
    private StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public List<Student> findAll() {
        return studentRepository.findAll();
    }


}
