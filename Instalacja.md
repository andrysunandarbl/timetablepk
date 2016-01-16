Time Table PK



# Instalacja Aplikacji #

Aplikacja TimeTable PK wykorzystuje następujące technologie:

  * Bazę danych PostgreSQL
  * Apache Wicket
  * Hibernate
  * Maven
  * Java SE JDK
  * Eclipse
  * Serwer Aplikacji Jetty

Choć kilka z tych technologi nie jest niezbędnych do działania aplikacji to ta dokumentacja opisuje jak zainstalować aplikacje tak, aby mieć możliwość edycji kodu.

## Maven ##

Na początku należy pobrać i zainstalować Apache Maven.

Maven jest narzędziem do automatycznego budowania oprogramowania.

Można pobrać Apache Maven ze strony http://maven.apache.org/downloads.html

Instalacja Maven'a polega na wypakowaniu go do wybranego katalogu a następnie na dodaniu katalogu bin do ścieżki systemowej poleceniem set PATH=PATH;_ścieżka do katalogu bin instalacji Maven'a_;

Można teraz sprawdzić poprawność wpisując w konsoli systemu polecenie _mvn -version_.<br />
Jeśli pokazał się komunikat z informacją o wersji Maven'a to wykonaliśmy wszystko poprawnie.

## Eclipse ##

Eclipse jest środowiskiem IDE dla języka Java oraz wielu innych języków i frameworków.

Eclipse IDE należy pobrać ze strony http://eclipse.org/downloads/

Dla potrzeb Aplikacji TimeTable PK w zupełności wystarczy wersja podstawowa: Eclipse IDE for Java Developers

Po pobraniu i rozpakowaniu, uruchamiany Eclipse. W menu _Help_ wybieramy _Install new software..._

W oknie _work with:_ wpisujemy adres:

update site: http://www.laughingpanda.org/svn/wicket-bench/trunk/wicket-bench-site

po wciśnięciu entera pojawi się opcja wicket-brench - zaznaczamy ją i pobieramy.

Eclipse po popraniu poprosi o ponowne uruchomienie. W ten sam sposób instalujemy jeszcze:
  * Maven Plugin: http://m2eclipse.sonatype.org/update/

Następnie w _Package Explorer_ klikamy PPM i wybieramy _import_.

w oknie importu wybieramy _general_ a następnie: _Existing projekt into workspace_

W kolejnym oknie wybieramy katalog z projektem TimeTable PK i importujemy go.

## PostgreSQL ##

PostgreSQL jest darmową bazą danych, jedną z najlepszych dostępnych na rynku aplikacji tego typu.

Instalacja PostgreSQL nie przysparza problemów, w środowisku Windows można się ograniczyć
do instalacji uproszczonej i klikania _dalej_.

Po zainstalowaniu PostgreSQL, uruchamiamy aplikacje pgAdminIII.

W tej aplikacji jeśli w oknie obiektów nie ma żadnych serwerów, to klikamy na ikonę z wtyczką.

Pozostawiany wszystkie wartości domyślne, a login i hasło podajemy takie jak przy instalacji bazy.

Po dodaniu serwer pojawi się w oknie obiektów. Klikamy na nazwę serwera i rozwijamy jego zawartość.

Klikając PPM na _Zarejestrowane Role_ wybieramy _dodaj nowy login_ i tworzymy nowego użytkownika, dodając mu pełne prawa tworzenia tabel, modyfikacji i wykonywania zapytań.

Pamiętajmy aby użytkownika wraz z hasłem wpisać do pliku _timetablepk\target\classes\hibernate.cfg.xml_

Następnie klikamy PPM na _bazy danych_ i tworzymy nową bazę o nazwie: _timetabledb_.

Bazę tą przypisujemy do stworzonego wcześniej użytkownika.

## Instalacja i uruchomienie projektu ##

w oknie konsoli systemu przechodzimy do katalogu projektu. W konsoli wpisujemy polecenie:

_mvn eclipse:eclipse install_

To polecenie może się wykonywać przez dłuższy czas, gdyż teraz Maven pobiera potrzebne pliki. Po zakończeniu sukcesem, wpisujemy polecenie _mvn jetty:run_ spowoduje to uruchomienie aplikacji.

Aplikacja jest teraz dostępna z poziomu przeglądarki www pod adresem:

http://127.0.0.1:8080/timetablepk

Wystarczy zalogować się aby móc korzystać z TimeTable PK.