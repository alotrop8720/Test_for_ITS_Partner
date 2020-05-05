<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Create room</title>
</head>
<body>
<div>
    <form action="/RoomLight/view/add" method="post">
        <label for="fname">Name room</label>
        <input type="text" id="fname" name="name_room" placeholder="Name room..">

        <label for="country">Country</label>
        <select id="country" name="country">
            <c:forEach var="element" begin="0" end="${listCountries.size() - 1}">
                <option>${listCountries.get(element)}</option>
            </c:forEach>
        </select>
        <button type="submit" onclick="goToPageList()">CREATE</button>
    </form>
</div>

<script>
    function goToPageList()
    {
        document.location.href = "/view/list.jsp";
    }
</script>
</body>
</html>
