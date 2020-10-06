Select T.Request_at AS Day, Round(Sum(If(Status='cancelled_by_driver',1,0))/count(*), 2) AS 'Cancellation Rate'
From Trips T JOIN Users U
ON T.Client_Id = U.Users_Id
Where Banned='No' And Role='client' And Request_at Between '2013-10-01' and '2013-10-03'
Group by Request_at
Order by Request_at;
