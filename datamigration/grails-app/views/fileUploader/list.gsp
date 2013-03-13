
<%@ page import="com.bayport.enums.MigrationStatus; com.bayport.domain.FileUploader" %>
<!doctype html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'fileUploader.label', default: 'FileUploader')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-fileUploader" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-fileUploader" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
				<thead>
					<tr>

                        <g:sortableColumn property="id" title="${message(code: 'fileUploader.id.label', default: 'ID')}" />

						<g:sortableColumn property="masterDataSheet" title="${message(code: 'fileUploader.masterDataSheet.label', default: 'Uploaded Sheet')}" />
					
						<g:sortableColumn property="dataSheetType" title="${message(code: 'fileUploader.dataSheetType.label', default: 'Uploaded Sheet Type')}" />
					
						<g:sortableColumn property="date" title="${message(code: 'fileUploader.date.label', default: 'Date')}" />
					
						<g:sortableColumn property="emailId" title="${message(code: 'fileUploader.emailId.label', default: 'Email Id')}" />

                        <g:sortableColumn property="uploadedBy" title="${message(code: 'fileUploader.uploadedBy.label', default: 'Uploaded By')}" />

                        <g:sortableColumn property="status" title="${message(code: 'fileUploader.status.label', default: 'Status')}" />

                        <g:sortableColumn property="isExportedToFlexifin" title="${message(code: 'fileUploader.isExportedToFlexifin.label', default: 'Export To FlexiFin')}" />

					</tr>
				</thead>
				<tbody>
				<g:each in="${fileUploaderInstanceList}" status="i" var="fileUploaderInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${fileUploaderInstance.id}">${fieldValue(bean: fileUploaderInstance, field: "id")}</g:link></td>

                        <td><g:link action="displayBlob" id="${fileUploaderInstance.id}">${fieldValue(bean: fileUploaderInstance, field: "uploadedFileName")}</g:link></td>

						<td>${fieldValue(bean: fileUploaderInstance, field: "dataSheetType")}</td>
					
						<td><g:formatDate date="${fileUploaderInstance.date}" /></td>
					
						<td>${fieldValue(bean: fileUploaderInstance, field: "emailId")}</td>

                        <td>${fieldValue(bean: fileUploaderInstance, field: "uploadedBy")}</td>

                        <td>${fieldValue(bean: fileUploaderInstance, field: "status")}</td>

                        <g:if test="${fileUploaderInstance?.status == MigrationStatus.InStagingArea}">
                            <td><g:link action="exportToFlexifin" id="${fileUploaderInstance.id}">${message(code: 'fileUploader.isExportedToFlexifin.label', default: 'Export To FlexiFin')}</g:link></td>
                        </g:if>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${fileUploaderInstanceTotal}" />
			</div>
		</div>
	</body>
</html>
