<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css" type="text/css" />
		<!-- 引入自定义css文件 style.css -->
		<link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css" type="text/css" />
<script>
	function deleteConfirm(id){
		if(confirm("你确定删除?")){
			window.location.href= "/beiyong/guanli?method=deleteHouseMsg&id="+id;
		}		
	}
</script>
<style>
#center {
	width: 940px;
	height: 530px;
	margin: 0px auto;
}

input {
	background-color: forestgreen;
	color: white;
}

#logo {
	
}

#exit {
	position: relative;
	left: 744px;
	top: -50px;
}

#clear {
	clear: both;
}

#msg {
	list-style: none;
}

ul {
	list-style: none;
}

table {
	border-collapse: collapse;
	width: 930px;
}

tr {
	
}

td {
	background-color: ghostwhite;
	padding: 22px;
	border-bottom: 1px solid #000000;
	padding-right: 22px;
}

#fenye {
	position: relative;
	top: -20px;
	left: 850px;
}

#ad {
	position: relative;
	top: -20px;
	left: 650px;
}

#end {
	font-size: 13px;
	color: darkgray;
}

#fenyezong {
	margin-top: 25px;
}
</style>
</head>
<body>
	<div id="center">
		<div>
			<img src="${pageContext.request.contextPath }/img/logo.gif" id="logo" />
			<div id="exit">
				<a href="${pageContext.request.contextPath }/guanli?method=fabu">发布房屋信息</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<a href="${pageContext.request.contextPath }/guanli?method=exit">退出</a>
			</div>
			<div id="clear"></div>
		</div>
		<div>
			<table>
				<c:forEach items="${pageBean.list }" var="item">
					<tr>
						<td><img
							src="${pageContext.request.contextPath }/img/thumb_house.gif"></td>
						<td>
							<ul>
								<li>${item.price}</li>
								<li>${item.address}</li>
								<li>联系方式：${item.link}</li>
							</ul>
						</td>

						<td><a href="${pageContext.request.contextPath }/guanli?method=xiugai">修改</a></td>
						<td><a  onclick="deleteConfirm(${item.id})">删除</a></td>
					</tr>
				</c:forEach>

			</table>
			<div style="width: 380px; margin: 0 auto; margin-top: 50px;">
				<ul class="pagination" style="text-align: center; margin-top: 10px;">
					<!-- 判断当前页是否是首页  -->
					<c:if test="${pageBean.currPage == 1 }">
						<li class="disabled"><a href="javascript:void(0)"
							aria-label="Previous"><span aria-hidden="true">&laquo;</span></a>
						</li>
					</c:if>

					<c:if test="${pageBean.currPage != 1 }">
						<li><a
							href="${pageContext.request.contextPath}/guanli?method=guanLi&currPage=${pageBean.currPage-1}"
							aria-label="Previous"><span aria-hidden="true">&laquo;</span></a>
						</li>
					</c:if>



					<!-- 展示所有页码 -->
					<c:forEach begin="${pageBean.currPage-5>0?pageBean.currPage-5:1 }"
						end="${pageBean.currPage+4>pageBean.totalPage?pageBean.totalPage:pageBean.currPage+4 }"
						var="n">
						<!-- 判断是否是当前页 -->
						<c:if test="${pageBean.currPage==n }">
							<li class="active"><a href="javascript:void(0)">${n }</a></li>
						</c:if>
						<c:if test="${pageBean.currPage!=n }">
							<li><a
								href="${pageContext.request.contextPath}/guanli?method=guanLi&currPage=${n}">${n
									}</a></li>
						</c:if>
					</c:forEach>


					<!-- 判断是否是最后一页 -->
					<c:if test="${pageBean.currPage == pageBean.totalPage }">
						<li class="disabled"><a href="javascript:void(0)"
							aria-label="Next"> <span aria-hidden="true">&raquo;</span>
						</a></li>
					</c:if>
					<c:if test="${pageBean.currPage != pageBean.totalPage }">
						<li><a
							href="${pageContext.request.contextPath}/guanli?method=guanLi&currPage=${pageBean.currPage+1}"
							aria-label="Next"> <span aria-hidden="true">&raquo;</span>
						</a></li>
					</c:if>

				</ul>
			</div>
		</div>
		<hr>
		<div id="end">
			<span>ETC租房 © 2016 中软国际 京ICP证1000001号</span>
			<div id="ad">
				<span>关于我们 · 联系方式 · 意见反馈 · 帮助中心</span>
			</div>
		</div>

	</div>
</body>
</html>