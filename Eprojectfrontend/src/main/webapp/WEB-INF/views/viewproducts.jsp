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


.buy {
  background-color: #4CAF50; /* Green */
  border: none;
  color: white;
  padding: 15px 32px;
  text-align: center;
  text-decoration: none;
  display: inline-block;
  font-size: 16px;
  margin: 4px 2px;
  cursor: pointer;
}

.cartt {
  background-color: blue; /* Green */
  border: none;
  color: white;
  padding: 15px 32px;
  text-align: center;
  text-decoration: none;
  display: inline-block;
  font-size: 16px;
  margin: 4px 2px;
  cursor: pointer;
}
</style>

<%@include file="header.jsp" %>
							<c:url value="/addprod" var="prod"/>
							
							<h2 align="center" color="blue">Available Products</h2>
							
							<table border="2" align="center" id="customers">
						<tr>
						
						<th>ProdName</th>
						<th>Price</th>
						<th>ProdImage</th>
						<th>Actions</th>
						</tr>
						<c:forEach items="${product}" var="prod">
						<tr>
						<td>${prod.getProdName()}</td>
						<td>${prod.getPrice()}</td>
						
						<td><img width="300px" height="300px" src="<c:url value="resources/images/${prod.getProdId()}.jpg"/>"></td>
						<td><a href="<c:url value="/addTocart/${prod.getProdId()}"/>"><button class="buy">Add TO Cart</button></a>/<a href="<c:url value="/addTocart/${prod.getProdId()}"/>"><button class="cartt">Buy</button></a></td>
						</tr>
						</c:forEach>
						</table>

</body>
</html>