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
						    <c:when test="${empty listMaterial}">
						      <form action="insertMaterial" method="post"  modelAttribute="materialMst">
									<!-- text input -->
											<div class="form-group">
												<label>Material Name</label> <input type="text" class="form-control"
													placeholder="Enter Material Name..." name="materialName">
													
												<label>Material Code</label> <input type="text" class="form-control"
													name="materialCode" value="${materialCode}" readonly>	
													
												<label>Material Description</label> <input type="text" class="form-control"
													placeholder="Enter Material Description..." name="materialDesc">
													
												<label>Unite of Measurement</label> <input type="text" class="form-control"
													placeholder="Enter UOM" name="UOM">
													
												<label>is Finish Good</label> <input type="text" class="form-control"
													placeholder="Enter Finish Good status..." name="isFG">
													
												<label>Active Status</label> <input type="text" class="form-control"
													placeholder="Enter Active..." name="isActive">
													
											</div>		
																			
									<button type="submit" class="btn btn-block btn-primary btn-sm">ADD</button>
								</form>
						    </c:when>
						    <c:otherwise>
						      <form action="updateMaterial" method="post"  modelAttribute="materialMst">
									<!-- text input -->
											<div class="form-group">
											
											<c:forEach
												items="${listMaterial}" var="listMaterial">
												
												<input type="hidden" class="form-control"
													 name="materialId" value="${listMaterial.materialId}">
												
												<label>Material Name</label> <input type="text" class="form-control"
													 name="materialName" value="${listMaterial.materialName}">
													
												<label>Material Code</label> <input type="text" class="form-control"
													name="materialCode" value="${listMaterial.materialCode}" readonly>	
													
												<label>Material Description</label> <input type="text" class="form-control"
											        name="materialDesc" value="${listMaterial.materialDesc}">
													
												<label>Unite of Measurement</label> <input type="text" class="form-control"
													 name="UOM" value="${listMaterial.UOM}">
													
												<label>is Finish Good</label> <input type="text" class="form-control"
													name="isFG" value="${listMaterial.isFG}">
													
												<label>Active Status</label> <input type="text" class="form-control"
													name="isActive" value="${listMaterial.isActive}">	
												
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