<%@ page import="grails_app.Micropost" %>



<div class="fieldcontain ${hasErrors(bean: micropostInstance, field: 'author', 'error')} required">
	<label for="author">
		<g:message code="micropost.author.label" default="Author" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="author" name="author.id" from="${grails_app.Author.list()}" optionKey="id" required="" value="${micropostInstance?.author?.id}" class="many-to-one"/>
</div>

<div class="fieldcontain ${hasErrors(bean: micropostInstance, field: 'content', 'error')} ">
	<label for="content">
		<g:message code="micropost.content.label" default="Content" />
		
	</label>
	<g:textField name="content" value="${micropostInstance?.content}"/>
</div>

