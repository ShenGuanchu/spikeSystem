<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<style type="text/css">
    .menu-last{
        margin-bottom: 5px;
    }
</style>
<body>
<div class="easyui-accordion" style="width:auto;height: 350px;border: 0px;">
    <div title="秒杀相关管理" iconCls="icon-man" style="overflow: auto;padding: 10px;">
        <div class="menu-last">
            <a href="#" class="easyui-linkbutton" onclick="addTab('商品管理','item')">商品管理</a>
        </div>
        <div class="menu-last">
            <a href="#" class="easyui-linkbutton" onclick="addTab('类别管理','category')">类别管理</a>
        </div>
        <div class="menu-last">
            <a href="#" class="easyui-linkbutton" onclick="addTab('优惠类型管理','discounttype')">优惠类型管理</a>
        </div>
        <div class="menu-last">
            <a href="#" class="easyui-linkbutton" onclick="addTab('店铺管理','stores')">店铺管理</a>
        </div>
    </div>
</div>
</body>
