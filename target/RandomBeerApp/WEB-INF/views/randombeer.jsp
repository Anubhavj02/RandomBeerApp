<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html>
<html lang="en">

<head>

<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<title>Full - Start Bootstrap Template</title>

<link href="<c:url value='/assets/css/bootstrap.min.css' />"
	rel="stylesheet">
<link href="<c:url value='/assets/css/style.css' />" rel="stylesheet">

<style type="text/css">
body {
	background: url('<c:url value='/assets/images/beer_background.jpg' />') no-repeat center center
		fixed;
	-webkit-background-size: cover;
	-moz-background-size: cover;
	background-size: cover;
	-o-background-size: cover;
}
</style>

</head>

<body ng-app="beerApp" ng-controller="RandomBeerController as randomBeerCtrl">

	<!-- Navigation -->
	
	<jsp:include page="header.jsp" />

	<!-- Page Content -->
	
	<div class="container">
    <!-- 2 columns card -->
    <div class="card header-card">
        <div class="card-block">
            <div class="row">
                <div class="col-lg-8 tags p-b-2">
                <img class="logo" src="<c:url value='/assets/images/logo.png' />"/>
                </div>
                <div class="col-lg-2 offset-lg-1 v-centre">
                    <button type="button" ng-click="randomBeerCtrl.fetchRandomBeer()" class="btn btn-primary btn-lg">Show Another Beer</button>
                </div>
            </div>
        </div>
        <!--/card-block-->
    </div>
    <!-- /2 columns card -->
    <!-- Content Row -->
      <div class="row">
       <div class="col-md-5 mb-4">
          <div class="card h-100">
            <div class="card-body">
              <img ng-src="{{randomBeerCtrl.beer.imageUrl}}" style="width: 400px; height: 400px"/>
            </div>
          </div>
        </div>
        <!-- /.col-md-4 -->
        <div class="col-md-7 mb-4">
        <div class="row">
       <div class="col-md-12 mb-4 first-col">
       <div class="card h-100">
            <div class="card-body">
              <h2>Name: <span ng-bind="randomBeerCtrl.beer.name"></span></h2>
            </div>
          </div>
       </div>
       </div>
       <div class="row">
       <div class="col-md-12 mb-4 second-col">
       <div class="card h-100 min-card-height">
            <div class="card-body">
              <b>Alcohol Level: </b> <span ng-bind="randomBeerCtrl.beer.abv"></span> %<br>
              <b>Brewery Location: </b><span ng-bind="randomBeerCtrl.beer.breweryLocation"></span><br>
              <b>Description:</b>
              <div style="overflow: auto; max-height: 200px">
              	<span ng-bind="randomBeerCtrl.beer.description"></span>
              </div>
            </div>
          </div>
       </div>
       </div>
        </div>
        <!-- /.col-md-4 -->

      </div>
</div>

	<!-- Bootstrap core JavaScript -->
	<script src="<c:url value='/assets/js/jquery.min.js' />">"></script>
	<script src="<c:url value='/assets/js/bootstrap.bundle.min.js' />"></script>
	<script src="<c:url value='/assets/js/angular.min.js' />"></script>
    <script src="<c:url value='/assets/js/angular-resource.min.js' />"></script>
	<script src="<c:url value='/assets/js/app.js' />"></script>

</body>

</html>