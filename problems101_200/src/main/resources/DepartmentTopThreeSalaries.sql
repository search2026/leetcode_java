SELECT D.Name AS Department, T.Name AS Employee, T.Salary
FROM
(
SELECT DepartmentId, Name, Salary,
    (CASE WHEN @id=DepartmentId THEN @rank:= IF(@preSalary = Salary, @rank, @rank+1)
         ELSE @rank:= 1
    END) AS Rank,
    @preSalary:= Salary AS preSalary,
    @id:= DepartmentId AS preId
From Employee, (SELECT @rank:=0, @preSalary:=-1, @id:=NULL) var
ORDER BY DepartmentId, Salary DESC
) T JOIN Department D
ON T.DepartmentId = D.Id
Where T.Rank <=3;
