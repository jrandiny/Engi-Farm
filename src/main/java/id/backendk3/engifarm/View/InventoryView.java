package id.backendk3.engifarm.View;

import com.intellij.uiDesigner.core.GridConstraints;
import com.intellij.uiDesigner.core.GridLayoutManager;

import id.backendk3.engifarm.Player;
import id.backendk3.engifarm.Product.Product;

import javax.swing.*;
import java.util.Observer;
import java.util.ArrayList;
import java.util.Map;
import java.util.Observable;

public class InventoryView extends JScrollPane implements Observer {

    private JList inventoryList;

    public InventoryView() {
        inventoryList = new JList();
        this.setViewportView(inventoryList);
    }

    public void update(Observable observable, Object arg) {
        Player p = (Player) observable;
        Map<Product,Integer> bag = p.getBag();

        ArrayList<String> text = new ArrayList<String>();
        for(Map.Entry<Product, Integer> entry : bag.entrySet() ){
            text.add(entry.getValue().toString()+" - "+entry.getKey().render());
        }  

        inventoryList = new JList(text.toArray());

        this.setViewportView(inventoryList);

        this.repaint();
        this.revalidate();
    }
}
