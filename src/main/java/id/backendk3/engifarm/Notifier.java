package id.backendk3.engifarm;

import java.util.Observable;

public class Notifier extends Observable{
    private String Msg;
    private Boolean exit;

    public Notifier(){
        Msg = "";
        exit = false;
    }
    public String getMsg(){
        return Msg;
    }

    public Boolean getExit(){
        return exit;
    }

    public void setMsg(String msg){
        this.Msg = msg;
        setChanged();
        notifyObservers();
    }

    public void setExit(Boolean flag){
        this.exit = flag;
    }
}