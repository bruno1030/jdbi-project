        INSERT INTO tb_student
        (
            name,
            age,
            stage,
            registration_date,
            registry
        )
        VALUES
        (
            :student.name,
            :student.age,
            :student.stage,
            :student.registrationDate,
            :student.registry
        );

