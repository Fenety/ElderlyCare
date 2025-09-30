# 🧓 Elderly Care Management System 

## 📖 Description
The **Elderly Care Management System (ECMS)** is a mobile application built using **Kotlin** and **Jetpack Compose** that helps doctors, nurses, patients, and family members monitor elderly health care more effectively.  

The system allows tracking of **daily health records, medical history, and user management** with a secure, role-based interface. It applies a clean **MVVM architecture** to ensure scalability, maintainability, and testability.  

---

## ✨ Core Features

### 🩺 Improvement Monitoring
- **Create** ➤ Nurses add daily health records (vital signs, symptoms, progress).  
- **Read** ➤ Family members and doctors view patient health history.  
- **Update** ➤ Nurses modify or correct health records.  
- **Delete** ➤ Admin removes records when necessary.  

### 📑 Medical History & Reports
- **Create** ➤ Nurses or doctors upload medical test results and reports.  
- **Read** ➤ Patients, family members, and doctors access reports anytime.  
- **Update** ➤ New test results replace outdated ones.  
- **Delete** ➤ Admin removes outdated or irrelevant reports.  

### 👥 User Management
- **Create** ➤ Admin registers new users (nurses, doctors, family members).  
- **Read** ➤ Nurses view their profiles and assigned roles.  
- **Update** ➤ Admin updates roles, permissions, or account details.  
- **Delete** ➤ Admin removes inactive or unauthorized users.  

---

## 🛠️ Frontend Architecture (Kotlin + Jetpack Compose)

The frontend of ECMS is built with a **modular MVVM architecture**:  

### 🏗️ Layers
- **UI Layer (Jetpack Compose)**  
  - Screens: `HealthRecordsScreen`, `ReportsScreen`, `UserManagementScreen`  
  - Uses `@Composable` functions to declaratively build UI.  
  - UI state managed via **StateFlow / LiveData**.  

- **ViewModel Layer**  
  - Holds UI state and exposes data to the UI.  
  - Handles user interactions (create, read, update, delete).  
  - Communicates with the repository for data.  

- **Repository Layer**  
  - Abstracts data sources (local Room DB + remote API).  
  - Ensures the UI doesn’t directly depend on data source implementations.  

- **Data Layer**  
  - **Room Database**: Stores health records, reports, and users for offline access.  
  - **Retrofit (if integrated)**: Handles API calls to sync with backend.  
  - **Data Models**: Kotlin data classes represent entities (e.g., `HealthRecord`, `MedicalReport`, `User`).  

---

## 🖥️ Tech Stack
- **Language**: Kotlin  
- **UI**: Jetpack Compose + Material 3  
- **Architecture**: MVVM + Repository Pattern  
- **State Management**: StateFlow / LiveData  
- **Database**: Room  
- **Networking (optional)**: Retrofit + Coroutines  
- **Dependency Injection**: Hilt / Koin (optional)  
