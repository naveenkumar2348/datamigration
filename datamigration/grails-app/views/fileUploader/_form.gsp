<%@ page import="com.bayport.domain.FileUploader" %>

<div class="fieldcontain ${hasErrors(bean: fileUploaderInstance, field: 'dataSheetType', 'error')} required">
    <label for="dataSheetType">
        <g:message code="fileUploader.dataSheetType.label" default="Data Sheet Type" />
        <span class="required-indicator">*</span>
    </label>
    <g:select name="dataSheetType" from="${com.bayport.enums.MasterDataSheetType?.values()}" keys="${com.bayport.enums.MasterDataSheetType.values()*.name()}" required="" value="${fileUploaderInstance?.dataSheetType?.name()}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: fileUploaderInstance, field: 'masterDataSheet', 'error')} ">
	<label for="masterDataSheet">
		<g:message code="fileUploader.masterDataSheet.label" default="Master Data Sheet" />
		
	</label>
	<input type="file" id="masterDataSheet" name="masterDataSheet" />
</div>

<div class="fieldcontain ${hasErrors(bean: fileUploaderInstance, field: 'date', 'error')} required">
	<label for="date">
		<g:message code="fileUploader.date.label" default="Date" />
		<span class="required-indicator">*</span>
	</label>
	<g:datePicker name="date" precision="day"  value="${fileUploaderInstance?.date}"  />
</div>

<div class="fieldcontain ${hasErrors(bean: fileUploaderInstance, field: 'emailId', 'error')} ">
	<label for="emailId">
		<g:message code="fileUploader.emailId.label" default="Email Id" />
		
	</label>
	<g:textField name="emailId" value="${fileUploaderInstance?.emailId}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: fileUploaderInstance, field: 'uploadedBy', 'error')} ">
	<label for="uploadedBy">
		<g:message code="fileUploader.uploadedBy.label" default="Uploaded By" />
		
	</label>
	<g:textField name="uploadedBy" value="${fileUploaderInstance?.uploadedBy}"/>
</div>

