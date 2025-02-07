# Password Generator API

![Java](https://img.shields.io/badge/Java-23-blue)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.0-green)
![License](https://img.shields.io/github/license/KacperTetela/Password-Generator)

Password Generator API is a simple REST API for generating passwords based on user-defined criteria.

## 🚀 Features

- Generate passwords based on custom criteria.
- Supports different password formats.
- RESTful API design.

## 📦 Technology Stack

- **Language**: Java 23
- **Framework**: Spring Boot 3.x
- **Build Tool**: Maven

## 🛠 Installation & Running the Project

### 1️⃣ Clone the Repository

```sh
git clone https://github.com/KacperTetela/Password-Generator.git
cd Password-Generator
```

### 2️⃣ Build and Run the Application

```sh
mvn spring-boot:run
```

The application will start on port `8080` by default.

## 📡 API Endpoints

### 🔹 Generate Password

**Endpoint:**\
`POST /api/v1/passwords`

**Description:**\
Generates a password based on the provided criteria.

### Request Body Parameters:

| Parameter             | Type    | Required | Description                 |
| --------------------- | ------- | -------- | --------------------------- |
| `length`              | Integer | Yes      | The length of the password. |
| `includeUppercase`    | Boolean | No       | Include uppercase letters.  |
| `includeNumbers`      | Boolean | No       | Include numbers.            |
| `includeSpecialChars` | Boolean | No       | Include special characters. |

### Example Request:

```json
POST /api/v1/passwords
Content-Type: application/json

{
  "length": 12,
  "includeUppercase": true,
  "includeNumbers": true,
  "includeSpecialChars": false
}
```

### Example Response:

```json
"Abcdef123456"
```

## 🛠 How to Build Example Requests

To send a request to the API, you can use:

### 1️⃣ cURL:

```sh
curl -X POST "http://localhost:8080/api/v1/passwords" \
     -H "Content-Type: application/json" \
     -d '{
           "length": 16,
           "includeUppercase": true,
           "includeNumbers": true,
           "includeSpecialChars": true
         }'
```

### 2️⃣ Postman:

- Open Postman and create a new `POST` request.
- Set the URL to `http://localhost:8080/api/v1/passwords`.
- Go to the `Body` tab and select `raw`, then set the format to `JSON`.
- Paste the following JSON:

```json
{
  "length": 10,
  "includeUppercase": false,
  "includeNumbers": true,
  "includeSpecialChars": false
}
```

- Click `Send` and check the response.

## 📄 License

This project is available under the MIT License. See [`LICENSE`](https://choosealicense.com/licenses/mit/) for details.

## ✨ Author

[Kacper Tetela](https://github.com/KacperTetela)
