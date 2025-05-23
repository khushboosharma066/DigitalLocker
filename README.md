# DigitalLocker
# 🔐 Digital Locker System – Java File Handling Project

## 📌 Overview

The **Digital Locker System** is a Java-based console project that simulates a secure system where users can **register**, **log in**, **upload documents**, and **view uploaded documents**. It uses core Java concepts like classes, file handling, and user authentication (text file-based).

This is a great beginner-friendly project for learning how file handling works in Java.

---

## 🛠️ Features

- 👤 **User Registration**  
  - Creates a new user by saving login credentials securely (in a text file).

- 🔐 **User Login**  
  - Verifies credentials before allowing access.

- 📤 **Upload Document**  
  - Lets users create and store a new file inside their personal locker folder.

- 📄 **View Documents**  
  - Shows a list of all documents uploaded by the logged-in user.

---

## ⚙️ Technologies Used

- Java (JDK 8 or higher)
- File Handling (java.io)
- Object-Oriented Programming
- Console-based UI

---

## 📦 Project Structure

```bash
DigitalLockerSystem/
├── src/
│   ├── Main.java
│   ├── User.java
│   ├── AuthManager.java
│   └── LockerManager.java
├── locker_files/           # Folder containing user-specific folders
├── users.txt               # Stores registered usernames & passwords
├── README.md


🚀 How to Run
1. Clone the Repository
git clone https://github.com/your-username/DigitalLockerSystem.git
cd DigitalLockerSystem


2. Compile the Code
javac -d bin src/*.java


3. Run the App
java -cp bin Main


🧑‍💻 How to Use
When the app starts, you'll see:
Welcome to Digital Locker System
1. Register
2. Login
3. Exit



📝 Register
Choose 1 to register a new user.

Enter a username and password.

A new folder is created for your documents.

🔐 Login
Choose 2 and enter your registered credentials.

Once logged in, a new menu appears:
1. Upload Document
2. View Documents
3. Logout
📤 Upload Document
Enter the file name and content.

A new text file is created in your personal folder.

📄 View Documents
Lists all documents you've uploaded.

✅ Requirements
Java JDK 8 or higher

Command Line / Terminal

No external libraries

👨‍🎓 Project Contributors
Admin: Khushboo Sharma (24SCSE1180286)

Members:

Krishna Sharma (24SCSE1180453)

Namrita (24SCSE1180013)

Piyush Kumar (24SCSE1180688)


