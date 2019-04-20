package id.backendk3.engifarm;

/**
 * Kelas abstrak TimerObj
 *
 * <p> Kelas ini merepresentasikan timer untuk setiap objek turunannya
 * Timer sebuah objek akan diinisiasi dengan nilai dan akan berkurang setiap ticknya.
 * Jika timer objek sudah habis maka akan memanggil method callback yang dioverride oleh kelas turunannya
 *
 * @author backendk3
 * @see id.backendk3.engifarm.cell.Cell
 */
public abstract class TimerObj {
    private int timer;
    private boolean timerActive;

    /**
     * Method abstrak callback yang merepresentasikan perintah jika timer objek habis
     */
    protected abstract void callback();

    /**
     * Konstruktor Kelas TimerObj
     */
    public TimerObj() {
        timerActive = false;
        timer = 0;
    }

    /**
     * Prosedur yang dilakukan setiap satu satuan tick pada timer
     */
    public void tick() {
        if (timerActive) {
            timer--;
            if (timer == 0) {
                timerActive = false;
                callback();
            }
        }
    }

    /**
     * Fungsi yang mengembalikan kondisi timerActive
     *
     * @return True jika timer aktif
     */
    public boolean getTimerActive() {
        return timerActive;
    }

    /**
     * Fungsi yang mengembalikan waktu sisa timer
     *
     * @return waktu sisa timer
     */
    public int getTimer() {
        return timer;
    }

    /**
     * Method yang menetapkan kondisi timerActive
     *
     * @param _timerActive kondisi timer
     */
    public void setTimerActive(boolean _timerActive) {
        timerActive = _timerActive;
    }

    /**
     * Method yang menetapkan waktu timer
     *
     * @param _timer waktu timer
     */
    public void setTimer(int _timer) {
        timer = _timer;
    }
}