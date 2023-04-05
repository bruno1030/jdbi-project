package com.bruno.jdbiproject.service;

import com.bruno.jdbiproject.dto.StudentDTO;
import com.bruno.jdbiproject.entity.Student;
import com.bruno.jdbiproject.mapper.StudentMapper;
import com.bruno.jdbiproject.repository.StudentRepository;
import com.bruno.jdbiproject.utils.RegistryCreator;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Component
public class StudentService {

    private final StudentRepository repository;
    private final StudentMapper mapper;

    public StudentService(StudentRepository repository, StudentMapper mapper){
        this.repository = repository;
        this.mapper = mapper;
    }

    public List<StudentDTO> getAllStudents(){
        return mapper.entityToDto(repository.getAllStudents());
    }

    public void save(StudentDTO studentDTO){
        Student student = mapper.dtoToEntity(studentDTO);
        repository.insert(student);
        repository.insertRegistry(student);
    }

    public Map<String, String> getStudentsInDebit(){
        List<StudentDTO> studentsInDebtList= mapper.entityToDtoInDebt(repository.getStudentsInDebt());
        Map<String, String> studentsInDebt = new HashMap<>();
        for (int i = 0; i < studentsInDebtList.size(); i++) {
            String name = studentsInDebtList.get(i).getName();
            String registry = studentsInDebtList.get(i).getRegistry();
            studentsInDebt.put(name, registry);
        }
        return studentsInDebt;
    }

}
