# 🎉 Greeting App — Spring Boot + HTML/CSS/JS

A beginner-friendly full-stack web app.  
Enter your name → Spring Boot greets you → Confetti explodes! 🥳

---

## Project Structure

```
greeting-app/
├── backend/                        ← Spring Boot project
│   ├── pom.xml                     ← Maven build file
│   └── src/main/java/com/example/greeting/
│       ├── GreetingApplication.java   ← Main entry point
│       ├── GreetingController.java    ← REST API (POST /api/greet)
│       ├── GreetingRequest.java       ← Incoming JSON model
│       └── GreetingResponse.java      ← Outgoing JSON model
│   └── src/main/resources/
│       └── application.properties     ← Server config (port 8080)
│
└── frontend/
    └── index.html                  ← Single-page frontend (HTML + CSS + JS)
```

---

## Prerequisites

| Tool | Minimum Version | Download |
|------|----------------|----------|
| Java JDK | 17+ | https://adoptium.net |
| Maven | 3.8+ | https://maven.apache.org/download.cgi |

> After installation, **restart your terminal** so `java` and `mvn` commands work.

---

## ▶️ How to Run

### Step 1 — Start the Backend

Open a terminal, navigate to the `backend` folder, and run:

```bash
cd greeting-app/backend
mvn spring-boot:run
```

You should see:
```
Started GreetingApplication in X seconds
Tomcat started on port(s): 8080
```

### Step 2 — Open the Frontend

Just double-click `frontend/index.html` to open it in your browser.  
(No extra server needed — it's a plain HTML file!)

---

## 🔌 API Reference

| Method | URL | Request Body | Response |
|--------|-----|-------------|----------|
| POST | `http://localhost:8080/api/greet` | `{"name": "Alice"}` | `{"message": "Hello, Alice!"}` |

### Example with curl:
```bash
curl -X POST http://localhost:8080/api/greet \
     -H "Content-Type: application/json" \
     -d "{\"name\": \"Alice\"}"
```

Expected response:
```json
{ "message": "Hello, Alice!" }
```

---

## 🛠️ How It Works

1. **User** types their name in the text box and clicks **Say Hello 🎉**
2. **Frontend** sends a `POST` request to `http://localhost:8080/api/greet` with JSON body `{"name": "..."}`
3. **Backend** (Spring Boot):
   - Receives the JSON
   - Trims whitespace from the name
   - Returns `{"message": "Hello, <name>!"}`
4. **Frontend** displays the greeting message
5. **Confetti** 🎊 animates across the screen for ~3.5 seconds
