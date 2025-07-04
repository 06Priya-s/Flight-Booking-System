# Flight-Booking-System
 <p>A Java-based console application developed by Pinnacle Labs</p>
    </header>

   <section>
        <h2>Project Overview</h2>
        <p>This Java application simulates a complete flight booking system with multiple airlines, seat selection, and passenger management. Built entirely with core Java concepts, it demonstrates object-oriented programming principles in a real-world scenario.</p>
  
  <strong>Core Technologies:</strong> Java SE 17+ | OOP Principles | Console I/O
   
  </section>

  <section>
        <h2>Key Features</h2>
            <h3>Multi-Flight Management</h3>
                <p>Handle 5+ simultaneous flight routes with dynamic seat allocation and real-time availability tracking.</p>
           
  <h3>OOP Implementation</h3>
          <p>Clean architecture with proper encapsulation (Flight, Seat, Passenger, Booking classes).</p>
            
   <h3>Interactive Console UI</h3>
                <p>User-friendly menu-driven interface with step-by-step booking flow.</p>
           
  <h3>Booking System</h3>
        <p>Complete reservation workflow from seat selection to confirmation generation.</p>
            
           
  <h3>Lightweight Code</h3>
  <p>Single-file implementation with no external dependencies.</p>
    </section>

  <section>
        <h2>How It Works</h2>
        <ol>
            <li>System displays available flights with routes and pricing</li>
            <li>User selects a flight and views available seats</li>
            <li>Passenger information is collected and validated</li>
            <li>System generates booking confirmation with unique ID</li>
            <li>Seats are automatically marked as reserved</li>
        </ol>
        
  <strong>Sample Usage:</strong>
           <pre><code>1. javac FlightBookingSystem.java
        2. java FlightBookingSystem</code></pre>
      
  </section>

  <section>
        <h2>Technical Highlights</h2>
        <ul>
            <li>Core Java implementation (no frameworks)</li>
            <li>Proper exception handling and input validation</li>
            <li>Memory management and resource cleanup</li>
            <li>Automatic price calculation based on seat selection</li>
            <li>Real-time seat availability updates</li>
        </ul>
    </section>

  <section>
        <h2>Class Structure</h2>
        <pre><code>FlightBookingSystem (Main Class)
├── Flight
│   ├── Seat[]
├── Passenger
└── Booking
    ├── Flight
    ├── Passenger
    └── Seat[]</code></pre>
    </section>

  <footer>
        <p>Developed by Pinnacle Labs | Java Training Project | © 2023</p>
    </footer>
</body>
</html>
