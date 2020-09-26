SELECT D.Name AS Department, T.Name AS Employee, T.Salary AS Salary
FROM Department D,
    (
    SELECT Name, Salary, E.DepartmentId FROM Employee E JOIN (
    SELECT DepartmentId, MAX(Salary) AS MaxSalary FROM Employee
    GROUP BY DepartmentId) tmp
    ON E.DepartmentId = tmp.DepartmentId
    WHERE E.Salary = tmp.MaxSalary
    ) AS T
WHERE D.Id = T.DepartmentId;