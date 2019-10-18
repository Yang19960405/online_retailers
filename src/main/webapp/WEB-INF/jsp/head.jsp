<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<head>
    <link href="/static/css/chooseprefer.css" rel="stylesheet">
</head>
<html lang="en">
<body>
<div style="background-color: black;height:50px;">
    <div class="container" id="header_info" style="line-height:50px;text-align: right;color:#C9C9C9;">
        <a class="a-index">首页</a> &nbsp;&nbsp;|&nbsp;&nbsp;
        <a class="a-order">我的订单</a> &nbsp;&nbsp;|&nbsp;&nbsp;
        <a class="a-cart">购物车</a>&nbsp;&nbsp;|&nbsp;&nbsp;
        <a class="a-login islogin_true">登录 / 注册 </a> <a class="a-loginOut islogin_felse" >注销</a>

    </div>
    <!-- 登陆界面 -->
    <div class="modal fade" id="myLogin">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                </div>
                <div class="modal-body">
                    <h4 class="modal-title" align="center">登录</h4>
                    <br/>
                    <form class="form-horizontal" role="form">
                        <div class="form-group">
                            <label for="name" class="col-sm-offset-2 col-sm-2 control-label">账号</label>
                            <div class="col-sm-5">
                                <input type="text" class="form-control" id="name" placeholder="请输您的入账号">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="password" class="col-sm-offset-2 col-sm-2 control-label">密码</label>
                            <div class="col-sm-5">
                                <input type="password" class="form-control" id="password" placeholder="请输入您的密码">
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-sm-offset-4 col-sm-5">
                                <button id="btn-login" type="button" class="btn btn-default btn-block btn-primary">登陆</button>
                                <button id="btn-face-login" type="button" class="btn btn-default btn-block btn-primary">人脸快捷登陆</button>
                                <a id="jump">跳转至注册页面</a>
                            </div>
                        </div>
                    </form>
                </div>
                <div class="modal-footer">
                </div>
            </div>
            <!-- /.modal-content -->
        </div><!-- /.modal-dialog -->
    </div><!-- /.modal -->

    <!-- 注册界面 -->
    <div class="modal fade" id="myReg">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                </div>
                <div class="modal-body">
                    <h4 class="modal-title" align="center">注册</h4>
                    <br/>
                    <form class="form-horizontal" role="form">
                        <div class="form-group">
                            <label for="name" class="col-sm-offset-2 col-sm-2 control-label">账号</label>
                            <div class="col-sm-5">
                                <input type="text" class="form-control" id="regName" placeholder="请输您的入账号">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="password" class="col-sm-offset-2 col-sm-2 control-label">密码</label>
                            <div class="col-sm-5">
                                <input type="password" class="form-control" id="regPwd" placeholder="请输入您的密码">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="password" class="col-sm-offset-2 col-sm-2 control-label">确认密码</label>
                            <div class="col-sm-5">
                                <input type="password" class="form-control" id="regPwdRepeat" placeholder="再次输入您的密码">
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-sm-offset-4 col-sm-5">
                                <button id="btn-reg" type="button" class="btn btn-default btn-block btn-primary">注册</button>

                            </div>
                        </div>
                    </form>
                </div>
                <div class="modal-footer">
                </div>
            </div>
            <!-- /.modal-content -->
        </div><!-- /.modal-dialog -->
    </div><!-- /.modal -->
    <!--用户偏号选择-->
    <%--<div class="modal fade" tabindex="-1" role="dialog" id="myPrefer" aria-labelledby="gridSystemModalLabel">--%>
        <%--<div class="modal-dialog" role="document">--%>
            <%--<div class="modal-content">--%>
                <%--<div class="modal-header">--%>
                    <%--<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>--%>
                    <%--<h4 class="modal-title" id="gridSystemModalLabel">用户偏好选择</h4>--%>
                <%--</div>--%>
                <%--<div class="modal-body" style="height: 300px;" >--%>
                    <%--<div class="prefer-choose clearprefer">--%>
                        <%--<div class="prefer-choose-checkbox">--%>
                            <%--<ul class="clearprefer">--%>
                                <%--<% for(ParentCategory parent:(List<ParentCategory>)request.getAttribute("categories")) {%>--%>
                                <%--<li class="prefer-choose-check" id="<%=parent.getId()%>"><%=parent.getTitle()%><i class="iconfont icon-checked"></i></li>--%>
                                <%--<% } %>--%>
                            <%--</ul>--%>
                        <%--</div>--%>
                    <%--</div>--%>
                <%--</div>--%>
                <%--<div class="modal-footer">--%>
                    <%--<button id="btnPrefer" type="button" class="btn btn-primary" >确定</button>--%>
                <%--</div>--%>
            <%--</div>--%>
        <%--</div>--%>
    <%--</div>--%>

    <!--信息提示-->
    <div class="modal fade" tabindex="-1" role="dialog" id="infoTip" aria-labelledby="gridSystemModalLabel">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                    <h4 class="modal-title" id="gridSystemModalLabel">提示</h4>
                </div>
                <div class="modal-body" id="divTip">
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-primary" data-dismiss="modal">确定</button>
                </div>
            </div>
        </div>
    </div>

</div>



<script src="/static/js/jquery.min.js"></script>
<!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
<script src="/static/js/bootstrap.js"></script>
<script type="text/javascript" src="/static/js/bootsnav.js"></script>
<script type="text/javascript" src="/static/js/login.js"></script>
<script>
    $(document).ready(function () {
        $("#btn-face-login").click(function () {
            $.ajax({
                url:"/user/faceLogin",
                type:"GET",
                dataType:"json",
                success:function (result) {
                    alert(result)
                }
            })
        })

        $.ajax({
            url:"/head/user",
            type:"GET",
            dataType:"json",
            success:function (result) {
                if(result.userId!=0){
                    $(".islogin_true").css("display","none");
                    $(".islogin_felse").css("display","");
                }
                else {
                    $(".islogin_true").css("display","");
                    $(".islogin_felse").css("display","none");
                }
            }
        })
    })
</script>
</body>
</html>