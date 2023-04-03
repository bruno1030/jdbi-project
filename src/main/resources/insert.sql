BEGIN
    INSERT INTO student_db.tb_student
    (
        name,
        age,
        stage,
        registrationDate
    )
    VALUES
    (
        student:name,
        student:age,
        student:stage,
        student:registrationDate
    )
END