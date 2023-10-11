<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<body style="margin-left: 30px; background-color: lightyellow;">
    <h2>Struts2 login & logout example with Session Management</h2>

    <s:form action="sessionman">
        <s:textfield name="userId" label="User ID" />
        <s:password name="userPass" label="Password" />
        <s:submit value="Login" />
    </s:form>

    <s:property value="msg" />

</body>
</html>