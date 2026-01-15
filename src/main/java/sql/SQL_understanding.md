This article has some good understanding of how we should think about SQL queries???

Let's address few important points for an SQL query:
1. Logical order of operations: `WHERE` happens before `GROUP BY` and `HAVING`
2. We should avoid un-necessary joins and think of using a `Window` function instead of complex self join
3. How do we handle `NULL` values?


### Aggregation
The key thing to understand here is relationship between `GROUP BY` and filter clauses.

#### The `HAVING` vs `WHERE` trap?

    * `WHERE` - Filters rows before they are grouped
    * `HAVING` - Filters group after the aggregation is calculated

Let's take a problem: Find avg price per category where inventory is greater than 0 and average price > 100
`select category_id, AVG(price)
from product
where inventory <> '0' -- happens first
group by category_id
having AVG(price) > 100; -- filters the resulting groups`

#### Window functions
Window function allows us to perform calculations across a set of rows that are related to current row, without collapsing them into a single output row like `GROUP BY` clauses
Eg. `with priceRank as (
	select 
		name, 
        category_id, 
        price,
        dense_rank() over(partition by category_id order by price desc) as rnk
        from product
)
select * from priceRank where rnk < 4 order by category_id DESC;`

Roadmap to excel SQL interviews: 

* Module 1: Advanced Joins (Self-joins, Cross-joins, and joining on Inequalities).

* Module 2: Window Functions Deep Dive (Frame clauses like ROWS BETWEEN).

* Module 3: Date/Time Manipulation (Calculating churn, retention, and cohorts).

* Module 4: Query Optimization (Indexing, EXPLAIN plans, and reducing BigQuery/Snowflake costs).