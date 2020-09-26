Select Id From (
Select Id, Date, Temperature,
    @Higher := If(Temperature > @preTemp, 'Yes', 'No') AS Higher,
    @DateContinuous := If(Datediff(Date, @preDate) = 1, 'Yes', 'No') AS DateContinuous,
    @preTemp := Temperature AS preTemp,
    @preDate := Date
From Weather, (Select @preTemp:=NULL, @Higher:=NULL, @preDate:=NULL) var
Order by Date
) tmp
Where Higher = 'Yes' AND DateContinuous = 'Yes';