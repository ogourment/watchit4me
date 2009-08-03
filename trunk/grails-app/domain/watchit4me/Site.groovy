package watchit4me

import javax.persistence.*

@Entity @Table (name = "SITE")

class Site {
  @Id @GeneratedValue (strategy = GenerationType.AUTO) Long id

  @Temporal (TemporalType.TIMESTAMP) Date dateCreated
  
  @Temporal (TemporalType.TIMESTAMP) Date lastUpdated

  @Version int version
  
  @Basic String url

  @Basic BigInteger checksum
  
  @Basic int lastHttpStatus
  
  @Basic String text
  
  static constraints = {
    id (visible:false)
    url (url:true)
    checksum (visible:false)
	}
}
