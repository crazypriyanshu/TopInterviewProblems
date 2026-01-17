## What is Window functions?

Standard `GROUP BY` is like a Reducer that aggregates multiple inputs into one output. 
A `Window Function` is like a Map operation that has access to a "sliding window" of neighbor records.

Window Functions are the way to perform "streaming aggregation" on a result set without collapsing the rows into a single group.

### Anatomy of Window function
Syntax: 
`FUNCTION_NAME() OVER (PARTITION BY ... ORDER BY ... FRAME_CLAUSE)`

**PARTITION BY: This** is the grouping logic. It defines the boundaries.(eg. reset sum for every user_id)
**ORDER BY**: This defines the sequence within partition. very crucial for ranking or time-series related data
**FRAME_CLAUSE**: Defines the sub-window(eg. last 3 rows, or from start until now)

### Ranking Functions:

1. `ROW_NUMBER()`: Unique incrementing numbers (eg. 1, 2, 3, 4)
2. `RANK()`: Gives ranking, handle ties by skipping the number(1, 1, 3, 4)
3. `DENSE_RANK()`: Gives ranking, handle ties without skipping(1, 2, 2, 3)

### Value Functions:
1. `LAG(col, n)`: Access the value of last n rows before current
2. `LEAD(col, n)`: Access the value of next n rows after current

### Aggregate Window Functions:
1. `SUM(col) OVER(...)`: can create a running total if an `ORDER BY` is provided


### Why and when to use them?
1. Eliminates self join, 
2. Doing a JOIN on the same table to compare "Current vs. Previous" is O(N^2). Window functions usually perform this in a single pass O(N), saving massive amounts of I/O and memory.
3. Unlike `GROUP BY`, window function don't lose the individual row data, in queries, we can see the `transaction_id` along with `tot_spent_by_user` next to it


## Some Interview level problems:
1. Problem 1: The "Gap Analysis" You have a table **ServerLogs** with **timestamp** and **status** as col. 
    A "**Downtime**" event is defined as any _gap between two consecutive logs greater than 5 minutes_.
    Question: How would you write a query to find the start and end time of all downtime periods?

    Mental model:
        1. For every log entry: identify the timestamp, identify preceding records 
        2. Find the diff between current record timestamp and previous record timestamp
        3. Identify only those records whose where diff is above 5 min
        4. The "Start" of downtime is the previous_timestamp, and the "End" is the current_timestamp.
 Solution:
        WITH DeltaCalculation AS(
            SELECT timestamp as end_time, LAG(timestamp) OVER(ORDER BY timestamp) as start_time
            FROM ServerLogs
        ) 
        SELECT start_time, end_time, (end_time - start_time) AS downtime_duration 
        FROM DeltaCalculation
        WHERE (end_time - start_time) > INTERVAL '5 minutes'; 
