<%@page pageEncoding="UTF-8" language="java" %>
<html>
<head>
    <title>attraction_manage</title>
    <jsp:include page="header.jsp"/>
</head>
<body>
<div align="center">
    <table id="dg" title="商品管理表" class="easyui-datagrid" style="width: 100%;height:auto"
           toolbar="#toolbar"
           fitColumns="true" singleSelect="true" pagination="true"
           data-options="rownumbers:true,
            url:'/item/list',
            method:'get',
            pageSize:15,
            pageList:[5,10,15,20,25]">
        <thead>
        <tr>
            <th field="name" width="50">名称</th>
            <th field="price" width="50">价格</th>
            <th field="voCategory" width="50">类别</th>
            <th field="stock" width="50">库存量</th>
            <th field="origin" width="50">产地</th>
            <th field="weight" width="50">重量</th>
            <th field="voStores" width="50">店铺</th>
            <th field="voDiscounttype" width="50">优惠类型</th>
        </tr>
        </thead>
    </table>
</div>
<div id="toolbar">
    <a href="#" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="newItem()">新建</a>
    <a href="#" class="easyui-linkbutton" iconCls="icon-edit" plain="true" onclick="editItem()">编辑</a>
    <a href="#" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="destroyItem()">删除</a>
</div>
<div id="ItemDialog" class="easyui-dialog" style="width:500px;height:550px;padding:10px 20px"
     closed="true" buttons="#Item-buttons">
    <div class="ftitle">商品信息填写</div>
    <form id="fm" method="post" enctype="multipart/form-data">
        <div class="fitem">
            <label>所属店铺&nbsp;&nbsp;&nbsp;</label><div>&nbsp;</div>
            <input name="stores"
                   class="easyui-combobox"
                   data-options="
                           valueField:'id',
                           textField:'name',
                           width:300,
                           url:'${pageContext.request.contextPath}/stores/ddllist'" />
        </div>
        <div class="fitem">
            <label>优惠类型&nbsp;&nbsp;&nbsp;</label><div>&nbsp;</div>
            <input name="discounttype"
                   class="easyui-combobox"
                   data-options="
                           valueField:'id',
                           textField:'name',
                           width:300,
                           url:'${pageContext.request.contextPath}/discounttype/ddllist'" />
        </div>
        <div class="fitem">
            <label>商品类型&nbsp;&nbsp;&nbsp;</label><div>&nbsp;</div>
            <input name="category"
                   class="easyui-combobox"
                   data-options="
                           valueField:'id',
                           textField:'name',
                           width:300,
                           url:'${pageContext.request.contextPath}/category/ddllist'" />
        </div>
        <div class="fitem">
            <label>名称</label><div>&nbsp;</div>
            <input type="text" name="name" placeholder="50字以内" class="plainText">
        </div>
        <div class="fitem">
            <label>价格</label><div>&nbsp;</div>
            <input type="text" name="price" class="plainText">
        </div>
        <div class="fitem">
            <label>库存量</label><div>&nbsp;</div>
            <input type="text" name="stock" class="plainText">
        </div>
        <div class="fitem">
            <label>产地</label><div>&nbsp;</div>
            <input type="text" name="origin" class="plainText">
        </div>
        <div class="fitem">
            <label>重量</label><div>&nbsp;</div>
            <input type="text" name="weight" class="plainText">
        </div>
    </form>
</div>
<div id="Item-buttons">
    <a href="#" class="easyui-linkbutton" iconCls="icon-ok" onclick="saveItem()">保存</a>
    <a href="#" class="easyui-linkbutton" iconCls="icon-cancel" onclick="javascript:$('#ItemDialog').dialog('close')">取消</a>
</div>

<div>
    <form id="dfm" method="post">
        <input type="hidden" name="_method" value="DELETE">
    </form>
</div>
</body>
</html>
