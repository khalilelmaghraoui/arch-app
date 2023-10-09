<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Create New Movie</title>
</head>
<body>
<h2>Create New Movie</h2>
<form action="/movie/${movie.id}" method="post">
    <div>
        <label for="name">Name:</label>
        <input type="text" id="name" name="name" value="${movie.name}" required>
    </div>
    <div>
        <label for="year">Year:</label>
        <input type="number" id="year" name="year" value="${movie.year}" required>
    </div>
    <div>
        <label for="description">Description:</label>
        <textarea id="description" name="description">${movie.description}</textarea>
    </div>
    <input type="hidden" name="id" value="${movie.id}">
    <div>
        <input type="submit" value="Create Movie">
    </div>
</form>
</body>
</html>
