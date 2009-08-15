package watchit4me

import com.google.appengine.api.datastore.*
import javax.mail.*
import javax.mail.internet.*

class WatchController {

    /**
	  * called by cron
	  */
	def index = {

		total =  Page.list().size()

		String info = "It is ${new Date()} at Google and we have ${total} site(s)."
		log.info (info) // where does this go???
		
		Session session = Session.getDefaultInstance(new Properties(), null)

		Message msg = new MimeMessage(session)
		// email address must be a valid developer
		msg.setFrom(new InternetAddress("watchit4me.app@gmail.com"))
		msg.addRecipient(Message.RecipientType.TO,
		                 new InternetAddress("ogourment@smarterportal.com", "Olivier Gourment"))
		msg.subject = "Hi from Watchit4me (jpa)!"
		msg.text = info
		Transport.send(msg)
		
		render info
	}
	
}