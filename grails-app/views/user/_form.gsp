<%@ page import="grails_app.User" %>



<div class="fieldcontain ${hasErrors(bean: userInstance, field: 'email', 'error')} ">
	<label for="email">
		<g:message code="user.email.label" default="Email" />
		
	</label>
	<g:textField name="email" value="${userInstance?.email}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: userInstance, field: 'micropost', 'error')} ">
	<label for="micropost">
		<g:message code="user.micropost.label" default="Micropost" />
		
	</label>
	
<ul class="one-to-many">
<g:each in="${userInstance?.micropost?}" var="m">
    <li><g:link controller="micropost" action="show" id="${m.id}">${m?.encodeAsHTML()}</g:link></li>
</g:each>
<li class="add">
<g:link controller="micropost" action="create" params="['user.id': userInstance?.id]">${message(code: 'default.add.label', args: [message(code: 'micropost.label', default: 'Micropost')])}</g:link>
</li>
</ul>

</div>

<div class="fieldcontain ${hasErrors(bean: userInstance, field: 'name', 'error')} ">
	<label for="name">
		<g:message code="user.name.label" default="Name" />
		
	</label>
	<g:textField name="name" value="${userInstance?.name}"/>
</div>

