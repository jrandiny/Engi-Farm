package id.backendk3.engifarm.View;

import com.intellij.uiDesigner.core.GridConstraints;
import com.intellij.uiDesigner.core.GridLayoutManager;

import id.backendk3.engifarm.Notifier;

import javax.swing.*;
import java.awt.*;
import java.util.Observer;
import java.util.Observable;

public class TooltipView extends JPanel implements Observer {

    private JLabel TooltipLabel;

    public TooltipView() {
        this.setLayout(new GridLayoutManager(1, 1, new Insets(0, 0, 0, 0), -1, -1));
        TooltipLabel = new JLabel();
        TooltipLabel.setText("Engi's Farm");
        this.add(TooltipLabel, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
    }

    public void update(Observable observable, Object arg) {
        Notifier notif = (Notifier) observable;
        TooltipLabel.setText(notif.getMsg());
        this.repaint();
        this.revalidate();
    }
}
