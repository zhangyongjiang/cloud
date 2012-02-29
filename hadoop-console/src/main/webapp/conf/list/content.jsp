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

<table style="border:solid 1px;">
<tr><th>Name</th><th>Value</th><th>&nbsp;</th></tr>
<c:forEach var="conf" items="${it }">
	<tr><td><a href='<c:url value="/conf/set/index.jsp.oo?confId="/>${conf.id}'>${conf.name}</a></td><td>${conf.value }</td><td><button onclick='remove(${conf.id})'>Remove</button></td></tr>
</c:forEach>
</table>

<script type="text/javascript">
	function createConf() {
		window.location = base + "/conf/set/index.jsp.oo";
	}

	function remove(id) {
		if(!confirm("are you sure?"))
			return;
	    $.ajax({
            url : base + "/conf/remove/" + id,
            type : "POST",
            contentType : "application/json; charset=utf-8",
            dataType : "json",
            complete : function(transport) {
                    if (transport.status == 200) {
                            window.location.reload();
                    } else {
                            alert('Error: ' + transport.status + ", "
                                            + transport.responseText);
                    }
            }
    });
	}
</script>