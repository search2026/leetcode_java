/* retain the unique emails*/
Select Min(Id) AS minId, Email From Person
Group by Email

/* delete the emails which don't appear in the unique emails*/
Delete From Person
Where Id not in (
    Select minId From (
        Select min(Id) AS minId, Email
        From Person
        Group by Email
    ) AS tmp
)