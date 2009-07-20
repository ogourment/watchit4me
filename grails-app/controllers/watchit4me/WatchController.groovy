package watchit4me

import com.google.appengine.api.datastore.*

class WatchController {

	def persistenceManager

    def index = {

		def query = persistenceManager.newQuery( Site )
		def siteInstanceList = query.execute()
		def total = 0
		if (siteInstanceList && siteInstanceList.size() > 0) {
			total =  siteInstanceList.size()
		}

		render "It is ${new Date()} here and we have $total sites."
	}
	
}