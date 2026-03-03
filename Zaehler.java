/**
 * zaehler was sonst
 * 
 * @author mathis (mathiiiiiis) 
 * @version 1.0.0
 */
public class Zaehler
{
    public int wert, maxWert;

    public Zaehler(int wert, int maxWert){
        this.wert = wert;
        this.maxWert = maxWert;
    }
    
    public int gibWert() {
        return wert;
    }
    
    public void erhoeheWert() {
        if (wert >= maxWert) {
            wert = 0;
        } else {
            wert += 1;
        }
    }
    
    public void setzeWert(int neuerWert) {
        if (neuerWert <= maxWert && neuerWert >= 0) {
            wert = neuerWert;
        }
    }
}