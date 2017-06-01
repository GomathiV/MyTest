    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Product Details</title>

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

<nav>
  <ul>
    <li><a href="/CustomerDetail/customer/user">User</a></li>
    <li><a href="/CustomerDetail/customer/product">Product</a></li>
    <li><a href="/CustomerDetail/customer/subscription">User Products Subscription</a></li>
  </ul>
</nav>

<article>

 	<div class="form-container">
 	
 	<h1>Enrollment Form</h1>
 	
	<form:form method="POST" modelAttribute="product" class="form-horizontal">
	
		<div class="row">
			<div class="form-group col-md-12">
				<label class="col-md-3 control-lable" for="internalProductId">Product ID</label>
				<div class="col-md-7">
					<form:input type="text" path="internalProductId" id="internalProductId" class="form-control input-sm"/>
					<div class="has-error">
						<form:errors path="internalProductId" class="help-inline"/>
					</div>
				</div>
			</div>
		</div>
		

		<div class="row">
			<div class="form-group col-md-12">
				<label class="col-md-3 control-lable" for="name">Product Name</label>
				<div class="col-md-7">
					<form:input type="text" path="name" id="name" class="form-control input-sm"/>
					<div class="has-error">
						<form:errors path="name" class="help-inline"/>
					</div>
				</div>
			</div>
		</div>

		<div class="row">
			<div class="form-group col-md-12">
				<label class="col-md-3 control-lable" for="region">Region</label>
				<div class="col-md-7">
					<form:input type="text" path="region" id="region" class="form-control input-sm"/>
					<div class="has-error">
						<form:errors path="region" class="help-inline"/>
					</div>
				</div>
			</div>
		</div>

		<div class="row">
			<div class="form-group col-md-12">
				<label class="col-md-3 control-lable" for="autoRenew">AutoRenew</label>
				<div class="col-md-7">
					<form:input type="text" path="autoRenew" id="autoRenew" class="form-control input-sm"/>
					<div class="has-error">
						<form:errors path="autoRenew" class="help-inline"/>
					</div>
				</div>
			</div>
		</div>
		
		<div class="row">
			<div class="form-group col-md-12">
				<label class="col-md-3 control-lable" for="price">Price</label>
				<div class="col-md-7">
					<form:input type="text" path="price" id="price" class="form-control input-sm"/>
					<div class="has-error">
						<form:errors path="price" class="help-inline"/>
					</div>
				</div>
			</div>
		</div>

		<div class="row">
			<div class="form-group col-md-12">
				<label class="col-md-3 control-lable" for="curreny">Currency</label>
				<div class="col-md-7">
					<form:input type="text" path="curreny" id="curreny" class="form-control input-sm"/>
					<div class="has-error">
						<form:errors path="curreny" class="help-inline"/>
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