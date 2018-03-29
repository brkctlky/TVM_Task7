<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="../layout/taglib.jsp"%>

<form:form commandName="user" cssClass="form-horizontal">

	<c:if test="${param.success eq true}">
		<div class="alert alert-success">Registration Successfull!</div>
	</c:if>

	<div class="form-group">
		<label for="firstName" class="col-sm-2 control-label">Name:</label>
		<div class="col-sm-10">
			<form:input path="firstName" cssClass="form-control" required="required" />
			<form:errors path="firstName" />
		</div>
	</div>
	<div class="form-group">
		<label for="lastName" class="col-sm-2 control-label">Surname:</label>
		<div class="col-sm-10">
			<form:input path="lastName" cssClass="form-control" required="required" />
			<form:errors path="lastName" />
		</div>
	</div>
	<div class="form-group">
		<label for="name" class="col-sm-2 control-label">User Name:</label>
		<div class="col-sm-10">
			<form:input path="name" cssClass="form-control" required="required" />
			<form:errors path="name" />
		</div>
	</div>
	<div class="form-group">
		<label for="email" class="col-sm-2 control-label">Email:</label>
		<div class="col-sm-10">
			<form:input path="email" cssClass="form-control" type="email" required="required" />
			<form:errors path="email" />
		</div>
	</div>
	<div class="form-group">
		<label for="password" class="col-sm-2 control-label">Password:</label>
		<div class="col-sm-10">
			<form:password path="password" cssClass="form-control" required="required" />
			<form:errors path="password" />
		</div>
	</div>
	<div class="form-group">
		<label for="password" class="col-sm-2 control-label">Password
			again:</label>
		<div class="col-sm-10">
			<input type="password" name="password_again" id="password_again"
				class="form-control" required />
		</div>
	</div>
	<div class="form-group">
		<label for="address" class="col-sm-2 control-label">Address:</label>
		<div class="col-sm-10">
			<form:input path="address" cssClass="form-control" />
			<form:errors path="address" />
		</div>
	</div>
	<div class="form-group">
		<div class="col-sm-12">
			<input type="submit" value="Save" class="btn btn-lg btn-primary" style="float: right;" />
		</div>
	</div>

</form:form>