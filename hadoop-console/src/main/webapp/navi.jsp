<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib tagdir="/WEB-INF/tags/common" prefix="o"%>

<div class="col-2">

	<h3 style="margin-top: 0px">&nbsp;</h3>
	<ul class="submenu">
		<li><a href='<c:url value="/hadoop/cluster/index.jsp.oo"/>'>Cluster</a></li>
		<li><a href='<c:url value="/hadoop/hdfs/info/index.jsp.oo?path=/"/>'>HDFS Explorer</a></li>
		<li><a href='<c:url value="/job/create/index.jsp.oo"/>'>New Work Flow</a></li>
		<li><a href='<c:url value="/job/list/index.jsp.oo"/>'>Work Flow List</a></li>
		<li><a href='<c:url value="/conf/list/index.jsp.oo"/>'>Settings</a></li>
		<li><a href='<c:url value=""/>'>Account</a></li>
		<li><a href='<c:url value=""/>'>Support</a></li>
	</ul>

</div>
