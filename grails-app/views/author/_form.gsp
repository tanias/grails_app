<%@ page import="grails_app.Author" %>



<div class="fieldcontain ${hasErrors(bean: authorInstance, field: 'email', 'error')} ">
	<label for="email">
		<g:message code="author.email.label" default="Email" />
		
	</label>
	<g:textField name="email" value="${authorInstance?.email}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: authorInstance, field: 'micropost', 'error')} ">
	<label for="micropost">
		<g:message code="author.micropost.label" default="Micropost" />
		
	</label>
	
<ul class="one-to-many">
<g:each in="${authorInstance?.micropost?}" var="m">
    <li><g:link controller="micropost" action="show" id="${m.id}">${m?.encodeAsHTML()}</g:link></li>
</g:each>
<li class="add">
<g:link controller="micropost" action="create" params="['author.id': authorInstance?.id]">${message(code: 'default.add.label', args: [message(code: 'micropost.label', default: 'Micropost')])}</g:link>
</li>
</ul>

</div>

<div class="fieldcontain ${hasErrors(bean: authorInstance, field: 'name', 'error')} ">
	<label for="name">
		<g:message code="author.name.label" default="Name" />
		
	</label>
	<g:textField name="name" value="${authorInstance?.name}"/>
</div>

