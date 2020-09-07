<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<!DOCTYPE html>
<html>
  
  <head>
    <meta charset="UTF-8">
    <title>添加课程</title>
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
    <div class="x-body layui-anim layui-anim-up">
        <form class="layui-form">
            <input value="${course.id}" name="id" type="hidden">
          <div class="layui-form-item">
              <label for="courseName" class="layui-form-label">
                  <span class="x-red">*</span>课程名称
              </label>
              <div class="layui-input-inline">
                  <input type="text" id="courseName" value="${course.courseName}" name="courseName" required="" lay-verify="courseNameVerify"
                  autocomplete="off" class="layui-input">
              </div>
          </div>
          <div class="layui-form-item">
              <label for="coursePrice" class="layui-form-label">
                  <span class="x-red">*</span>课程价格
              </label>
              <div class="layui-input-inline">
                  <input type="number" id="coursePrice" value="${course.coursePrice}" name="coursePrice" required="" lay-verify="coursePriceVerify"
                  autocomplete="off" class="layui-input">
              </div>
          </div>
          <div class="layui-form-item">
              <label for="courseCount" class="layui-form-label">
                  <span class="x-red">*</span>课程课时
              </label>
              <div class="layui-input-inline">
                  <input type="number" id="courseCount"value="${course.courseCount}" name="courseCount" required="" lay-verify="courseCountVerify"
                  autocomplete="off" class="layui-input">
              </div>
          </div>
          <div class="layui-form-item">
              <label for="courseCount" class="layui-form-label">
                  <span class="x-red">*</span>课程描述
              </label>
              <div class="layui-input-inline">
                  <textarea id="courseDesc" name="courseDesc" placeholder="请输入课程描述" class="layui-textarea" >${course.courseDesc}</textarea>
              </div>
          </div>
          <div class="layui-form-item">
              <label  class="layui-form-label">
              </label>
              <button  class="layui-btn" lay-filter="add" lay-submit="">
                  保存
              </button>
          </div>
      </form>
    </div>
    <script>
        layui.use(['form','layer'], function(){
            $ = layui.jquery;
          var form = layui.form
          ,layer = layui.layer;
          //自定义验证规则
          form.verify({
              courseNameVerify: function(value){
              if(value.length < 2 || value.length > 10){
                return '课程名称不符合规定（2~10个字符）';
              }
            }
            ,courseCountVerify:function (value) {
                 if (value <= 0) {
                     return '课程时长必须大于0';
                 }

              }
              ,coursePriceVerify:function (value) {
                  if (value <= 0){
                      return '课程价格必须大于0';
                  }
              }
          });

          //监听提交
          form.on('submit(add)', function(data){
            console.log(data.field);
            //发异步，把数据提交给java

              $.ajax({
                  type:"post",
                  url:"${pageContext.request.contextPath}/course/doUpdate",
                  dataType:"json",
                  data:data.field,
                  success:function (data) {
                      console.log(data)
                            if (data.code == 200){
                                layer.alert(data.msg, {icon: 6},function () {
                                    // 获得frame索引
                                    var index = parent.layer.getFrameIndex(window.name);
                                    //关闭当前frame
                                    parent.layer.close(index);
                                    parent.location.replace(parent.location.href);
                                });
                            } else{
                                layer.alert(data.msg, {icon: 5},function () {
                                    // 获得frame索引
                                    var index = parent.layer.getFrameIndex(window.name);
                                    //关闭当前frame
                                    parent.layer.close(index);
                                    parent.location.replace(parent.location.href);
                                });
                            }


                      }
              })
            return false;
          });
          
          
        });
    </script>

  </body>

</html>