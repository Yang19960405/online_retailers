<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="../../favicon.ico">

    <title>首页</title>
    <link href="/static/css/bootstrap.min.css" rel="stylesheet"/>

    <link href="/static/css/font-awesome.css" rel="stylesheet">
    <link href='https://fonts.googleapis.com/css?family=Open+Sans:400,700'
          rel='stylesheet' type='text/css'>
    <link href="/static/css/animate.css" rel="stylesheet">
    <link href="/static/css/bootsnav.css" rel="stylesheet">
    <link rel="stylesheet" type="text/css"
          href="/static/css/htmleaf-demo.css">
    <link href="/static/css/overwrite.css" rel="stylesheet">
    <link href="/static/css/style.css" rel="stylesheet">
    <link href="/static/css/color.css" rel="stylesheet">

    <style type="text/css">
        .container h1 {
            font-size: 20px;
        }

        .caption {
            text-align: center;
        }

        .caption h3 {
            font-size: 14px;
        }

        #carousel-example-generic img {
            width: 100%;
        }

        #header_info a {
            color: #C9C9C9;
        }

        #header_info a:hover {
            color: #FFF;
            text-decoration: none;
        }
    </style>

</head>

<body id="home">
<%--<iframe id="mainIframe" name="mainIframe" src="/head" frameborder="0" scrolling="no" width="100%"></iframe>--%>
<%--<iframe id="mainIframe2" name="mainIframe2" src="/headSearch" frameborder="0" scrolling="no" width="100%"></iframe>--%>
<jsp:include page="head.jsp"/>
<!-- Start Navigation -->
<nav class="navbar navbar-default navbar-brand-top bootsnav">
    <!-- End Header Navigation
    <div class="container">
        <div style="height: 100px">该位置放置广告</div>
        <div id="custom-search-input">
            <div class="input-group col-md-12">
                <input type="text" class="search-query form-control"
                       placeholder="Search"/> <span class="input-group-btn">
					<button class="btn btn-danger btn-search" type="button">
						<span class=" glyphicon glyphicon-search"></span>
					</button>
				</span>
            </div>
        </div>
    </div>
-->
    <div class="container">

        <!-- End Header Navigation -->

        <!-- Collect the nav links, forms, and other content for toggling -->
        <div class="collapse navbar-collapse" id="navbar-menu">
            <ul class="nav navbar-nav" data-in="fadeInDown" data-out="fadeOutUp" id="category">
            </ul>

        </div>
        <!-- /.navbar-collapse -->

    </div>
</nav>
<!-- End Navigation -->
<div style="margin-top: 20px"></div>


<div class="clearfix"></div>


<div class="container">
    <div id="carousel-example-generic" class="carousel slide"
         data-ride="carousel">
        <!-- Indicators -->
        <ol class="carousel-indicators">
            <li data-target="#carousel-example-generic" data-slide-to="0"
                class="active"></li>
            <li data-target="#carousel-example-generic" data-slide-to="1"></li>
            <li data-target="#carousel-example-generic" data-slide-to="2"></li>
        </ol>

        <!-- Wrapper for slides -->
        <div class="carousel-inner" role="listbox">
            <div class="item active">
                <img src="/static/images/img_fjords_wide.jpg" alt="...">
                <div class="carousel-caption">第一个商品</div>
            </div>
            <div class="item">
                <img src="../static/images/img_nature_wide.jpg" alt="...">
                <div class="carousel-caption">第二个商品</div>
            </div>
            <div class="item">
                <img src="../static/images/img_mountains_wide.jpg" alt="...">
                <div class="carousel-caption">第三个商品</div>
            </div>
        </div>

        <!-- Controls -->
        <a class="left carousel-control" href="#carousel-example-generic"
           role="button" data-slide="prev"> <span
                class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
            <span class="sr-only">Previous</span>
        </a> <a class="right carousel-control" href="#carousel-example-generic"
                role="button" data-slide="next"> <span
            class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
        <span class="sr-only">Next</span>
    </a>
    </div>
</div>

