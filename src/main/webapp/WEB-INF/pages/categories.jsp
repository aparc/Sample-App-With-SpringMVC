<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="from" uri="http://www.springframework.org/tags/form" %>
<%@ page session="false" %>
<html>
<head>
    <title>Category Page</title>

    <style type="text/css">
        .tg {
            border-collapse: collapse;
            border-spacing: 0;
            border-color: #ccc;
        }

        .tg td {
            font-family: Arial, sans-serif;
            font-size: 14px;
            padding: 10px 5px;
            border-style: solid;
            border-width: 1px;
            overflow: hidden;
            word-break: normal;
            border-color: #ccc;
            color: #333;
            background-color: #fff;
        }

        .tg th {
            font-family: Arial, sans-serif;
            font-size: 14px;
            font-weight: normal;
            padding: 10px 5px;
            border-style: solid;
            border-width: 1px;
            overflow: hidden;
            word-break: normal;
            border-color: #ccc;
            color: #333;
            background-color: #f0f0f0;
        }

        .tg .tg-4eph {
            background-color: #f9f9f9
        }
    </style>
</head>
<body>
<a href="../products-system/">Back to main menu</a>

<br/>
<br/>

<h1>Categories List</h1>

<c:if test="${!empty listCategories}">
    <table class="tg">
        <tr>
            <th width="80">ID</th>
            <th width="120">Name</th>
            <th width="60">Edit</th>
            <th width="60">Delete</th>
        </tr>
        <c:forEach items="${listCategories}" var="category">
            <tr>
                <td>${category.categoryId}</td>
                <td>${category.name}</td>
                <td><a href="<c:url value='categories/edit/${category.categoryId}'/>">Edit</a></td>
                <td><a href="<c:url value='categories/remove/${category.categoryId}'/>">Delete</a></td>
            </tr>
        </c:forEach>
    </table>
</c:if>

<h1>Add a Category</h1>

<c:url var="addAction" value="/categories/add"/>

<form:form action="${addAction}" commandName="category">
    <table>
        <c:if test="${!empty category.name}">
            <tr>
                <td>
                    <form:label path="categoryId">
                        <spring:message text="ID"/>
                    </form:label>
                </td>
                <td>
                    <form:input path="categoryId" readonly="true" size="8" disabled="true"/>
                    <form:hidden path="categoryId"/>
                </td>
            </tr>
        </c:if>
        <tr>
            <td>
                <form:label path="name">
                    <spring:message text="Name"/>
                </form:label>
            </td>
            <td>
                <form:input path="name"/>
            </td>
        </tr>
        <tr>
            <td colspan="2">
                <c:if test="${!empty category.name}">
                    <input type="submit"
                           value="<spring:message text="Edit Product"/>"/>
                </c:if>
                <c:if test="${empty product.name}">
                    <input type="submit"
                           value="<spring:message text="Add Product"/>"/>
                </c:if>
            </td>
        </tr>
    </table>
</form:form>
</body>
</html>
