### 1. **Package aur Imports**

### 1. `package com.example;`
- Yeh batata hai ke yeh file kis package (folder structure) mein hai.

---

### 2. `import io.github.cdimascio.dotenv.Dotenv;`
- **Dotenv**:  
  Yeh library .env file se environment variables (jaise API key) load karne ke liye use hoti hai.

---

### 3. `import javafx.application.Application;`
- **Application**:  
  JavaFX ki base class hai, isko extend karke aap apni GUI app bana sakte hain.

---

### 4. `import javafx.geometry.Insets;`
- **Insets**:  
  Layouts mein padding/margin set karne ke liye use hota hai.

---

### 5. `import javafx.geometry.Pos;`
- **Pos**:  
  Layouts mein alignment set karne ke liye (center, left, right, etc).

---

### 6. `import javafx.scene.Scene;`
- **Scene**:  
  JavaFX ka main container, jismein saari UI hoti hai.

---

### 7. `import javafx.scene.control.*;`
- **Controls (Button, TextField, Label, etc)**:  
  Sab UI controls (jaise button, text field, label, etc) import ho jate hain.

---

### 8. `import javafx.scene.layout.*;`
- **Layouts (VBox, HBox, etc)**:  
  UI ko arrange karne ke liye layouts (vertical, horizontal, etc) import ho jate hain.

---

### 9. `import javafx.scene.paint.Color;`
- **Color**:  
  Rang set karne ke liye (background, text, etc).

---

### 10. `import javafx.scene.text.Font;`
- **Font**:  
  Text ka font style set karne ke liye.

---

### 11. `import javafx.scene.text.FontWeight;`
- **FontWeight**:  
  Text ko bold ya normal weight dene ke liye.

---

### 12. `import javafx.stage.Stage;`
- **Stage**:  
  JavaFX ka main window (app ka frame).

---

### 13. `import javafx.scene.image.Image;`
- **Image**:  
  Image load karne ke liye (jaise logo).

---

### 14. `import javafx.scene.image.ImageView;`
- **ImageView**:  
  Image ko UI mein dikhane ke liye.

---

### 15. `import javafx.scene.text.Text;`
- **Text**:  
  Simple text node banane ke liye.

---

### 16. `import javafx.scene.text.TextFlow;`
- **TextFlow**:  
  Multiple text nodes ko ek sath arrange karne ke liye.

---

### 17. `import java.net.http.HttpClient;`
- **HttpClient**:  
  Internet par request bhejne ke liye (API call).

---

### 18. `import java.net.http.HttpRequest;`
- **HttpRequest**:  
  HTTP request banane ke liye (kya bhejna hai, kahan bhejna hai).

---

### 19. `import java.net.http.HttpResponse;`
- **HttpResponse**:  
  Server se aane wala response receive karne ke liye.

---

### 20. `import java.net.URI;`
- **URI**:  
  URL ko represent karne ke liye (API endpoint).

---

### 21. `import org.json.JSONObject;`
- **JSONObject**:  
  JSON data ko parse aur create karne ke liye (API response handle karne ke liye).

---

### 22. `import org.json.JSONArray;`
- **JSONArray**:  
  JSON array ko parse aur create karne ke liye.


---

## 2. **Class Declaration**
- `public class SyrexTech extends Application`  
  Yeh class `Application` ko extend kar rahi hai, jo JavaFX ka base class hai GUI apps ke liye.

---

## 3. **Variables**
- `VBox chatContainer`  
  Yeh ek vertical box hai jismein chat messages show hongay.
- `ScrollPane chatScrollPane`  
  Yeh scrollable area hai jismein chatContainer wrap hota hai.
- `TextField inputField`  
  Yeh user input ke liye text field hai.
- `Button sendButton`  
  Yeh button hai jo message bhejne ke liye hai.
- `ProgressIndicator loadingIndicator`  
  Yeh loading spinner hai jab tak AI se response aa raha ho.
- `API_KEY`, `API_URL`  
  Yeh Gemini API ke liye key aur URL hai.
- `HttpClient httpClient`  
  Yeh HTTP requests bhejne ke liye object hai.

---

## 4. **start(Stage primaryStage)**
Yeh JavaFX ka main method hai jo app start karta hai.

