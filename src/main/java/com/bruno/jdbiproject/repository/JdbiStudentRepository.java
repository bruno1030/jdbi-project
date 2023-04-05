package com.bruno.jdbiproject.repository;

import com.bruno.jdbiproject.entity.Student;
import com.bruno.jdbiproject.mapper.StudentMapper;
import org.jdbi.v3.sqlobject.config.RegisterBeanMapper;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.locator.UseClasspathSqlLocator;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;
import org.jdbi.v3.sqlobject.statement.UseRowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@UseClasspathSqlLocator
public interface JdbiStudentRepository extends StudentRepository {

    @Override
    @SqlQuery
    @UseRowMapper(StudentMapper.class)
    List<Student> getAllStudents();

    @Override
    @SqlUpdate
    void insert(@BindBean("student") Student student);

    @Override
    @SqlUpdate
    void insertRegistry(@BindBean("student") Student student);

    @Override
    @SqlQuery
    @UseRowMapper(StudentMapper.class)
    List<Student> getStudentsInDebt();

}
