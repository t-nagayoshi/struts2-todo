<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
  <title>todo</title>
  <link href="<s:url value='/styles/todo.css'/>" rel="stylesheet" type="text/css" media="all"/>
  <s:head />
</head>
<body>
  <h1>Todo Items</h1>
  <table border="1">
    <thead>
      <tr>
        <th>タスク</th>
        <th>作成日</th>
        <th>期限</th>
        <th>完了</th>
      </tr>
    </thead>
    <tbody>
      <s:iterator value="todoItemList">
        <tr>
          <td><s:property value="title" /></td>
          <td><s:property value="created_date" /></td>
          <td><s:property value="limited_date" /></td>
          <td><s:property value="done" /></td>
        </tr>
      </s:iterator>
    </tbody>
  </table>
</body>
</html>