- **httpClient initialize hota hai.**
- **Window ka title set hota hai.**
- **mainContainer (VBox) banta hai, jismein sab kuch add hota hai.**
- **Logo load karne ki koshish hoti hai.**
- **chatContainer aur chatScrollPane bante hain, styling ke sath.**
- **inputContainer banta hai, jismein inputField aur sendButton add hotay hain.**
- **loadingIndicator initialize hota hai.**
- **Footer add hota hai (copyright + website link).**
- **Event handlers set hotay hain sendButton aur inputField ke liye.**
- **Scene create hoti hai aur stage pe show hoti hai.**
- **Welcome message show hota hai.**

---

## 5. **handleUserInput()**
Yeh method tab call hota hai jab user message bhejta hai.

- User ka input field se text leta hai.
- Agar empty nahi hai:
  - Message chat mein add karta hai (addMessage).
  - Input field aur button disable karta hai, loading spinner show karta hai.
  - Gemini API ko request bhejta hai (getGeminiResponse).
  - AI ka response chat mein add karta hai.
  - Sab kuch wapas enable karta hai.

---

## 6. **getGeminiResponse(String userInput)**
Yeh method Gemini API ko HTTP POST request bhejta hai.

- JSON body banata hai user ke message ke sath.
- HTTP request create karta hai aur bhejta hai.
- Response ko JSON mein parse karta hai.
- AI ka response extract karta hai aur return karta hai.

---

## 7. **addMessage(String sender, String message)**
Yeh method chat mein message add karta hai.

- HBox banata hai message ke liye.
- Agar sender "Syrex" hai to Syrex ka icon bhi add karta hai.
- Styling set karta hai (user aur bot ke liye alag).
- Message chatContainer mein add karta hai.
- ScrollPane ko bottom pe scroll karta hai.

---

## 8. **main(String[] args)**
Yeh JavaFX app ko launch karta hai.

---

## **Kuch Important JavaFX Keywords**
- **VBox, HBox:** Layouts hain, vertical ya horizontal items arrange karte hain.
- **Scene:** JavaFX ka main container hai jo stage pe show hota hai.
- **Stage:** Window ko represent karta hai.
- **TextField, Button, Label:** UI controls hain.
- **setOnAction:** Event handler set karta hai jab koi action hota hai (jaise button click).
- **setStyle:** CSS ki tarah styling apply karta hai.

---

## **Summary**
- App start hota hai, window open hoti hai, logo aur chat area show hota hai.
- User message type karta hai, send karta hai.
- Message chat mein show hota hai, AI se response aata hai, woh bhi chat mein show hota hai.
- Sab kuch JavaFX ke layouts aur controls se manage hota hai.
- Gemini API se AI response milta hai.


---

### **Maven kya hai aur is project mein kyun use kiya?**
- **Maven** ek build automation tool hai jo Java projects ko manage karne, build karne, aur dependencies (libraries) ko handle karne ke liye use hota hai.
- Is project mein Maven use kiya gaya hai taake:
  - Sare required libraries (jaise JavaFX, dotenv, org.json) automatically download ho jayein.
  - Project ko easily compile, run, aur package kiya ja sake.
  - Build process standard ho aur kisi bhi machine pe repeatable ho.

---

### **pom.xml file kya karti hai?**
- **pom.xml** Maven ka main configuration file hai.
- Is file mein:
  - Project ka naam, version, aur author info hoti hai.
  - Konsi dependencies (external libraries) chahiyein, woh list hoti hain.
  - Build instructions, plugins, aur project settings define hoti hain.
- Jab aap `mvn install` ya `mvn package` chalate hain, Maven isi file ko follow karta hai.

---

### **target folder mein kya hota hai?**
- **target** folder Maven ke build ke baad automatically banta hai.
- Isme:
  - Compiled classes (jaise `.class` files) hoti hain.
  - Final jar file (jaise `syrextech-chatbot-1.0-SNAPSHOT.jar`) hoti hai, jo run karne ke liye use hoti hai.
  - Temporary build files, reports, aur generated sources bhi yahin store hote hain.

---

### **Project Directory Structure ka explaination:**

- **pom.xml**  
  Maven ka configuration file (project settings, dependencies, build instructions).

- **README.md**  
  Project ka overview aur instructions.

- **vivaPrep.md**  
  Aapke viva ke notes.

