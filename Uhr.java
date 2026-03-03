/**
 * uhr was sonst
 * 
 * @author mathis (mathiiiiiis) 
 * @version 1.0.0
 */
public class Uhr
{
    private Zaehler sekunde;
    private Zaehler minute;
    private Zaehler stunde;
    
    public Uhr() {
        sekunde = new Zaehler(0, 59);
        minute = new Zaehler(0, 59);
        stunde = new Zaehler(0, 23);
    }
    
    public String gibZeit() {
        return String.format("%02d:%02d:%02d", stunde.gibWert(), minute.gibWert(), sekunde.gibWert());
    }
    
    public void setzeZeit(int newSekunde, int newMinute, int newStunde) {
        sekunde.setzeWert(newSekunde);
        minute.setzeWert(newMinute);
        stunde.setzeWert(newStunde);
    }
    
    public void erhoeheZeit() {
        sekunde.erhoeheWert();
        if (sekunde.gibWert() == 0) {
            minute.erhoeheWert();
            if (minute.gibWert() == 0) {
                stunde.erhoeheWert();
            }
        }
    }
}