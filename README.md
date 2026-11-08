# Week 8 Assignment 3: Creating REST Controllers and Mapping HTTP Methods

ProductService.java file was created for the business logic/repository calls

I utilized Postman to test the endpoints as APIDog was having issues and uploaded the testing screenshots to the LMS as a Word doc.

## API Commands with Postman

**Base URL:** `http://localhost:8080/api/products`

### 1. GET — Retrieve All Products

**Method:** `GET`

**URL:**
```http
http://localhost:8080/api/products
```
Returns a JSON array containing all products stored in the database.

### 2. GET — Retrieve Product by ID

**Method:** `GET`

**URL:**
```http
http://localhost:8080/api/products/1
```

Returns the product associated with the specified ID. If the product does not exist, the API returns `404 Not Found`.

### 3. POST — Create a New Product

**Method:** `POST`

**URL:**
```http
http://localhost:8080/api/products
```

**Body:** Select `Body → raw → JSON` in Postman.

```json
{
  "name": "Sun Chips",
  "category": "Chips",
  "price": 3.50,
  "stockQuantity": 30
}
```
Creates a new product in the database and returns the saved product with its automatically generated ID.

### 4. PUT — Update an Existing Product(Updated Price)

**Method:** `PUT`

**URL:**
```http
http://localhost:8080/api/products/1
```

**Body:** Select `Body → raw → JSON` in Postman.

```json
{
  "name": "Sun Chips",
  "category": "Chips",
  "price": 4.0,
  "stockQuantity": 30
}
```

Updates the existing product with the specified ID and returns the updated product. If the ID does not exist, the API returns `404 Not Found`.

### 5. DELETE — Remove a Product

**Method:** `DELETE`

**URL:**
```http
http://localhost:8080/api/products/1
```
Deletes the product associated with the specified ID. If the product does not exist, the API returns `404 Not Found`.
