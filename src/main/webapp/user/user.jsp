<%@  page pageEncoding="UTF-8" contentType="text/html;UTF-8" isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="path" value="${pageContext.request.contextPath}"/>

<script>
    $(function () {
        $("#bntable").jqGrid({
            url : "${path}/user/showAll",
            editurl:"${path}/user/edit",
            datatype : "json",
            rowNum:2,
            rowList:[2,4,6,8],
            autowidth:true,
            height:"auto",
            styleUI:"Bootstrap",
            pager : '#bnpager',
            //是否展示总条数
            viewrecords : true,
            colNames : [ 'ID','电话','头像','密码','盐','法名','姓名','性别','城市','签名','状态','注册时间','上师ID'],
            colModel : [
                {name : 'id',hidden:true,width : 55},
                {name : 'phone',editable:true,width : 90},
                {name : 'picImg',width : 100,editable:true,edittype:"file",algn:"center",
                    formatter:function(cellvalue){ //cellvalue是路径这一列的值
                        //alert(cellvalue)
                        return "<img src='${path}/upload/user/"+cellvalue+"' style='width:180px;height:80px'>"  //补全路径就可以展示图片了
                    },

                },
                {name : 'password',width : 80,align : "right"},
                {name : 'salt',hidden:true,width : 80,align : "right"},
                {name : 'ahama',editable:true,width : 80,align : "right"},
                {name : 'name',width : 80,align : "right"},
                {name : 'sex',width : 80,align : "right"},
                {name : 'ciry',width : 80,align : "right"},
                {name : 'sign',width : 80,align : "right"},
                {name : 'status',width : 80,align : "right",
                    formatter:function (cellvalue,option,row) {
                        if(cellvalue==1){
                            //展示状态
                            return "<button class='btn btn-success' onclick='change(\""+row.id+"\",\""+cellvalue+"\")'>冻结</button>"
                        }else {
                            //不展示状态
                            return "<button class='btn btn-danger' onclick='change(\""+row.id+"\",\""+cellvalue+"\")'>解除冻结</button>"
                        }
                    }
                },
                {name : 'regDate',width : 80,align : "right"},
                {name : 'guruId',hidden:true,width : 80,align : "right"}
            ]
        });
        //增删该查操作
        $("#bntable").jqGrid('navGrid', '#bnpager', {edit : true, add : true, del : true,addtext:"添加",edittext:"编辑",deltext:"删除"},
            {},
            {},//执行添加操作的配置项
            {}//执行删除操作的配置项
        );
    })
    //点击修改
    function change(id,value){

        if(value==1){

            $.ajax({
                url:"${path}/user/updateStatus",
                type:"post",
                dataType:"JSON",
                data:{"id":id,"status":"2"},
                success:function(data){
                    //页面的刷新
                    $("#bntable").trigger("reloadGrid");
                    //提示框添加信息
                    $("#showMsg").html(data.message);
                    //展示错误信息
                    $("#show").show();

                    //设置提示框时间
                    setTimeout(function () {
                        //关闭提示框
                        $("#show").hide();
                    }, 3000);
                }
            });
        }else{
            $.ajax({
                url:"${path}/user/updateStatus",
                type:"post",
                dataType:"JSON",
                data:{"id":id,"status":"1"},
                success:function(data){

                    //页面的刷新
                    $("#bntable").trigger("reloadGrid");
                    //提示框添加信息
                    $("#showMsg").html(data.message);
                    //展示错误信息
                    $("#show").show();
                    //设置提示框时间
                    setTimeout(function () {
                        //关闭提示框
                        $("#show").hide();
                    }, 3000);
                }
            });
        }
    }
    //点击导出
    function easyImport() {
        $.ajax({
            url:"${path}/user/easyImport",
            type:"post",
            dataType:"JSON",
            data:{},
            success:function(data){
                //页面的刷新
                $("#bntable").trigger("reloadGrid");
                //提示框添加信息
                $("#showMsg").html(data.message);
                //展示错误信息
                $("#show").show();

                //设置提示框时间
                setTimeout(function () {
                    //关闭提示框
                    $("#show").hide();
                }, 3000);
            }
        });
    }

</script>
<%--初始化面板--%>
<div class="panel panel-info">
    <div class="panel panel-heading">
        <h2>用户信息</h2>
    </div>
    <ul class="nav nav-tabs">
        <li class="active"><a href="#">用户信息</a></li>
    </ul>

    <div class="panel panel-body">
        <button type="button" class="btn btn-info" >修改用户</button>
        <button type="button" class="btn btn-success" onclick="easyImport()" href="#"><a href="#">导出用户</a></button>
    </div>
    <%--提示信息--%>
    <div id="show" class="alert alert-warning alert-dismissible" role="alert"  style="width:200px;display: none">
        <button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <strong id="showMsg"></strong>
    </div>
    <table id="bntable"></table>

    <%--定义分页工具栏--%>
    <div id="bnpager"></div>
</div>
