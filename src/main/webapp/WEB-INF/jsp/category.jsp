<%@page pageEncoding="UTF-8" language="java" %>
<html>
<head>
    <title>attraction_region</title>
    <jsp:include page="header.jsp"/>
</head>
<body>
<div align="center">
    <table id="dg" title="商品类别管理表" class="easyui-datagrid" style="width: 100%;height:auto"
           toolbar="#toolbar"
           fitColumns="true" singleSelect="true" pagination="true"
           data-options="rownumbers:true,
            url:'/category/list',
            method:'get',
            pageSize:15,
            pageList:[5,10,15,20,25]">
        <thead>
        <tr>
            <th field="id" width="50">编号</th>
            <th field="name" width="50">名称</th>
            <th field="info" width="50">备注</th>
        </tr>
        </thead>
    </table>
</div>
<div id="toolbar">
    <a href="#" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="newCategory()">新建</a>
    <a href="#" class="easyui-linkbutton" iconCls="icon-edit" plain="true" onclick="editCategory()">编辑</a>
    <a href="#" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="destroyCategory()">删除</a>
</div>
<div id="CategoryDialog" class="easyui-dialog" style="width:500px;height:550px;padding:10px 20px"
     closed="true" buttons="#Category-buttons">
    <div class="ftitle">商品类别信息填写</div>
    <form id="fm" method="post">
        <div class="fitem">
            <label>名称</label><div>&nbsp;</div>
            <input type="text" name="name" placeholder="50字以内" class="plainText">
        </div>
        <div class="fitem">
            <label>备注</label><div>&nbsp;</div>
            <textarea name="info" class="textareaComment" placeholder="255字以内"></textarea>
        </div>
    </form>
</div>
<div id="Category-buttons">
    <a href="#" class="easyui-linkbutton" iconCls="icon-ok" onclick="saveCategory()">保存</a>
    <a href="#" class="easyui-linkbutton" iconCls="icon-cancel" onclick="javascript:$('#CategoryDialog').dialog('close')">取消</a>
</div>

<div>
    <form id="dfm" method="post">
        <input type="hidden" name="_method" value="DELETE">
    </form>
</div>
</body>
</html>
