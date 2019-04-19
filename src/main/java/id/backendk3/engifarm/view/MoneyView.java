package id.backendk3.engifarm.view;

import com.intellij.uiDesigner.core.GridConstraints;
import com.intellij.uiDesigner.core.GridLayoutManager;
import id.backendk3.engifarm.Player;

import javax.swing.*;
import java.awt.*;
import java.util.Observable;
import java.util.Observer;

/**
 * Kelas riil MoneyView turunan JPanel
 * 
 * <p>Kelas ini merepresentasikan data money yang dimiliki oleh player dan ditampilkan ke layar
 */
public class MoneyView extends JPanel implements Observer {

    private JLabel moneyLabel;

    /**
     * Konstruktor kelas MoneyView
     */
    public MoneyView() {
        this.setLayout(new GridLayoutManager(1, 1, new Insets(0, 0, 0, 0), -1, -1));
        moneyLabel = new JLabel();
        moneyLabel.setText("Money = ");
        this.add(moneyLabel, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
    }

    /**
     * Method pembaruan untuk menangani perubahan data money yang dimiliki player dan ditampilkan kembali ke layar
     */
    public void update(Observable observable, Object arg) {
        Player p = (Player) observable;
        moneyLabel.setText(String.format("Money  = %d", p.getMoney()));
        this.repaint();
        this.revalidate();
    }
}
