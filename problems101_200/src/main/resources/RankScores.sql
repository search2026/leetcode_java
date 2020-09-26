SELECT Score, Rank FROM (
    SELECT Id, Score,
        @rank := if(@preScore = Score, @rank, @rank+1) AS Rank,
        @preScore := Score AS preScore
    From Scores, (SELECT @rank:=0, @preScore:=-1) var
    Order by Score DESC
    ) tmp;