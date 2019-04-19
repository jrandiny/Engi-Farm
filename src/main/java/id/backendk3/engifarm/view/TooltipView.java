package id.backendk3.engifarm.view;

import com.intellij.uiDesigner.core.GridConstraints;
import com.intellij.uiDesigner.core.GridLayoutManager;
import id.backendk3.engifarm.Tooltip;

import javax.swing.*;
import java.awt.*;
import java.util.Observable;
import java.util.Observer;

/**
 * Kelas riil TooltipView turunan JPanel
 * 
 * <p>Kelas ini merepresentasikan pesan bantuan dari Tooltip yang akan ditampilkan pada layar
 */
public class TooltipView extends JPanel implements Observer {

    private JTextArea TooltipLabel;

    /**
     * Konstruktor kelas TooltipView
     */
    public TooltipView() {
        this.setLayout(new GridLayoutManager(1, 1, new Insets(0, 0, 0, 0), -1, -1));
        TooltipLabel = new JTextArea();
        TooltipLabel.setSize(new Dimension(AppView.SIDEBAR_SIZE, 50));
        TooltipLabel.setBackground(new Color(255, 255, 255, 0));
        TooltipLabel.setLineWrap(true);
        TooltipLabel.setWrapStyleWord(true);
        TooltipLabel.setText("Engi's Farm");
        this.add(TooltipLabel, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_CAN_GROW | GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
    }

    /**
     * Method pembaruan untuk menangani perubahan data tooltip dan ditampilkan kembali ke layar
     */
    public void update(Observable observable, Object arg) {
        Tooltip notif = (Tooltip) observable;
        TooltipLabel.setText(notif.getMsg());
        this.repaint();
        this.revalidate();
    }
}
