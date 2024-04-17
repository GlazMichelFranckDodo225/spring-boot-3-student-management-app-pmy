package com.dgmf.service.impl;

import com.dgmf.entity.Student;
import com.dgmf.repository.StudentRepository;
import com.dgmf.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {
    private final StudentRepository studentRepository;

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public Student getStudentById(String studentId) {
        return studentRepository.findById(studentId).get();
    }

    @Override
    public Student getStudentByStudentCode(String studentCode) {
        return studentRepository.findByStudentCode(studentCode);
    }
}
