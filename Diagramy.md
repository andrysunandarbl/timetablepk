# Diagramy #



W ramach realizacji projektu TimeTablePk zostały przygotowane następujące diagramy

## Diagram encji ##

![http://timetablepk.googlecode.com/svn/trunk/timetablepk/doc/html/image/encje.jpg](http://timetablepk.googlecode.com/svn/trunk/timetablepk/doc/html/image/encje.jpg)

Diagram przedstawia zależności między poszczególnymi encjami na kanwie, których działa TimeTablePk. Kolejne encje odpowiadają za:
  * UnitDef - wspólny interfejs dla jednostek i ich grup
  * Unit - jednostka czyli rocznik
  * Group - grupa wydzielona z jednostki
  * Course - kurs jaki ma zostać zrealizowany przez jednostkę
  * Teacher - nauczyciel który realizuje kursy
  * User - użytkownik systemu
  * Room - sale wykładowe/laboratoryjne
  * Schedule - zapisany plan zajęć
  * ScheduleDay - pojedyńczy dzień w planie zajęć
  * ScheduleRow - pojedyńczy wiersz w dniu
  * ScheduleItem - pojedyńczy zestaw (UnitDef,Course,Teacher,Room)

## Diagram przypadków użycia ##

![http://timetablepk.googlecode.com/svn/trunk/timetablepk/doc/html/image/usecase.jpg](http://timetablepk.googlecode.com/svn/trunk/timetablepk/doc/html/image/usecase.jpg)