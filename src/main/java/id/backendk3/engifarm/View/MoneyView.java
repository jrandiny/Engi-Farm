package id.backendk3.engifarm.View;

import com.intellij.uiDesigner.core.GridConstraints;
import com.intellij.uiDesigner.core.GridLayoutManager;
import id.backendk3.engifarm.Player;

import javax.swing.*;
import java.awt.*;
import java.util.Observable;
import java.util.Observer;

// import id.backendk3.engifarm.Tooltip;

public class MoneyView extends JPanel implements Observer {

    private JLabel moneyLabel;

    public MoneyView() {
        this.setLayout(new GridLayoutManager(1, 1, new Insets(0, 0, 0, 0), -1, -1));
        moneyLabel = new JLabel();
        moneyLabel.setText("Money = ");
        this.add(moneyLabel, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
    }

    public void update(Observable observable, Object arg) {
        Player p = (Player) observable;
        moneyLabel.setText(String.format("Money  = %d",p.getMoney()));
        this.repaint();
        this.revalidate();
    }
}
