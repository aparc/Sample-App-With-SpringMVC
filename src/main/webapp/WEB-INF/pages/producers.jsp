<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="from" uri="http://www.springframework.org/tags/form" %>
<%@ page session="false" %>
<html>
<head>
    <title>Products Page</title>

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

<h1>Producer List</h1>

<c:if test="${!empty listProducers}">
    <table class="tg">
        <tr>
            <th width="80">ID</th>
            <th width="120">Name</th>
            <th width="120">Address</th>
            <th width="60">Edit</th>
            <th width="60">Delete</th>
        </tr>
        <c:forEach items="${listProducers}" var="producer">
            <tr>
                <td>${producer.producerId}</td>
                <td>${producer.name}</td>
                <td>${producer.address}</td>
                <td><a href="<c:url value='producers/edit/${producer.producerId}'/>">Edit</a></td>
                <td><a href="<c:url value='producers/remove/${producer.producerId}'/>">Delete</a></td>
            </tr>
        </c:forEach>
    </table>
</c:if>


<h1>Add a Producer</h1>

<c:url var="addAction" value="/producers/add"/>

<form:form action="${addAction}" commandName="producer">
    <table>
        <c:if test="${!empty producer.name}">
            <tr>
                <td>
                    <form:label path="producerId">
                        <spring:message text="ID"/>
                    </form:label>
                </td>
                <td>
                    <form:input path="producerId" readonly="true" size="8" disabled="true"/>
                    <form:hidden path="producerId"/>
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
            <td>
                <form:label path="address">
                    <spring:message text="Address"/>
                </form:label>
            </td>
            <td>
                <form:input path="address"/>
            </td>
        </tr>
        <tr>
            <td colspan="2">
                <c:if test="${!empty producer.name}">
                    <input type="submit"
                           value="<spring:message text="Edit Producer"/>"/>
                </c:if>
                <c:if test="${empty producer.name}">
                    <input type="submit"
                           value="<spring:message text="Add Producer"/>"/>
                </c:if>
            </td>
        </tr>
    </table>
</form:form>
</body>
</html>