- **src/main/java/com/example/**  
  - **SyrexTech.java**: Main Java code (chatbot ka logic).
  - **Syrex.png, SyrexTech.png**: Images (logo, etc).

- **target/**  
  - **syrextech-chatbot-1.0-SNAPSHOT.jar**: Final build jar file.
  - **classes/com/example/SyrexTech.class**: Compiled Java class files.
  - **generated-sources/**: Maven ke dwara generate ki gayi source files.
  - **maven-archiver/**, **maven-status/**: Build process ki metadata files.

---

### 1. **HttpClient, HttpRequest, HttpResponse**
- **HttpClient:**  
  Java ka ek object hai jo internet par request bhejne ke liye use hota hai. Iska kaam hai server se baat karna, jaise ke AI API ko message bhejna.
- **HttpRequest:**  
  Yeh ek request ka object hai, jismein aap batate hain ke kahan (kaunsi URL pe) aur kya (kaunsa data) bhejna hai.
- **HttpResponse:**  
  Jab aap request bhejte hain, to server se jo jawab aata hai, woh HttpResponse object mein milta hai.

---

### 2. **setVgrow**
- **VBox.setVgrow(chatScrollPane, Priority.ALWAYS);**  
  JavaFX ka layout ka function hai. Iska matlab hai ke jab window ka size change ho, to chatScrollPane ko hamesha zyada space milay.  
  "Vgrow" ka matlab hai "Vertical Grow" — yani vertically space ko adjust karna.

---

### 3. **throws Exception**
- **private String getGeminiResponse(String userInput) throws Exception**  
  Jab method ke aage "throws Exception" likha ho, iska matlab hai ke agar is method mein koi error aaye (jaise internet ka masla, ya API ka response na aaye), to yeh error aage bhej dega.  
  Yani, method ke andar koi bhi exception aaye to usko handle karne ki zimmedari method ko call karne wale pe hai.

---

### 4. **static**
- **static** keyword ka matlab hai ke yeh variable ya method class ke sath belong karta hai, na ke kisi object ke sath.  
  Jaise: `static final String API_KEY` — yeh har object ke liye alag nahi, balkay class ke liye ek hi hota hai.

---

### 5. **final**
- **final** ka matlab hai ke is variable ki value sirf ek dafa set ho sakti hai, baad mein change nahi ho sakti.

---

### 6. **extends**
- **public class SyrexTech extends Application**  
  "extends" ka matlab hai ke SyrexTech class, Application class ki properties aur methods inherit kar rahi hai.  
  Yani, SyrexTech bhi ek Application hai, aur uske saare features use kar sakti hai.

---

### 7. **@Override**
- Yeh ek annotation hai jo batata hai ke yeh method parent class (Application) ka method override kar raha hai.  
  Jaise: `@Override public void start(Stage primaryStage)`

---

### 8. **try-catch**
- **try-catch** block error handle karne ke liye hota hai.  
  "try" mein code likhte hain jo error de sakta hai, aur "catch" mein likhte hain ke agar error aaye to kya karna hai.

---

### 9. **JSONArray, JSONObject**
- Yeh classes JSON data (jo API se aata hai) ko parse karne aur usmein se data nikalne ke liye use hoti hain.

---

### 10. **bind**
- **chatScrollPane.vvalueProperty().bind(chatContainer.heightProperty());**  
  "bind" ka matlab hai ke jab bhi chatContainer ki height change ho (naye message ki wajah se), to scrollPane apne aap neeche scroll ho jaye.

---

### 11. **setOnAction**
- Yeh method kisi button ya field pe event lagata hai, jaise button click ya enter press hone par koi function call ho.

---


---
---

## SyrexTech JavaFX Chatbot Viva – Advanced Q&A

### 1. **JavaFX Application ka flow kya hota hai?**
**A:** JavaFX app ka flow start() method se hota hai, jo Application class ko extend karte hue override kiya jata hai. Yahan se UI initialize hoti hai aur stage pe scene set hota hai.

---

### 2. **Dotenv library ka kya role hai is project mein?**
**A:** Dotenv .env file se environment variables (jaise API key aur API URL) load karta hai, taake sensitive info code mein hardcode na ho.

---

### 3. **HttpClient, HttpRequest, aur HttpResponse ka istemal kaise ho raha hai?**
**A:** HttpClient object API se baat karne ke liye use hota hai. HttpRequest se POST request banti hai, aur HttpResponse se server ka jawab receive hota hai.

---

### 4. **getGeminiResponse() method ka detailed flow samjhayen.**
**A:** Is method mein user ka input JSON format mein Gemini API ko bheja jata hai, response receive hota hai, phir JSON parse karke AI ka jawab extract kiya jata hai.

---

### 5. **JavaFX mein VBox aur HBox ka kya farq hai?**
**A:** VBox vertical direction mein nodes arrange karta hai, jabke HBox horizontal direction mein.

---

### 6. **ScrollPane ka kya role hai chat mein?**
**A:** ScrollPane chatContainer ko wrap karta hai, taake jab messages zyada ho jayein to user scroll kar sake.

---

### 7. **@Override annotation ka kya matlab hai?**
**A:** Yeh batata hai ke method parent class ka method override kar raha hai, jaise start() method Application class ka.

---

### 8. **static aur final keywords ka kya use hai?**
**A:** static ka matlab hai variable ya method class level pe hai, object level pe nahi. final ka matlab hai value sirf ek dafa set ho sakti hai, change nahi ho sakti.

---

### 9. **Exception handling kaise ki gayi hai?**
**A:** try-catch blocks use kiye gaye hain, taake agar API call ya file loading mein error aaye to user ko friendly message milay.

---

### 10. **JavaFX mein event handling kaise hoti hai?**
**A:** setOnAction method se button ya input field pe event listener lagaya jata hai, jo user ke action pe method call karta hai.

---

### 11. **ProgressIndicator ka kya role hai?**
**A:** Jab tak AI ka response nahi aata, tab tak loading spinner show hota hai, taake user ko pata chale ke process ho raha hai.

---

### 12. **JSON parsing kaise ho rahi hai?**
**A:** org.json.JSONObject aur JSONArray classes se API ka response parse kiya jata hai, aur required data extract kiya jata hai.

---

### 13. **SyrexTech class Application ko kyun extend kar rahi hai?**
**A:** Application JavaFX ka base class hai, isko extend karne se hum apni custom GUI app bana sakte hain.

---

### 14. **bind() method ka kya use hai chatScrollPane mein?**
**A:** bind() se jab bhi chatContainer ki height change ho (naya message aaye), scrollPane apne aap neeche scroll ho jata hai.

---

### 15. **Scene aur Stage mein kya farq hai?**
**A:** Stage JavaFX ka main window hai, Scene us window ka content (UI tree) hai.

---

### 16. **Syrex logo kaise load ho raha hai?**
**A:** Image aur ImageView classes se logo file load hoti hai, agar file na mile to catch block mein error print hota hai.

---

### 17. **API key aur URL secure rakhne ka kya tareeqa hai?**
**A:** Inko .env file mein rakha gaya hai, taake code public ho to bhi sensitive info leak na ho.

---

### 18. **handleUserInput() method ka step-by-step flow kya hai?**
**A:** User ka input check hota hai, message chat mein add hota hai, input disable hota hai, API call hoti hai, response milta hai, sab kuch wapas enable hota hai.

---

### 19. **JavaFX mein CSS style kaise apply ki ja rahi hai?**
**A:** setStyle() method se inline CSS properties directly Java code mein apply ki ja rahi hain.

---

### 20. **main() method ka kya role hai?**
**A:** main() method se JavaFX application launch hoti hai, yeh Application class ka launch() method call karta hai.

---

### 21. **Hyperlink kaise kaam kar raha hai footer mein?**
**A:** Hyperlink pe setOnAction lagaya gaya hai, jo click pe default browser mein website open karta hai.

---

### 22. **Why is Gemini API used and how is it integrated?**
**A:** Gemini API AI chatbot ke liye use ho rahi hai. User ka message API ko POST request se bheja jata hai, aur AI ka jawab receive hota hai.

---

### 23. **What is the use of Priority.ALWAYS in VBox.setVgrow()?**
**A:** Yeh ensure karta hai ke chatScrollPane ko hamesha available vertical space milay, taake chat area flexible ho.

---

### 24. **What is the difference between Label and Text in JavaFX?**
**A:** Label ek control hai jo text display karta hai aur user interaction handle kar sakta hai, jabke Text ek simple node hai jo sirf text show karta hai.

---

### 25. **How does the application handle API errors or no response?**
**A:** Agar API se response na aaye ya error ho, to catch block mein user ko error message show hota hai.

