<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Room</title>
</head>
<body onload="changeBackground();">
    <p>Room: ${name}</p>
    <button onclick="turnLight()">turn</button>


    <script>
        var light = ${light};
        function turnLight() {
            light = !light;
            changeBackground();
        }
        function changeBackground() {
            if (light)
                document.body.style.background = "#FFD700";
            else
                document.body.style.background = "#5F9EA0";
        }
    </script>
</body>
</html>
