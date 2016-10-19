<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>${cmsInfo.title}</title>
<meta charset="utf-8" />
<%@ include file="../../init/cssInit.jsp" %>
</head>
<body>
	<form id = "articleEdit" action="<%=basePath%>/system/article/saveOrUpdate">
		<table class="table">
			<input type="hidden" name="strId" value="${article.strId}" />
			<tr>
				<td class="label">标题</td>
				<td><input type="text" name="strTitle" value="${article.strTitle}" /></td>
			</tr>
			<tr>
				<td class="label">描述</td>
				<td><input type="text" name="strDescription" value="${article.strDescription}" /></td>
			</tr>
			<tr>
				<td class="label">创建时间</td>
				<td><input type="text" name="dtCreateTime" value="<fmt:formatDate value="${article.dtCreateTime}" pattern="yyyy-MM-dd HH:mm:ss" type="date" />" /></td>
			</tr>
			<tr>
				<td class="label" colspan="2">
					<a id = "articleSave" class="button">
						<b>保存</b>
					</a>
				</td>
			</tr>
		</table>
	</form>
</body>
<script type="text/javascript" src="<%=basePath%>/plugins/jquery-1.11.3.min.js"></script>
</html>