<%@page pageEncoding="UTF-8" language="java" %>
<html>
<head>
    <title>attraction_region</title>
    <jsp:include page="header.jsp"/>
</head>
<body>
<div align="center">
    <table id="dg" title="优惠类别管理表" class="easyui-datagrid" style="width: 100%;height:auto"
           toolbar="#toolbar"
           fitColumns="true" singleSelect="true" pagination="true"
           data-options="rownumbers:true,
            url:'/discounttype/list',
            method:'get',
            pageSize:15,
            pageList:[5,10,15,20,25]">
        <thead>
        <tr>
            <th field="id" width="50">编号</th>
            <th field="name" width="50">名称</th>
            <th field="rule" width="50">规则</th>
        </tr>
        </thead>
    </table>
</div>
<div id="toolbar">
    <a href="#" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="newDiscounttype()">新建</a>
    <a href="#" class="easyui-linkbutton" iconCls="icon-edit" plain="true" onclick="editDiscounttype()">编辑</a>
    <a href="#" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="destroyDiscounttype()">删除</a>
</div>
<div id="DiscounttypeDialog" class="easyui-dialog" style="width:500px;height:550px;padding:10px 20px"
     closed="true" buttons="#Discounttype-buttons">
    <div class="ftitle">优惠类别信息填写</div>
    <form id="fm" method="post">
        <div class="fitem">
            <label>名称</label><div>&nbsp;</div>
            <input type="text" name="name" placeholder="50字以内" class="plainText">
        </div>
        <div class="fitem">
            <label>规则</label><div>&nbsp;</div>
            <textarea name="rule" class="textareaComment" placeholder="255字以内"></textarea>
        </div>
    </form>
</div>
<div id="Discounttype-buttons">
    <a href="#" class="easyui-linkbutton" iconCls="icon-ok" onclick="saveDiscounttype()">保存</a>
    <a href="#" class="easyui-linkbutton" iconCls="icon-cancel" onclick="javascript:$('#DiscounttypeDialog').dialog('close')">取消</a>
</div>

<div>
    <form id="dfm" method="post">
        <input type="hidden" name="_method" value="DELETE">
    </form>
</div>
</body>
</html>
