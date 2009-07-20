package watchit4me

import com.google.appengine.api.datastore.*
class SiteController {

	def persistenceManager
    
    def index = { redirect(action:list,params:params) }

    // the delete, save and update actions only accept POST requests
    static allowedMethods = [delete:'POST', save:'POST', update:'POST']

    def list = {
        params.max = Math.min( params.max ? params.max.toInteger() : 10,  100)
		def query = persistenceManager.newQuery( Site )
		def  siteInstanceList = query.execute()
		def total = 0
		if(  siteInstanceList &&  siteInstanceList.size() > 0){
			total =  siteInstanceList.size()
		}
		[  siteInstanceList :  siteInstanceList,  siteInstanceTotal: total ]
    }

    def show = {
	    def siteInstance = persistenceManager.getObjectById( Site.class, Long.parseLong( params.id )  )
        if(!siteInstance) {
            flash.message = "Site not found with id ${params.id}"
            redirect(action:list)
        }
        else { return [ siteInstance : siteInstance ] }
    }

    def delete = {
	    def siteInstance = persistenceManager.getObjectById( Site.class, Long.parseLong( params.id )  )
        if(siteInstance) {
            try {
                persistenceManager.deletePersistent(siteInstance)
                flash.message = "Site ${params.id} deleted"
                redirect(action:list)
            }
            catch(Exception e) {
                flash.message = "Site ${params.id} could not be deleted"
                redirect(action:show,id:params.id)
            }
        }
        else {
            flash.message = "Site not found with id ${params.id}"
            redirect(action:list)
        }
    }

    def edit = {
	    def siteInstance = persistenceManager.getObjectById( Site.class, Long.parseLong( params.id )  )
		if(!siteInstance) {
            flash.message = "Site not found with id ${params.id}"
            redirect(action:list)
        }
        else {
			siteInstance = persistenceManager.detachCopy( siteInstance )    
        	return [ siteInstance : siteInstance ]
        }
    }

    def update = {
	 	def siteInstance = persistenceManager.getObjectById( Site.class, Long.parseLong( params.id )  )
    
    	if(siteInstance) {
            siteInstance.properties = params
            if(!siteInstance.hasErrors()){
	
				try{
					persistenceManager.makePersistent(siteInstance)
				} catch( Exception e ){
				   	render(view:'edit',model:[siteInstance:siteInstance])
				}finally{
					flash.message = "Site ${params.id} updated"
	                redirect(action:show,id:siteInstance.id)
				}        
 			}
            else {
                render(view:'edit',model:[siteInstance:siteInstance])
            }
        }
        else {
            flash.message = "Site not found with id ${params.id}"
            redirect(action:list)
        }
    }

    def create = {
        def siteInstance = new Site()
        siteInstance.properties = params
        return ['siteInstance':siteInstance]
    }

    def save = {
        def siteInstance = new Site(params)
		if(!siteInstance.hasErrors() ) {
			try{
				persistenceManager.makePersistent(siteInstance)
			} finally{
				flash.message = "Site ${siteInstance.id} created"
				redirect(action:show,id:siteInstance.id)	
			}
		}
   
		render(view:'create',model:[siteInstance:siteInstance])
        
    }
}
