package watchit4me

import com.google.appengine.api.datastore.*
import javax.mail.*
import javax.mail.internet.*

class WatchController {

	def persistenceManager

    /**
	  * called by cron
	  */
	def index = {

		// jdo query
		def query = persistenceManager.newQuery (Site)
		def siteInstanceList = query.execute()
		def total = 0
		if (siteInstanceList && siteInstanceList.size() > 0) {
			total =  siteInstanceList.size()
		}

		String info = "It is ${new Date()} at Google and we have ${total} site(s)."
		log.info (info) // where does this go???
		
		Session session = Session.getDefaultInstance(new Properties(), null)

		Message msg = new MimeMessage(session)
		// email address must be a valid developer
		msg.setFrom(new InternetAddress("watchit4me.app@gmail.com"))
		msg.addRecipient(Message.RecipientType.TO,
		                 new InternetAddress("ogourment@smarterportal.com", "Olivier Gourment"))
		msg.subject = "coucou!"
		msg.text = info
		Transport.send(msg)
		
		render info
	}
	
}