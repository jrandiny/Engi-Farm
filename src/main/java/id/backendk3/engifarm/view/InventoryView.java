package id.backendk3.engifarm.view;

import id.backendk3.engifarm.Player;
import id.backendk3.engifarm.product.Product;

import javax.swing.*;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;

/**
 * Kelas riil InventoryView turunan JScrollPane
 * 
 * <p>Kelas ini merepresentasikan data produk yang terdapat pada inventory yang dimiliki player dan ditampilkan ke layar
 */
public class InventoryView extends JScrollPane implements Observer {

    private JList<String> inventoryList;
    private DefaultListModel<String> listModel;

    /**
     * Konstruktor kelas InventoryView
     */
    public InventoryView() {
        listModel = new DefaultListModel<>();
        inventoryList = new JList<String>(listModel);

        this.setViewportView(inventoryList);
    }

    /**
     * Method pembaruan untuk menangani perubahan data produk yang terdapat pada inventiry yang dimiliki player dan ditampilkan kembali ke layar
     */
    public void update(Observable observable, Object arg) {
        Player p = (Player) observable;
        Map<Product, Integer> bag = p.getBag();

        listModel.clear();
        for (Map.Entry<Product, Integer> entry : bag.entrySet()) {
            listModel.addElement(entry.getValue().toString() + " - " + entry.getKey().render());
        }

        this.setViewportView(inventoryList);

        this.repaint();
        this.revalidate();
    }
}
