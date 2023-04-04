package com.bruno.jdbiproject.mapper;

import com.bruno.jdbiproject.dto.StudentDTO;
import com.bruno.jdbiproject.entity.Stage;
import com.bruno.jdbiproject.entity.Student;
import org.jdbi.v3.core.mapper.RowMapper;
import org.jdbi.v3.core.statement.StatementContext;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
public class StudentMapper implements RowMapper<Student> {

    @Override
    public Student map(ResultSet rs, StatementContext ctx) throws SQLException {
        try {
            Student student = new Student();
            student.setId(rs.getInt("id"));
            student.setName(rs.getString("name"));
            student.setAge(rs.getInt("age"));
            student.setStage(Stage.valueOf(rs.getString("stage")));
            student.setRegistrationDate(rs.getDate("registrationDate"));
            return student;
        }catch(IllegalArgumentException error){
            throw new SQLException(error.getMessage());
        }
    }

    public Student dtoToEntity(StudentDTO studentDTO) {
        Student student = new Student();
        student.setName(studentDTO.getName());
        student.setAge(studentDTO.getAge());
        student.setStage(getStudentStage(studentDTO.getStage()));
        student.setRegistrationDate(new Date());

        return student;
    }

    public List<StudentDTO> entityToDto(List<Student> students) {
        List<StudentDTO> dtoList = new ArrayList<>();
        for (int i = 0; i < students.size(); i++) {
            StudentDTO dto = new StudentDTO();
            dto.setId(students.get(i).getId());
            dto.setName(students.get(i).getName());
            dto.setAge(students.get(i).getAge());
            dto.setStage(students.get(i).getStage().toString());
            dtoList.add(dto);
        }
        return dtoList;
    }

    private Stage getStudentStage(String stage){
        switch(stage){
            case "1":
            case "BEGINNER":
                return Stage.BEGINNER;
            case "2":
            case "PROFICIENT":
                return Stage.PROFICIENT;
            case "3":
            case "ADVANCED":
                return Stage.ADVANCED;
            default:
                return Stage.UNDEFINED;
        }
    }


}
