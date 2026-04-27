# Write your MySQL query statement below
SELECT 
    ROUND(
        COUNT(DISTINCT a.player_id) / 
        (SELECT COUNT(DISTINCT player_id) FROM Activity),
        2
    ) AS fraction
FROM Activity a
JOIN (
    -- Step 1: Get first login date for each player
    SELECT player_id, MIN(event_date) AS first_login
    FROM Activity
    GROUP BY player_id
) b
ON a.player_id = b.player_id
-- Step 2: Check if player logged in next day
WHERE a.event_date = DATE_ADD(b.first_login, INTERVAL 1 DAY);