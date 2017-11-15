<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
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
		<jsp:include page="../admin/header.jsp"></jsp:include>
		<jsp:include page="../admin/sidebar.jsp"></jsp:include>

		<div class="content-wrapper">

			<div class="col-md-3"></div>
			<div class="col-md-6">
				<div class="box-body">
					
				</div>
			</div>
			<div class="col-md-3"></div>

			<div>
			
				<!-- /.box-header -->
				<div class="box-body">
				<a href="/MyERP/createVendor"><button type="button" class="btn bg-purple margin">Create New</button></a>
					<table id="example1" class="table table-bordered table-striped">
						<thead>
							<tr>
								<th>Vendor ID</th>
								<th>Vendor Name</th>
								<th>Vendor Code</th>
								<th>Address Line 1</th>
								<th>Address Line 2</th>
								<th>Vendor Email</th>
								<th>Vendor Status</th>
								<th>Edit</th>
								<th>Delete</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="listVendor" items="${ listVendor}">
								<tr>
									<td>${listVendor.vendorId}</td>
									<td>${listVendor.vendorName}</td>
									<td>${listVendor.vendorCode}</td>
									<td>${listVendor.vendorAddressline1}</td>
									<td>${listVendor.vendorAddressline2}</td>
									<td>${listVendor.vendorEmail}</td>
									<td>${listVendor.isAcive}</td>
									
									<td>
									<a href="/MyERP/getVendorById?vendorId=${listVendor.vendorId}"><button type="button" class="btn bg-purple margin">Edit</button></a>
									</td>
									
									<td>
									<a href="/MyERP/deleteVendor?vendorId=${listVendor.vendorId}"><button type="button" class="btn bg-purple margin">Delete</button></a>
									</td>
									
								</tr>
							</c:forEach>
						</tbody>
						<tfoot>
							<tr>
								<th>Vendor ID</th>
								<th>Vendor Name</th>
								<th>Vendor Code</th>
								<th>Address Line 1</th>
								<th>Address Line 2</th>
								<th>Vendor Email</th>
								<th>Vendor Status</th>
								<th>Edit</th>
								<th>Delete</th>
							</tr>
						</tfoot>
					</table>
				</div>
				<!-- /.box-body -->
			</div>


		</div>






		<jsp:include page="../admin/footer.jsp"></jsp:include>

		<!-- DataTables -->
		<%-- <script
			src="${pageContext.request.contextPath}/resources/admin/plugins/jQuery/jquery-2.2.3.min.js"></script>
 --%>
		<script
			src="${pageContext.request.contextPath}/resources/admin/plugins/datatables/jquery.dataTables.min.js"></script>
		<script
			src="${pageContext.request.contextPath}/resources/admin/plugins/datatables/dataTables.bootstrap.min.js"></script>

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