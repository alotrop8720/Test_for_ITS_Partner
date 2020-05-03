<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>List rooms</title>
    <link rel="stylesheet" type="text/css" href="css/mainCss.css?2">
</head>
<body>
    <c:forEach var="element" items="${rooms}">
        <p name="tag" id="${element.isLight()}">${element.getName()}  ${element.getCountry()}</p>
    </c:forEach>
    <script>
        document.body.onclick = function(e) {
            el = e.target;
            document.location.href = "/RoomLight/view/room.jsp?name="+el.innerHTML+"&light="+el.id;
        };
    </script>
</body>
</html>
