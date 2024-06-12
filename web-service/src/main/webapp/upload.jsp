<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Upload Content</title>
</head>
<body>
    <h1>Upload Content</h1>
    <form action="content" method="post" enctype="multipart/form-data">
        <input type="hidden" name="action" value="upload">
        <label for="file">File:</label>
        <input type="file" id="file" name="file"><br>
        <label for="description">Description:</label>
        <input type="text" id="description" name="description"><br>
        <button type="submit">Upload</button>
    </form>
</body>
</html>
