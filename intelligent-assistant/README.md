# ðŸ¤– Assistant Intelligent - Chatbot Spring Boot IA

Un projet Spring Boot complet intÃ©grant GPT-4o et Llama 3.2.

## ðŸš€ Démarrage rapide

### 1. Configurer la clé OpenAI
```powershell
$env:OPENAI_API_KEY="clef api"
```

### 2. Installer Ollama et Llama 3.2
```bash
ollama pull llama3.2
ollama serve
```

### 3. Lancer l'application
```bash
mvn spring-boot:run
```

## ðŸ”— Endpoints principaux

- `POST /api/conversation/discuter` - Chat avec mémoire
- `POST /api/cinema/recommandations` - Recommandations de films  
- `POST /api/comparaison/gpt4o` - Questions GPT-4o
- `POST /api/comparaison/llama32` - Questions Llama 3.2
- `POST /api/comparaison/comparer` - Comparaison des modéles
- `GET /api/test/ping` - Test de connectivité

## ðŸ“Š Interfaces

- Application: http://localhost:8080
- Console H2: http://localhost:8080/h2-console (sa/password)

## ðŸ§ª Tests rapides

```powershell
# Test de base
Invoke-RestMethod -Uri "http://localhost:8080/api/test/ping" -Method GET

# Chat GPT-4o
Invoke-RestMethod -Uri "http://localhost:8080/api/comparaison/gpt4o" -Method POST -Body @{question="Bonjour"} -ContentType "application/x-www-form-urlencoded"

# Chat Llama 3.2
Invoke-RestMethod -Uri "http://localhost:8080/api/comparaison/llama32" -Method POST -Body @{question="Bonjour"} -ContentType "application/x-www-form-urlencoded"

# Comparaison
Invoke-RestMethod -Uri "http://localhost:8080/api/comparaison/comparer" -Method POST -Body @{question="Capitale France?"} -ContentType "application/x-www-form-urlencoded"
```
