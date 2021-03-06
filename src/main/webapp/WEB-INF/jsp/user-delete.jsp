<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="../layout/taglib.jsp"%>

<form:form commandName="userDel" cssClass="form-horizontal">

	<c:if test="${param.success eq true}">
		<div class="alert alert-success">Deletion Successfull!</div>
	</c:if>
	
	<c:if test="${param.success eq false}">
		<div class="alert alert-danger">Deletion Unsuccessfull! Cannot Find User to Delete!</div>
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
			<input type="submit" value="Delete" class="center btn btn-lg btn-primary" style="float: right;" />
		</div>
	</div>

</form:form>