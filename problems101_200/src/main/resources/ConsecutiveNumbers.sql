SELECT DISTINCT Num AS ConsecutiveNums FROM (
    SELECT Id, Num,
        @count := If(@preNum = Num, @count+1, 1) AS Count,
        @preNum := Num AS preNum
    From Logs, (SELECT @preNum:=NULL, @count:=1) var
    ) tmp
Where Count >=3;