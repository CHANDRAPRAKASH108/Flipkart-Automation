# Flipkart Automation Testing Project

This project is a **Test Automation Framework** for Flipkart, utilizing **Selenium WebDriver, TestNG, Extent Reports, and Docker**. It runs tests using **Selenium Grid in Docker** and supports execution via **GitHub Actions**.

## 📌 Features
- **Automated UI Testing** using **Selenium WebDriver**
- **Parallel execution** with **Selenium Grid (Docker)**
- **Reports & Logs** with **Extent Reports & Log4j**
- **CI/CD Integration** via **GitHub Actions**
- **Scheduled Execution** daily at **8:30 PM UTC**

---

## 🛠️ Setup Instructions

### **1️⃣ Prerequisites**
- Install **Java 19**
- Install **Maven**
- Install **Docker & Docker Compose**

### **2️⃣ Clone the Repository**
```sh
git clone https://github.com/your-repo/flipkartAutomation.git
cd flipkartAutomation
```

### **3️⃣ Start Selenium Grid (Docker)**
```sh
docker-compose up -d
```

### **4️⃣ Run Test Cases**
```sh
mvn test -DsuiteXmlFile=testng.xml
```

### **5️⃣ Stop Selenium Grid**
```sh
docker-compose down
```

---

## 🏃‍♂️ Running Tests with GitHub Actions

### **Manual Trigger**
You can trigger the test run manually from GitHub Actions.

### **Scheduled Execution**
- The tests **run automatically every day at 8:30 PM UTC** via **GitHub Actions**.
- The workflow is defined in `.github/workflows/selenium-tests.yml`.

---

## 📊 Test Reports & Logs
- **Extent Reports** are generated at `extent-test-output/Index.html`.
- **Logs** are available in the `logs` directory.

To retrieve the test report after execution:
1. Navigate to GitHub Actions.
2. Select the latest run.
3. Download the **Extent-Report** artifact.

---

## 🛠️ Project Structure
```
flipkartAutomation/
├── src/
│   ├── main/java/  # Page Objects & Utilities
│   ├── test/java/  # Test Cases
│   ├── resources/  # Configuration files
│
├── extent-test-output/  # Test Reports
├── logs/  # Log Files
├── testng.xml  # Test Suite Configuration
├── docker-compose.yml  # Selenium Grid Setup
├── pom.xml  # Maven Dependencies & Build Config
├── .github/workflows/selenium-tests.yml  # GitHub Actions Workflow
```

---

## 🚀 CI/CD Pipeline (GitHub Actions)
The GitHub Actions workflow:
1. **Checks out code** from GitHub.
2. **Sets up Java 19**.
3. **Starts Selenium Grid (Docker Compose)**.
4. **Executes TestNG Tests**.
5. **Stops Selenium Grid**.
6. **Uploads Extent Report as an artifact**.

---

## ❓ Troubleshooting
### **Docker not found?**
Ensure Docker is installed and running.
```sh
docker --version
docker-compose --version
```

### **Invalid Target Release: 19?**
Ensure Java 19 is installed:
```sh
java -version
```
If not, install Java 19 and set it as the default version.

### **Tests not logging?**
Check `logback.xml` and ensure `log4j-core` is included in `pom.xml`.

---

## 🤝 Contribution
1. Fork the repository
2. Create a new branch (`feature-xyz`)
3. Commit your changes
4. Push to the branch
5. Open a Pull Request

---

## 📜 License
This project is **open-source**

Happy Testing! 🚀

