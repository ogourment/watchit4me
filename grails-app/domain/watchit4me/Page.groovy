package watchit4me

import javax.persistence.*;
// import com.google.appengine.api.datastore.Key;

@Entity
class Page {

    @Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Long id

	@Basic
	String url

	@Temporal (TemporalType.TIMESTAMP)
	Date dateCreated
	
	@Temporal (TemporalType.TIMESTAMP)
	Date lastUpdated
	
	@Basic
	int lastHttpStatus
	
	@Basic
	String lastContentType
	
	@Basic
	String lastContents

    static constraints = {
    	id visible:false
		url url:true
		lastContents visible:false
	}
}
