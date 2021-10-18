package com.iuh.student.service;

import com.iuh.student.enity.Student;
import com.iuh.student.repository.StudentRepository;
import com.iuh.student.vo.Faculty;
import com.iuh.student.vo.ResponseTemplate;
import io.github.resilience4j.retry.annotation.Retry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private RestTemplate restTemplate;

    public Student saveStudent(Student student){
        return studentRepository.save(student);
    }


    @Retry(name = "basic")
    public ResponseTemplate getUserWithFaculties(Long studentId){
        ResponseTemplate responseTemplate = new ResponseTemplate();
        Student student = studentRepository.findById(studentId).get();
        Faculty faculty = restTemplate.getForObject("http://localhost:9001/faculty/" + student.getFacultyId()
        , Faculty.class);

        responseTemplate.setStudent(student);
        responseTemplate.setFaculty(faculty);

        return responseTemplate;
    }
}
