package com.example.greeting;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * REST Controller that handles greeting requests.
 *
 * Endpoint: POST /api/greet
 * - Receives a JSON body with a "name" field
 * - Trims whitespace from the name
 * - Returns a greeting message: "Hello, <name>!"
 *
 * CORS is enabled to allow requests from the frontend (any origin).
 */
@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")  // Allow requests from any origin (for development)
public class GreetingController {

    /**
     * POST /api/greet
     * Processes the user's name and returns a personalized greeting.
     *
     * @param request  JSON body containing the "name" field
     * @return         JSON response with the "message" field
     */
    @PostMapping("/greet")
    public ResponseEntity<GreetingResponse> greet(@RequestBody GreetingRequest request) {

        // Step 1: Get the name from the request
        String name = request.getName();

        // Step 2: Validate that name is not null or blank
        if (name == null || name.isBlank()) {
            return ResponseEntity
                    .badRequest()
                    .body(new GreetingResponse("Please provide a valid name!"));
        }

        // Step 3: Process the name - trim leading/trailing spaces
        String processedName = name.trim();

        // Step 4: Build the greeting message
        String greetingMessage = "Hello, " + processedName + "!";

        // Step 5: Return the response
        return ResponseEntity.ok(new GreetingResponse(greetingMessage));
    }
}
