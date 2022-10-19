package ru.netology;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class TicketManagerTest {
    TicketRepository repo = new TicketRepository();
    TicketManager manager = new TicketManager(repo);

    Ticket ticket1 = new Ticket(1, 400, "DME", "KZN", 130);
    Ticket ticket2 = new Ticket(2, 800, "VKO", "VVO", 480);
    Ticket ticket3 = new Ticket(3, 300, "VOZ", "DME", 45);
    Ticket ticket4 = new Ticket(4, 350, "DME", "KZN", 130);
    Ticket ticket5 = new Ticket(5, 550, "IST", "AER", 180);
    Ticket ticket6 = new Ticket(6, 650, "DME", "KZN", 130);

    @BeforeEach
    public void setUp() {
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
    }

    @Test
    public void shouldSearchOneTicket() {
        Ticket[] expected = {ticket2};
        Ticket[] actual = manager.searchTickets("VKO", "VVO");

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchSeveralTickets() {
        Ticket[] expected = {ticket4, ticket1, ticket6};
        Ticket[] actual = manager.searchTickets("DME", "KZN");

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldNotSearchTicket() {
        Ticket[] expected = {};
        Ticket[] actual = manager.searchTickets("VKO", "KZN");

        assertArrayEquals(expected, actual);
    }
}
