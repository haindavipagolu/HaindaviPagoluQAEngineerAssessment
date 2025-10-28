package Authors_API;

import io.cucumber.java.Before;


public class APIHooks {
    @Before("@RunAuthorsAPI")
    public void apiSetup() {
        // Optional setup for API tests
        System.out.println("Starting API scenario...");
    }
}