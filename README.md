# Parabank UI Automation Testing

Proyek ini adalah framework otomasi pengujian UI untuk website **ParaBank** menggunakan **Java**, **Selenium WebDriver**, dan **Cucumber (BDD)**.

## 🚀 Fitur yang Diuji
* **Registrasi Akun:** Validasi pendaftaran berhasil dan penanganan error kata sandi tidak cocok.
* **Login:** Validasi login berhasil (Positive) dan gagal (Negative).

## 🛠️ Tech Stack
* **Language:** Java 25
* **Automation:** Selenium WebDriver
* **BDD Framework:** Cucumber
* **Test Runner:** JUnit 4
* **Build Tool:** Maven

## 📂 Struktur Proyek
* `src/test/resources/features`: Berisi skenario pengujian dalam bahasa Gherkin (.feature).
* `src/test/java/MyStepDef`: Berisi implementasi kode dari langkah-langkah Gherkin.
* `src/test/java/runner`: Berisi TestRunner untuk mengeksekusi tes.

## 🏃 Cara Menjalankan Tes
1. Clone repository ini.
2. Pastikan Google Chrome terinstal di komputer Anda.
3. Buka proyek di IntelliJ IDEA.
4. Update dependencies menggunakan Maven: `mvn clean install`.
5. Jalankan file `TestRunner.java`.

## 📊 Laporan Pengujian
Setelah tes selesai dijalankan, laporan akan otomatis dibuat di:
`target/cucumber-report.html`