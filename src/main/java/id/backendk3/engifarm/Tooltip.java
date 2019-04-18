package id.backendk3.engifarm;

import java.util.Observable;

/**
 * Kelas riil Tooltip turunan Obeservable
 * 
 * @author backendk3
 */
public class Tooltip extends Observable{
    private String Msg;
    private boolean exit;

    public Tooltip(){
        Msg = "";
        exit = false;
    }
    public String getMsg(){
        return Msg;
    }

    public boolean getExit(){
        return exit;
    }

    public void setMsg(String msg){
        this.Msg = msg;
        setChanged();
        notifyObservers();
    }

    public void setExit(boolean flag){
        this.exit = flag;
    }
}