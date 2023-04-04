package com.bruno.jdbiproject.mapper;

import com.bruno.jdbiproject.dto.StudentDTO;
import com.bruno.jdbiproject.entity.Student;
import org.jdbi.v3.core.mapper.RowMapper;
import org.jdbi.v3.core.statement.StatementContext;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Component
public class StudentMapper implements RowMapper<Student> {

    @Override
    public Student map(ResultSet rs, StatementContext ctx) throws SQLException {
        try {
            Student student = new Student();
            student.setName(rs.getString("name"));
            student.setAge(rs.getInt("age"));
            return student;
        }catch(IllegalArgumentException error){
            throw new SQLException(error.getMessage());
        }
    }

    public Student dtoToEntity(StudentDTO studentDTO) {
        Student student = new Student();
        student.setName(studentDTO.getName());
        student.setAge(studentDTO.getAge());

        return student;
    }

    public List<StudentDTO> entityToDto(List<Student> students) {
        List<StudentDTO> dtoList = new ArrayList<>();
        for (int i = 0; i < students.size(); i++) {
            StudentDTO dto = new StudentDTO();
            dto.setName(students.get(i).getName());
            dto.setAge(students.get(i).getAge());
            dtoList.add(dto);
        }
        return dtoList;
    }

}
