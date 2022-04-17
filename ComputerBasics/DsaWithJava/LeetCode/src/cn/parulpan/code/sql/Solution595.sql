/**
  595. 大的国家
  https://leetcode-cn.com/problems/big-countries/

  @author parzulpan
  @since 2022/4/17
*/
use leetcode;
Create table If Not Exists world (name varchar(255), continent varchar(255), area int, population int, gdp bigint);
Truncate table world;
insert into world (name, continent, area, population, gdp) values ('Afghanistan', 'Asia', 652230, 25500100, 20343000000);
insert into world (name, continent, area, population, gdp) values ('Albania', 'Europe', 28748, 2831741, 12960000000);
insert into world (name, continent, area, population, gdp) values ('Algeria', 'Africa', 2381741, 37100000, 188681000000);
insert into world (name, continent, area, population, gdp) values ('Andorra', 'Europe', 468, 78115, 3712000000);
insert into world (name, continent, area, population, gdp) values ('Angola', 'Africa', 1246700, 20609294, 100990000000);

-- 法一: 使用 WHERE 子句和 OR
select name, population, area
from leetcode.world
where area >= 3000000 or population >= 25000000;

-- 法二: 使用 WHERE 子句和 UNION
select name, population, area
from leetcode.world
where area >= 3000000
union
select name, population, area
from leetcode.world
where population >= 25000000;

-- 法一和法二的区别, 以及 or 是否走索引

