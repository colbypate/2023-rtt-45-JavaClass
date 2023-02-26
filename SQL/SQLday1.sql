SELECT    orderNumber, orderlinenumber, 
quantityOrdered * priceEach
FROM    orderdetails
ORDER BY   quantityOrdered * priceEach DESC;

SELECT 
    orderNumber,
    orderLineNumber,
    quantityOrdered * priceEach AS subtotal
FROM    orderdetails
ORDER BY subtotal DESC;

select p.MSRP, p.buyPrice, c.customerName, o.orderNumber, od.productCode, p.productName,
od.quantityOrdered, (p.MSRP * od.quantityOrdered) as customer_payment,
(p.MSRP - p.buyPrice) as product_margin, ((p.MSRP - p.buyPrice)*od.quantityOrdered) as total_margin
from orders o, orderdetails od, products p, customers c
where o.orderNumber = od.orderNumber
and od.productCode = p.productCode
and c.customerNumber = o.customerNumber;

select c.customerName, p.productName, p.productCode, count(p.productCode)
from customers c, products p, orders o, orderdetails od
where c.customerNumber = o.customerNumber
and od.productCode = p.productCode
and o.orderNumber = od.orderNumber
group by c.customerNumber, p.productCode
order by p.productCode;

select p.productName, p.productCode, count(p.productCode) as quantitySold
from products p, orderdetails od
where p.productCode = od.productCode
group by p.productCode
order by quantitySold desc, productName asc;

select pl.productLine, pl.textDescription, count(pl.productLine)
from products p, productlines pl 
where pl.productLine = p.productLine
group by productLine;

select p.productCode, p.productName, sum(od.quantityOrdered) as quantityOrdered, p.buyPrice, p.MSRP,
sum(p.buyPrice *od.quantityOrdered) as cost, sum(p.MSRP * od.quantityOrdered) as net_sales,
((p.MSRP - p.buyPrice)*(sum(od.quantityOrdered))) as profit
from products p, orderdetails od
where p.productCode = od.productCode
group by p.productCode;