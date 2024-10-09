package dev.mohit.websocket.websocket_server.config;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class MessageController {

    private String currentData = "Initial data"; // Initial data that all clients will sync to

    // Method to receive updates from one client and broadcast to all clients
    @MessageMapping("/update")
    @SendTo("/topic/data")
    public String updateData(String newData) {
        currentData = newData; // Update the data
        return currentData; // Broadcast updated data to all clients
    }

    // Optionally, you could add a method to get the current data
    @MessageMapping("/getData")
    @SendTo("/topic/data")
    public String getCurrentData() {
        return currentData; // Send the current data to the requesting client
    }
}
