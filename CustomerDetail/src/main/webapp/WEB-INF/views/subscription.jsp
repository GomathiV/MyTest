<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Subscription Details</title>

	<link href="<c:url value='/static/css/bootstrap.css' />" rel="stylesheet"></link>
	<link href="<c:url value='/static/css/custom.css' />" rel="stylesheet"></link>
</head>
   <style>
div.container {
    width: 100%;
    border: 1px solid gray;
}

header, footer {
    padding: 1em;
    color: white;
    background-color: maroon;
    clear: left;
    text-align: center;
}

nav {
    float: left;
    max-width: 160px;
    margin: 0;
    padding: 1em;
}

nav ul {
    list-style-type: none;
    padding: 0;
}
   
nav ul a {
    text-decoration: none;
}

article {
    margin-left: 170px;
    border-left: 1px solid gray;
    padding: 1em;
    overflow: hidden;
}
</style>


<body>



<div class="container">


<header>
   <h1>Subscription Detail</h1>
</header>

<nav>
  <ul>
    <li><a href="/CustomerDetail/customer">Customer</a></li>
    <li><a href="/CustomerDetail/product">Product</a></li>
    <li><a href="/CustomerDetail/vehicle">Vehicle</a></li>
    <li><a href="/CustomerDetail/vehicle/subscription">Subscription</a></li>   
    <li><a href="/CustomerDetail/vehicle/viewsubscriptiondetail">View Subscription</a></li>
    
  </ul>
</nav>

<article>


 	<div class="form-container">
 	
 	<h1>Enrollment Form</h1>
 	
	<form:form method="POST" modelAttribute="subscription" class="form-horizontal">
	
		<div class="row">
			<div class="form-group col-md-12">
				<label class="col-md-3 control-lable" for="subscriptionId">Subscription ID</label>
				<div class="col-md-7">
					<form:input type="text" path="subscriptionId" id="subscriptionId" class="form-control input-sm"/>
					<div class="has-error">
						<form:errors path="subscriptionId" class="help-inline"/>
					</div>
				</div>
			</div>
		</div>
		
		<div class="row">
			<div class="form-group col-md-12">
				<label class="col-md-3 control-lable" for="vehicle">VIN</label>
				<div class="col-md-7">
					<form:input type="text" path="vehicle.vin" id="vehicle.vin" class="form-control input-sm"/>
					<div class="has-error">
						<form:errors path="vehicle.vin" class="help-inline"/>
					</div>
				</div>
			</div>
		</div>
		
		<div class="row">
			<div class="form-group col-md-12">
				<label class="col-md-3 control-lable" for="customer">Customer Id</label>
				<div class="col-md-7">
					<form:input type="text" path="customer.internalCustomerId" id="customer.internalCustomerId" class="form-control input-sm"/>
					<div class="has-error">
						<form:errors path="customer.internalCustomerId" class="help-inline"/>
					</div>
				</div>
			</div>
		</div>
		
		<div class="row">
			<div class="form-group col-md-12">
				<label class="col-md-3 control-lable" for="product">Product Id</label>
				<div class="col-md-7">
					<form:input type="text" path="product.internalProductId" id="product.internalProductId" class="form-control input-sm"/>
					<div class="has-error">
						<form:errors path="product.internalProductId" class="help-inline"/>
					</div>
				</div>
			</div>
		</div>
		
		
		<div class="row">
			<div class="form-actions floatRight">
				<input type="submit" value="Register" class="btn btn-primary btn-sm">
			</div>
		</div>
	</form:form>
	</div>
	
	
</article>

<footer></footer>

</div>


</body>
</html>