<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/admin/plugins/datatables/dataTables.bootstrap.css">
	
	

</head>
<body class="hold-transition skin-blue sidebar-mini">
	<div class="wrapper">
		<jsp:include page="header.jsp"></jsp:include>
		<jsp:include page="sidebar.jsp"></jsp:include>

		<div class="content-wrapper">

			<div class="col-md-3"></div>
			<div class="col-md-6">
			<font color="red"><h2>${message}</h2></font>
				<div class="box-body">
						      <form:form action="createUser" method="post" commandName="userMasterDto">
						      <form:hidden path="userid" />
	<label>Login ID:</label> <form:input path="loginid" class="form-control"/>
	<label>Password:</label> <form:input path="password" class="form-control"/>
	<label>E-mail:</label> <form:input path="email" class="form-control"/>
	<label>Is Active:</label> <form:checkbox path="isActive" value="isActive"/><br>
	<label>Is Administrator:</label> <form:checkbox path="roles" value="ROLE_isAdministrator"/>
	

<table border="2">
	<tr>
		<th>Menu Name</th>
		<th>Create</th>
		<th>Read</th>
		<th>Update</th>
		<th>Delete</th>
	</tr>
	<c:forEach items="${menuMasterList}" var="currentObject">
	<tr>
		<td><label>${currentObject.getMenuName()}</label></td> 
		<td><form:checkbox path="roles" value="ROLE_${currentObject.getMenuName()}IsCreate"/></td>
		<td><form:checkbox path="roles" value="ROLE_${currentObject.getMenuName()}IsSelect"/></td>
		<td><form:checkbox path="roles" value="ROLE_${currentObject.getMenuName()}IsUpdate"/></td>
		<td><form:checkbox path="roles" value="ROLE_${currentObject.getMenuName()}IsDelete"/></td>
	</tr>
	</c:forEach>
</table>
<button type="submit" name="createUser" class="btn btn-block btn-primary btn-sm">Create USer</button>
</form:form>
				</div>
			</div>
			<div class="col-md-3"></div>
			<%-- <form action="create" method="get">
			<div>
				<!-- /.box-header -->
				<div class="box-body">
						<table id="example1" class="table table-bordered table-striped">
							<thead>
								<tr>
									<th>Menu Name</th>
									<th>Status</th>
								</tr>
							</thead>
							<tbody>
							<c:forEach items="${menuMasterList}" var="currentObject" varStatus="loop">
								<tr>
									<td><a href="updateMenu?index=${loop.index}">${currentObject.getMenuName()}</a></td>
									<td><c:choose>
											<c:when test="${currentObject.getIsActive()}">Active</c:when>
											<c:otherwise>Inactive</c:otherwise>
										</c:choose></td>
								</tr>
							</c:forEach>
						</tbody>
							<!-- <tfoot>
								<tr>
									<th>Cateory Id</th>
									<th>Cateory Name</th>
									<th>Operation</th>
								</tr>
							</tfoot> -->
						</table>
				</div>
				<!-- /.box-body -->
			</div>
			<table align="right">
				<tr>
					<td> <input type="submit" value="Submit"> </td>
				</tr>
			</table><br><br>
			</form> --%>
		</div>


		



		<jsp:include page="footer.jsp"></jsp:include>
		<script
			src="${pageContext.request.contextPath}/resources/admin/plugins/jQuery/jquery-2.2.3.min.js"></script>
		<!-- Bootstrap 3.3.6 -->
		<script
			src="${pageContext.request.contextPath}/resources/admin/bootstrap/js/bootstrap.min.js"></script>
		<!-- DataTables -->
		<script
			src="${pageContext.request.contextPath}/resources/admin/plugins/datatables/jquery.dataTables.min.js"></script>
		<script
			src="${pageContext.request.contextPath}/resources/admin/plugins/datatables/dataTables.bootstrap.min.js"></script>
		<!-- SlimScroll -->
		<script
			src="${pageContext.request.contextPath}/resources/admin/plugins/slimScroll/jquery.slimscroll.min.js"></script>
		<!-- FastClick -->
		<script
			src="${pageContext.request.contextPath}/resources/admin/plugins/fastclick/fastclick.js"></script>
		<!-- AdminLTE App -->
		<script
			src="${pageContext.request.contextPath}/resources/admin/dist/js/app.min.js"></script>
		<!-- AdminLTE for demo purposes -->
		<script
			src="${pageContext.request.contextPath}/resources/admin/dist/js/demo.js"></script>
		<!-- page script -->
		<script>
			$(function() {
				$("#example1").DataTable();
				$('#example2').DataTable({
					"paging" : true,
					"lengthChange" : false,
					"searching" : false,
					"ordering" : true,
					"info" : true,
					"autoWidth" : false
				});
			});
		</script>
	</div>
</body>
</html>