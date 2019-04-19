package id.backendk3.engifarm.controller;

import id.backendk3.engifarm.Concurrent;
import id.backendk3.engifarm.Farm;

public class SimulationController extends Thread {
    private Farm farm;


    public SimulationController(Farm _farm) {
        farm = _farm;
    }


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