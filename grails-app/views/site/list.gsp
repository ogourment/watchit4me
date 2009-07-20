<%@ page import="watchit4me.Site" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <meta name="layout" content="main" />
        <title>Site List</title>
    </head>
    <body>
        <div class="nav">
            <span class="menuButton"><a class="home" href="${resource(dir:'')}">Home</a></span>
            <span class="menuButton"><g:link class="create" action="create">New Site</g:link></span>
        </div>
        <div class="body">
            <h1>Site List</h1>
            <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
            </g:if>
            <div class="list">
                <table>
                    <thead>
                        <tr>
                        
                   	        <g:sortableColumn property="id" title="Id" />
                        
                   	        <g:sortableColumn property="url" title="Url" />
                        
                   	        <g:sortableColumn property="checksum" title="Checksum" />
                        
                   	        <g:sortableColumn property="dataCreated" title="Data Created" />
                        
                   	        <g:sortableColumn property="lastHttpStatus" title="Last Http Status" />
                        
                   	        <g:sortableColumn property="lastUpdated" title="Last Updated" />
                        
                        </tr>
                    </thead>
                    <tbody>
                    <g:each in="${siteInstanceList}" status="i" var="siteInstance">
                        <tr class="${(i % 2) == 0 ? 'odd' : 'even'}">
                        
                            <td><g:link action="show" id="${siteInstance.id}">${fieldValue(bean:siteInstance, field:'id')}</g:link></td>
                        
                            <td>${fieldValue(bean:siteInstance, field:'url')}</td>
                        
                            <td>${fieldValue(bean:siteInstance, field:'checksum')}</td>
                        
                            <td>${fieldValue(bean:siteInstance, field:'dataCreated')}</td>
                        
                            <td>${fieldValue(bean:siteInstance, field:'lastHttpStatus')}</td>
                        
                            <td>${fieldValue(bean:siteInstance, field:'lastUpdated')}</td>
                        
                        </tr>
                    </g:each>
                    </tbody>
                </table>
            </div>
            <div class="paginateButtons">
                <g:paginate total="${siteInstanceTotal}" />
            </div>
        </div>
    </body>
</html>
