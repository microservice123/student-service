package com.iuh.student.vo;

import com.iuh.student.enity.Student;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseTemplate {
    private Student student;
    private Faculty faculty;
}
