<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>

<head>
    <meta charset="UTF-8"/>
    <title>首页</title>
    <link rel="stylesheet" type="text/css" href="/ui/themes/material/easyui.css">
    <link rel="stylesheet" type="text/css" href="/ui/themes/icon.css">
    <link rel="stylesheet" type="text/css" href="/ui/demo/demo.css">
    <script type="text/javascript" src="/ui/jquery.min.js"></script>
    <script type="text/javascript" src="/ui/jquery.easyui.min.js"></script>
    <script type="text/javascript" src="/ui/custom.js"></script>
    <script type="text/javascript">
        function addTab(title, url){
            if ($('#tt').tabs('exists', title)){
                $('#tt').tabs('select', title);
            } else {
                var content = '<iframe scrolling="auto" frameborder="0"  src="'+url+'" style="width:100%;height:100%;"></iframe>';
                $('#tt').tabs('add',{
                    title:title,
                    content:content,
                    closable:true
                });
            }
        }
    </script>
</head>
<body>
<div class="easyui-layout" style="width:100%;height: 723px;">
    <div region="north" split="false" style="width: 100%;height: 50px;border: 0px">
        <jsp:include page="north.jsp"/>
    </div>
    <div region="west" split="false" title="常用功能" style="width: 270px;height:100%;">
        <jsp:include page="west.jsp"/>
    </div>
    <div region="center" title="主体任务区" style="padding:5px;height: auto;">
        <div id="tt" class="easyui-tabs" style="width: 100%;height: 100%;">
            <div title="Home">
                <span style="float:right;height: auto;margin: 50px;">
                    <div class="easyui-calendar" style="width:250px;height:250px;"></div>
                </span>
            </div>
        </div>
    </div>
    <div region="south" split="true" style="width: 100%;height: 50px;border: 0px;">
        <jsp:include page="south.jsp"/>
    </div>
</div>

</body>
</html>
