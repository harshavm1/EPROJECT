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
<c:url var="add" value="/addCard"/>
<form:form action="${add}" method="post" modelAttribute="card">

<form:input type="hidden" path="cardId" />

<label>NAME ON CARD</label>
<form:input type="text" placeholder="NAME ON CARD"  path="cardName" required=""/>
</br>

<label>CARD NUMBER</label>
<form:input type="text" placeholder="CARD NUMBER"  path="cardNumber" required=""/>
</br>

<label>EXPIRY DATE</label>
<form:input type="text" placeholder="MM/YY"  path="expiryDate" required=""/>

</br>

<label>CVV</label>
<form:input type="text" placeholder="CVV"  path="cvv" required=""/>
</br>

<input type="submit" value="Submit"/>

</form:form>

</div>

</body>
</html>