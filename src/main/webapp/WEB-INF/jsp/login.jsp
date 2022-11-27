<%@ include file="/WEB-INF/jsp/header.jsp"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<div class="container">
    <h1>Authentification</h1>

    <form:form method="post" modelAttribute="xuser">

        <div class="form-group">
            <label>Username :</label>
            <form:input path="userName" cssClass="form-control"
                        cssErrorClass="form-control is-invalid" />
            <form:errors path="userName" cssClass="alert alert-warning" element="div" />
        </div>
        <div class="form-group">
            <label>Password :</label>
            <form:input path="password" cssClass="form-control"
                        cssErrorClass="form-control is-invalid" />
            <form:errors path="password" cssClass="alert alert-warning" element="div" />
        </div>
        </div>
        <div class="form-group">
            <button type="submit" class="btn btn-primary">Login</button>
        </div>
    </form:form>
</div>

<%@ include file="/WEB-INF/jsp/footer.jsp"%>
