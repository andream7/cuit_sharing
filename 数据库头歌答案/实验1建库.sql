1. 创建数据库
mysql -uroot -p123123 -

2. 创建数据表

3. 单表投影查询
use purchase_book;
#-- (1)查询所有顾客的顾客代码、昵称、性别、省份和城市。
select cCustomerID,vNickName,vSex,vProvince,vCity from customer;

4. 单表等值条件查询
use purchase_book;
#-- (2)查询书号为“2109010001”的书的名称和作者。
select vBookName,vAuthor from books where cBookID="2109010001";

5. 单表取值范围查询
use purchase_book;
#-- (3)查询实际售价在至10元到40元（含10元和40元）之间的书的编号、名称、出版社、作者和售价。
select cBookID,vBookName,vPressHouse,vAuthor,mSalePrice from books where mSalePrice>=10 and mSalePrice<=40;

6. 单表多项选择条件查询
use purchase_book;
#-- (4)查询2021年1月1号之前和2021年6月1日以后（以付款为准，不含2021年6月1号和2021年1月1日）订单金额大于100的消费者编号。
select cCustomerID from orders where (dPayTime<"2021-01-01 00:00:00" or dPayTime>"2021-06-01 23:59:59")
 and mTotalCost>100;

7. 单表查询 in
use purchase_book;
#-- (5)查询订单中支付手段为“微信、支付宝、网银“的订单信息
select * from orders where vPayType in('微信','支付宝','网银');

8. 单表 最大值 最小值 平均值 以及条件查询
use purchase_book;
#-- (6)查询支付手段为“微信“的所有订单的最高订单金额、最低订单金额和平均订单金额。
select max(mTotalCost) as '最高订单金额',min(mTotalCost) as '最低订单金额',avg(mTotalCost) as '平均订单金额' from orders where vPayType="微信";

9. 单表 最大 最小 平均 属性名重命名 group by
use purchase_book;
#-- (7)查询每种支付手段的订单的最高订单金额、最低订单金额和平均订单金额。
select vPayType,
max(mTotalCost) as '最高订单金额',
min(mTotalCost) as '最低订单金额',
avg(mTotalCost) as '平均订单金额'
from orders
group by vPayType;

10. 单表 count 多项选择条件查询
use purchase_book;
#-- (8)统计查询实际售价在至10元到40元（含10元和40元）之间的书有多少种？
select count(mSalePrice) as 种类 from books
 where mSalePrice between 10 and 40;

11. 单表 count函数 重命名 升序排列
use  purchase_book;
#-- (9)统计每个顾客的购书次数，要求查询结果按购书次数的升序排列。
select cCustomerID,count(cCustomerID) 
as 购书次数
from orders 
group by cCustomerID 
order by count(cCustomerID) asc;

12. 单表 sum count 重命名 group by
use  purchase_book;
#-- (10)查询买书次数超过3次的顾客的订单总金额和买书次数。
select cCustomerID,
sum(mTotalCost) as 订单总金额,
count(cCustomerID) as 购书次数
from orders
group by cCustomerID
having count(cCustomerID)>3;

13. 单表 sum 重命名 group order
use purchase_book;
#-- (11)统计每种支付手段的订单的数目和订单总金额，按从大到小的顺序，列出订单金额前2名和第3名的支付手段和订单总金额。
select vPayType,
sum(mTotalCost) as 订单总金额
from orders
group by vPayType
order by sum(mTotalCost) desc
limit 1,2;