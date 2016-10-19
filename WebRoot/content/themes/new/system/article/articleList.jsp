<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>${cmsInfo.title}</title>
<meta charset="utf-8" />
<%@ include file="../../init/cssInit.jsp" %>
<link href="<%=basePath%>/plugins/pagination/pagination.css" rel="stylesheet" type="text/css" />
</head>
<body>
	<table class="table">
		<thead>
			<th></th>
			<th>标题</th>
			<th>创建日期</th>
		</thead>
		<c:forEach items="${articleList.list}" var="article">
			<tr>
				<td><input name="strId" value="${article.strId}" type="checkbox" /></td>
				<td class = "toDetail" value = "${article.strId}">${article.strTitle}</td>
				<td>
					<fmt:formatDate value="${article.dtCreateTime}" pattern="yyyy-MM-dd HH:mm:ss" type="date" />
				</td>
			</tr>
		</c:forEach>
	</table>
	<pg:defaultPaging url="${url}" totalRows="${totalRows}" numPerPage="${numPerPage}" startIndex="${startIndex}"/>
</body>
<script type="text/javascript" src="<%=basePath%>/plugins/jquery-1.11.3.min.js"></script>
<script type="text/javascript">
<shiro:hasPermission name="article:detail">
</shiro:hasPermission>
	new parent.parent.ui.tags.AjaxOverlay;
	var dialog = parent.parent.ui.createDialog('<div>',{
		title:'文章编辑',
		width:'80%'
	});
	
	$('.toDetail').css('cursor','pointer');
	
	/**
	 * 文章编辑
	 */
	$('.toDetail').click(function(){
		$.get('<%=basePath %>/system/article/toDetail?strId='+ $(this).attr('value'),function(data){
			dialog.html(data).dialog('open');
		});
	});
	
	dialog.on('click','#articleSave',function(){
		var form = dialog.find('#articleEdit');
		$.ajax({
			type : 'POST',
			url  : form.attr('action'),
			data : form.serialize(),
			dataType : 'json',
			success:function(data) { 
				if(data.code != 0){
					alert(data.info);
				}
				dialog.dialog('close');
				window.location.href = window.location.href;
			},
			error : function(XMLHttpRequest, textStatus, errorThrown) {    
				alert("异常");
				dialog.dialog('close');
			}
		});
	});
</script>
</html>