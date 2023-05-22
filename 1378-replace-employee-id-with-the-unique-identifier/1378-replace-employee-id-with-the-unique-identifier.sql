SELECT
        B.unique_id, A.name
FROM
        Employees AS A LEFT JOIN EmployeeUNI AS B
ON
        A.id = B.id
;