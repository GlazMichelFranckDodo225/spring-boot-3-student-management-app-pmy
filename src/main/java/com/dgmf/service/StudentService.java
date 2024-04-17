package com.dgmf.service;

import com.dgmf.entity.Student;

import java.util.List;

public interface StudentService {
    List<Student> getAllStudents();
    Student getStudentById(String studentId);
    Student getStudentByStudentCode(String studentCode);
}
