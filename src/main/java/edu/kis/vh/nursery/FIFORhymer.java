package edu.kis.vh.nursery;

/**
 * Klasa reprezentująca stos FIFO (First In, First Out).
 * Klasa ta rozszerza klasę `DefaultCountingOutRhymer` i implementuje specyficzne
 * zachowanie, które umożliwia usuwanie elementów w kolejności FIFO (czyli
 * w kolejności, w jakiej zostały dodane).
 *
 * Używana jest do przechowywania danych w porządku FIFO. Elementy są przenoszone
 * na tymczasowy stos, a następnie przywracane w odwrotnej kolejności.
 *
 * @author Imię Nazwisko
 * @version 1.0
 */
public class FIFORhymer extends DefaultCountingOutRhymer {

    // Tymczasowy obiekt do przechowywania wartości przed ich przywróceniem do głównego stosu
    public final DefaultCountingOutRhymer temp = new DefaultCountingOutRhymer();

    /**
     * Nadpisuje metodę `countOut` z klasy bazowej, aby usunąć elementy w kolejności FIFO.
     * Zamiast usuwać elementy w standardowy sposób, elementy są przenoszone na tymczasowy stos,
     * a następnie przywracane w odwrotnej kolejności, aby zachować porządek FIFO.
     *
     * Przenosi wszystkie elementy ze stosu głównego na tymczasowy stos, a potem
     * usuwa pierwszy element z tymczasowego stosu. Następnie przywraca pozostałe elementy
     * z powrotem do głównego stosu.
     *
     * @return Element, który został usunięty z stosu FIFO.
     * @throws IllegalStateException Jeśli stos jest pusty.
     * @author Imię Nazwisko
     * @version 1.0
     */
    @Override
    public int countOut() {
        // Przenoszenie wszystkich elementów na tymczasowy stos
        while (!callCheck()) {
            temp.countIn(super.countOut());  // TODO: needs refactoring - metoda mogłaby być bardziej wydajna
        }

        // Usuwanie elementu z tymczasowego stosu (w kolejności FIFO)
        int ret = temp.countOut();

        // Przywracanie elementów do głównego stosu w tej samej kolejności
        while (!temp.callCheck()) {
            countIn(temp.countOut());
        }

        return ret;
    }
}
