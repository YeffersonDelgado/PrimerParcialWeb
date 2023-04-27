<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%><!DOCTYPE html>

<html>
<head>
<meta charset="UTF-8">
<title>Registro de Pacientes</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
</head>
<body>

	<header>


		<nav class="navbar navbar-expand-md navbar-dark"
			style="background-color: blue">

			<div>
				<a href="#" class="navbar-brand"> Gestion de Pacientes </a>
			</div>

			<ul class="navbar-nav">

				<li><a href="<%=request.getContextPath()%>/pacientelist.jsp"
					class="nav-link"> Pacientes </a></li>

			</ul>

		</nav>

	</header>
	<br>
	<div class="container col-md-5">
		<div class="card">
			<div class="card-body"></div>


			<c:if test="${paciente != null}">
				<form action="update" method="post">
			</c:if>
			<c:if test="${paciente == null}">
				<form action="insert" method="post">
			</c:if>

			<caption>

				<h2>
					<c:if test="${usuario != null}">
			             Editar Paciente  
			     </c:if>

					<c:if test="${usuario == null}">
			             Agregar Nuevo Paciente  
			     </c:if>
				</h2>
			</caption>

			<c:if test="${paciente != null}">
				<input type="hidden" name="id"
					value="<c:out value='${usuario.id}'/>" />
			</c:if>
			
			<fieldset class="form-group">

				<label>Documento del Paciente</label> <input type="text"
					value="<c:out value='${paciente.documento}' />" class="form-control"
					name="nombre" required="required">

			</fieldset>

			<fieldset class="form-group">

				<label>Nombre de Paciente</label> <input type="text"
					value="<c:out value='${paciente.nombre}' />" class="form-control"
					name="nombre" required="required">

			</fieldset>

			<fieldset class="form-group">

				<label>Apellido del Usuario</label> <input type="text"
					value="<c:out value='${paciente.apellido}' />" class="form-control"
					name="apellido">

			</fieldset>

			<fieldset class="form-group">

				<label>Email del Paciente</label> <input type="text"
					value="<c:out value='${paciente.email}' />" class="form-control"
					name="email">

			</fieldset>
			
			<fieldset class="form-group">

				<label>Genero del Paciente</label> <input type="text"
					value="<c:out value='${paciente.genero}' />" class="form-control"
					name="genero">

			</fieldset>
			
				<fieldset class="form-group">

				<label>fecha de Nacimiento del Paciente</label> <input type="text"
					value="<c:out value='${paciente.fechaNacimiento}' />" class="form-control"
					name="fechaNacimiento">

			</fieldset>
			
			<fieldset class="form-group">

				<label>Telefono del Paciente</label> <input type="text"
					value="<c:out value='${paciente.telefono}' />" class="form-control"
					name="telefono">

			</fieldset>
			
			<fieldset class="form-group">

				<label>Direccion del Paciente</label> <input type="text"
					value="<c:out value='${paciente.direccion}' />" class="form-control"
					name="direccion">

			</fieldset>
			
			<fieldset class="form-group">

				<label>Peso del Paciente</label> <input type="text"
					value="<c:out value='${paciente.peso}' />" class="form-control"
					name="peso">

			</fieldset>
			
			<fieldset class="form-group">

				<label>Estatura del Paciente</label> <input type="text"
					value="<c:out value='${paciente.estatura}' />" class="form-control"
					name="estatura">

			</fieldset>

			<button type="submit" class="btn btn-success">Guardar</button>

			</form>

		</div>
	</div>
	
</body>
</html>