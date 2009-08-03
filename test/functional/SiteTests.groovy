class SiteTests extends functionaltestplugin.FunctionalTestCase {

    void testSiteList() {

      get("/site/list")
      
      println page.titleText
      
      assertStatus 200
      assertContentContains("url")

      assertContentContains("Logout")
    }
}
