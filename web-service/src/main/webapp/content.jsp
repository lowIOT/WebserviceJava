<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Content</title>
</head>
<body>
    <h1>Content</h1>
    <ul>
        <c:forEach var="content" items="${contents}">
            <li>
                <a href="download?id=${content.id}">${content.fileName}</a> - ${content.description}
            </li>
        </c:forEach>
    </ul>
</body>
</html>
