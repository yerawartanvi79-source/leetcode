# Write your MySQL query statement below
select t.request_at as Day,
round(
    sum(case
    when t.status!='completed' then 1
    else 0
    end)/count(*),2) as "Cancellation Rate"
from trips t
join users c
ON t.client_id = c.users_id
JOIN Users d 
    ON t.driver_id = d.users_id
WHERE c.banned = 'No'
  AND d.banned = 'No'
  AND t.request_at BETWEEN '2013-10-01' AND '2013-10-03'
GROUP BY t.request_at;