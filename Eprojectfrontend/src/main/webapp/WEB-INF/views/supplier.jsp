<%@include file="header.jsp" %>

<style>

input[type=text], select, textarea {
  width: 100%;
  padding: 12px;
  border: 1px solid #ccc;
  border-radius: 4px;
  resize: vertical;
}
input[type=number], select, textarea {
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
<div class="containers"><h2 align="center">Suppliers</h2>
<c:url value="/addsupp" var="supp"/>
							<form:form action="${supp}" method="post" modelAttribute="supplier">
								<div class="contact-bottom">
									<div class="col-md-12 in-contact">
										<span>suppId</span>
										<form:input type="text" name="suppId" path="suppId"/>
									</div>
									
									
									<div class="col-md-12 in-contact">
										<span>suppName</span>
										<form:input type="text" name="suppName" path="suppName"/>
									</div>
									
									
									<div class="col-md-12 in-contact">
										<span>email</span>
										<form:input type="text" name="email" path="email"/>
									</div>
									
									
									<div class="col-md-12 in-contact">
										<span>password</span>
										<form:input type="password" name="password" path="password"/>
									</div>
									
									
									<div class="col-md-12 in-contact">
										<span>phoneNum</span>
										<form:input type="number" name="phoneNum" path="phoneNum"/>
									</div>
									
									
									<div class="col-md-12 in-contact">
										<span>address</span>
										<form:input type="text" name="address" path="address"/>
									</div>
									
									
							
															
								</div>
							
							
								<input type="submit" value="Send" />
							</form:form>
	</div>						
							
							<table id="customers">
						<tr>
						<th>suppId</th>
						<th>suppName</th>
						<th>email</th>
						<th>password</th>
						<th>phoneNum</th>
						<th>address</th>
						<th>Action</th>
						</tr>
						<c:forEach items="${suppliers}" var="supp">
						<tr>
						<td>${supp.getSuppId()}</td>
						<td>${supp.getSuppName()}</td>
						<td>${supp.getEmail()}</td>
						<td>${supp.getPassword()}</td>
						<td>${supp.getPhoneNum()}</td>
						<td>${supp.getAddress()}</td>
						<td><a href="<c:url value="/editSupplier/${supp.getSuppId()}"/>"><button class="mybutton">Edit</button></a>/<a href="<c:url value="/deleteSupplier/${supp.getSuppId()}"/>"><button class="mybutton">Delete</button></a></td>
						</tr>
						</c:forEach>
						</table>
					</body>
									</html>