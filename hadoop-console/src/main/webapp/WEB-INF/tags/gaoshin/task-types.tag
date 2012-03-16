<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ attribute name="select" %>
<jsp:include page="/ws/v1/job/task/type-list?format=object&var=typeList"></jsp:include>
<select name="handler" id="handler">
<c:forEach var="taskType" items="${typeList.items }">
	<c:if test="${taskType.value == select }">
		<option selected value="${taskType.value }">${taskType.value }</option>
	</c:if>
	<c:if test="${taskType.value != select }">
		<option value="${taskType.value }">${taskType.value }</option>
	</c:if>
</c:forEach>
</select>