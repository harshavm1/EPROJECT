<%@include file="header.jsp" %>
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
								<h1 align="center">User login</h1>
							<c:url value="/j_spring_security_check" var="a"/>
							<form:form action="${a}" method="post" modelAttribute="login">
									
									<div class="col-md-12 in-contact">
										<span>email</span>
										<input type="text" name="j_username" placeholder="enter username">
									</div>
									<div class="col-md-12 in-contact">
										<span>password</span>
										<input type="password" name="j_password" placeholder="enter password">
									</div>

									
							
								<input type="submit" value="Send">
							</form:form>
			</div>				

	</body>
	</html>