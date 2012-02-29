<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib tagdir="/WEB-INF/tags/common" prefix="o" %>

<%
	String url = "/conf/list?format=object";
	request.getRequestDispatcher(url).include(request, response);
%>

<div class="page-header">Configuration List</div>

<button onclick="createConf()">Create</button>

<table>
<tr><th>Name</th><th>Value</th></tr>
<c:forEach var="conf" items="${it }">
	<tr><td>${conf.name}</td><td>${conf.value }</td></tr>
</c:forEach>
</table>

<script type="text/javascript">
	function createConf() {
		window.location = base + "/conf/create/index.jsp.oo";
	}
</script>