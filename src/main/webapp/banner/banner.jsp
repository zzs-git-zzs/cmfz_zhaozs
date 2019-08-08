<%@  page pageEncoding="UTF-8" contentType="text/html;UTF-8" isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="path" value="${pageContext.request.contextPath}"/>

<script>
    $(function () {
        $("#bntable").jqGrid({
            url : "${path}/banner/showAll",
            editurl:"${path}/banner/edit",
            datatype : "json",
            rowNum:3,
            rowList:[3,6,9,12],
            autowidth:true,
            height:"auto",
            styleUI:"Bootstrap",
            pager : '#bnpager',
            //是否展示总条数
            viewrecords : true,
            colNames : [ 'ID', '名称', '路径', '状态', '上传时间','描述'],
            colModel : [
                {name : 'id',hidden:true,width : 55},
                {name : 'username',editable:true,width : 90},
                {name : 'path',width : 100,editable:true,edittype:"file",algn:"center",
                    formatter:function(cellvalue){ //cellvalue是路径这一列的值
                    //alert(cellvalue)
                    return "<img src='${path}/upload/photo/"+cellvalue+"' style='width:180px;height:80px'>"  //补全路径就可以展示图片了
                    },

                },
                {name : 'status',algn:"center",
                    formatter:function (cellvalue,option,row) {
                        if(cellvalue==1){
                            //展示状态
                            return "<button class='btn btn-success' onclick='change(\""+row.id+"\",\""+cellvalue+"\")'>不展示</button>"
                        }else {
                            //不展示状态
                            return "<button class='btn btn-danger' onclick='change(\""+row.id+"\",\""+cellvalue+"\")'>展示</button>"
                        }
                    }
                },
                {name : 'cupdate',width : 80,align : "right"},
                {name : 'cdescribe',editable:true,width : 80,align : "right"}
            ]
        });
        //增删该查操作
        $("#bntable").jqGrid('navGrid', '#bnpager', {edit : true, add : true, del : true,addtext:"添加",edittext:"编辑",deltext:"删除"},
        {afterSubmit:function (data) {
                $.ajaxFileUpload({
                    url:"${path}/banner/uploadBanner",
                    type:"post",
                    dataType:"JSON",
                    fileElementId:"path",
                    data:{id:data.responseText},
                    success:function () {
                        //刷新表单
                        $("#bntable").trigger("reloadGrid");
                    }
                })
                //一定要有返回值，随便什么都可以
                return "hello";
            },
            closeAfterEdit:true},//执行修改操作的配置项
        {   //提交之后做的操作--即文件上传
            afterSubmit:function (data) {
                $.ajaxFileUpload({
                    url:"${path}/banner/uploadBanner",
                    type:"post",
                    dataType:"JSON",
                    fileElementId:"path",
                    data:{id:data.responseText},
                    success:function () {
                        //刷新表单
                        $("#bntable").trigger("reloadGrid");
                    }
                })
                //一定要有返回值，随便什么都可以
                return "hello";
            },
            closeAfterAdd:true
        },//执行添加操作的配置项
        {}//执行删除操作的配置项
        );
    })
    //点击修改
    function change(id,value){

        if(value==1){

            $.ajax({
                url:"${path}/banner/updateStatus",
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
                url:"${path}/banner/updateStatus",
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

</script>
<%--初始化面板--%>
<div class="panel panel-info">
    <div class="panel panel-heading">
        <h2>轮播图信息</h2>
    </div>
    <ul class="nav nav-tabs">
        <li class="active"><a href="#">轮播图信息</a></li>
    </ul>

    <div class="panel panel-body">
        <button type="button" class="btn btn-info" >添加轮播图</button>
        <button type="button" class="btn btn-success" >修改轮播图</button>
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




