<%@ page import="watchit4me.Site" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <meta name="layout" content="main" />
        <title>Create Site</title>         
    </head>
    <body>
        <div class="nav">
            <span class="menuButton"><a class="home" href="${resource(dir:'')}">Home</a></span>
            <span class="menuButton"><g:link class="list" action="list">Site List</g:link></span>
        </div>
        <div class="body">
            <h1>Create Site</h1>
            <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
            </g:if>
            <g:hasErrors bean="${siteInstance}">
            <div class="errors">
                <g:renderErrors bean="${siteInstance}" as="list" />
            </div>
            </g:hasErrors>
            <g:form action="save" method="post" >
                <div class="dialog">
                    <table>
                        <tbody>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="url">Url:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:siteInstance,field:'url','errors')}">
                                    <input type="text" id="url" name="url" value="${fieldValue(bean:siteInstance,field:'url')}"/>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="checksum">Checksum:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:siteInstance,field:'checksum','errors')}">
                                    <input type="text" id="checksum" name="checksum" value="${fieldValue(bean:siteInstance,field:'checksum')}" />
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="dataCreated">Data Created:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:siteInstance,field:'dataCreated','errors')}">
                                    <g:datePicker name="dataCreated" value="${siteInstance?.dataCreated}" precision="minute" ></g:datePicker>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="lastHttpStatus">Last Http Status:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:siteInstance,field:'lastHttpStatus','errors')}">
                                    <input type="text" id="lastHttpStatus" name="lastHttpStatus" value="${fieldValue(bean:siteInstance,field:'lastHttpStatus')}" />
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="lastUpdated">Last Updated:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:siteInstance,field:'lastUpdated','errors')}">
                                    <g:datePicker name="lastUpdated" value="${siteInstance?.lastUpdated}" precision="minute" ></g:datePicker>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="text">Text:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:siteInstance,field:'text','errors')}">
                                    <input type="text" id="text" name="text" value="${fieldValue(bean:siteInstance,field:'text')}"/>
                                </td>
                            </tr> 
                        
                        </tbody>
                    </table>
                </div>
                <div class="buttons">
                    <span class="button"><input class="save" type="submit" value="Create" /></span>
                </div>
            </g:form>
        </div>
    </body>
</html>
