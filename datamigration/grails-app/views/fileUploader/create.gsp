<%@ page import="com.bayport.domain.FileUploader" %>
<!doctype html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'fileUploader.label', default: 'FileUploader')}" />
		<title><g:message code="default.create.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#create-fileUploader" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="create-fileUploader" class="content scaffold-create" role="main">
			<h1><g:message code="default.create.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			    <div class="message" role="status">${flash.message}</div>
			</g:if>
            <g:if test="${flash.errorMessage}">
                <div class="errors" style="display: block" role="status">${flash.errorMessage}</div>
            </g:if>
            <g:if test="${fileUploaderInstance?.getErrorList()?.size() > 0}">
                <div class="errors" style="display: block" role="status">
                    <g:each in="${fileUploaderInstance?.getErrorList()}" var="errorItem">
                        <g:if test="${errorItem?.getColumnNumber()}">
                            ${errorItem?.getColumnNumber()}
                        </g:if>
                        <g:if test="${errorItem?.getRowNumber()}">
                            ${errorItem?.getRowNumber()}
                        </g:if>
                        ${errorItem?.getErrorMessage()}
                    </g:each>
                </div>
            </g:if>
			<g:hasErrors bean="${fileUploaderInstance}">
			<ul class="errors" role="alert">
				<g:eachError bean="${fileUploaderInstance}" var="error">
				<li <g:if test="${error in org.springframework.validation.FieldError}">data-field-id="${error.field}"</g:if>><g:message error="${error}"/></li>
				</g:eachError>
			</ul>
			</g:hasErrors>
			<g:form action="save"  enctype="multipart/form-data">
				<fieldset class="form">
					<g:render template="form"/>
				</fieldset>
				<fieldset class="buttons">
					<g:submitButton name="create" class="save" value="${message(code: 'default.button.create.label', default: 'Create')}" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
