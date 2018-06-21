function newItem() {
    $("#fm").form("clear");
    $("#ItemDialog").dialog("open").dialog("setTitle","新建");
    url = "/item/addition";
}
function editItem() {
    var row = $("#dg").datagrid("getSelected");
    if (row){
        $("#ItemDialog").dialog("open").dialog("setTitle","编辑");
        $("#fm").form("load",row);
        url = "/item/updates/"+row.id;
    }
}
function destroyItem() {
    var row = $("#dg").datagrid("getSelected");
    if (row){
        $.messager.confirm("Confirm","确定要删除这条记录吗",function (r) {
            if (r){
                $("#dfm").form("submit",{
                    url:"/item/deletion/"+row.id,
                    success: function (res) {
                        alert(res);
                        $("#ItemDialog").dialog("close");
                        $("#dg").datagrid("reload")
                    }
                })
            }
        })
    }
}
function saveItem() {
    $("#fm").form("submit",{
        url:url,
        success: function (res) {
            alert(res);
            $("#ItemDialog").dialog("close");
            $('#dg').datagrid("reload");
        }
    })
}

function newCategory() {
    $("#fm").form("clear");
    $("#CategoryDialog").dialog("open").dialog("setTitle","新建");
    url = "/category/addition";
}
function editCategory() {
    var row = $("#dg").datagrid("getSelected");
    if (row){
        $("#CategoryDialog").dialog("open").dialog("setTitle","编辑");
        $("#fm").form("load",row);
        url = "/category/updates/"+row.id;
    }
}
function destroyCategory() {
    var row = $("#dg").datagrid("getSelected");
    if (row){
        $.messager.confirm("Confirm","确定要删除这条记录吗",function (r) {
            if (r){
                $("#dfm").form("submit",{
                    url:"/category/deletion/"+row.id,
                    success: function (res) {
                        alert(res);
                        $("#CategoryDialog").dialog("close");
                        $("#dg").datagrid("reload")
                    }
                })
            }
        })
    }
}
function saveCategory() {
    $("#fm").form("submit",{
        url:url,
        success: function (res) {
            alert(res);
            $("#CategoryDialog").dialog("close");
            $('#dg').datagrid("reload");
        }
    })
}

function newStores() {
    $("#fm").form("clear");
    $("#StoresDialog").dialog("open").dialog("setTitle","新建");
    url = "/stores/addition";
}
function editStores() {
    var row = $("#dg").datagrid("getSelected");
    if (row){
        $("#StoresDialog").dialog("open").dialog("setTitle","编辑");
        $("#fm").form("load",row);
        url = "/stores/updates/"+row.id;
    }
}
function destroyStores() {
    var row = $("#dg").datagrid("getSelected");
    if (row){
        $.messager.confirm("Confirm","确定要删除这条记录吗",function (r) {
            if (r){
                $("#dfm").form("submit",{
                    url:"/stores/deletion/"+row.id,
                    success: function (res) {
                        alert(res);
                        $("#StoresDialog").dialog("close");
                        $("#dg").datagrid("reload")
                    }
                })
            }
        })
    }
}
function saveStores() {
    $("#fm").form("submit",{
        url:url,
        success: function (res) {
            alert(res);
            $("#StoresDialog").dialog("close");
            $('#dg').datagrid("reload");
        }
    })
}

function newDiscounttype() {
    $("#fm").form("clear");
    $("#DiscounttypeDialog").dialog("open").dialog("setTitle","新建");
    url = "/discounttype/addition";
}
function editDiscounttype() {
    var row = $("#dg").datagrid("getSelected");
    if (row){
        $("#DiscounttypeDialog").dialog("open").dialog("setTitle","编辑");
        $("#fm").form("load",row);
        url = "/discounttype/updates/"+row.id;
    }
}
function destroyDiscounttype() {
    var row = $("#dg").datagrid("getSelected");
    if (row){
        $.messager.confirm("Confirm","确定要删除这条记录吗",function (r) {
            if (r){
                $("#dfm").form("submit",{
                    url:"/discounttype/deletion/"+row.id,
                    success: function (res) {
                        alert(res);
                        $("#DiscounttypeDialog").dialog("close");
                        $("#dg").datagrid("reload")
                    }
                })
            }
        })
    }
}
function saveDiscounttype() {
    $("#fm").form("submit",{
        url:url,
        success: function (res) {
            alert(res);
            $("#DiscounttypeDialog").dialog("close");
            $('#dg').datagrid("reload");
        }
    })
}