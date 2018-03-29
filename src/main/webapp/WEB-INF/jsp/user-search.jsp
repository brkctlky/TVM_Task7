<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="../layout/taglib.jsp"%>

<form:form commandName="userFind" cssClass="form-horizontal">

	<c:if test="${param.success eq true}">
		<div class="alert alert-success">Searching Successfull! You Can
			See the Details of User Below!</div>
	</c:if>

	<c:if test="${param.success eq false}">
		<div class="alert alert-danger">Searching Unsuccessfull! Cannot
			Find User to Display!</div>
	</c:if>

	<div class="form-group">
		<label for="name" class="col-sm-2 control-label">User Name:</label>
		<div class="col-sm-10">
			<form:input path="name" cssClass="form-control" required="required" />
			<form:errors path="name" />
		</div>
	</div>
	<div class="form-group">
		<div class="col-sm-12">
			<input type="submit" value="Search" class="center btn btn-lg btn-primary" style="float: right;" />
		</div>
	</div>

	<c:if test="${param.success eq true}">
		<table class="table table-bordered table-hover table-striped">
			<thead>
				<tr>
					<th>User Name</th>
					<th>Name</th>
					<th>Surname</th>
					<th>Address</th>
					<th>E-mail</th>
				</tr>
			</thead>
			<tbody>
				<c:catch var="user">
					<tr>
						<td>${user.name}</td>
						<td>${user.firstName}</td>
						<td>${user.lastName}</td>
						<td>${user.address}</td>
						<td>${user.email}</td>
					</tr>
				</c:catch>
			</tbody>
		</table>
	</c:if>

</form:form>