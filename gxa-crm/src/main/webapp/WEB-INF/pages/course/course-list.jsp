<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" isELIgnored="false" %>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8">
    <title>欢迎页面-X-admin2.0</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width,user-scalable=yes, minimum-scale=0.4, initial-scale=0.8,target-densitydpi=low-dpi" />
    <link rel="shortcut icon" href="/favicon.ico" type="image/x-icon" />
    <link rel="stylesheet" href="/static/css/font.css">
    <link rel="stylesheet" href="/static/css/xadmin.css">
    <script type="text/javascript" src="https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>
    <script type="text/javascript" src="/static/lib/layui/layui.js" charset="utf-8"></script>
    <script type="text/javascript" src="/static/js/xadmin.js"></script>
    <!-- 让IE8/9支持媒体查询，从而兼容栅格 -->
    <!--[if lt IE 9]>
      <script src="https://cdn.staticfile.org/html5shiv/r29/html5.min.js"></script>
      <script src="https://cdn.staticfile.org/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
  </head>
  
  <body>
    <div class="x-nav">
      <span class="layui-breadcrumb">
        <a href="">首页</a>
        <a href="">演示</a>
        <a>
          <cite>导航元素</cite></a>
      </span>
      <a class="layui-btn layui-btn-small" style="line-height:1.6em;margin-top:3px;float:right" href="javascript:location.replace(location.href);" title="刷新">
        <i class="layui-icon" style="line-height:30px">ဂ</i></a>
    </div>
    <div class="x-body">
      <%--<div class="layui-row">--%>
      <div>
        <div class="layui-form layui-col-md12 x-so">
          <input class="layui-input" placeholder="开始日" name="startTime" id="start">
          <input class="layui-input" placeholder="截止日" name="endTime" id="end">
          <input type="text" name="keyWords" id="keyWords"  placeholder="请输入关键字" autocomplete="off" class="layui-input">
          <button class="layui-btn" id="search" onclick="getData(1,1)"><i class="layui-icon">&#xe615;</i></button>
        </div>

      </div>
      <xblock>
        <button class="layui-btn layui-btn-danger" onclick="delAll()"><i class="layui-icon"></i>批量删除</button>
        <button class="layui-btn" onclick="x_admin_show('添加用户','${pageContext.request.contextPath}/course/add')"><i class="layui-icon"></i>添加</button>
        <span class="x-right" style="line-height:40px">共有数据：<span id="total"></span> 条</span>
      </xblock>
      <table class="layui-table" id="data-table">
        <thead>
          <tr>
            <th>
              <div class="layui-unselect header layui-form-checkbox" lay-skin="primary"><i class="layui-icon">&#xe605;</i></div>
            </th>
            <th>ID</th>
            <th>课程名称</th>
            <th>课程描述</th>
            <th>课程价格</th>
            <th>课程课时</th>
            <th>创建时间</th>
            <th>更新时间</th>
            <th>操作</th>
        </thead>
        <tbody id="tbcourse">
          <tr>
            <td>
              <div class="layui-unselect layui-form-checkbox" lay-skin="primary" data-id='2'><i class="layui-icon">&#xe605;</i></div>
            </td>
            <td>1</td>
            <td>admin</td>
            <td>18925139194</td>
            <td>113664000@qq.com</td>
            <td>超级管理员</td>
            <td>2017-01-01 11:11:42</td>
            <td class="td-manage">
              <a title="编辑"  onclick="x_admin_show('编辑','admin-edit.html')" href="javascript:;">
                <i class="layui-icon">&#xe642;</i>
              </a>
              <a title="删除" onclick="member_del(this,'要删除的id')" href="javascript:;">
                <i class="layui-icon">&#xe640;</i>
              </a>
            </td>
          </tr>
        </tbody>
      </table>
      <div class="page">
        <div id="page-container">
          <a class="prev" href="">&lt;&lt;</a>
          <a class="num" href="">1</a>
          <span class="current">2</span>
          <a class="num" href="">3</a>
          <a class="num" href="">489</a>
          <a class="next" href="">&gt;&gt;</a>
        </div>
      </div>

    </div>
    <script>
      layui.use('laydate', function(){
        let laydate = layui.laydate;
        
        //执行一个laydate实例
        laydate.render({
          elem: '#start' //指定元素
        });

        //执行一个laydate实例
        laydate.render({
          elem: '#end' //指定元素
        });
      });

       /*用户-停用*/
      function member_stop(obj,id){
          layer.confirm('确认要停用吗？',function(index){

              if($(obj).attr('title')=='启用'){

                //发异步把用户状态进行更改
                $(obj).attr('title','停用')
                $(obj).find('i').html('&#xe62f;');

                $(obj).parents("tr").find(".td-status").find('span').addClass('layui-btn-disabled').html('已停用');
                layer.msg('已停用!',{icon: 5,time:1000});

              }else{
                $(obj).attr('title','启用')
                $(obj).find('i').html('&#xe601;');

                $(obj).parents("tr").find(".td-status").find('span').removeClass('layui-btn-disabled').html('已启用');
                layer.msg('已启用!',{icon: 5,time:1000});
              }
              
          });
      }

      /*用户-删除*/
      function member_del(obj,id){
          layer.confirm('确认要删除吗？',function(index){
              //发异步删除数据
            // console.log("要删除的数据"+id);
            var ids=[];
            ids.push(id);
            $.ajax({
              type:"post",
              url:"${pageContext.request.contextPath}/course/delete",
              data:{ids:ids},
              dataType:"json",
              success:function (data) {
                if (data.code === 200){
                  $(obj).parents("tr").remove();
                  layer.msg('已删除!',{icon:1,time:1000});
                }
                console.log(data)
              }
            })
          });
      }

      
      function delAll (argument) {

        var ids = tableCheck.getData();

        layer.confirm('确认要删除吗？'+ids,function(index){
            //捉到所有被选中的，发异步进行删除

          $.ajax({
            type:"post",
            url:"${pageContext.request.contextPath}/course/delete",
            data:{ids:ids},
            dataType:"json",
            success:function (data) {
              if (data.code === 200){
                layer.msg('删除成功', {icon: 1});
                $(".layui-form-checked").not('.header').parents('tr').remove();
              }
              console.log(data)
            }
          })
        });
      }

      function getData(pageNum,pageSize){

        let startTime = $("#start").val();
        if (startTime.length >0){
              startTime = startTime+"00:00:00";
          }

        let endTime = $("#end").val();

        if (endTime.length>0){
              endTime = endTime+"23:59:59";
          }

        let keyWords =  encodeURI($("#keyWords").val());

        let param ={pageNum:pageNum,pageSize:pageSize,startTime:startTime,endTime:endTime,keyWords:keyWords};

        console.log(param);
        $.ajax({
          type:"get",
          url:"${pageContext.request.contextPath}/course/getAllCourse",
          data:param,
          dataType:"json",
          success:function (data) {
            console.log(data);
            if (data.code === 200){
              $("#total").text(data.data.total);
              $("#tbcourse").empty();

              $(data.data.list).each(function () {
                var tr = $('          <tr>\n' +
                        '            <td>\n' +
                        '              <div class="layui-unselect layui-form-checkbox" lay-skin="primary" data-id="'+this.id+'"><i class="layui-icon">&#xe605;</i></div>\n' +
                        '            </td>\n' +
                        '            <td>'+this.id+'</td>\n' +
                        '            <td>'+this.courseName+'</td>\n' +
                        '            <td>'+this.courseDesc+'</td>\n' +
                        '            <td>'+this.coursePrice+'</td>\n' +
                        '            <td>'+this.courseCount+'</td>\n' +
                        '            <td>'+this.createTime+'</td>\n' +
                        '            <td>'+(this.updateTime ==null ? '未更新':this.updateTime)+'</td>\n' +
                        '            <td class="td-manage">\n' +
                        '              <a title="编辑"  onclick="x_admin_show(\'编辑\',\'${pageContext.request.contextPath}/course/update/'+this.id+'\')" href="javascript:;">\n' +
                        '                <i class="layui-icon">&#xe642;</i>\n' +
                        '              </a>\n' +
                        '              <a title="删除" onclick="member_del(this,'+this.id+')" href="javascript:;">\n' +
                        '                <i class="layui-icon">&#xe640;</i>\n' +
                        '              </a>\n' +
                        '            </td>\n' +
                        '          </tr>')
                $("#tbcourse").append(tr);
              })

              $("#page-container").empty();


              if (!data.data.isFirstPage) {
                if (data.data.hasPreviousPage) {
                  $("#page-container").append('<a class="prev" href="javascript:change_page('+(data.data.pageNum-1)+')">&lt;&lt;</a>')
                }else{
                  $("#page-container").append('<a class="prev">&lt;&lt;</a>')
                }
              }else{
                $("#page-container").append('<a class="prev">&lt;&lt;</a>')
                
              }


              $(data.data.navigatepageNums).each(function () {
                if (pageNum == this){
                $("#page-container").append('<span class="current">'+this+'</span>');
                }else{
                  $("#page-container").append('<a class="num" href="javascript:change_page('+this+')">'+this+'</a>');
                }

              })

              if (!data.data.isLastPage) {
                if (data.data.hasNextPage) {
                  $("#page-container").append('<a class="prev" href="javascript:change_page('+(data.data.pageNum+1)+')">&gt;&gt;</a>')
                }else{
                  $("#page-container").append('<a class="prev">&gt;&gt;</a>')
                }
              }else{
                $("#page-container").append('<a class="prev">&gt;&gt;</a>')

              }
            }
          }
        })
      }


      function change_page(pageNum){
        getData(pageNum,1);
      }

      $(function () {
          getData(1,1);
      })


    </script>

  </body>

</html>