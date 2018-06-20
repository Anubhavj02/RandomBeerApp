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

<title>Manage Beer</title>

<link rel="stylesheet"
	href="https://fonts.googleapis.com/css?family=Roboto|Varela+Round">
<link rel="stylesheet"
	href="https://fonts.googleapis.com/icon?family=Material+Icons">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">

<link href="<c:url value='/assets/css/bootstrap.min.css' />"
	rel="stylesheet">
<link href="<c:url value='/assets/css/style.css' />" rel="stylesheet">

<style type="text/css">
body {
	background: url('<c:url value='/assets/images/beer_background.jpg' />')
		no-repeat center center fixed;
	-webkit-background-size: cover;
	-moz-background-size: cover;
	background-size: cover;
	-o-background-size: cover;
}
</style>


</head>

<body ng-app="beerApp" ng-controller="BeerController as beerCtrl">

	<!-- Navigation Start -->
	
	<jsp:include page="header.jsp" />
	
	<!-- Navigation End -->

	<!-- Page Content Start -->
	<div class="container">
		<div class="table-wrapper">
			<div class="table-title">
				<div class="row">
					<div class="col-sm-6">
						<h2>
							Manage <b>Beers</b>
						</h2>
					</div>
					<div class="col-sm-6">
						<a href="#addBeerModal"
							ng-click="$event.preventDefault();beerCtrl.reset();"
							class="btn btn-success" data-toggle="modal"><i
							class="material-icons">&#xE147;</i> <span>Add New Beer</span></a>

					</div>
				</div>
			</div>
			<table class="table table-striped table-hover">
				<thead>
					<tr>
						<th>Image</th>
						<th>Name</th>
						<th>Description</th>
						<th>Brewery Location</th>
						<th>Alcohol Percentage</th>
						<th>Action</th>
					</tr>
				</thead>
				<tbody>
					<tr ng-repeat="row in beerCtrl.beers">
						<td><img ng-src="{{row.imageUrl}}"
							style="width: 100px; height: 100px" /></td>
						<td><span ng-bind="row.name"></span></td>
						<td><div style="overflow: auto; max-height: 100px">
								<span ng-bind="row.description"></span>
							</div></td>
						<td><span ng-bind="row.breweryLocation"></span></td>
						<td><span ng-bind="row.abv"></span></td>
						<td><a href="#editBeerModal"
							ng-click="$event.preventDefault();beerCtrl.editBeer(row.id);"
							class="edit" data-toggle="modal"><i class="material-icons"
								data-toggle="tooltip" title="Edit">&#xE254;</i></a> <a href="#"
							ng-click="$event.preventDefault();beerCtrl.deleteBeer(row.id)"
							class="delete"><i class="material-icons"
								data-toggle="tooltip" title="Delete">&#xE872;</i></a></td>
					</tr>

				</tbody>
			</table>
		</div>
	</div>
	<!-- Add Modal HTML -->
	<div id="addBeerModal" class="modal fade">
		<div class="modal-dialog">
			<div class="modal-content">
				<form name="beerForm" method="POST">
					<div class="modal-header">
						<h4 class="modal-title">Add Beer</h4>
						<button type="button" class="close" data-dismiss="modal"
							aria-hidden="true">&times;</button>
					</div>
					<div class="modal-body">
						<div class="form-group">
							<label>Beer Name</label> <input name="name"
								ng-model="beerCtrl.beer.name" type="text" class="form-control"
								required>
						</div>
						<div class="form-group">
							<label>Alcohol Percentage</label> <input name="abv"
								ng-model="beerCtrl.beer.abv" type="number" min="0" max="100"
								step="0.0001" class="form-control" required>
						</div>
						<div class="form-group">
							<label>Beer Description</label>
							<textarea maxlength="2000" name="description" ng-model="beerCtrl.beer.description"
								class="form-control" required></textarea>
						</div>
						<div class="form-group">
							<label>Brewery Location</label>
							<textarea maxlength="255" name="breweryLocation"
								ng-model="beerCtrl.beer.breweryLocation" class="form-control"
								required></textarea>
						</div>
						<div class="form-group">
							<label>Upload Image</label> <input maxlength="200 name="imageUrl"
								ng-model="beerCtrl.beer.imageUrl" class="form-control" required>
						</div>
					</div>
					<div class="modal-footer">
						<input type="button" class="btn btn-default" data-dismiss="modal"
							value="Cancel"> <input type="submit"
							ng-click="beerCtrl.addBeer()" class="btn btn-success" value="Add">
					</div>
				</form>
			</div>
		</div>
	</div>
	<!-- Edit Modal HTML -->
	<div id="editBeerModal" class="modal fade">
		<div class="modal-dialog">
			<div class="modal-content">
				<form name="beerForm" method="POST">
					<div class="modal-header">
						<h4 class="modal-title">Add Beer</h4>
						<button type="button" class="close" data-dismiss="modal"
							aria-hidden="true">&times;</button>
					</div>
					<div class="modal-body">
						<div class="form-group">
							<label>Beer Name</label> <input name="name"
								ng-model="beerCtrl.beer.name" type="text" class="form-control"
								required>
						</div>
						<div class="form-group">
							<label>Alcohol Percentage</label> <input name="abv"
								ng-model="beerCtrl.beer.abv" type="number" min="0" max="100"
								step="0.0001" class="form-control" required>
						</div>
						<div class="form-group">
							<label>Beer Description</label>
							<textarea maxlength="2000" name="description" ng-model="beerCtrl.beer.description"
								class="form-control" required></textarea>
						</div>
						<div class="form-group">
							<label>Brewery Location</label>
							<textarea maxlength="255" name="breweryLocation"
								ng-model="beerCtrl.beer.breweryLocation" class="form-control"
								required></textarea>
						</div>
						<div class="form-group">
							<label>Upload Image</label> <input maxlength="200" name="imageUrl"
								ng-model="beerCtrl.beer.imageUrl" class="form-control" required>
						</div>
					</div>
					<div class="modal-footer">
						<input type="button" class="btn btn-default" data-dismiss="modal"
							value="Cancel"> <input type="submit"
							ng-click="beerCtrl.updateBeerDetail()" class="btn btn-success"
							value="Update">
					</div>
				</form>
			</div>
		</div>
	</div>
	
	<!-- Page Content End -->


	<!-- Bootstrap and core JavaScript -->
	<script src="<c:url value='/assets/js/jquery.min.js' />">"></script>
	<script src="<c:url value='/assets/js/bootstrap.bundle.min.js' />"></script>
	
	<!-- Angular js files -->
	<script src="<c:url value='/assets/js/angular.min.js' />"></script>
	<script src="<c:url value='/assets/js/angular-resource.min.js' />"></script>
	<script src="<c:url value='/assets/js/app.js' />"></script>

</body>

</html>
