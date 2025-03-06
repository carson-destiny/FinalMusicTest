package testing.automated_tests;

import java.util.HashMap;
import java.util.Map;

public class TicketService {
    private Map<String, Integer> availableTickets;
    private Map<String, Integer> soldTickets;

    public TicketService() {
        this.availableTickets = new HashMap<>();
        this.soldTickets = new HashMap<>();
    }

    public int getAvailableTickets(String eventName) {
        return availableTickets.getOrDefault(eventName, 0);
    }

    public int getSoldTickets(String eventName) {
        return soldTickets.getOrDefault(eventName, 0);
    }

    public void sellTicket(String eventName, String customerName) {
        int available = availableTickets.getOrDefault(eventName, 0);
        int sold = soldTickets.getOrDefault(eventName, 0);

        if (available > 0) {
            availableTickets.put(eventName, available - 1);
            soldTickets.put(eventName, sold + 1);
        }
    }

    // Method to set up initial available tickets for an event
    public void setAvailableTickets(String eventName, int count) {
        availableTickets.put(eventName, count);
    }
}
