<aside class="main-sidebar">
	<!-- sidebar: style can be found in sidebar.less -->
	<section class="sidebar">
		<!-- Sidebar user panel -->
		<div class="user-panel">
			<div class="pull-left image">
				<img
					src="${pageContext.request.contextPath}/resources/admin/dist/img/user2-160x160.jpg"
					class="img-circle" alt="User Image">
			</div>
			<div class="pull-left info">
				<p>Admin</p>
				<a href="#"><i class="fa fa-circle text-success"></i> Online</a>
			</div>
		</div>
		<!-- search form -->
		<form action="#" method="get" class="sidebar-form">
			<div class="input-group">
				<input type="text" name="q" class="form-control"
					placeholder="Search..."> <span class="input-group-btn">
					<button type="submit" name="search" id="search-btn"
						class="btn btn-flat">
						<i class="fa fa-search"></i>
					</button>
				</span>
			</div>
		</form>
		<!-- /.search form -->
		<!-- sidebar menu: : style can be found in sidebar.less -->
		<ul class="sidebar-menu">
			<li class="header">MAIN NAVIGATION</li>
			<li class="treeview"><a href="#"> <i class="fa fa-dashboard"></i>
					<span>Vendor Mgmt</span> <span class="pull-right-container">
						<i class="fa fa-angle-left pull-right"></i>
				</span>
			</a>
				<ul class="treeview-menu">
					<li class="active"><a href="/MyERP/listOfVendor"><i
							class="fa fa-circle-o"></i>Manage Vendor</a></li>
				</ul></li>
		</ul>
		
		<ul class="sidebar-menu">
			<li class="treeview"><a href="#"> <i class="fa fa-dashboard"></i>
					<span>Material Mgmt</span> <span class="pull-right-container">
						<i class="fa fa-angle-left pull-right"></i>
				</span>
			</a>
				<ul class="treeview-menu">
					<li class="active"><a href="/MyERP/listOfMaterial"><i
							class="fa fa-circle-o"></i>Manage Material</a></li>
			   </ul></li>
		</ul>
		
		<ul class="sidebar-menu">
			<li class="treeview"><a href="#"> <i class="fa fa-dashboard"></i>
					<span>Customer Mgmt</span> <span class="pull-right-container">
						<i class="fa fa-angle-left pull-right"></i>
				</span>
			</a>
				<ul class="treeview-menu">
					<li class="active"><a href="/MyERP/listOfCustomer"><i
							class="fa fa-circle-o"></i>Manage Customer</a></li>
			   </ul></li>
		</ul>
		
		<ul class="sidebar-menu">
			<li class="treeview"><a href="#"> <i class="fa fa-dashboard"></i>
					<span>Administrator</span> <span class="pull-right-container">
						<i class="fa fa-angle-left pull-right"></i>
				</span>
			</a>
				<ul class="treeview-menu">
					<li class="active"><a href="/MyERP/menu"><i
							class="fa fa-circle-o"></i>Menu Management</a></li>
					<li class="active"><a href="/MyERP/user"><i
							class="fa fa-circle-o"></i>User Management</a></li>
			   </ul></li>
		</ul>
		
		<ul class="sidebar-menu">
			<li class="treeview"><a href="#"> <i class="fa fa-dashboard"></i>
					<span>Purchase Orders Mgmt</span> <span class="pull-right-container">
						<i class="fa fa-angle-left pull-right"></i>
				</span>
			</a>
				<ul class="treeview-menu">
					<li class="active"><a href="/MyERP/allPurchaseOrders"><i
							class="fa fa-circle-o"></i>All Purchase Orders</a></li>
					
			   </ul></li>
		</ul>
		
		
		
	</section>
	<!-- /.sidebar -->
</aside>