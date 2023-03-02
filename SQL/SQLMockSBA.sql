select * from users;
select * from order_items;
select * from orders;
select * from items;
select * from stores;
select o.order_id
from orders o, stores s
where o.STORE_ID = s.STORE_ID and S.CITY = "New York";

-- Problem1 --
select o.ORDER_ID, u.USER_ID, o.STORE_ID
from orders o, users u
where u.FIRST_NAME = "Marion" and u.USER_ID = o.USER_ID;

-- Problem2 --
select *
from users u 
where u.USER_ID not in (select USER_ID from orders);

-- Problem3 -- 
select i.name, i.PRICE
from items i, order_items o
where i.ITEM_ID = o.ITEM_ID
group by i.name
having (count(o.ORDER_ID)>=2);

-- Problem4 --
-- Create a query to return the Order Id, Item name, Item Price, and Quantity from orders
-- made at stores in the city “New York”. Order by Order Id in ascending order.
select oi.ORDER_ID, i.name, i.PRICE, oi.QUANTITY
from order_items oi, items i, orders o, stores s
where oi.ITEM_ID = i.ITEM_ID and o.ORDER_ID = oi.ORDER_ID and o.STORE_ID = s.STORE_ID and s.CITY = "New York"
order by oi.ORDER_ID;


-- Problem5 -- 
-- Your boss would like you to create a query that calculates the total revenue generated
-- by each item. Revenue for an item can be found as (Item Price * Total Quantity
-- Ordered). Please return the first column as ‘ITEM_NAME’ and the second column as ‘REVENUE’.
select i.name as 'ITEM_NAME', (i.price * Sum(o.quantity)) as 'REVENUE'
from items i, order_items o
where i.item_id = o.item_id
group by i.name;

-- Problem6 --
select s.name as 'NAME', count(s.store_id) as 'ORDER_QUANTITY', 
case
	when count(s.store_id) > 3 then 'High'
	when count(s.store_id) <= 3 and count(s.store_id) > 1 then 'Medium'
	when count(s.store_id) <= 1 then 'Low'
end as 'SALES_FIGURE'
from stores s, orders o
where s.store_id = o.store_id
group by s.name
order by  count(s.store_id) desc;