/**
 * alles class was sonst
 * 
 * @author mathis (mathiiiiiis) 
 * @version 1.0.0
 */
public class WeckStoppUhr {
    private Uhr stoppUhr;
    private Uhr uhr;
    private Uhr wecker;
    
    private boolean stoppUhrAktiv;
    private boolean weckerEin;
    private boolean weckerAlarmEin;
    private tacktGenerator taktGeber;
    
    private int snoozeZeit;
    private int snoozeZaehler;
    
    // KONSTRUKTOR
    public WeckStoppUhr() {
        stoppUhr = new Uhr();
        uhr = new Uhr();
        wecker = new Uhr();
        
        stoppUhrAktiv = false;
        taktGeber = new tacktGenerator(this);
        weckerEin = false;
        weckerAlarmEin = false;
        snoozeZeit = 300;
        snoozeZaehler = 0;
    }
    
    // GLOBAL
    void erhoeheZeit() {
        if (stoppUhrAktiv) {
            stoppUhr.erhoeheZeit();
            System.out.println("STOPPUHR: " + stoppUhrGibZeit());
        }
        uhr.erhoeheZeit();
        if (weckerEin) {
            if (wecker.gibZeit().equals(uhr.gibZeit())) {
                weckerAlarmEin = true;
            }
        }
    }

    // STOPP-UHR
    public String stoppUhrGibZeit() {
        return stoppUhr.gibZeit();
    }
    
    public void stoppUhrStarten() {
        stoppUhrAktiv = true;
        taktGeber.starten();
    }
    
    public void stoppUhrStoppen() {
        stoppUhrAktiv = false;
        taktGeber.stoppen();
    }
    
    public void stoppUhrReset() {
        stoppUhr.setzeZeit(0, 0, 0);
    }
    
    // UHR
    public String uhrGibZeit() {
        return uhr.gibZeit();
    }
    
    public void uhrSetzeZeit(int sekunde, int minute, int stunde) {
        uhr.setzeZeit(stunde, minute, sekunde);
    }
    
    // WECKER
    public String weckerGibZeit() {
        return wecker.gibZeit();
    }
    
    public boolean weckerGibAlarm() {
        return weckerAlarmEin;
    }
    
    public void weckerEinAus() {
        weckerEin = !weckerEin;
    }
    
    public void weckerAlarmAus() {
        weckerAlarmEin = false;
        setzeAufUhrsprungsAlarm();
        snoozeZaehler = 0;
    }
    
    public void weckerSetzeZeit(int sekunde, int minute, int stunde) {
        wecker.setzeZeit(stunde, minute, sekunde);
    }
    
    public void weckerSnooze() {
        weckerAlarmEin = false;
        snoozeZaehler++;
        for (int i=0; i < snoozeZeit; i++) {
            wecker.erhoeheZeit();
        }
    }
    
    public void setzeAufUhrsprungsAlarm() {
        for (int i = 0; i < 24*60*60-(snoozeZeit*snoozeZaehler); i++) {
            wecker.erhoeheZeit();
        }
    }
}