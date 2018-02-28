public interface CinemaApi {

    /**
    * Bookings methods
    */
    public void createBooking();

    public boolean deleteBooking(Booking booking);

    public boolean updateBooking(Booking booking);

    public List<Booking> getBookings();


    /**
    * Customers methods
    */
    public Customer createCustomer();

    public boolean deleteCustomer(Customer customer)

    public boolean updateCustomer(Customer customer);

    public List<Customer> getCustomers();


    /**
    * Film methods
    */
    public Film createFilm();

    public boolean deleteFilm(Film film);

    public boolean updateFilm(Film film);

    public List<Film> getFilms();

    /**
    * Screen methods
    */
    public Screen createScreen();

    public boolean deleteScreen(Screen screen);

    public boolean updateScreen(Screen screen);

    public List<Screen> getScreens();

    /**
    * Screenings methods
    */
    public Screening createScreening();

    public boolean deleteScreening(Screening screening);

    public boolean updateScreening(Screening screening);

    public List<Screening> getScreening();

    /**
    * Seat methods
    */
    public Seat createSeat();

    public boolean deleteSeat(Seat seat);

    public boolean updateSeat(Seat seat);

    public List<Seat> getSeats();

    /**
    * Ticket methods
    */
    public Ticket createTicket();

    public boolean deleteTicket(Ticket ticket);

    public boolean updateTicket(Ticket ticket);

    public List<Ticket> getTickets();

}
