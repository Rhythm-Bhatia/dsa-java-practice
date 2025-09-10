-- # Write your MySQL query statement belo
-- -- select a.machine_id,ROUND(AVG(b.timestamp-a.timestamp),3)as processing_time
-- -- from Activity as a Join Activity as b
-- -- on a.machine_id=b.machine_id AND a.process_id=b.process_id
-- -- where a.activity_type='start' AND b.activity_type='end'
-- -- group by a.machine_id












































select a.machine_id,round(avg(b.timestamp-a.timestamp),3) as processing_time
from Activity as a join Activity as b
on a.machine_id=b.machine_id && a.process_id=b.process_id
where a.activity_type='start' and b.activity_type='end'
group by a.machine_id;