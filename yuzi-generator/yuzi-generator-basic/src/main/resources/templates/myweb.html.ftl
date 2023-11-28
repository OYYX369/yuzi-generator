<!DOCTYPE html>
<html>
<head>
<#--    这是模板-->
    <title>鱼皮官网</title>
</head>
<body>
<h1>欢迎来到鱼皮官网</h1>
<ul>
    <#list menuItems as item>
    <li><a href="${item.url}">${item.label} </a> </li>
    </#list>
    <#--  -->
</ul>

    <footer>
        ${currentYear}鱼皮官网.All rights reserved.
    </footer>
</body>
</html>