    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Product Details</title>

	<link href="<c:url value='/static/css/bootstrap.css' />" rel="stylesheet"></link>
	<link href="<c:url value='/static/css/custom.css' />" rel="stylesheet"></link>
</head>  <style>
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
   <h1>Vehicle Detail</h1>
</header>

<nav>
  <ul>
    <li><a href="/CustomerDetail/customer/user">Customer</a></li>
    <li><a href="/CustomerDetail/customer/product">Product</a></li>
    <li><a href="/CustomerDetail/customer/vehicle">Vehicle</a></li>
    <li><a href="/CustomerDetail/customer/subscription">Subscription</a></li>   
    <li><a href="/CustomerDetail/customer/viewsubscriptiondetail">View Subscription</a></li>
    
  </ul>
</nav>

<article>

 	<div class="form-container">
 	
 	<h1></h1>
 	<b>
 	<p align="center" > Data is not found. Please try with another value.</p>
 	</b>
 	
	</div>
	
	
</article>

<footer></footer>

</div>


</body>
</html>