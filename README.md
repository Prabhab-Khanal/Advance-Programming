

# README — How to Run

## Prerequisites

* **JDK 11** (or 8)
* **Apache Tomcat 9.x** (use 9, not 10—Tomcat 10+ uses `jakarta.*` while many legacy projects use `javax.*`)
* **MySQL 8** (or MariaDB)
* **Eclipse IDE for Enterprise Java** (recommended)
* **MySQL Connector/J** (JDBC driver JAR)

---

## 1) Clone the project

```bash
git clone <repo-url>.git
cd StarStore
```

---

## 2) Create the database

1. Start MySQL.
2. Create a database and import the SQL dump:

   ```bash
   mysql -u root -p -e "CREATE DATABASE starstore DEFAULT CHARACTER SET utf8mb4;"
   mysql -u root -p starstore < StarStore.sql
   ```

> If the dump defines a different DB name, use that. Otherwise `starstore` is fine.

---

## 3) Configure DB credentials (JDBC)

Open `src/main/java/database/DatabaseController.java` and set the JDBC URL, user, and password to match your local MySQL:

```java
// Example values – adjust to your environment
private static final String URL  = "jdbc:mysql://localhost:3306/starstore?useSSL=false&serverTimezone=UTC";
private static final String USER = "root";
private static final String PASS = "your_mysql_password";
```

> If the code reads from environment variables or a properties file, set those instead.
> Make sure **MySQL Connector/J** is available:
>
> * Put the JAR in `webapp/WEB-INF/lib/`, **or**
> * Add it to the project’s **Build Path**, **and/or**
> * Drop it into `TOMCAT_HOME/lib/`

---

## 4) Run in Eclipse (recommended)

1. Open **Eclipse** → **File → Import → Existing Projects into Workspace** → select the `StarStore` folder.
2. Install **Tomcat 9** in Eclipse: **Window → Preferences → Server → Runtime Environments → Add → Apache Tomcat v9.0** and point to your Tomcat folder.
3. Right-click project → **Properties → Targeted Runtimes** → check **Apache Tomcat v9.0**.
4. Ensure **Java Build Path** includes **MySQL Connector/J** JAR (and it’s also under **Deployment Assembly** or in `WEB-INF/lib`).
5. Right-click project → **Run As → Run on Server** → choose **Tomcat v9.0**.

Access the app at:
**[http://localhost:8080/StarStore/](http://localhost:8080/StarStore/)**
(or whatever context path Eclipse assigns; sometimes just `/`).

---

## 5) Run by WAR deployment (alternative)

1. In Eclipse: **Right-click project → Export → WAR file**, e.g. `StarStore.war`.
2. Copy the WAR to `TOMCAT_HOME/webapps/`.
3. Start Tomcat:

   ```bash
   # Linux/macOS
   $CATALINA_HOME/bin/startup.sh

   # Windows
   %CATALINA_HOME%\bin\startup.bat
   ```
4. Visit **[http://localhost:8080/StarStore/](http://localhost:8080/StarStore/)**

> Ensure **MySQL Connector/J** is available at runtime (either inside `WEB-INF/lib` in the WAR or in `TOMCAT_HOME/lib`).

---

