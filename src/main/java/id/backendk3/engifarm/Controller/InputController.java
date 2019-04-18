package id.backendk3.engifarm.Controller;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import id.backendk3.engifarm.Player;
import id.backendk3.engifarm.Concurrent;
import id.backendk3.engifarm.Farm;
import id.backendk3.engifarm.Cell.Cell;
import id.backendk3.engifarm.FarmAnimal.*;
import id.backendk3.engifarm.Product.Product.ProductType;
import id.backendk3.engifarm.Cell.Facility.*;
import id.backendk3.engifarm.Cell.Land.*;
import id.backendk3.engifarm.Tooltip;
import id.backendk3.engifarm.OptionBox;

public class InputController implements KeyListener {

    Player p;
    Farm map;
    Tooltip notif;
    OptionBox ob;

    public InputController(Player player, Farm farm, Tooltip notif, OptionBox ob) {
        this.p = player;
        this.map = farm;
        this.notif = notif;
        this.ob = ob;
    }

    @Override
    public void keyPressed(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

    public void dialogSet(String type, String result){
        synchronized(Concurrent.TOKEN){
            if(type.equals("mix")){
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

    @Override
    public void keyTyped(KeyEvent e) {
        synchronized (Concurrent.TOKEN) {
            Cell[] surr = map.getSurrounding(p.getX(),p.getY());
            notif.setMsg("Engi's Farm");
            try {
                if(e.getKeyChar() == 'q'){
                    notif.setExit(true);
                } else if(e.getKeyChar() == 'w'){
                    p.move(Farm.MoveType.Up,surr);
                } else if(e.getKeyChar() == 'd'){
                    p.move(Farm.MoveType.Right,surr);
                } else if(e.getKeyChar() == 's'){
                    p.move(Farm.MoveType.Down,surr);
                } else if(e.getKeyChar() == 'a'){
                    p.move(Farm.MoveType.Left,surr);
                } else if(e.getKeyChar() == 'l'){
                    p.grow((Land)(map.getMap().get(p.getY()).get(p.getX())));
                // } else if(input.equals("h")){
                //     printHelp();
                } else if(e.getKeyChar() == 'k' || e.getKeyChar() == 'i' || e.getKeyChar() == 'j'){
                    FarmAnimal animal = map.getAnimals(p.getX(), p.getY(), p.getDirection());
                    if(animal!=null){
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
                        Facility facility = map.getFacilities(p.getX(), p.getY(),p.getDirection());
                        if(facility != null){
                            // ada facility
                            switch (facility.getType()){
                                case MixerType:
                                    String[] options = new String[3];
                                    options[0] = "Beef Rolade";
                                    options[1] = "Egg Benedict";
                                    options[2] = "Meatza";
                                    ob.setOptions(options,"mix");
                                    break;
                                case TruckType:
                                    p.interact((Truck)facility);
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