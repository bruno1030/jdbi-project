package com.bruno.jdbiproject.config;

import com.bruno.jdbiproject.repository.JdbiStudentRepository;
import com.bruno.jdbiproject.repository.StudentRepository;
import org.jdbi.v3.core.Jdbi;
import org.jdbi.v3.core.mapper.RowMapper;
import org.jdbi.v3.core.spi.JdbiPlugin;
import org.jdbi.v3.sqlobject.SqlObjectPlugin;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.TransactionAwareDataSourceProxy;

import javax.sql.DataSource;
import java.util.List;

@Configuration
public class JdbiConfiguration {

    @Bean
    public StudentRepository studentRepository(Jdbi jdbi){
        return jdbi.onDemand(JdbiStudentRepository.class);
    }

    @Bean
    public Jdbi jdbi(DataSource ds, List<JdbiPlugin> jdbiPlugins, List<RowMapper<?>> rowMappers) {
        TransactionAwareDataSourceProxy proxy = new TransactionAwareDataSourceProxy(ds);
        Jdbi jdbi = Jdbi.create(proxy);

        jdbiPlugins.forEach(jdbi::installPlugin);
        rowMappers.forEach(jdbi::registerRowMapper);

//        jdbiPlugins.forEach(plugin -> jdbi.installPlugin(plugin));
//        rowMappers.forEach(mapper -> jdbi.registerRowMapper(mapper));

        return jdbi;
    }

    @Bean
    public JdbiPlugin sqlObjectPlugin(){
        return new SqlObjectPlugin();
    }


}
