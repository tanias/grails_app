<%@ page import="grails_app.Micropost" %>



<div class="fieldcontain ${hasErrors(bean: micropostInstance, field: 'content', 'error')} ">
	<label for="content">
		<g:message code="micropost.content.label" default="Content" />
		
	</label>
	<g:textField name="content" value="${micropostInstance?.content}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: micropostInstance, field: 'user', 'error')} required">
	<label for="user">
		<g:message code="micropost.user.label" default="User" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="user" name="user.id" from="${grails_app.User.list()}" optionKey="id" required="" value="${micropostInstance?.user?.id}" class="many-to-one"/>
</div>

