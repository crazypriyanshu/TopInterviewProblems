-- query to calculate the
-- total sales amount of each item for each year,
-- with corresponding product_id, product_name and report year
-- order by product id, report year
-- use cte method
-- sale period between range 2018 - 2022

WITH FD as (
    select date_add(Last_Day(date('2017-12-31')), interval 1 day) as FirstDay
    union
    select date_add(Last_Day(date('2018-12-31')), interval 1 day)
    union
    select date_add(Last_Day(date('2019-12-31')), interval 1 day)
    union
    select date_add(Last_Day(date('2020-12-31')), interval 1 day)
    union
    select date_add(Last_Day(date('2021-12-31')), interval 1 day)
    union
    select date_add(Last_Day(date('2022-12-31')), interval 1 day)
),
LD as(
    select FirstDay, Lead(FirstDay) over(order by FirstDay) as Last_D from FD
),
Calender as (
select)