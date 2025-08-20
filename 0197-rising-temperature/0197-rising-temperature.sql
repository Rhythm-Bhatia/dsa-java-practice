# Write your MySQL query statement below
select w2.id
from Weather as w1
join Weather as w2 
on DateDiff(w1.recordDate,w2.recordDate)=-1 && w2.temperature>w1.temperature


-- select w2.id
-- from Weather as w1
-- join Weather as w2 
-- on DateDiff(w1.recordDate,w2.recordDate)=-1 
-- where w2.temperature>w1.temperature