/*
Mary is a teacher in a middle school and she has a table seat storing students' names and their corresponding seat ids.

The column id is continuous increment.
Mary wants to change seats for the adjacent students.
Can you write a SQL query to output the result for Mary?
+---------+---------+
|    id   | student |
+---------+---------+
|    1    | Abbot   |
|    2    | Doris   |
|    3    | Emerson |
|    4    | Green   |
|    5    | Jeames  |
+---------+---------+
For the sample input, the output is:
+---------+---------+
|    id   | student |
+---------+---------+
|    1    | Doris   |
|    2    | Abbot   |
|    3    | Green   |
|    4    | Emerson |
|    5    | Jeames  |
+---------+---------+
Note:
If the number of students is odd, there is no need to change the last one's seat.
*/



/* get all the even numbered rows as odd numbered rows */
SELECT s1.id - 1 as id, s1.student
FROM Seat s1
WHERE s1.id MOD 2 = 0

UNION

/* get all the odd numbered rows as even numbered rows */
SELECT s2.id + 1 as id, s2.student
FROM Seat s2
WHERE s2.id MOD 2 = 1 AND s2.id != (SELECT MAX(id) FROM Seat)
/* Just don't get the last row as we will handle it in the next UNION */

UNION

/* get the last row if odd and don't change the id value */
SELECT s3.id, s3.student
FROM Seat s3
WHERE s3.id MOD 2 = 1 AND s3.id = (SELECT MAX(id) FROM Seat)

/* Order the result by id */
ORDER BY id ASC;