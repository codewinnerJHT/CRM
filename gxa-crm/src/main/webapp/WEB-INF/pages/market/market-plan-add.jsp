<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<!DOCTYPE html>
<html>
  
  <head>
    <meta charset="UTF-8">
    <title>市场计划添加</title>
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
    <div class="x-body">
        <form class="layui-form">
          <div class="layui-form-item">
              <label for="planName" class="layui-form-label">
                  <span class="x-red">*</span>计划名称
              </label>
              <div class="layui-input-inline">
                  <input type="text" id="planName" name="planName" required=""  lay-verify="planName"
                  autocomplete="off" class="layui-input">
              </div>
          </div>
            <div class="layui-form-item">
                <label class="layui-form-label">
                    <span class="x-red">*</span>截止日期
                </label>
                <div class="layui-input-inline">
                    <input class="layui-input" placeholder="截止日期" lay-verify="planEndTime" name="planEndTime" id="planEndTime" >
                </div>
            </div>
          <div class="layui-form-item">
              <label class="layui-form-label">
                  <span class="x-red">*</span>计划课程
              </label>
              <div class="layui-input-inline">
                  <select name="courseId" class="valid" lay-filter="course" required="" id="course-list">
                    <option value="0">请输入课程名称</option>
                  </select>
              </div>
          </div>
          <div class="layui-form-item">
              <label class="layui-form-label">
                  <span class="x-red">*</span>计划教师
              </label>
              <div class="layui-input-inline">
                  <select name="teacherId" id="teacher-list" lay-filter="course" lay-verify="teacherId">
                    <option value="0">没有教师数据</option>
                  </select>
              </div>
          </div>

            <div class="layui-form-item">
                <label class="layui-form-label">
                    <span class="x-red">*</span>计划教室
                </label>
                <div class="layui-input-inline">
                    <select name="ClassRoomId" id="class-room-list" lay-filter="classRoom" lay-verify="ClassRoomId">
                        <option>无教室</option>
                    </select>
                </div>
                <div class="layui-form-mid layui-word-aux">
                    <span>该教室最多容纳<span class="x-red" id="volume-count">0</span>人</span>
                </div>
            </div>

          <div class="layui-form-item">
              <label class="layui-form-label">
                  <span class="x-red">*</span>计划人数
              </label>
              <div class="layui-input-inline">
                  <input type="number" id="planStuCount" lay-verify="planStuCount" name="planStuCount" required=""
                  autocomplete="off" class="layui-input">
              </div>
          </div>



          <div class="layui-form-item layui-form-text">
              <label for="desc" class="layui-form-label">
                  计划详情
              </label>
              <div class="layui-input-block">
                  <textarea placeholder="请输入详情" id="desc" name="planDetail" class="layui-textarea" lay-verify="planDetail"></textarea>
              </div>
          </div>
          <div class="layui-form-item">
              <label  class="layui-form-label">
              </label>
              <button  class="layui-btn" lay-filter="add" lay-submit="">
                  增加
              </button>
          </div>
      </form>
    </div>
    <script>
        layui.use(['form','layer','laydate'], function(){
            $ = layui.jquery;
          var form = layui.form
          ,layer = layui.layer;
          var laydate = layui.laydate;
            //使用日期控件
           laydate.render({
               elem: '#planEndTime' //指定元素
            });
          //自定义验证规则
          form.verify({
              planName: function(value){
              if(value.length < 3 || value.length >10){
                return '计划名称必须在3~10个字符之间！';
              }
            }
              ,planEndTime: function(value){
                  if(value.length < 0){
                      return '请选择时间！';
                  }
              }
              ,teacherId: function(value){
                  if(value == 0){
                      return '没有可用的教师';
                  }
              }
              ,ClassRoomId: function(value){
                  if(value == 0){
                      return '没有可用的教室';
                  }
              }
              ,planStuCount: function(value){
                  let volume=$("#volume-count").text();
                  volume = parseInt(volume);
                  value = parseInt(value);
                  if (value > volume){
                      return "超出该教室容量";
                  }
              }
              ,planDetail: function(value){
                  if (value.length==0){
                      return "请输入计划详情";
                  }
              }
          });

          //监听提交
          form.on('submit(add)', function(data){

            let param=data.field;
            param.planEndTime=param.planEndTime+" 00:00:00";
              console.log(param);
            //发异步，把数据提交给java
              $.ajax({
                  type:"post",
                  url:"${pageContext.request.contextPath}/market/plan/doAdd",
                  data:param,
                  dataType:"json",
                  asyn:false,
                  success:function (data) {
                      console.log(data);
                      if (data.code == 200){
                          layer.msg(data.msg, {icon: 6},function () {
                            // 获得frame索引
                            var index = parent.layer.getFrameIndex(window.name);
                            //关闭当前frame
                            parent.layer.close(index);
                            parent.location.replace(parent.location.href);
                        });
                      } else{
                          layer.msg(data.msg,{icon:5});
                      }
                  }
              });
            return false;
          });
            form.on('select(course)', function(data){
                var courseId=data.value;
                getTeacherList(courseId);
            });

            form.on('select(classRoom)',function (data) {
                let classRoomid=data.value;
                console.log(classRoomid);
                $("#class-room-list>option").each(function () {
                    let value=$(this).attr('value');
                    let volume=$(this).attr('volume');
                    if (classRoomid === value){
                        $("#volume-count").text(volume);
                    }
                })
            })


        });

        //获取教室数据
        function getTeacherList(courseId){
            $.ajax({
                type:"get",
                url:"${pageContext.request.contextPath}/teacher/list/course/"+courseId,
                dataType:"json",
                asyn:false,
                success:function (data) {
                    console.log(data);
                    if (data.code === 200) {
                        $("#teacher-list").empty();
                        console.log("+"+data.data);
                        if (data.data.length == 0) {
                            $("#teacher-list").append('<option value="0">没有教师数据</option>');

                        }else{
                            $(data.data).each(function () {

                                console.log("===="+this.teacherName);
                                let option=$('<option value="'+this.id+'">'+this.teacherName+'</option>');
                                $("#teacher-list").append(option);
                            })
                        }
                    }
                    //渲染下拉列表
                    layui.use('form', function(){
                        var form = layui.form;
                        form.render();
                    });
                }
            })
        }


        $(function () {

            $.ajax({
                type:"get",
                url:"${pageContext.request.contextPath}/course/list/all/data",
                dataType:"json",
                asyn:false,
                success:function (data) {
                    console.log(data);
                    if (data.code === 200) {
                        $("#course-list").empty();
                        $(data.data).each(function () {

                            console.log("===="+this.courseName);
                            let option=$('<option value="'+this.id+'">'+this.courseName+'</option>');
                            $("#course-list").append(option);

                            layui.use('form', function(){  //此段代码必不可少
                                var form = layui.form;
                                form.render();
                            });


                        })
                        let courseId=$("#course-list").val();
                        console.log("id："+courseId);
                        getTeacherList(courseId);

                        $.ajax({
                            type:"get",
                            url:"${pageContext.request.contextPath}/class/room/list/all/data",
                            dataType:"json",
                            success:function (data) {
                                if (data.code === 200){
                                    $("#class-room-list").empty();
                                    if (data.data.length === 0){
                                        $("#class-room-list").append('<option value="0">无教室</option>')
                                    }else {
                                        $(data.data).each(function () {
                                            let option=('<option value="'+this.id+'" volume="'+this.volume+'">'+this.num+'</option>');
                                            $("#class-room-list").append(option);
                                        })


                                        let roomId=$("#class-room-list").val();
                                        $("#class-room-list>option").each(function () {
                                            let value=$(this).attr('value');
                                            let volume=$(this).attr('volume');
                                            if (roomId === value){
                                                $("#volume-count").text(volume);
                                            }
                                        })

                                    }


                                    layui.use('form', function(){  //此段代码必不可少
                                        var form = layui.form;
                                        form.render();
                                    });


                                }
                            }
                        })
                    }
                }
            })
        })
    </script>
  </body>
</html>