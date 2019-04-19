package id.backendk3.engifarm;

import java.util.Observable;

public class OptionBox extends Observable {
    private String[] param;
    private String type;

    public void setOptions(String[] param, String type) {
        this.param = param;
        this.type = type;
        setChanged();
        notifyObservers();
    }

    public String[] getOptions() {
        return param;
    }

    public String getType() {
        return type;
    }
}