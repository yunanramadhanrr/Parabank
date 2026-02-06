# 🧪 ParaBank Automation Testing (BDD Framework)

Proyek ini adalah framework otomatisasi pengujian untuk website **ParaBank** menggunakan pendekatan **Behavior-Driven Development (BDD)**. Framework ini dirancang agar mudah dibaca oleh tim bisnis namun tetap teknis untuk tim pengembang.

## 🚀 Fitur Utama
- **BDD Implementation**: Menggunakan Cucumber dengan Gherkin dalam Bahasa Indonesia.
- **Robust Locators**: Penggunaan ID, CSS Selectors, dan XPath yang efisien.
- **Hooks Management**: Penanganan otomatis pembukaan dan penutupan browser (`@Before` & `@After`).
- **Data-Driven Testing**: Implementasi `DataTable` untuk menangani banyak input data sekaligus.

## 🛠️ Teknologi yang Digunakan
* **Bahasa Pemrograman**: Java 17+
* **Automasi Browser**: Selenium WebDriver
* **Test Runner**: JUnit 4
* **BDD Framework**: Cucumber
* **Dependency Management**: Maven
* **Driver Management**: WebDriverManager

## 📁 Struktur Proyek
```text
src/test/java
├── MyStepDef       # Logika langkah pengujian & Hooks
├── runner          # Pemicu eksekusi pengujian (TestRunner)
src/test/resources
└── features        # Skenario pengujian (Gherkin .feature)