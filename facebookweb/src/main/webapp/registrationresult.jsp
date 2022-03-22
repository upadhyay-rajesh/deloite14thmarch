
<%
	int i=(int)request.getAttribute("result");

if(i>0) { %>
	Registration Success from jsp<a href=login.html>Sign In</a>
<%}
else { %>
	Registration Fail
<%
}
%>