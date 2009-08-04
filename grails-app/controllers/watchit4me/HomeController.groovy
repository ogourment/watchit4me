
package watchit4me

import com.google.appengine.api.users.UserServiceFactory

class HomeController {
	
	def index = {
		
		def userService = UserServiceFactory.getUserService()
		
        String thisURL = request.requestURI
        if (request.userPrincipal) {
			def signout = userService.createLogoutURL(thisURL)
            flash.message = """<p>Hello, ${request.userPrincipal.name}!
			You can <a href=\"${signout}"\">sign out</a>.</p>"""			
        } else {
			def signin = userService.createLoginURL(thisURL)
            flash.message = "<p>Please <a href=\"${signin}\">sign in</a>.</p>"
        }
	}
}