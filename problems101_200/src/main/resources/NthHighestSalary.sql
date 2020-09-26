SELECT DISTINCT Salary FROM (
    SELECT Id, Salary,
        @rank := if(@preSalary = Salary, @rank, @rank+1) AS Rank,
        @preSalary := Salary AS preSalary
    From Employee, (SELECT @rank:=0, @preSalary:=-1) var
    Order by Salary DESC
    ) tmp
Where Rank=N;