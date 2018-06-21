<%@page pageEncoding="UTF-8" language="java" %>
<html>
<head>
    <title>attraction_region</title>
    <jsp:include page="header.jsp"/>
</head>
<body>
<div align="center">
    <table id="dg" title="店铺管理表" class="easyui-datagrid" style="width: 100%;height:auto"
           toolbar="#toolbar"
           fitColumns="true" singleSelect="true" pagination="true"
           data-options="rownumbers:true,
            url:'/stores/list',
            method:'get',
            pageSize:15,
            pageList:[5,10,15,20,25]">
        <thead>
        <tr>
            <th field="name" width="50">名称</th>
            <th field="star" width="50">星级</th>
            <th field="owner" width="50">店主</th>
            <th field="info" width="50">简介</th>
        </tr>
        </thead>
    </table>
</div>
<div id="toolbar">
    <a href="#" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="newStores()">新建</a>
    <a href="#" class="easyui-linkbutton" iconCls="icon-edit" plain="true" onclick="editStores()">编辑</a>
    <a href="#" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="destroyStores()">删除</a>
</div>
<div id="StoresDialog" class="easyui-dialog" style="width:500px;height:550px;padding:10px 20px"
     closed="true" buttons="#Stores-buttons">
    <div class="ftitle">店铺信息填写</div>
    <form id="fm" method="post">
        <div class="fitem">
            <label>名称</label><div>&nbsp;</div>
            <input type="text" name="name" placeholder="50字以内" class="plainText">
        </div>
        <div class="fitem">
            <label>星级</label><div>&nbsp;</div>
            <input type="text" name="star" class="plainText">
        </div>
        <div class="fitem">
            <label>店主</label><div>&nbsp;</div>
            <input type="text" name="owner" class="plainText">
        </div>
        <div class="fitem">
            <label>简介</label><div>&nbsp;</div>
            <textarea name="info" class="textareaComment" placeholder="255字以内"></textarea>
        </div>
    </form>
</div>
<div id="Stores-buttons">
    <a href="#" class="easyui-linkbutton" iconCls="icon-ok" onclick="saveStores()">保存</a>
    <a href="#" class="easyui-linkbutton" iconCls="icon-cancel" onclick="javascript:$('#StoresDialog').dialog('close')">取消</a>
</div>

<div>
    <form id="dfm" method="post">
        <input type="hidden" name="_method" value="DELETE">
    </form>
</div>
</body>
</html>
