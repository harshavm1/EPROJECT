<%@include file="header.jsp" %>






			<div class="checkout-left">
				<div class="address_form_electronics mt-sm-5 mt-4">
					<h4 class="mb-sm-4 mb-3">Add a new Details</h4>
					   <c:url var="add" value="/placeorder"/>
                        <form:form method="post" action="${add}" class="creditly-card-form electronicsinfo_form" modelAttribute="shipping">
					
						<div class="creditly-wrapper electronics-stroe, stores_electronicsits_wrapper">
							<div class="information-wrapper">
								<div class="first-row">
									<div class="controls form-group">
										<input class="billing-address-name form-control" type="text" path="shipName" name="name" placeholder="Full Name" required="">
									</div>
									<div class="stores_electronicsits_card_number_grids">
										<div class="stores_electronicsits_card_number_grid_left form-group">
											<div class="controls">
												<input type="text" class="form-control" placeholder="HouseNo" path="shipCity" name="number" required="">
											</div>
										</div>
										<div class="stores_electronicsits_card_number_grid_right form-group">
											<div class="controls">
												<input type="text" class="form-control" placeholder="shipState" path="shipState" name="landmark" required="">
											</div>
										</div>
										<div class="stores_electronicsits_card_number_grid_right form-group">
											<div class="controls">
												<input type="text" class="form-control" placeholder="shipPhone" path="shipPhone" name="landmark" required="">
											</div>
										</div>
									</div>
									<div class="controls form-group">
										<input type="text" class="form-control" placeholder="Town/City" name="city" required="">
									</div>
									<div class="controls form-group">
										<select class="option-storesls">
											<option>Select Address type</option>
											<option>Office</option>
											<option>Home</option>
											<option>Commercial</option>

										</select>
								
									</div>
								</div>
						
								<button class="submit check_out btn">Delivery to this Address</button>
						
							</div>
						
						</div>
						<div class="mb-sm-4 mb-3" align="center" style="margin-top: -40px;">
					Cash On Delievery<input type="radio" value="cash" id="payment-method" name="payment-method"/>
					Card<input type="radio" value="card" id="payment-method" name="payment-method"/>
						</div>
					</form:form>
					
					
					<!-- <div class="checkout-right-basket">
						<a href="payment.html">Make a Payment
							<span class="far fa-hand-point-right"></span>
						</a>
					</div> -->
				</div>
			</div>
		</div>
	</div>
	
</body>

</html>