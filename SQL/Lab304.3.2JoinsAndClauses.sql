-- Problem 1 --
select c.customerName as "Customer Name", concat(e.lastName,", ", e.firstName) as "Sales Rep"  
from customers c, employees e
where c.salesRepEmployeeNumber = e.employeeNumber
order by c.customerName;

-- Problem 2 --
select p.productName as "Product Name", sum(od.quantityOrdered) as "Total # Ordered", sum(od.quantityOrdered * od.priceEach) as "Total Sale"
from products p left join orderdetails od
on p.productCode = od.productCode
group by p.productName
order by sum(od.quantityOrdered * od.priceEach) desc;

-- Problem 3 -- 
select o.status as "Order Status", count(o.status) as "Total Orders"
from orders o
group by o.status
order by o.status;

-- Problem 4 -- 
select p.productLine as "Product Line", sum(od.quantityOrdered) as "total Sold" 
from products p, orderdetails od
where p.productCode = od.productCode
group by p.productLine
order by 2 desc;

-- Problem 5 --
select * from payments;
select monthname(p.paymentDate) as "Month", year(p.paymentDate) as "Year", format(sum(p.amount),2) as "Payments Received"
from payments p
group by monthname(p.paymentDate), year(p.paymentDate)
order by year(paymentDate), month(paymentDate);

-- Problem 6 --
select p.productName, p.productLine, p.productScale, p.productVendor
from products p
where p.productLine in ("Vintage Cars", "Classic Cars")
group by p.productName
order by p.productLine desc, p.productName;

