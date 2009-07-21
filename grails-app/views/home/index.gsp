<html>
    <head>
        <title>Welcome to Watchit4Me!</title>
		<meta name="layout" content="main" />
    </head>
    <body>
        <h1 style="margin-left:20px;">Welcome to Watchit4Me!</h1>
        <g:if test="${flash.message}">
        <div class="message">${flash.message}</div>
        </g:if>
        <div class="dialog" style="margin-left:20px;width:60%;">
			<g:link controller="site">My Sites</g:link>
        </div>
    </body>
</html>