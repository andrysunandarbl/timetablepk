Time Table PK

# Funkcjonalności Interfejsu Time Table PK #



Zgodnie z założeniem projektu mamy możliwość wpisywania danych do bazy za pomocą
odpowiednich interfejsów.


W głównym oknie aplikacji użytkownik ma do wyboru kilka opcji.
Po kolei od góry są to pozycje menu:

  * Dostępne dla Użytkownika i Administratora
    * Wykładowcy
    * Jednostki
    * Grupy
    * Sale
    * Zajęcia
  * Dostępne tylko dla Administratora
    * Użytkownicy
    * Menu
    * Tłumaczenia

![http://timetablepk.googlecode.com/svn/trunk/timetablepk/doc/html/image/menu.jpg](http://timetablepk.googlecode.com/svn/trunk/timetablepk/doc/html/image/menu.jpg)

## Dostępne dla Użytkownika i Administratora ##

### Wykładowcy ###

Wykładowcy są zapisywani w bazie, każdy wpis o wykładowcy zawiera informacje takie jak Imię, Nazwisko,
stopień naukowy, oraz informacje o przedmiotach prowadzonych przez wykładowcę.

klikając na pozycje Wykładowcy zobaczymy listę wszystkich wykładowców
wraz z ich stopniami naukowymi.

![http://timetablepk.googlecode.com/svn/trunk/timetablepk/doc/html/image/wyk.jpg](http://timetablepk.googlecode.com/svn/trunk/timetablepk/doc/html/image/wyk.jpg)

Każdego wykładowcę, można edytować co pozwala na zmianę jego stopnia naukowego lub nazwiska
jeśli taka nastąpi.

Oczywiście można też usuwać wykładowców.
Dodawanie odbywa się poprzez formularz. Po otwarciu formularza,
oprócz danych takich jak imię, nazwisko, i stopień naukowy, wybieramy zajecia,
które może prowadzić konkretny wykładowca.

![http://timetablepk.googlecode.com/svn/trunk/timetablepk/doc/html/image/wykdod.jpg](http://timetablepk.googlecode.com/svn/trunk/timetablepk/doc/html/image/wykdod.jpg)

### Jednostki ###

Jednostką w naszym rozumieniu jest rok studiów. Poza nazwą w bazie jest zapisana informacja o ilości studentów danego roku.

Panel Jednostki w menu głównym TimeTable PK daje użytkownikowi możliwość przeglądania jednostek, a także modyfikacji tych jednostek.

![http://timetablepk.googlecode.com/svn/trunk/timetablepk/doc/html/image/jed.jpg](http://timetablepk.googlecode.com/svn/trunk/timetablepk/doc/html/image/jed.jpg)

Dodawanie nowych jednostek odbywa się poprzez formularz, w którym podajemy,
nazwę jednostki i ilość studentów danej jednostki.

![http://timetablepk.googlecode.com/svn/trunk/timetablepk/doc/html/image/jeddod.jpg](http://timetablepk.googlecode.com/svn/trunk/timetablepk/doc/html/image/jeddod.jpg)

Kliknięcie na Zobacz obok nazwy jednostki otwiera jej szczegóły, z możliwością edycji, dodania nowej jednostki oraz skasowania wybranej jednostki.

Każda jednostka dzieli się na grupy.

### Grupy ###

Grupy reprezentują część danej jednostki, Każda jednostka ma jedną lub więcej grup. Są to grupy laboratoryjne.

Po wybraniu Grupy z menu głównego mamy możliwość przeglądania grup, ich nazw, oraz ich liczebności.

![http://timetablepk.googlecode.com/svn/trunk/timetablepk/doc/html/image/gru.jpg](http://timetablepk.googlecode.com/svn/trunk/timetablepk/doc/html/image/gru.jpg)

Z tego miejsca grupy można edytować, kasować, i przeglądać ich szczegóły. Widok szczegółowy pokazuje nazwę, liczebność i jednostkę do której należy grupa.

Dodawanie też odbywa się poprzez formularz, w którym wpisujemy nazwę grupy, jej liczebność oraz wybieramy jednostkę do której grupa należy.

![http://timetablepk.googlecode.com/svn/trunk/timetablepk/doc/html/image/grudod.jpg](http://timetablepk.googlecode.com/svn/trunk/timetablepk/doc/html/image/grudod.jpg)

### Sale ###

Sale dzielimy na laboratoryjne i wykładowe, każda sala ma przypisany numer oraz pojemność. W widoku Sal, mamy wyświetlone informacje o salach, o rodzaju sali, i nazwie.
Z tego miejsca możemy edytować sale, usuwać je a także przejść do szczegółowego widoku danej sali.

![http://timetablepk.googlecode.com/svn/trunk/timetablepk/doc/html/image/sal.jpg](http://timetablepk.googlecode.com/svn/trunk/timetablepk/doc/html/image/sal.jpg)

Dodawanie odbywa się przez formularz w który zaznaczamy czy sala jest salą wykładową poza tym wpisujemy nazwę sali i jej pojemność.

![http://timetablepk.googlecode.com/svn/trunk/timetablepk/doc/html/image/saldod.jpg](http://timetablepk.googlecode.com/svn/trunk/timetablepk/doc/html/image/saldod.jpg)

### Zajęcia ###

Każda jednostka ma określoną siatkę zajęć, to znaczy każdy rok musi odbyć odpowiednią ilość zadanych przedmiotów.

W widoku zajęć widzimy nazwy zajęć oraz informacji o tym, czy przedmiot jest wykładem. Z tego miejsca możemy edytować, kasować oraz dodawać nowe przedmioty.

![http://timetablepk.googlecode.com/svn/trunk/timetablepk/doc/html/image/zaj.jpg](http://timetablepk.googlecode.com/svn/trunk/timetablepk/doc/html/image/zaj.jpg)

Dodawanie odbywa się poprzez formularz dodawania, w którym wybieramy nazwę, oraz zaznaczamy czy przedmiot jest wykładem. Przedmioty przyporządkowywane są jednostką przy tworzeniu bądź edycji jednostki.

![http://timetablepk.googlecode.com/svn/trunk/timetablepk/doc/html/image/zajdod.jpg](http://timetablepk.googlecode.com/svn/trunk/timetablepk/doc/html/image/zajdod.jpg)

### Harmonogram ###

Z tego miejsca mamy możliwość stworzenia nowego harmonorgamu, wybieramy nazwę, opis, a także zaznaczamy czy przedmioty mają być brane losowo, czy w kolejności wystąpienia w bazie.

![http://timetablepk.googlecode.com/svn/trunk/timetablepk/doc/html/image/har.jpg](http://timetablepk.googlecode.com/svn/trunk/timetablepk/doc/html/image/har.jpg)

## Dostępne tylko dla Administratora ##

### Użytkownicy ###

Użytkownicy dzielą się na zwykłych użytkowników i administratorów. Panel Użytkowników daję wgląd do danych takich jak login, imię, nazwisko oraz informacji o aktywności użytkownika.

Możemy edytować, kasować i dodawać użytkowników podobnie jak w innych interfejsach aplikacji.

![http://timetablepk.googlecode.com/svn/trunk/timetablepk/doc/html/image/uzy.jpg](http://timetablepk.googlecode.com/svn/trunk/timetablepk/doc/html/image/uzy.jpg)

W widoku szczegółowym poza informacjami widocznymi w panelu głównym możemy uzyskać informacje o przywileju użytkownika.

Formularz dodawania oprócz wymienionych już informacji przyjmuje także krótki komentarz do
użytkownika. Można tam zawrzeć informacje np. o hierarchii administratorów, czy numerze telefonu do administratora.

![http://timetablepk.googlecode.com/svn/trunk/timetablepk/doc/html/image/uzydod.jpg](http://timetablepk.googlecode.com/svn/trunk/timetablepk/doc/html/image/uzydod.jpg)

### Menu ###

Ta Pozycja pozwala administratorom na dodawanie i edycje wszystkich elementów znajdujących się w menu głównym i w górnym menu na żółtym pasku pod nagłówkiem strony.

![http://timetablepk.googlecode.com/svn/trunk/timetablepk/doc/html/image/men.jpg](http://timetablepk.googlecode.com/svn/trunk/timetablepk/doc/html/image/men.jpg)

Dodawanie jest bardziej skomplikowane z uwagi na to, iż należy stworzyć w kodzie podstronę lub element do którego chcemy się odwołać z tworzonej pozycji. Można także w ten sposób dodawać linki do stron zewnętrznych.

Wybieramy położenie obiektu: góra, dół, menu główne, adres url do którego się odwołujemy, a także komponent, kawałek kodu odpowiedzialny za link lub pozycje w menu.
Ustalamy też kto ma dostęp do danej pozycji czy wszyscy czy tylko administrator.

![http://timetablepk.googlecode.com/svn/trunk/timetablepk/doc/html/image/mendod.jpg](http://timetablepk.googlecode.com/svn/trunk/timetablepk/doc/html/image/mendod.jpg)

### Tłumaczenie ###

Technologia Wicket umożliwia tworzenie aplikacji wielojęzycznych. W pozycji tłumaczenia, administrator ma możliwość edycji i dodawania nowych tłumaczeń.

Tłumaczenie odbywa się na zasadzie przypisania tekstu tłumaczenia do zadanego elementu interfejsu.

![http://timetablepk.googlecode.com/svn/trunk/timetablepk/doc/html/image/tlu.jpg](http://timetablepk.googlecode.com/svn/trunk/timetablepk/doc/html/image/tlu.jpg)

Dodając tłumaczenie dodajemy Nazwę polską, niemiecką i angielską do wybranego elementu.

![http://timetablepk.googlecode.com/svn/trunk/timetablepk/doc/html/image/tludod.jpg](http://timetablepk.googlecode.com/svn/trunk/timetablepk/doc/html/image/tludod.jpg)

Przy czym komunikaty i elementy standardowe korzystają z tłumaczeń zawartych w bibliotekach Wicket, natomiast tu dodajemy tłumaczenia Samych elementów interfejsu.