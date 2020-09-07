<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<!DOCTYPE html>
<html>
  
  <head>
    <meta charset="UTF-8">
    <title>市场计划</title>
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
      <div class="layui-row">
        <div class="layui-form layui-col-md12 x-so">
          <input class="layui-input" placeholder="活动截止日期" name="planEndTime" id="planEndTime">
          <div class="layui-input-inline">
            <select name="courseId" id="course-list" lay-filter="course">
              <option value="">计划课程</option>
            </select>
          </div>
          <div class="layui-input-inline">
            <select name="status" id="status">
              <option value="">活动状态</option>
              <option value="0">未开始</option>
              <option value="1">进行中</option>
              <option value="2">已结束</option>
            </select>
          </div>
          <input type="text" id="keyWords" name="keyWords" placeholder="请输入计划名称" autocomplete="off" class="layui-input">
          <button class="layui-btn"  lay-submit=""  onclick="getData(1,1)" lay-filter="sreach"><i class="layui-icon">&#xe615;</i></button>
        </div>
      </div>
      <xblock>
        <button class="layui-btn layui-btn-danger" onclick="delAll()"><i class="layui-icon"></i>批量删除</button>
        <button class="layui-btn" onclick="x_admin_show('添加用户','${pageContext.request.contextPath}/market/plan/add/page')"><i class="layui-icon"></i>添加</button>
        <span class="x-right" style="line-height:40px">共有数据：<span id="count">0</span> 条</span>
      </xblock>
      <table class="layui-table" id="data-table">
        <thead>
          <tr>
            <th>
              <div class="layui-unselect header layui-form-checkbox" lay-skin="primary"><i class="layui-icon">&#xe605;</i></div>
            </th>
            <th>ID</th>
            <th>计划名称</th>
            <th>计划详情</th>
            <th>计划课程</th>
            <th>计划教室</th>
            <th>计划老师</th>
            <th>计划人数</th>
            <th>状态</th>
            <th>截止日期</th>
            <th>创建时间</th>
            <th >操作</th>
            </tr>
        </thead>
        <tbody id="data-body">
          <tr>
            <td>
              <div class="layui-unselect layui-form-checkbox" lay-skin="primary" data-id='2'><i class="layui-icon">&#xe605;</i></div>
            </td>
            <td>2017009171822298053</td>
            <td>老王:18925139194</td>
            <td>7829.10</td>
            <td>7854.10</td>
            <td>待确认</td>
            <td>未支付</td>
            <td>未发货</td>
            <td>其他方式</td>
            <td>申通物流</td>
            <td>2017-08-17 18:22</td>
            <td class="td-manage">
              <a title="查看"  onclick="x_admin_show('编辑','order-view.html')" href="javascript:;">
                <i class="layui-icon">&#xe63c;</i>
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
        var laydate = layui.laydate;
        
        //执行一个laydate实例
        laydate.render({
          elem: '#planEndTime' //指定元素
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
      function member_del(obj,planId,classRoomId,teacherId){
          layer.confirm('确认要删除吗？',function(index){
              //发异步删除数据

            console.log(planId,classRoomId,teacherId);
            let planIds=[];
            planIds.push(planId);
            let classRoomIds=[];
            classRoomIds.push(classRoomId);
            let teacherIds=[];
            teacherIds.push(teacherId);

            let param={planIds:planIds,classRoomIds:classRoomIds,teacherIds:teacherIds};

            $.ajax({
              type:"post",
              url:"${pageContext.request.contextPath}/market/plan/doDelete",
              data:param,
              dataType:"json",
              success:function (data) {
                if (data.code==200) {
                  layer.msg(data.msg,{icon:1,time:1000},function () {
                    $(obj).parents("tr").remove();
                    location.replace(location.href);
                  });

                }
              }
            })


          });
      }



      function delAll (argument) {

        let planIds = tableCheck.getDataPlan();

        let classRoomIds=tableCheck.getDataClassRoomId();

        let teacherIds=tableCheck.getDataTeacherId();

        console.log(planIds,classRoomIds,teacherIds);

        let param={planIds:planIds,classRoomIds:classRoomIds,teacherIds:teacherIds};

        layer.confirm('确认要删除吗？'+planIds,function(index){
            //捉到所有被选中的，发异步进行删除
            $.ajax({
              type:"post",
              url:"${pageContext.request.contextPath}/market/plan/doDelete",
              data:param,
              dataType:"json",
              success:function (data) {
              if (data.code==200) {
                layer.msg(data.msg, {icon: 1,time:1000},function () {
                  $(".layui-form-checked").not('.header').parents('tr').remove();
                  location.replace(location.href);
                });

              }
              }
            })

        });
      }

      let planStatus=["未开始","进行中","已结束"]
      
      $(function () {

        getData(1,1);

        $.ajax({
          type:"get",
          url:"${pageContext.request.contextPath}/course/list/all/data",
          dataType:"json",
          asyn:false,
          success:function (data) {
            //console.log(data);
            if (data.code === 200) {
              $(data.data).each(function () {
                let option = $('<option value="' + this.id + '">' + this.courseName + '</option>');
                $("#course-list").append(option);
                //渲染下拉列表
                layui.use('form', function () {
                  var form = layui.form;
                  form.render();
                });
              })
            }
          }
        })
      })


      function getData(pageNum,pageSize) {

        let planEndTime=$("#planEndTime").val();
        if (planEndTime.length != 0){
          planEndTime=planEndTime+" 00:00:00"
        }

        let keyWords =  encodeURI($("#keyWords").val());

        let courseId = $("#course-list").val();

        let status= $("#status").val();

        let  param ={planEndTime:planEndTime,keyWords:keyWords,courseId:courseId,status:status,pageNum:pageNum,pageSize:pageSize};

        console.log(param);

        $.ajax({
          type:"get",
          url:"${pageContext.request.contextPath}/market/plan/list/data",
          data:param,
          dataType:"json",
          success:function (data) {
            console.log(data);
            if (data.code === 200){
              $("#total").text(data.data.total);
              $("#data-body").empty();

              $(data.data.list).each(function () {
                var tr = $('<tr>\n' +
                        '            <td>\n' +
                        '              <div class="layui-unselect layui-form-checkbox" lay-skin="primary" data-id='+this.id+' class-room-id='+this.classRoom.id+' teacher-id='+this.teacher.id+'><i class="layui-icon">&#xe605;</i></div>\n' +
                        '            </td>\n' +
                        '            <td>'+this.id+'</td>\n' +
                        '            <td>'+this.planName+'</td>\n' +
                        '            <td>'+this.planDetail+'</td>\n' +
                        '            <td>'+this.course.courseName+'</td>\n' +
                        '            <td>'+this.classRoom.num+'</td>\n' +
                        '            <td>'+this.teacher.teacherName+'</td>\n' +
                        '            <td>'+this.planStuCount+'</td>\n' +
                        '            <td>'+planStatus[this.status]+'</td>\n' +
                        '            <td>'+this.planEndTime+'</td>\n' +
                        '            <td>'+this.createTime+'</td>\n' +
                        '            <td class="td-manage">\n' +
                        '              <a title="查看"  onclick="x_admin_show(\'编辑\',\'order-view.html\')" href="javascript:;">\n' +
                        '                <i class="layui-icon">&#xe63c;</i>\n' +
                        '              </a>\n' +
                        '              <a title="删除" onclick="member_del(this,'+this.id+','+this.classRoom.id+','+this.teacher.id+')" href="javascript:;">\n' +
                        '                <i class="layui-icon">&#xe640;</i>\n' +
                        '              </a>\n' +
                        '            </td>\n' +
                        '          </tr>')
                $("#data-body").append(tr);
              })

              $("#page-container").empty();
              $("#count").text(data.data.total);

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
    </script>

  </body>

</html>