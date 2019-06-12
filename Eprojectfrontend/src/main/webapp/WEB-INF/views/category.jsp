<%@include file="header.jsp" %>
<style>
#customers {
  font-family: "Trebuchet MS", Arial, Helvetica, sans-serif;
  border-collapse: collapse;
  width: 100%;
}

#customers td, #customers th {
  border: 1px solid #ddd;
  padding: 8px;
}

#customers tr:nth-child(even){background-color: #f2f2f2;}

#customers tr:hover {background-color: #ddd;}

#customers th {
  padding-top: 12px;
  padding-bottom: 12px;
  text-align: left;
  background-color: #4CAF50;
  color: white;
}


.mybutton {
  padding: 15px 25px;
  font-size: 14px;
  text-align: center;
  cursor: pointer;
  outline: none;
  color: #fff;
  background-color: #4CAF50;
  border: none;
  border-radius: 15px;
  box-shadow: 0 9px #999;
}

.mybutton:hover {background-color: #3e8e41}

.mybutton:active {
  background-color: #3e8e41;
  box-shadow: 0 5px #666;
  transform: translateY(4px);
}
</style>
	<!-- //navigation -->

	<!-- banner-2 -->
	<div class="page-head_electronics_info_storesl">

	</div>
	<!-- //banner-2 -->
	<!-- page -->
	
	<!-- //page -->

	<!-- contact -->
	<!-- <div class="contact py-sm-5 py-4">
		<div class="container py-xl-4 py-lg-2">
			tittle heading
			<h3 class="tittle-storesl text-center mb-lg-5 mb-sm-4 mb-3">
				<span>C</span>ontact
				<span>U</span>s
			</h3>
			//tittle heading
			<div class="row contact-grids electronics-1 mb-5">
				<div class="col-sm-4 contact-grid electronicsinfo-6 mt-sm-0 mt-2">
					<div class="contact-grid1 text-center">
						<div class="con-ic">
							<i class="fas fa-map-marker-alt rounded-circle"></i>
						</div>
						<h4 class="font-weight-bold mt-sm-4 mt-3 mb-3">Address</h4>
						<p>567PO BOX Bengaluru
							<label>India.</label>
						</p>
					</div>
				</div>
				<div class="col-sm-4 contact-grid electronicsinfo-6 my-sm-0 my-4">
					<div class="contact-grid1 text-center">
						<div class="con-ic">
							<i class="fas fa-phone rounded-circle"></i>
						</div>
						<h4 class="font-weight-bold mt-sm-4 mt-3 mb-3">Call Us</h4>
						<p>8892954626
							<label>8660815118</label>
						</p>
					</div>
				</div>
				<div class="col-sm-4 contact-grid electronicsinfo-6">
					<div class="contact-grid1 text-center">
						<div class="con-ic">
							<i class="fas fa-envelope-open rounded-circle"></i>
						</div>
						<h4 class="font-weight-bold mt-sm-4 mt-3 mb-3">Email</h4>
						<p>
							<a href="mailto:harshav53@gmail.com">harshav53@gmail.com</a>
							
						</p>
					</div>
				</div>
			</div> -->
			<!-- form -->
			<c:url value="/addcat" var="cat"/>
			<form:form action="${cat}" method="post" modelAttribute="category">
				<div class="contact-grids1 storeselectronics-6">
					<div class="row">
						<div class="col-md-6 col-sm-6 contact-form1 form-group">
							<label class="col-form-label">CategoryId</label>
							<form:input type="text" class="form-control" name="id" placeholder="" path="catId" required="required"/>
						</div>
						<div class="col-md-6 col-sm-6 contact-form1 form-group">
							<label class="col-form-label">CategoryName</label>
							<form:input type="text" class="form-control" name="name" placeholder="" path="catName" required="required"/>
						</div>
					</div>
					
					<div class="contact-form">
						<input type="submit" value="Submit">
						<input type="reset" value="Cancel">
					
					</div>
				</div>
			</form:form>
			<!-- //form -->
		</div>
	</div>
	<!-- //contact -->
	
	
	<div class="me" id="customers">
	<table border=2 align="center">
		<tr><th>categoryid</th>
		<th>categoryname</th>
		<th>Action</th>
		</tr>
		<c:forEach items="${categories}" var="cats">
		<tr>
		<td>${cats.getCatId()}</td>
		<td>${cats.getCatName()}</td>
		<td><a href="<c:url value="/editCategory/${cats.getCatId()}"/>"><button class="mybutton">Edit</button></a>/<a href="<c:url value="/deleteCategory/${cats.getCatId()}"/>"><button class="mybutton">Delete</button></a></td>
		</tr>
		</c:forEach>
	</table>
</div>
	<!-- map -->
	
<%-- <%@ include file="footer.jsp" %> --%>