package testing.automated_tests; 

public class Venue {
    private TicketService ticketService;
    private int capacity;

    public Venue(TicketService ticketService, int capacity) {
        this.ticketService = ticketService;
        this.capacity = capacity;
    }

    public boolean purchaseTicket(String eventName, String customerName) {
        int availableTickets = ticketService.getAvailableTickets(eventName);
        int soldTickets = ticketService.getSoldTickets(eventName);

        if (availableTickets > 0 && soldTickets < capacity) {
            ticketService.sellTicket(eventName, customerName);
            return true;
        }
        return false;
    }

    public int getRemainingCapacity(String eventName) {
        int soldTickets = ticketService.getSoldTickets(eventName);
        return capacity - soldTickets;
    }
}
