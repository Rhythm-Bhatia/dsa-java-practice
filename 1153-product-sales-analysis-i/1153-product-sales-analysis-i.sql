# Write your MySQL query statement below
select product_name,year,price
from Sales as s
Inner Join Product as p
on s.product_id=p.product_id;