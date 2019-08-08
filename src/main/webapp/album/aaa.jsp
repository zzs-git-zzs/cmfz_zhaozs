<%@  page pageEncoding="UTF-8" contentType="text/html;UTF-8" isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="path" value="${pageContext.request.contextPath}"/>


<script>
    $(function(){

        $("#abtable").jqGrid({
            url : "${path}/album/queryAll",
            editurl:"${path}/album/edit",
            datatype : "json",
            autowidth:true,
            height : "auto",
            styleUI:"Bootstrap",
            rowNum : 2,
            rowList : [ 2, 4, 6, 8 ],
            pager : '#abpager',
            sortname : 'id',
            viewrecords : true,
            multiselect : false,
            colNames : [ 'Id', '名字', '作者', '封面','集数', '描述','评分','朗读者','发布时间' ],
            colModel : [
                {name : 'id',hidden:true,index : 'id',  width : 55},
                {name : 'title',index : 'invdate',width : 90},
                {name : 'author',index : 'name',width : 100},
                {name : 'coverImg',index : 'amount',width : 80,align : "right",edittype:"file",
                    editoptions:{enctype:"multipart/from-data"},
                    formatter:function(cellvalue){ //cellvalue是路径这一列的值
                        //alert(cellvalue)
                        return "<img src='${path}/upload/album/"+cellvalue+"' style='width:180px;height:80px'>"  //补全路径就可以展示图片了
                    },
                },
                {name : 'acount',index : 'tax',width : 80,align : "right"},
                {name : 'content',index : 'total',width : 80,align : "right"},
                {name : 'score',index : 'tax',width : 80,align : "right"},
                {name : 'broadcast',index : 'tax',width : 80,align : "right"},
                {name : 'pubDate',index : 'tax',width : 80,align : "right"}

            ],
            subGrid : true, //开启子表格支持
            //subgrid_id  子表格的Id,当开启子表格式,会在主表格中创建一个子表格，subgrid_id就是这个子表格的Id
            subGridRowExpanded : function(subgridId, rowId) {
                addSubGrid(subgridId,rowId);
            },
            /*subGridRowColapsed : function(subgrid_id, row_id) {
                // this function is called before removing the data
                //var subgrid_table_id;
                //subgrid_table_id = subgrid_id+"_t";
                //jQuery("#"+subgrid_table_id).remove();
            }*/
        });
        /*增删改查操作*/
        $("#abtable").jqGrid('navGrid', '#abpager',
            {add : true,edit : false,del : true}

        );

    });

    //创建子表单
    function addSubGrid(subgridId,rowId) {

        var subgridTableId = subgridId + "table";
        var pagerId = subgridId+"pager";

        //初始化表单,分页工具栏
        $("#" + subgridId).html("<table id='" + subgridTableId+ "'/><div id='"+ pagerId + "'/>");

        //创建表单
        $("#" + subgridTableId).jqGrid({
            //url:"/chapter/queryByPage?albumId="+rowId,
            url:"${path}/chapter/queryAll?albumId="+rowId,
            editurl:"${path}/chapter/edit?albumId="+rowId,
            datatype : "json",
            rowNum : 2,
            rowList : [ 2, 4, 6, 8 ],
            pager : "#"+pagerId,
            sortname : 'num',
            sortorder : "asc",
            autowidth:true,
            height : "auto",
            viewrecords : true,
            styleUI:"Bootstrap",
            colNames : [ 'Id', '名字', '音频大小', '音频时长','上传时间','AubimId',"操作" ],
            colModel : [
                {name : "id",  index : "num",width : 80,key : true},
                {name : "url",editable:true,index : "item",  width : 130,edittype:"file"},
                {name : "size",index : "qty",width : 70,align : "right"},
                {name : "duration",index : "unit",width : 70,align : "right"},
                {name : "upDate",index : "total",width : 70,align : "right"},
                {name : "albumId",hidden:true,index : "total",width : 70,align : "right"},
                {name : "url",align : "center",
                    formatter:function(cellVale){

                        return "<a href='#' onclick='playerChapter(\""+cellVale+"\")' ><span class='glyphicon glyphicon-play-circle' /></a>&nbsp;&emsp;&emsp;" +
                            "<a href='#' onclick='downloadChapter(\""+cellVale+"\")' ><span class='glyphicon glyphicon-download' /></a>";
                    }
                }
            ]
        });

        /*子表格增删改查*/
        $("#" + subgridTableId).jqGrid('navGrid',"#" + pagerId,
            {edit : true,add : true,del : false},
            {},
            {
                afterSubmit:function(data){
                    //文件上传
                    $.ajaxFileUpload({
                        url:"${path}/chapter/uploadChapter",
                        type:"post",
                        dataType:"JSON",
                        fileElementId:"url",
                        data:{id:data.responseText},
                        success:function(data){
                            console.log(data);
                            //刷新表单
                            $("#abtable").trigger("reloadGrid");
                        }
                    });
                    //一定要有返回值，返回什么都行
                    return "hello";
                },
                closeAfterAdd:true
            }
        );
    }

    //下载
    function downloadChapter(fileName){
        location.href="${path}/chapter/downloadChapter?fileName="+fileName;
    }

    //在线播放
    function playerChapter(fileName){

        //展示模态框
        $("#audioModal").modal("show");
        //播放
        $("#playAudio").attr("src","${path}/upload/music/"+fileName);
    }


</script>



<div class="panel panel-success">
    <div class="panel-heading">专辑信息</div>
    <ul class="nav nav-tabs">
        <li class="active"><a href="#">专辑信息</a></li>
    </ul>
    <table id="abtable"/>

    <div id="abpager"/>

    <div id="audioModal" class="modal fade" tabindex="-1" role="dialog">
        <div class="modal-dialog" role="document">
            <audio id="playAudio" src="" controls/>
        </div>

    </div>

</div>



