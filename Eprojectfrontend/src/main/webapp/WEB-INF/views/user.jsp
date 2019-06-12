<%@include file="header.jsp"%>

<style>
* {
  box-sizing: border-box;
}

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
</style>	
<div class="containers">
								<h1 align="center">User Registration</h1>
							<c:url value="/adduser" var="add"/>
							<form:form action="${add}" method="post" modelAttribute="user">
									<div class="col-md-12 in-contact">
										<span>userId</span>
										<form:input type="text" name="userId" path="userId" />
									</div>
									<div class="col-md-12 in-contact">
										<span>userName</span>
										<form:input type="text" name="name" path="userName" placeholder="username"/>
									</div>
									<div class="col-md-12 in-contact">
										<span>email</span>
										<form:input type="text" name="email" path="email" placeholder="email"/>
									</div>
									<div class="col-md-12 in-contact">
										<span>password</span>
										<form:input type="password" name="password" path="password" placeholder="password"/>
									</div>
									<div class="col-md-12 in-contact">
										<span>phoneNo</span>
										<form:input type="text" name="phoneNo" path="phoneNo" placeholder="phonenumber"/>
									</div>
									<div class="col-md-12 in-contact">
										<span>address</span>
										<form:input type="text" name="qty" path="address" placeholder="address"/>
									</div>
									
							
								<input type="submit" value="Send">
							</form:form>
					</div>		

	</body>
	</html>