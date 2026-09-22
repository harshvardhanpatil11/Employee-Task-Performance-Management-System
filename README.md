# Employee Task & Performance Management System

Taskflow is a Java web application for organizing employees, departments, tasks, and team performance. It uses JSP and Java Servlets for the web interface and controllers, JDBC for database access, and MySQL for storage.

> This repository uses standard Java web technologies. It does not use Maven, Spring, REST APIs, Hibernate, or JPA.

## Features

### Roles and access

- **Admin:** dashboard, employee directory, employee account management, department management, and task oversight.
- **Manager:** team task dashboard, task creation and assignment, and task progress monitoring.
- **Employee:** assigned task list, task status updates, and personal task performance summary.
- Login sessions, role checks, and logout.

### Tasks and performance

- Create tasks with title, description, priority, assignee, start date, and due date.
- Employees can set task status to Pending, In Progress, or Completed.
- Dashboard cards show task totals, status counts, overdue work, and completion percentage.
- The database schema includes a task remarks table and a performance summary table.

## Technology

- Java 17+
- JSP and Jakarta Servlets
- JDBC
- MySQL 8+ (MariaDB may also work)
- Apache Tomcat 10.1
- HTML, CSS, JavaScript, and Bootstrap 5

## Project layout

```text
database/schema.sql                         Database and table definitions
src/main/java/com/etpms/                    Servlets, filters, and application listener
src/main/java/com/etpms/dao/                JDBC data access
src/main/java/com/etpms/model/              Application models
src/main/java/com/etpms/util/               Database and password utilities
src/main/webapp/WEB-INF/views/               JSP pages
src/main/webapp/assets/                      Stylesheets and JavaScript
build.ps1                                    Windows WAR build script
```

## Requirements

- JDK 17 or newer
- Apache Tomcat 10.1
- MySQL Server 8 or a compatible MySQL database
- MySQL Connector/J driver
- PowerShell on Windows to use the included `build.ps1`

## Setup and run on Windows

### 1. Create the database

From the project root, run the schema script. Add `-p` if your MySQL root account has a password:

```powershell
mysql -u root -e "source database/schema.sql"
```

### 2. Set the local tool paths

Download and extract a JDK, Tomcat, and MySQL Connector/J if they are not already installed. Set these paths in PowerShell; replace the example paths with the locations on your computer:

```powershell
$jdk = 'C:\tools\jdk-17'
$tomcat = 'C:\tools\apache-tomcat-10.1'
$connector = 'C:\tools\mysql-connector-j.jar'

$env:JAVA_HOME = $jdk
$env:PATH = "$jdk\bin;$env:PATH"
```

### 3. Build and deploy

Run the build script from the project root. It compiles the Java source, packages the web application, and includes Connector/J in the WAR:

```powershell
.uild.ps1 -TomcatHome $tomcat -MySqlConnector $connector
Copy-Item .\build\etpms.war "$tomcat\webapps\etpms.war" -Force
```

### 4. Configure the database and start Tomcat

Set the database connection values in the same PowerShell window. Use your MySQL account and password:

```powershell
$env:ETPMS_DB_URL = 'jdbc:mysql://localhost:3306/etpms?useSSL=false&serverTimezone=UTC'
$env:ETPMS_DB_USER = 'root'
$env:ETPMS_DB_PASSWORD = 'your-mysql-password'

$env:CATALINA_HOME = $tomcat
$env:CATALINA_BASE = $tomcat
& "$tomcat\bin\catalina.bat" run
```

Keep this window open while the server runs. Press **Ctrl+C** in the window to stop Tomcat. If port `8080` is already in use, change the connector port in `$tomcat\conf\server.xml` and use the new port in the URL.

### 5. Open the application

Visit [http://localhost:8080/etpms/login](http://localhost:8080/etpms/login).

## Demo accounts

On the first startup with an empty `users` table, the application creates these demo accounts:

| Role | Username | Password |
|---|---|---|
| Admin | `admin` | `pass@123` |
| Manager | `manager` | `pass@123` |
| Employee | `employee` | `pass@123` |

The demo accounts are for local development only. The application automatically creates them when the `users` table is empty, so do not expose an unmodified deployment to a public network or use these accounts for real organizational data.

Passwords are stored as salted PBKDF2-HMAC-SHA256 hashes. The initial demo users are created by `UserDAO.ensureDemoUsers()` in the application listener.

## Current scope

The current UI supports employee create, edit, and delete; department create and delete; task creation and assignment; and employee task status updates. Task remarks and task history are represented in the database design but are not yet exposed as workflows in the UI. Editing existing task details and editing department details are also not currently implemented.

## Configuration

The database connection can be customized with environment variables:

| Variable | Default |
|---|---|
| `ETPMS_DB_URL` | `jdbc:mysql://localhost:3306/etpms?useSSL=false&serverTimezone=UTC` |
| `ETPMS_DB_USER` | `root` |
| `ETPMS_DB_PASSWORD` | Empty password |

Avoid committing database passwords or other secrets to GitHub.
