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
	
<script type="text/javascript">	
	
	</script>

</head>
<body class="hold-transition skin-blue sidebar-mini">
	<div class="wrapper">
		<jsp:include page="../admin/header.jsp"></jsp:include>
		<jsp:include page="../admin/sidebar.jsp"></jsp:include>

		<div class="content-wrapper">

			<div class="col-md-3"></div>
			<div class="col-md-6">
				<div class="box-body">
				
				
					<c:choose>
						    <c:when test="${empty listVendor}">
						      <form action="insertVendor" method="post"  modelAttribute="vendor">
									<!-- text input -->
											<div class="form-group">
												<h3>Create Vendor</h3>
												<label>Vendor Name</label> <input type="text" class="form-control"
													placeholder="Enter Vendor Name..." name="vendorName" maxlength="20" required>
													
												<label>Vendor Code</label> <input type="text" class="form-control"
													placeholder="Enter vendor Code..." name="vendorCode" value="${vendorCode}" readonly>	
													
												<label>Vendor Email</label> <input type="email" class="form-control"
													placeholder="Enter vendor Email..." name="vendorEmail" required>
													
												<label>vendorAddressline1</label> <input type="text" class="form-control"
													placeholder="Enter vendorAddressline1..." name="vendorAddressline1" maxlength="50" required>
													
												<label>vendorAddressline2</label> <input type="text" class="form-control"
													placeholder="Enter vendorAddressline2..." name="vendorAddressline2" maxlength="50" required>
													
												<!-- <label>Active Status</label> <input type="text" class="form-control"
													name="isAcive"> -->		
												<label>Active Status</label><br>	
													<label>Active
														  <input type="radio" checked="checked" name="isAcive" value="Active">
														  <span class="checkmark"></span>
														</label>
														<label>Inactive
														  <input type="radio" name="isAcive" value="Inactive">
														  <span class="checkmark"></span>
													</label>
											</div>		
																			
									<button type="submit" class="btn btn-block btn-primary btn-sm">ADD</button>
								</form>
						    </c:when>
						    <c:otherwise>
						      <form action="updateVendor" method="post"  modelAttribute="vendor">
									<!-- text input -->
											<div class="form-group">
											<h3>Update Vendor</h3>
											<c:forEach
												items="${listVendor}" var="listVendor">
												
												<input type="hidden" class="form-control"
													 name="vendorId" value="${listVendor.vendorId}">
												
												<label>Vendor Name</label> <input type="text" class="form-control"
													 name="vendorName" value="${listVendor.vendorName}" required>
													
												<label>Vendor Code</label> <input type="text" class="form-control"
													name="vendorCode" value="${listVendor.vendorCode}" readonly>	
													
												<label>Vendor Email</label> <input type="email" class="form-control"
											        name="vendorEmail" value="${listVendor.vendorEmail}" required>
													
												<label>vendorAddressline1</label> <input type="text" class="form-control"
													 name="vendorAddressline1" value="${listVendor.vendorAddressline1}" required>
													
												<label>vendorAddressline2</label> <input type="text" class="form-control"
													name="vendorAddressline2" value="${listVendor.vendorAddressline2}" required>
													
												<%-- <label>Active Status</label> <input type="text" class="form-control"
													name="isAcive" value="${listVendor.isAcive}"> --%>
													
												<c:choose>
						    						<c:when test="${listVendor.isAcive eq 'Active'}">
						    							<label>Active Status</label><br>	
														<label>Active
															  <input type="radio" checked="checked" name="isAcive" value="Active">
															  <span class="checkmark"></span>
															</label>
															<label>Inactive
															  <input type="radio" name="isAcive" value="Inactive">
															  <span class="checkmark"></span>
														</label>
						    						</c:when>
						    						<c:otherwise>
						    							<label>Active Status</label><br>	
														<label>Active
															  <input type="radio"  name="isAcive" value="Active">
															  <span class="checkmark"></span>
															</label>
															<label>Inactive
															  <input type="radio" checked="checked" name="isAcive" value="Inactive">
															  <span class="checkmark"></span>
														</label>
						    						</c:otherwise>
						    					</c:choose>
												
												
											</c:forEach>
											</div>		
																			
									<button type="submit" class="btn btn-block btn-primary btn-sm">Update</button>
								</form>
						      
						      
						    </c:otherwise>
						</c:choose>
				
				</div>
			</div>
			<div class="col-md-3"></div>

			
		
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
					"paging" : true,
					"lengthChange" : false,
					"searching" : false,
					"ordering" : true,
					"info" : true,
					"autoWidth" : false
				});
			});
		</script>
		
		
		<script>
			function updateCategoryStatus(id,name,status) {
				var data = {"categoryMasterId":id,"categoryMasterName":name, "isActive": status} 
				 $.ajax({
					type : "POST",
					url : "/ECOMM/updateCategoryStatus",
					datatype : "application/json",
					contentType: "application/json; charset=utf-8",
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

 		<script
			src="${pageContext.request.contextPath}/resources/validation/formValidation.js"></script>
 
	</div>
</body>
</html>