
<%@ page import="com.bayport.domain.FileUploader" %>
<!doctype html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'fileUploader.label', default: 'FileUploader')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-fileUploader" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-fileUploader" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list fileUploader">

				<g:if test="${fileUploaderInstance?.uploadedFileName}">
				<li class="fieldcontain">
					<span id="uploadedFileName-label" class="property-label"><g:message code="fileUploader.uploadedFileName.label" default="Uploaded File Name" /></span>
					
						<span class="property-value" aria-labelledby="uploadedFileName-label"><g:fieldValue bean="${fileUploaderInstance}" field="uploadedFileName"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${fileUploaderInstance?.dataSheetType}">
				<li class="fieldcontain">
					<span id="dataSheetType-label" class="property-label"><g:message code="fileUploader.dataSheetType.label" default="Data Sheet Type" /></span>
					
						<span class="property-value" aria-labelledby="dataSheetType-label"><g:fieldValue bean="${fileUploaderInstance}" field="dataSheetType"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${fileUploaderInstance?.date}">
				<li class="fieldcontain">
					<span id="date-label" class="property-label"><g:message code="fileUploader.date.label" default="Date" /></span>
					
						<span class="property-value" aria-labelledby="date-label"><g:formatDate date="${fileUploaderInstance?.date}" /></span>
					
				</li>
				</g:if>
			
				<g:if test="${fileUploaderInstance?.emailId}">
				<li class="fieldcontain">
					<span id="emailId-label" class="property-label"><g:message code="fileUploader.emailId.label" default="Email Id" /></span>
					
						<span class="property-value" aria-labelledby="emailId-label"><g:fieldValue bean="${fileUploaderInstance}" field="emailId"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${fileUploaderInstance?.uploadedBy}">
				<li class="fieldcontain">
					<span id="uploadedBy-label" class="property-label"><g:message code="fileUploader.uploadedBy.label" default="Uploaded By" /></span>
					
						<span class="property-value" aria-labelledby="uploadedBy-label"><g:fieldValue bean="${fileUploaderInstance}" field="uploadedBy"/></span>
					
				</li>
				</g:if>
			
			</ol>
			<g:form>
				<fieldset class="buttons">
					<g:hiddenField name="id" value="${fileUploaderInstance?.id}" />
					%{--<g:link class="edit" action="edit" id="${fileUploaderInstance?.id}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />--}%
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
