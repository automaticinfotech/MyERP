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
		<jsp:include page="../admin/header.jsp"></jsp:include>
		<jsp:include page="../admin/sidebar.jsp"></jsp:include>

		<div class="content-wrapper">

			<div class="col-md-3"></div>
			<div class="col-md-6">
				<div class="box-body">
					<c:choose>
						    <c:when test="${empty listCustomerMst}">
						      <form action="insertCustomer" method="post"  modelAttribute="customerMst">
									<!-- text input -->
											<div class="form-group">
												<h3>Create Customer</h3>
												<label>Customer Name</label> <input type="text" class="form-control"
													placeholder="Enter customer Name..." name="customerName" maxlength="20" required>
													
												<label>Customer Code</label> <input type="text" class="form-control"
													placeholder="Enter customer Code..." name="customerCode" value="${customerCode}" readonly>	
													
												<label>Customer Email</label> <input type="email" class="form-control"
													placeholder="Enter customer Email..." name="customerEmail"  required>
													
												<label>CustomerAddressline1</label> <input type="text" class="form-control"
													placeholder="Enter customerAddressline1..." name="customerAddressline1" maxlength="50" required>
													
												<label>CustomerAddressline2</label> <input type="text" class="form-control"
													placeholder="Enter customerAddressline2..." name="customerAddressline2" maxlength="50" required>
													
												<!-- <label>Active Status</label> <input type="text" class="form-control"
													name="isActive"> -->
													
												<label>Active Status</label><br>	
													<label>Active
														  <input type="radio" checked="checked" name="isActive" value="Active">
														  <span class="checkmark"></span>
														</label>
														<label>Inactive
														  <input type="radio" name="isActive" value="inactive">
														  <span class="checkmark"></span>
													</label>			
													
											</div>		
																			
									<button type="submit" class="btn btn-block btn-primary btn-sm">ADD</button>
								</form>
						    </c:when>
						    <c:otherwise>
						      <form action="updateCustomer" method="post"  modelAttribute="customerMst">
									<!-- text input -->
											<div class="form-group">
											<h3>Update Customer</h3>
											<c:forEach
												items="${listCustomerMst}" var="listCustomerMst">
												
												<input type="hidden" class="form-control"
													 name="customerId" value="${listCustomerMst.customerId}">
											
												
												<label>Customer Name</label> <input type="text" class="form-control"
													 name="customerName" value="${listCustomerMst.customerName}" maxlength="20" required>
													
												<label>Customer Code</label> <input type="text" class="form-control"
													name="customerCode" value="${listCustomerMst.customerCode}" readonly>	
													
												<label>Customer Email</label> <input type="email" class="form-control"
											        name="customerEmail" value="${listCustomerMst.customerEmail}" required>
													
												<label>CustomerAddressline1</label> <input type="text" class="form-control"
													 name="customerAddressline1" value="${listCustomerMst.customerAddressline1}" maxlength="50" required>
													
												<label>CustomerAddressline2</label> <input type="text" class="form-control"
													name="customerAddressline2" value="${listCustomerMst.customerAddressline2}" maxlength="50" required>
													
												<%-- <label>Active Status</label> <input type="text" class="form-control"
													name="isActive" value="${listCustomerMst.isActive}"> --%>
													
												<c:choose>
						    						<c:when test="${listCustomerMst.isActive eq 'Active'}">
						    							<label>Active Status</label><br>	
														<label>Active
															  <input type="radio" checked="checked" name="isActive" value="Active">
															  <span class="checkmark"></span>
															</label>
															<label>Inactive
															  <input type="radio" name="isActive" value="inactive">
															  <span class="checkmark"></span>
														</label>
						    						</c:when>
						    						<c:otherwise>
						    							<label>Active Status</label><br>	
														<label>Active
															  <input type="radio"  name="isActive" value="Active">
															  <span class="checkmark"></span>
															</label>
															<label>Inactive
															  <input type="radio" checked="checked" name="isActive" value="inactive">
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

 
 
	</div>
</body>
</html>
