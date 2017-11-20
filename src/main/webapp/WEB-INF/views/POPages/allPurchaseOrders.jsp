<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>My ERP | All Purchase Orders</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/admin/plugins/datatables/dataTables.bootstrap.css">

<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/admin/bootstrap/css/bootstrap.min.css">
<!-- Font Awesome -->
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.5.0/css/font-awesome.min.css">
<!-- Ionicons -->
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/ionicons/2.0.1/css/ionicons.min.css">
<!-- Theme style -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/admin/dist/css/AdminLTE.min.css">
<!-- AdminLTE Skins. Choose a skin from the css/skins
       folder instead of downloading all of them to reduce the load. -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/admin/dist/css/skins/_all-skins.min.css">
<!-- iCheck -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/admin/plugins/iCheck/flat/blue.css">
<!-- Morris chart -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/admin/plugins/morris/morris.css">
<!-- jvectormap -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/admin/plugins/jvectormap/jquery-jvectormap-1.2.2.css">
<!-- Date Picker -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/admin/plugins/datepicker/datepicker3.css">
<!-- Daterange picker -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/admin/plugins/daterangepicker/daterangepicker.css">
<!-- bootstrap wysihtml5 - text editor -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/admin/plugins/bootstrap-wysihtml5/bootstrap3-wysihtml5.min.css">
<!-- toggle -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/admin/css/toggleswitch.css">
<script>
	function myFunction() {
		var id = document.getElementById("myCheck").value;
		if (id == 'A') {
			document.getElementById("myCheck").value = "I";
			var y = document.getElementById("myCheck").value;
		} else {
			document.getElementById("myCheck").value = "A";
			var y = document.getElementById("myCheck").value;
		}
	}

	function deleteConform(projectName) {
		var decision = confirm("Project '" + projectName
				+ "'  may contains multiple wings\nDo you want to Delete?");
		if (decision) {
			return true;
		} else {
			return false;
		}
	}
</script>
<style>
div.panel-body {
	box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2), 0 6px 20px 0
		rgba(0, 0, 0, 0.19);
}
</style>

</head>
<body class="hold-transition skin-blue sidebar-mini">
	<div class="wrapper">
		<jsp:include page="../admin/header.jsp"></jsp:include>
		<jsp:include page="../admin/sidebar.jsp"></jsp:include>

		<div class="content-wrapper">

			<c:if test="${not empty successMessage}">
				<div class="alert alert-success alert-dismissable fade in"
					id="success-alert">
					<a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
					<strong>Success!</strong> ${successMessage}
				</div>
			</c:if>
			<c:if test="${not empty errorMessage}">
				<div class="alert alert-danger alert-dismissable fade in"
					id="success-alert">
					<a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
					<strong>Error!</strong> ${errorMessage}
				</div>
			</c:if>

			<div class="col-md-1"></div>
			<div class="col-md-10">
				<div></div>
			</div>
			<div class="col-md-1"></div>

			<div>
				<div class="box-body">
					<div>
						<a href="/MyERP/newPurchaseOrder"><button type="submit"
								class="btn btn-success btn-sm">Create New Purchase
								Order</button></a>
						<hr>
						<table id="example1"
							class="table table-responsive table-bordered table-hover"
							style="background-color: white;">
							<thead>
								<tr>
									<th>Document No</th>
									<th>Document Date</th>
									<th>Vender</th>
									<th>Material</th>
									<th>Quantity</th>
									<th>Rate</th>
									<th>Amount</th>
									<th>Ref Doc No</th>
									<th>Ref Doc Date</th>
									<th>Print</th>
									<th>Delete</th>

								</tr>
							</thead>
							<tbody>
								<c:forEach items="${purchaseDetailsList}" var="poDetails">

									<tr>
									    
										<td>${poDetails.purchaseOrderHeader.documentNo}</td>
										<td>${poDetails.purchaseOrderHeader.documentDate}</td>
										<td>${poDetails.purchaseOrderHeader.vendorMst.vendorName}</td>
										<td>${poDetails.materialMst.materialName}</td>
										<td>${poDetails.quantity}</td>
                                        <td>${poDetails.rate}</td>
                                        <td>${poDetails.rate * poDetails.quantity}</td>
										<td>${poDetails.purchaseOrderHeader.refDocNo}</td>
										<td>${poDetails.purchaseOrderHeader.refDocDate}</td>
										<td><a href="#">Print</a></td>
										<%-- <td><a href="deletePurchaseOrder/${poDetails.documentId}">Delete</a></td> --%>
										<td><a href="<c:url value='/deletePurchaseOrder/${poDetails.poDetailsID}' />">Delete</a></td>

									</tr>
								</c:forEach>

							</tbody>
						</table>
					</div>
					<!-- /.box-body -->
				</div>

			</div>
		</div>

		<jsp:include page="../admin/footer.jsp"></jsp:include>
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
					"paging" : false,
					"lengthChange" : false,
					"searching" : false,
					"ordering" : false,
					"info" : false,
					"autoWidth" : false
				});
			});
		</script>


		<script>
			function updateActiveStatus(id, name, status) {
				var data = {
					"projectId" : id,
					"projectName" : name,
					"projectIsActive" : status
				}

				$.ajax({
					type : "POST",
					url : "/BuildingManagement/editCategoryMasterStatus",
					datatype : "application/json",
					contentType : "application/json; charset=utf-8",
					data : JSON.stringify(data),
					timeout : 100000,
					success : function(data) {
						//alert("success");
					},
					error : function(e) {
						//alert("error");
					},
					done : function(e) {
						console.log("DONE");
					}
				});

			};
		</script>
		<script>
			$("#success-alert").fadeTo(2000, 500).slideUp(500, function() {
				$("#success-alert").slideUp(500);
			});
		</script>
		<script>
			$("#addProjectFormId").fadeTo(200000, 50000).slideDown(50000,
					function() {
						$("#addProjectFormId").slideDown(50000);
					});
		</script>

	</div>
</body>
</html>