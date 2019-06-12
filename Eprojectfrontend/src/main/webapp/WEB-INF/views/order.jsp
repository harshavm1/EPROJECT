<%@include file="header.jsp"%>
		<div id="page-wrapper">
		<div class="row">
		<div class="col-xs-1">
		</div>
		<div id="move" class="col-xs-10">
		<br><br><br><br>
		<center><div><h1><font color="#1e1d5a" size="6">
		&nbsp;<i class="fa fa-opencart" aria-hidden="true"></i> YOUR ORDERS</font></h1></div></center>
		   <div class="table-responsive">
    <table class="table product-table">
        <!--Table head-->
        <thead>
            <tr>
                <th><img width="160px" height="100px" src="<c:url value="resources/images/m4.jpg"/>"></th>
                <th>Product</th>
                <th>Description</th>
                <th>Price</th>
                <th></th>
            </tr>
        </thead>

        <tbody>
		<!--First row-->
            <tr>
                <th scope="row">
                    <img src="<c:url value="resources/images/m4.jpg"/>" style="width:100px" class="img-fluid">
                </th>
                <td>
                    <h5><strong>name</strong></h5>
                </td>
                <td>descriptn</td>
                <td><i class="fa fa-inr" aria-hidden="true"></i> 650</td>
<!--                 <td> -->
<!--                     <button class="button" style="width:100px"" data-toggle="tooltip" data-placement="top" title="track item">Track Order -->
<!--                     </button> -->
<!--                 </td> -->
            </tr>
            <!--/First row-->

        </tbody>
        <!--/Table body-->
    </table>
</div>


</html>