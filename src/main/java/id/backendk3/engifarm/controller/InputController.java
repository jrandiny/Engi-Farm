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
 * <p>Kelas ini merepresentasikan penanganan pada input perintah dari user agar dapat dimengerti dan dijalankan pada permainan
 */
public class InputController implements KeyListener {

    Player p;
    Farm map;
    Tooltip notif;
    OptionBox ob;

    /**
     * Konstruktor kelas InputController
     * 
     * @param player player
     * @param farm data permainan simulasi Engi's Farm
     * @param notif pesan bantuan tooltip
     * @param ob opsi pilihan perintah optionbox
     */
    public InputController(Player player, Farm farm, Tooltip notif, OptionBox ob) {
        this.p = player;
        this.map = farm;
        this.notif = notif;
        this.ob = ob;
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
                        p.mix(ProductType.BeefRoladeType);
                        break;
                    case "Egg Benedict":
                        p.mix(ProductType.EggBenedictType);
                        break;
                    case "Meatza":
                        p.mix(ProductType.MeatzaType);
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
            Cell[] surr = map.getSurrounding(p.getX(), p.getY());
            notif.setMsg("Engi's Farm");
            try {
                if (e.getKeyChar() == 'q') {
                    notif.setExit(true);
                } else if (e.getKeyChar() == 'w') {
                    p.move(Farm.MoveType.Up, surr);
                } else if (e.getKeyChar() == 'd') {
                    p.move(Farm.MoveType.Right, surr);
                } else if (e.getKeyChar() == 's') {
                    p.move(Farm.MoveType.Down, surr);
                } else if (e.getKeyChar() == 'a') {
                    p.move(Farm.MoveType.Left, surr);
                } else if (e.getKeyChar() == 'l') {
                    p.grow((Land) (map.getMap().get(p.getY()).get(p.getX())));
                } else if (e.getKeyChar() == 'k' || e.getKeyChar() == 'i' || e.getKeyChar() == 'j') {
                    FarmAnimal animal = map.getAnimals(p.getX(), p.getY(), p.getDirection());
                    if (animal != null) {
                        //ada animal di arahnya
                        switch (e.getKeyChar()) {
                            case 'j':
                                notif.setMsg(p.talk(animal));
                                break;
                            case 'i':
                                p.interact(animal);
                                break;
                            case 'k':
                                p.kill(animal);
                                map.cleanFarmAnimal();
                                break;
                            default:
                                break;
                        }
                    } else {
                        //tidak ada animal
                        Facility facility = map.getFacilities(p.getX(), p.getY(), p.getDirection());
                        if (facility != null) {
                            // ada facility
                            switch (facility.getType()) {
                                case MixerType:
                                    String[] options = new String[3];
                                    options[0] = "Beef Rolade";
                                    options[1] = "Egg Benedict";
                                    options[2] = "Meatza";
                                    ob.setOptions(options, "mix");
                                    break;
                                case TruckType:
                                    p.interact((Truck) facility);
                                    break;
                                case WellType:
                                    p.interact((Well) facility);
                                    break;
                                default:
                                    break;
                            }
                        }
                    }
                } else {
                    notif.setMsg("wrong command");
                }
            } catch (Exception ex) {
                notif.setMsg(ex.getMessage());
            }
        }
    }
}