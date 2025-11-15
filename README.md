# Backend Intern Project – Clothing Store Management API

A simple Spring Boot REST API for managing a clothing store, including products, customers, carts, invoices, and basic reporting features.  
This project is built to practice backend skills for internship preparation.

---

## Technologies Used
- Java 17
- Spring Boot 3.x
- Spring Data JPA / Hibernate
- SQL Server (or MySQL)
- Maven
- Lombok
- Postman
- IntelliJ IDEA

---

## API Endpoints (Example)

### Bill API
| Method | Endpoint | Description |
|--------|----------|-------------|
| GET    | /api/hoadon-management | Get all bills |
| POST   | /api/hoadon-management/add | Create bill |
| PUT    | /api/hoadon-management/update/{id} | Update bill |
| DELETE | /api/hoadon-management/delete/{id} | Delete bill |

### Product API
| Method | Endpoint | Description |
|--------|----------|-------------|
| GET    | /api/sanpham-management | Get all products |
| POST   | /api/sanpham-management/add | Create product |
| PUT    | /api/sanpham-management/update/{id} | Update product |
| DELETE | /api/sanpham-management/delete/{id} | Delete product |

---

## Features
- CRUD operations for Products, Customers, Invoices
- Pagination & Filtering
- RESTful API with 3-layer architecture
- Validation using `@Valid`
- DTO mapping (optional)
- Clean folder structure
- Easy to extend for full web application

---

## To-Do List (Upcoming Features)
- [ ] Build simple UI using **HTML/CSS/JS on VS Code**
- [ ] Connect UI ↔ Backend via REST API
- [ ] Add Authentication (JWT)
- [ ] Add Swagger API Documentation
- [ ] Improve error handling (Global Exception)
- [ ] Add Unit Tests (JUnit)
- [ ] Add Product Images / File Upload
- [ ] Deploy API online (Render / Railway)

---

## Demo Video
https://youtu.be/GhdeM-1mWEc?si=JY2kyoeWWte7s6LT


---

## Author
- Nguyễn Đình Hải Anh  
- Backend Developer Intern  
- Email: anhndh285@gmail.com  

---

## Note
I will integrate a simple frontend built with **Visual Studio Code** (HTML/CSS/JavaScript or Vue.js) in the near future to complete the full application UI.
