# Remitly Internship 2024 Task
## CheckJSON - Sprawdzanie poprawności JSON


## Opis
CheckJSON to prosty program napisany w języku Java, który umożliwia walidację i analizę struktury plików JSON. Program sprawdza, czy podany plik JSON spełnia określone wymagania dotyczące właściwości `PolicyDocument` i `PolicyName`. Dodatkowo, program sprawdza obecność oraz poprawność pola `Resource` w strukturze JSON. Jeżeli pole `Resource` zawiera pojedynczy znak `*` - program zwraca wartość `True`. W każdym innym przypadku program zwraca wartość `False`. W zadaniu zadbano o obsługę błędów, uwzględnienie przypadków krawędziowych oraz zaimplementowano testy jednostkowe. Program poza boolowską wartością `True` lub `False` zwraca również informację o błedzie lub poprawności wejściowego JSON'a.


## Uruchomienie
Aby uruchomić program, wykonaj następujące kroki:

### 1. Pobranie projektu
Skopiuj lub pobierz repozytorium z projektem na swój lokalny komputer.

    git clone https://github.com/m-bugaj/Remitly-Internship-2024-Task.git

### 2. Przygotowanie środowiska
Upewnij się, że masz zainstalowane wymagane narzędzia:

- Java Development Kit (JDK)
- Apache Maven

### 3. Uruchomienie projektu w IntelliJ IDEA

W IntelliJ IDEA otwórz projekt `File` -> `Open`. Następnie wybierz najbardziej wewnętrzny katalog `Remitly-Internship-2024-Task` 

### 4. Uruchomienie testów jednostkowych
Przejdź do katalogu `src` i uruchomić program klikając przycisk "Run". Upewnij się, że masz otwartą klasę `CheckJSONTest`.

### 5. Uruchomienie programu
Aby uruchomić program na własnym pliku JSON, edytuj plik `input/input.json` zgodnie z własnymi wymaganiami.
Przejdź do katalogu `src` i uruchomić program klikając przycisk "Run". Upewnij się, że masz otwartą klasę `CheckJSON`.
