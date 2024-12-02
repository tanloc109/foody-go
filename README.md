Food Delivery Microservices System

NOTICE: This is a project being developed based on the hobby of 4 devs who find it interesting to learn more about microservices and flutter. THE PROJECT IS STILL UNDER DEVELOPMENT.

Overview: This project is a Food Delivery Application built using a microservices architecture. The system enables users to order food, restaurants to manage their offerings, shippers to deliver orders, and administrators to oversee operations. The project uses modern tools and technologies to ensure scalability, maintainability, and robustness.

Features:
  - User Services:
    + User registration and login.
    + Update personal information and password.
    + Verify the phone number and reset the password via OTP.
  - Restaurant Services:
  + Manage restaurants, including creation, update, and deletion.
  + Retrieve restaurant details and list of all restaurants.
- Location Services
  + Calculate distances and retrieve location details.
  + Manage user and branch addresses.
- Inventory Services
  + Manage food categories and product inventories.
  + Update stock quantities and product statuses.
- Order Services
  + Add, update, or delete items from the cart.
  + Create, view, and cancel orders.
  + Retrieve user-specific and branch-specific orders.
- Shipping Services
  + Manage shipper locations and delivery statuses.
  + Calculate delivery fees and recommend orders for shippers.
- Payment Services
  + Create and retrieve payment details for users.
- Notification Services
  + Notify users about payment success or order completion.

Architecture
This project follows a microservices architecture where each service handles a specific domain:
  + Backend: Spring Boot for service development.
  + Frontend: ReactJS for the user interface.
  + Database: Combination of relational (MySQL, PostgreSQL) and NoSQL (MongoDB).
  + Message Queue: Kafka for communication between services.
  + Containerization: Docker for managing microservices.
  + Orchestration: Kubernetes for scaling and managing the containers.

Technologies
- Service	Technologies	Database
  + User Service	Spring Boot, Spring Security	PostgreSQL
  + Restaurant	Spring Boot, Hibernate	MySQL
  + Location	Spring Boot	MySQL
  + Inventory	Spring Boot, Hibernate	MySQL
  + Order	Spring Boot	PostgreSQL
  + Shipping	Spring Boot	MongoDB
  + Payment	Spring Boot, Stripe API Integration	MySQL
  + Notification	Spring Boot, Kafka	MongoDB
