<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib tagdir="/WEB-INF/tags/common" prefix="o" %>
<%@ taglib tagdir="/WEB-INF/tags/gaoshin" prefix="g" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%
	String hostId = request.getParameter("hostId");
	String url = "/xen/same-pool-host-list?format=object&var=hostList&hostId=" + hostId;
	request.getRequestDispatcher(url).include(request, response);
%>
<select id="hostList">
	<c:forEach var="host" items="${hostList.items}">
		<option value="${host.uuid }">${host.name}</option>
	</c:forEach>
</select>
