<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Main page</title>
</head>
<body>

    <button onclick="goToAdd()" class="button">Create room</button>
    <button type="submit" onclick="goToList()" class="button">List of rooms</button>

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
    <script type="text/javascript">
        var d;

        $.get('https://www.cloudflare.com/cdn-cgi/trace',
            function(data) {
                d = data;
            })

        function goToAdd() {
            document.location.href = "/view/add.jsp?data="+ d;
        }

        function goToList() {
            document.location.href = "/view/list.jsp?data="+ d;
        }
    </script>

</body>
</html>
