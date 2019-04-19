package id.backendk3.engifarm.controller;

import id.backendk3.engifarm.Concurrent;
import id.backendk3.engifarm.Farm;

/**
 * Kelas riil SimulationController turunan Thread
 * 
 * <p>Kelas ini merepresentasikan penjalanan program secara otomatisasi menggunakan thread
 */
public class SimulationController extends Thread {
    private Farm farm;

    /**
     * Konstruktor kelas SimulationController
     * @param _farm data permainan simulasi Engi's Farm
     */
    public SimulationController(Farm _farm) {
        farm = _farm;
    }

    /**
     * Method yang dijalankan secara otomatisasi menggunakan thread
     */
    public void run() {
        while (true) {
            synchronized (Concurrent.TOKEN) {
                farm.oneTick();
            }
            try {
                Thread.sleep(1000);
            } catch (Exception e) {

            }
        }
    }
}