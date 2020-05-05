<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Room</title>
</head>
<body id="myBody">
    <p>Number: ${num}</p>
    <p>Room: ${name}</p>
    <p>Country: ${country}</p>
    <button value="${light}" onclick="changeLightStateOnServer()">turn</button>
    <p id="turn"></p>

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
    <script>
        function changeLightStateOnServer(){
            $.ajax({
                "type": "GET",
                "url": "/view/room",
                "data": {num : ${num}}
            })
        }

        function setLightStateOnClient(){
            $.ajax({
                "type": "POST",
                "url": "/view/room",
                "data": {num : ${num}},
                "dataType": "json",
                "success": function(data) {
                    document.getElementById("turn").innerText = "turn " + data.light;
                },
                "error": function(errorData) {
                    console.log("lookup ajax error");
                    console.log(errorData);
                }
            })
        }

        setInterval(setLightStateOnClient, 1000);
    </script>

</body>
</html>