package testing.automated_tests;


import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class MusicTest {

    @Test
    public void testPurchaseTicket_Success() {
        TicketService mockTicketService = Mockito.mock(TicketService.class);
        Venue venue = new Venue(mockTicketService, 100);

        when(mockTicketService.getAvailableTickets("Rock Concert")).thenReturn(1);
        when(mockTicketService.getSoldTickets("Rock Concert")).thenReturn(0);

        boolean result = venue.purchaseTicket("Rock Concert", "Alice");

        assertTrue(result);
        verify(mockTicketService).sellTicket("Rock Concert", "Alice");
    }

    @Test
    public void testPurchaseTicket_NoTicketsAvailable() {
        TicketService mockTicketService = Mockito.mock(TicketService.class);
        Venue venue = new Venue(mockTicketService, 100);

        when(mockTicketService.getAvailableTickets("Jazz Night")).thenReturn(0);
        when(mockTicketService.getSoldTickets("Jazz Night")).thenReturn(100);

        boolean result = venue.purchaseTicket("Jazz Night", "Bob");

        assertFalse(result);
        verify(mockTicketService, never()).sellTicket(anyString(), anyString());
    }

    @Test
    public void testGetRemainingCapacity() {
        TicketService mockTicketService = Mockito.mock(TicketService.class);
        Venue venue = new Venue(mockTicketService, 200);

        when(mockTicketService.getSoldTickets("Pop Show")).thenReturn(150);

        int remainingCapacity = venue.getRemainingCapacity("Pop Show");

        assertEquals(50, remainingCapacity);
        verify(mockTicketService).getSoldTickets("Pop Show");
    }
}
