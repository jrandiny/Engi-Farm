package id.backendk3.engifarm;

import id.backendk3.engifarm.cell.Cell;
import id.backendk3.engifarm.cell.land.Land;
import id.backendk3.engifarm.controller.InputController;
import id.backendk3.engifarm.controller.SimulationController;
import id.backendk3.engifarm.view.*;

import java.util.ArrayList;

/**
 * Kelas utama permainan Engi's Farm
 *
 * <p>Kelas ini berguna untuk menyiapkan sistem MVC (Model - view - controller).
 */
class App {

    /**
     * Program Utama permainan Engi's Farm
     * @param args argumen program utama
     */
    public static void main(String[] args) {
        // Setup variable
        OptionBox optionBox = new OptionBox();
        Farm map = new Farm(8, 8);
        Player player = initPlayer(map);
        Tooltip notifier = new Tooltip();
        InputController inputContoller = new InputController(player, map, notifier, optionBox);
        SimulationController simulationController = new SimulationController(map);
        AppView myAppView;

        // Create main view
        myAppView = new AppView(player, map);
        MapView mapView = myAppView.getMapView();
        TooltipView tooltipView = myAppView.getTooltipView();
        MoneyView moneyView = myAppView.getMoneyView();
        WaterView waterView = myAppView.getWaterView();
        InventoryView inventoryView = myAppView.getInventoryView();

        // Connect view with model
        map.addObserver(mapView);
        notifier.addObserver(tooltipView);
        player.addObserver(moneyView);
        player.addObserver(waterView);
        player.addObserver(inventoryView);
        player.addObserver(mapView);

        player.forceNotifyOberservers();

        optionBox.addObserver(myAppView);

        // Connect view with controller
        myAppView.setInputListener(inputContoller);

        // Start simulation
        simulationController.start();
        while (true) ;
    }

    /**
     * Method yang menginisiasikan kondisi player awal
     * 
     * @param map peta permainan
     * @return karakter Player dengan data-data Playernya
     */
    public static Player initPlayer(Farm map) {
        ArrayList<ArrayList<Cell>> temp = map.getMap();
        final int INIT_WATER = 50;
        final int INIT_MONEY = 0;
        int initX, initY;
        do {
            initX = (int) (Math.random() * temp.get(0).size());
            initY = (int) (Math.random() * temp.size());
        } while (temp.get(initY).get(initX).isOccupied());
        ((Land) (temp.get(initY).get(initX))).occupy();
        return new Player(INIT_WATER, INIT_MONEY, initX, initY, Farm.MoveType.Up);
    }
}
