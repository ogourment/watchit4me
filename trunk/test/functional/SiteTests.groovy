class SiteTests extends functionaltestplugin.FunctionalTestCase {

    void testSiteList() {
		
		//get("/site/list") with URL passed as 'grails functional-test URL' did not work: it inserted the app.name for some reason:
		//URL Stack that resulted in junit.framework.AssertionFailedError: Expected HTTP status [200] but was [404]
		//http://localhost:8080/watchit4me/site/list (webWindowContentChange event)
		//where baseURL: http://localhost:8080/
		def baseURL = "http://localhost:8080/"
		
		get(baseURL + "site/list")
      
		println page.titleText
      
		assertStatus 200
		assertContentContains("url")

		assertContentContains("Logout")
	}
}
