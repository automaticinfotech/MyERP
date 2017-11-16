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
						      
				</div>
			</div>
			<div class="col-md-3"></div>
			<div>
				<!-- /.box-header -->
				<div class="box-body">
				<a href="/MyERP/createUser"><button type="button" class="btn bg-purple margin">Create New</button></a>
						<table id="example1" class="table table-bordered table-striped">
							<thead>
								<tr>
									<th>Login Id</th>
									<th>E-mail</th>
									<th>Status</th>
									<th>Delete</th>
								</tr>
							</thead>
							<tbody>
							<c:forEach items="${userMasterList}" var="currentObject" varStatus="loop">
								<tr>
									<td><a href="updateUser?loginId=${currentObject.getLoginid()}">${currentObject.getLoginid()}</a></td>
									<td>${currentObject.getEmail()}</td>
									<td><c:choose>
											<c:when test="${currentObject.getIsActive()}">Active</c:when>
											<c:otherwise>Inactive</c:otherwise>
										</c:choose></td>
									<td><a href="deleteUser?loginId=${currentObject.getLoginid()}">Delete</a></td>									
								</tr>
							</c:forEach>
						</tbody>
						</table>
				</div>
				<!-- /.box-body -->
			</div>
			<table align="right">
				<tr>
					<td> <input type="submit" value="Submit"> </td>
				</tr>
			</table><br><br>
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