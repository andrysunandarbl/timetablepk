# Algorytm #



Projekt wymagał zbudowania stosownego algorytmu szeregującego i układającego plan zajęć na podstawie jego elementów składowych. Są nimi:

  * osoby prowadzące zajęcia
  * dostępne na uczelni sale
  * wszystkie zajęcia jakie powinny zostać zrealizowane
  * jednostki studentów czyli wszystkie roki wraz z podgrupami
  * godziny w jakich mają się odbywać kolejne zajęcia

Wykorzystując te informacje budowany jest plan zajęć rozdzielający zajęcia na poszczególne godziny w tygodniu biorąc pod uwagę możliwe konflikty:

  * jeden wykładowca nie może prowadzić dwóch zajęć w tym samym czasie
  * wykładowca nie może prowadzić zajęć do których nie ma predyspozycji/wiedzy/umiejętności
  * sala musi odpowiadać swoim profilem prowadzonym w niej zajęciom
  * sala musi pomieścić wszystkich studentów w ciągu zajęć
  * grupa nie może mieć zajęć w tym samym czasie co rok z którego się wywodzi (działa w dwie strony)

Algorytm został wyposażony w dodatkowe możliwości:

  * losowość - każde wywołanie algortmu zwraca w rezultacie inny plan zajęć
  * możliwość odgórnego określenia maksymalnej ilości wykorzystywanych godzin w ciągu dnia

## Kroki algorytmu ##

Algorytm układania planu zajęć można zapisać jako poszczególne kroki:

Słownik:
  * wiersz - zestaw zajęć które mogą być wykonywane w tym samym czasie
  * item - pojedyńcze zajęcie składające się z jednostki, sali, nauczyciela i przedmiotu

### Kroki ###

  1. Wczytaj dane wejściowe
  1. Stworz kolejke avItems składającą się z wstępnego zbioru wszystkich zajęć dla każdej jednostki (roku i grupy). Stwórz kolejke filledRows która będzie zawierać wypełnione wiersze. Wylicz (maxItemsAtRow) maksymalną możliwoą ilość zajęć jakie mogą się odbyć w tym samym czasie (jest to minimalna wartość z ilości jednostek, kursów, sal i nauczycieli.
  1. Sprawdź czy są jeszcze dostępne elementy do ułożenia. Jeżeli tak idź do 4, w przeciwnym przypadku do 12.
  1. Stwórz pusty wiersz (row). Pod maxFindingLoopCount przypisz ilość elementów w kolejce avItems. Pod findingLoopCounter przypisz 0.
  1. Sprawdź czy ilość elementów w wierszu jest już równa maxItemsAtRow lub czy findingLoopCounter jest mniejszy od maxFindingLoopCount. Jeżeli warunki są prawdziwe idź do 11, w przeciwnym przypadku do 6 (wiersz jeszcze nie jest pełen)
  1. Pod item wstaw pierwszy element w liscie avItems. Zwiększ findingLoopCounter o 1.
  1. Sprawdź czy dana jednostka nie ma już zajęć w tym samym wierszu. Znajdź nauczyciela spełniającego warunki. Znajdz sale spełniającą warunki.
  1. Jeżeli któraś operacja z kroku 7 nie powiodła się idź do 10, w przeciwnym przypadku do 9.
  1. Ustaw dla aktualnie rozpatrywanego elementu item wyszukaną salę i nauczyciela. Wróć do kroku 5.
  1. Ustaw rozpatrywany element item na końcu kolejki avItems
  1. Dodaj wypełniony wiersz do kolejki filledRows. Idź do kroku 3.
  1. Ułóż wypełnione wiersze w kolejnych dostępnych godzinach w ciągu tygodnia
  1. Koniec

### Schemat blokowy ###

![http://timetablepk.googlecode.com/svn/trunk/timetablepk/doc/html/image/algorytm.jpg](http://timetablepk.googlecode.com/svn/trunk/timetablepk/doc/html/image/algorytm.jpg)