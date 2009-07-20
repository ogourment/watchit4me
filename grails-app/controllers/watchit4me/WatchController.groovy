package watchit4me

import com.google.appengine.api.datastore.*
import javax.mail.*
import javax.mail.internet.*

class WatchController {

	def persistenceManager

    def index = {

		def query = persistenceManager.newQuery (Site)
		def siteInstanceList = query.execute()
		def total = 0
		if (siteInstanceList && siteInstanceList.size() > 0) {
			total =  siteInstanceList.size()
		}

		String info = "It is ${new Date()} here and we have $total site(s)."
		log.info (info)
		
		Session session = Session.getDefaultInstance([:], null)

		Message msg = new MimeMessage(session)
		msg.setFrom(new InternetAddress("watchit4me@smarterportal.com"))
		msg.addRecipient(Message.RecipientType.TO,
		                 new InternetAddress("ogourment@smarterportal.com", "Olivier Gourment"))
		msg.setSubject(info)
		msg.setText(info)
		Transport.send(msg)
		
		render msg
	}
	
}