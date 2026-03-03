package com.example.greeting;

/**
 * Represents the incoming POST request body from the frontend.
 * Contains the name entered by the user.
 */
public class GreetingRequest {

    private String name;

    // Default constructor (required for JSON deserialization)
    public GreetingRequest() {}

    public GreetingRequest(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
