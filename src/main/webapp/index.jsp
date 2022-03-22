<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
    <link rel="stylesheet" href="css/tailwind-out.css">
</head>
<body>
    <h1 class="text-md">hello</h1>
<h1 class="text-5xl text-8xl"><%=session.getId()%>></h1>
<c:forEach begin="1" end="10">
    <h2>core tag library test</h2>
</c:forEach>
</body>
</html>