<div class="container">
    <h1>热门商品</h1>
    <div class="row" id="hotgoods">

    </div>


    <!-- Jumbotron -->
    <div>
        <h1>新品推荐</h1>

        <div class="row" id="newgoods">
        </div>
    </div>

    <%--<div>--%>
        <%--<h1>猜你喜欢</h1>--%>

        <%--<div class="row">--%>
            <%--<% for(Goods4List hg:(List<Goods4List>)request.getAttribute("recommendGoods")) {%>--%>
            <%--<div class="col-sm-6 col-md-4">--%>
                <%--<div class="thumbnail goods-item">--%>
                    <%--<a href="/home/productView/<%=hg.getId()%>">--%>
                        <%--<img src="/static/images/cover_picture/<%=hg.getCategory().getParentId()%>/<%=hg.getCategoryId()%>/<%=hg.getId()%>/<%=hg.getUrl()%>" alt="...">--%>
                    <%--</a>--%>
                    <%--<div class="caption div-desc" id="<%=hg.getId()%>">--%>
                        <%--<h3><%=hg.getName()%></h3>--%>
                        <%--<p style="font-size:12px; color:dimgray"><%=hg.getDescription()%></p>--%>
                        <%--<p style="color:red">&yen;<%=hg.getPrice()%></p>--%>

                    <%--</div>--%>
                <%--</div>--%>

            <%--</div>--%>
            <%--<%}%>--%>
        <%--</div>--%>
    <%--</div>--%>

    <!-- Site footer -->
    <footer class="footer">
        <p>&copy; 2019 Company, Inc.</p>
    </footer>

</div>
<!-- /container -->


<script src="/static/js/jquery.min.js"></script>
<!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
<script src="/static/js/bootstrap.js"></script>

<script>

    $(document).ready(function () {

        $.ajax({
            url:"/home/data",
            type:"GET",
            dataType:"json",
            success: function (result) {
                getHomeData("hotgoods",result.hotGoods)
                getHomeData("newgoods",result.newGoods)
            }
        })
        $.ajax({
            url:"/headSearch/data",
            type:"GET",
            dataType:"json",
            async:"false",
            success:function (result) {
                data=result.parentCategoryAOS
                htmlText=""
                for (i=0;i<data.length;i++){
                    htmlText+="<li class=\"dropdown megamenu-fw\">\n" +
                        "                    <a href=\"#\" class=\"\"\n" +
                        "                       data-toggle=\"dropdown\">"+data[i].title+"\n" +
                        "                    </a>\n" +
                        "\n" +
                        "                    <ul class=\"dropdown-menu megamenu-content\" role=\"menu\">\n" +
                        "                        <li>\n" +
                        "                            <div class=\"row\">\n"

                    for (j=0;j<data[i].groups.length;j++){
                        group=data[i].groups[j]
                        htmlText+="<div class=\"col-menu col-md-3\">\n" +
                            "                                    <h6 class=\"title\">"+group.groupName+"\n" +
                            "                                    </h6>\n" +
                            "                                    <div class=\"content\">\n" +
                            "                                        <ul class=\"menu-col\">\n"
                        for (k=0;k<group.categories.length;k++) {
                            categorie=group.categories[k]
                            htmlText=" <li><a href=\"/home/product/"+categorie.id+"/9/0\">"+categorie.title+"\n" +
                                "                                            </a></li>"
                        }
                        htmlText+="</ul>\n" +
                            "                                    </div>\n" +
                            "                                </div>"
                    }
                    htmlText+=" </div>\n" +
                        "                            <!-- end row -->\n" +
                        "                        </li>\n" +
                        "\n" +
                        "                    </ul>\n" +
                        "\n" +
                        "                </li>"
                }
                $("#category").empty()
                $("#category").append(htmlText)
            }

        })

    })

    function getHomeData(id,data) {

        htmlText=""
        for (i=0;i<data.length;i++)
        {
            htmlText+= "            <div class=\"col-sm-6 col-md-4\">\n" +
                "                <div class=\"thumbnail goods-item\">\n" +
                "                    <a href=\"/home/productView/"+data[i].id+"\">\n"+
                "                       <img src=\"/static/images/cover_picture/"+data[i].category.parentId+"/"+data[i].categoryId+"/"+data[i].id+"/"+data[i].url+"\" alt=\"...\"/>\n"+
                "                   </a>\n"+
                "                   <div class=\"caption div-desc\" id=\""+data[i].id+"\">\n"+
                "                       <h3>"+data[i].goodsName+"</h3>\n"+
                "                       <p style=\"font-size:12px; color:dimgray\">"+data[i].goodsIntroduce+"</p>\n"+
                "                       <p style=\"color:red\">&yen;"+data[i].goodsPrice+"</p>\n"+
                "                    </div>\n" +
                "                </div>\n" +
                "            </div>"
        }
        $("#"+id+"").empty()
        $("#"+id+"").append(htmlText)
    }
</script>

<script type="text/javascript" src="/static/js/bootsnav.js"></script>
<script type="text/javascript" src="/static/js/search.js"></script>
</body>
</html>
