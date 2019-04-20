package id.backendk3.engifarm.controller;

import id.backendk3.engifarm.cell.Cell;
import id.backendk3.engifarm.cell.facility.Facility;
import id.backendk3.engifarm.cell.facility.Truck;
import id.backendk3.engifarm.cell.facility.Well;
import id.backendk3.engifarm.cell.land.Land;
import id.backendk3.engifarm.*;
import id.backendk3.engifarm.farmanimal.FarmAnimal;
import id.backendk3.engifarm.product.Product.ProductType;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Kelas riil InputController turunan KeyListener
 * 
 * <player>Kelas ini merepresentasikan penanganan pada input perintah dari user agar dapat dimengerti dan dijalankan pada permainan
 */
public class InputController implements KeyListener {

    private final Player player;
    private final Farm map;
    private final Tooltip tooltip;
    private final OptionBox optionBox;

    /**
     * Konstruktor kelas InputController
     * 
     * @param player player
     * @param farm data permainan simulasi Engi's Farm
     * @param tooltip pesan bantuan tooltip
     * @param optionBox opsi pilihan perintah optionbox
     */
    public InputController(Player player, Farm farm, Tooltip tooltip, OptionBox optionBox) {
        this.player = player;
        this.map = farm;
        this.tooltip = tooltip;
        this.optionBox = optionBox;
    }

    /**
     * Method overide yang melakukan aksi jika perintah key ditekan
     * @param e perintah key
     */
    @Override
    public void keyPressed(KeyEvent e) {
    }

    /**
     * Method overide yang melakukan aksi jika perintah key dilepas
     * @param e perintah key
     */
    @Override
    public void keyReleased(KeyEvent e) {
    }

    /**
     * Method yang penanganan input dari optionbox pada perintah mix pada produk-produk dalam inventory player
     * @param type tipe perintah 
     * @param result produk yang akan dihasilkan melalui perintah mix
     */
    public void dialogSet(String type, String result) {
        synchronized (Concurrent.TOKEN) {
            if (type.equals("mix")) {
                switch (result) {
                    case "Beef Rolade":
                        player.mix(ProductType.BeefRoladeType);
                        break;
                    case "Egg Benedict":
                        player.mix(ProductType.EggBenedictType);
                        break;
                    case "Meatza":
                        player.mix(ProductType.MeatzaType);
                        break;
                    default:
                        break;
                }
            }
        }
    }

    /**
     * Method yang menangani aksi sesuai dengan penerimaan input perintah key dari user
     * @param e perintah key dari user
     */
    @Override
    public void keyTyped(KeyEvent e) {
        synchronized (Concurrent.TOKEN) {
            Cell[] surr = map.getSurrounding(player.getX(), player.getY());
            tooltip.setMsg("Engi's Farm");
            try {
                if (e.getKeyChar() == 'w') {
                    player.move(Farm.MoveType.Up, surr);
                } else if (e.getKeyChar() == 'd') {
                    player.move(Farm.MoveType.Right, surr);
                } else if (e.getKeyChar() == 's') {
                    player.move(Farm.MoveType.Down, surr);
                } else if (e.getKeyChar() == 'a') {
                    player.move(Farm.MoveType.Left, surr);
                } else if (e.getKeyChar() == 'l') {
                    player.grow((Land) (map.getMap().get(player.getY()).get(player.getX())));
                } else if (e.getKeyChar() == 'k' || e.getKeyChar() == 'i' || e.getKeyChar() == 'j') {
                    FarmAnimal animal = map.getAnimals(player.getX(), player.getY(), player.getDirection());
                    if (animal != null) {
                        //ada animal di arahnya
                        switch (e.getKeyChar()) {
                            case 'j':
                                tooltip.setMsg(player.talk(animal));
                                break;
                            case 'i':
                                player.interact(animal);
                                break;
                            case 'k':
                                player.kill(animal);
                                map.cleanFarmAnimal();
                                break;
                            default:
                                break;
                        }
                    } else {
                        //tidak ada animal
                        Facility facility = map.getFacilities(player.getX(), player.getY(), player.getDirection());
                        if (facility != null) {
                            // ada facility
                            switch (facility.getType()) {
                                case MixerType:
                                    String[] options = new String[3];
                                    options[0] = "Beef Rolade";
                                    options[1] = "Egg Benedict";
                                    options[2] = "Meatza";
                                    optionBox.setOptions(options, "mix");
                                    break;
                                case TruckType:
                                    player.interact((Truck) facility);
                                    break;
                                case WellType:
                                    player.interact((Well) facility);
                                    break;
                                default:
                                    break;
                            }
                        }
                    }
                } else {
                    tooltip.setMsg("wrong command");
                }
            } catch (Exception ex) {
                tooltip.setMsg(ex.getMessage());
            }
        }
    }
}