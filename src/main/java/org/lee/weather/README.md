* 计算在1949-1955年，每年温度最高的时间
* 计算在1949-1955年，每年温度最高前十天
* 思路：

    1、按照年份升序排序，同时每一年种温度降序排序
    2、按照年份分组，每一年对应一个reduce任务
    
    mapper输出：key为封装对象
* 目的：

    1、自定义排序
    2、自定义分区
    3、自定义分组