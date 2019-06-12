
<%@include file="header.jsp" %>

<style>

input[type=text], select, textarea {
  width: 100%;
  padding: 12px;
  border: 1px solid #ccc;
  border-radius: 4px;
  resize: vertical;
}

input[type=password], select, textarea {
  width: 100%;
  padding: 12px;
  border: 1px solid #ccc;
  border-radius: 4px;
  resize: vertical;
}

label {
  padding: 12px 12px 12px 0;
  display: inline-block;
}

input[type=submit] {
  background-color: #4CAF50;
  color: white;
  padding: 12px 20px;
  border: none;
  border-radius: 4px;
  cursor: pointer;
  float: right;
}

input[type=submit]:hover {
  background-color: #45a049;
}

.containers {
  border-radius: 5px;
  background-color: #f2f2f2;
  padding: 20px;
}

.col-25 {
  float: left;
  width: 25%;
  margin-top: 6px;
}

.col-75 {
  float: left;
  width: 75%;
  margin-top: 6px;
}

/* Clear floats after the columns */
.row:after {
  content: "";
  display: table;
  clear: both;
}

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
  font-size: 24px;
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

<div class="containers"><h2 align="center">Products</h2>
							<c:url value="/addprod" var="prod"/>
							<form:form action="${prod}" method="post" modelAttribute="product" enctype="Multipart/form-data">
								<div class="contact-bottom">
									<div class="col-md-12 in-contact">
										<span>prodId</span>
										<form:input type="text" name="name" path="prodId"/>
									</div>
									<div class="col-md-12 in-contact">
										<span>prodName</span>
										<form:input type="text" name="name" path="prodName"/>
									</div>
									<div class="col-md-12 in-contact">
										<span>prodPrice</span>
										<form:input type="text" name="price" path="price"/>
									</div>
									<div class="col-md-12 in-contact">
										<span>prodQty</span>
										<form:input type="text" name="qty" path="quantity"/>
									</div>
									
									<div class="col-md-12 in-contact">
										<span>categoryId
										<form:select name="qty" path="category.catId">
										<option value="NONE" label="-----select category--"/>
										<c:forEach var="cat" items="${categories}">
										<option value="${cat.catId}">${cat.catName}</option>
										</c:forEach>
										</form:select>
										</span>
					
									</div>
									
										<div class="col-md-12 in-contact">
										<span>SupplierId
										<form:select name="qty" path="supplier.suppId">
										<option value="NONE" label="-----select category--"/>
										<c:forEach var="supp" items="${suppliers}">
										<option value="${supp.suppId}">${supp.suppName}</option>
										</c:forEach>
										</form:select>
										</span>
					
									</div>
									
								
									
									<div class="col-md-12 in-contact">
										<span>prodImage
						<form:input type="file" name="img" path="pimg" value="Upload file"/> 
									</span>
									</div>
							
															
								</div>
							
							
								<input type="submit" value="Send">
							</form:form>
						</div>	
							
							<table border="2" align="center" id="customers">
						<tr>
						<th>ProductId</th>
						<th>ProductName</th>
						<th>Price</th>
						<th>Qty</th>
						<th>ProductImage</th>
						<th>Actions</th>
						</tr>
						<c:forEach items="${products}" var="prod">
						<tr>
						<td>${prod.getProdId()}</td>
						<td>${prod.getProdName()}</td>
						<td>${prod.getPrice()}</td>
						<td>${prod.getQuantity()}</td>
						<td><img width="300px" height="300px" src="<c:url value="resources/images/${prod.getProdId()}.jpg"/>"></td>
						<td><a class="green" href="<c:url value="/editProduct/${prod.getProdId()}"/>"><button class="mybutton">Edit</button></a>/<a href="<c:url value="/deleteProduct/${prod.getProdId()}"/>"><button class="mybutton">Delete</button></a></td>
						</tr>
						</c:forEach>
						</table>

</body>
</html>