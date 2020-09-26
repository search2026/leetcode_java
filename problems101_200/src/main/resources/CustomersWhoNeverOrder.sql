SELECT C.Name AS Customers
FROM Customers C LEFT JOIN Orders O
ON C.Id = O.CustomerId
WHERE O.CustomerId IS NULL;