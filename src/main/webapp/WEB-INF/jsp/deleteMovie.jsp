<%--
  Created by IntelliJ IDEA.
  User: m17004453
  Date: 14/09/2022
  Time: 11:33
  To change this template use File | Settings | File Templates.
--%>
<%@ include file="/WEB-INF/jsp/header.jsp"%>

<div class="container">
    <h1>Liste des films</h1>

    <c:url var="movieAction" value="/movies" />


    Voulez-vous vraiment supprimer le film "<c:out value="${movie.name}"/>" ?

    <form method="post" modelAttribute="movie">
        <button type="submit" class="btn btn-primary">Oui</button>
        <a class="btn btn-primary" href="${movieAction}">Non</a>
    </form>
</div>

<%@ include file="/WEB-INF/jsp/footer.jsp"%>
