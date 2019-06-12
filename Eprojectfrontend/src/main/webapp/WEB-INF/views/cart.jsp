
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
							
												
							<table border="2" align="center" id="customers">
						<tr>
						
						<th>ProdName</th>
						<th>Price</th>
						<th>category</th>
						<th>supplier</th>
						<th>ProdImage</th>
						<th>Action</th>
						</tr>
						<c:forEach items="${allCartItems}" var="cit">
						<tr>
						<td>${cit.getProduct().getProdName()}</td>
						<td>${cit.getProduct().getPrice()}</td>
						
						<td>${cit.getProduct().getCategory().getCatName()}</td>
						<td>${cit.getProduct().getSupplier().getSuppName()}</td>
						
						
						<td><img width="300px" height="300px" src="<c:url value="resources/images/${cit.getProduct().getProdId()}.jpg"/>"></td>
						<td><a href="<c:url value="/removeItem/${cit.getcItemsId()}"/>"><button class="mybutton">Remove</button></a>
						</tr>
						
						</c:forEach>
						<tr>
						<td><strong>Grand Total</strong></td><td><h4>${gTotal}</h4>
						</td>
						</tr>
						
						</table>
						<a href="<c:url value="/checkout"/>" align="center"><button align="center" class="cartt">checkout</button></a>

</body>
</html>