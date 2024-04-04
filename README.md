# CheckJSON - Sprawdzanie poprawności JSON

## Opis
CheckJSON to prosty program napisany w języku Java, który umożliwia walidację i analizę struktury plików JSON. Program sprawdza, czy podany plik JSON spełnia określone wymagania dotyczące właściwości `PolicyDocument` i `PolicyName`. Dodatkowo, program sprawdza obecność oraz poprawność pola `Resource` w strukturze JSON. Jeżeli pole `Resource` zawiera pojedynczy znak `*` - program zwraca wartość `True`. W każdym innym przypadku program zwraca wartość `False`.

## Uruchomienie
Aby uruchomić program, wykonaj następujące kroki:

### 1. Pobranie projektu
Skopiuj lub pobierz repozytorium z projektem na swój lokalny komputer.

    git clone https://github.com/m-bugaj/Remitly-Internship-2024-Task.git

### 2. Przygotowanie środowiska
Upewnij się, że masz zainstalowane wymagane narzędzia:

- Java Development Kit (JDK)
- Apache Maven

### 3. Uruchomienie testów jednostkowych
Przejdź do głównego katalogu projektu i wykonaj polecenie Maven, aby uruchomić testy jednostkowe:

    cd Remitly-Internship-2024-Task
    mvn test

### 4. Uruchomienie programu
Aby uruchomić program na własnym pliku JSON, edytuj plik `input/input.json` zgodnie z własnymi wymaganiami. Następnie możesz użyć jednego z poniższych sposobów:

- **Uruchomienie z linii poleceń:**

  ```bash
  mvn exec:java -Dexec.mainClass="CheckJSON"
  ```

lub

  ```bash
  java -cp target/classes CheckJSON
  ```

Uruchomienie za pomocą IntelliJ IDEA:

W IntelliJ IDEA możesz uruchomić program klikając przycisk "Run" lub używając skrótu klawiszowego Shift + F10. Upewnij się, że masz zdefiniowaną konfigurację uruchamiania dla klasy CheckJSON.
