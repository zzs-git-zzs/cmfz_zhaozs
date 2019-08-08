<%@  page pageEncoding="UTF-8" contentType="text/html;UTF-8" isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="path" value="${pageContext.request.contextPath}"/>

<script>
    $(function () {
        $("#bntable").jqGrid({
            url : "${path}/article/showAll",
            editurl:"${path}/article/edit",
            datatype : "json",
            rowNum:3,
            rowList:[3,6,9,12],
            autowidth:true,
            height:"auto",
            styleUI:"Bootstrap",
            pager : '#bnpager',
            //是否展示总条数
            viewrecords : true,
            colNames : [ 'ID', '名称', '封面', '内容', '上传时间','上师ID'],
            colModel : [
                {name : 'id',hidden:true,width : 55},
                {name : 'title',editable:true,width : 90},
                {name : 'insertImg',width : 100,editable:true,edittype:"file",algn:"center",
                    formatter:function(cellvalue){ //cellvalue是路径这一列的值
                        //alert(cellvalue)
                        return "<img src='${path}/upload/article/"+cellvalue+"' style='width:180px;height:80px'>"  //补全路径就可以展示图片了
                    },

                },
                {name : 'content',width : 80,align : "right"},
                {name : 'upDate',width : 80,align : "right"},
                {name : 'guruId',editable:true,width : 80,align : "right"}
            ]
        });
        //增删该查操作
        $("#bntable").jqGrid('navGrid', '#bnpager', {edit : true, add : true, del : true,addtext:"添加",edittext:"编辑",deltext:"删除"},
            {},//执行修改操作的配置项
            {},//执行添加操作的配置项
            {}//执行删除操作的配置项
        );
    })
</script>
<%--初始化面板--%>
<div class="panel panel-info">
    <div class="panel panel-heading">
        <h2>文章信息</h2>
    </div>
    <table id="bntable"></table>

    <%--定义分页工具栏--%>
    <div id="bnpager"></div>
</div>
