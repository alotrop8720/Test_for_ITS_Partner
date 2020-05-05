<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>List rooms</title>
    <link rel="stylesheet" type="text/css" href="css/mainCss.css?2">
</head>
<body>
    <c:forEach var="element" items="${rooms}" varStatus="counter">
        <p id="${counter.index} ${element.isLight()}">${element.getName()} ${element.getCountry()}</p>
    </c:forEach>
    <script>
        document.body.onclick = function(e) {
            el = e.target;
            var arrValue = el.innerHTML.split(" ");
            var arrId = el.id.split(" ");
            if (arrValue[1].toUpperCase() === "${ipCountry}".toUpperCase())
                document.location.href = "/view/room.jsp?name="+arrValue[0]+"&num="+arrId[0]+"&country="+arrValue[1]+"&light="+arrId[1];
            else
                alert("You do not located " + arrValue[1]);
        };

    </script>
</body>
</html>
