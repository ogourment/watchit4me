package watchit4me

import javax.jdo.annotations.*;
// import com.google.appengine.api.datastore.Key;

@PersistenceCapable(identityType = IdentityType.APPLICATION, detachable="true")
class Site implements Serializable {

	@PrimaryKey
    @Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
	Long id

	@Persistent
	String url
	
	@Persistent
	Date dataCreated
	
	@Persistent
	Date lastUpdated
	
	@Persistent
	BigInteger checksum
	
	@Persistent
	int lastHttpStatus

	@Persistent
	String text
	
    static constraints = {
    	id (visible:false)
		url (url:true)
		checksum (visible:false)
	}
}
