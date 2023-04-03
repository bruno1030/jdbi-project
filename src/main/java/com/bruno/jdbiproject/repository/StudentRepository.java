package com.bruno.jdbiproject.repository;

import com.bruno.jdbiproject.entity.Student;
import com.bruno.jdbiproject.mapper.StudentMapper;
import org.jdbi.v3.sqlobject.config.RegisterBeanMapper;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;
import org.springframework.stereotype.Repository;

@Repository
@RegisterBeanMapper(value = StudentMapper.class)
public interface StudentRepository {

    @SqlUpdate
    void insert(Student student);

}
