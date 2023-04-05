SELECT * FROM tb_student AS s
LEFT JOIN  tb_registry AS r ON s.registry = r.registry_code
WHERE r.status = "IN DEBT"
;