package id.backendk3.engifarm.View;

import com.intellij.uiDesigner.core.GridConstraints;
import com.intellij.uiDesigner.core.GridLayoutManager;

import id.backendk3.engifarm.Farm;
import id.backendk3.engifarm.Cell.Cell;
import id.backendk3.engifarm.Cell.Land.Coop;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.Observer;
import java.util.ArrayList;
import java.util.Observable;

public class MapView extends JPanel implements Observer {

    private JButton button1;
    private JPanel panel1;

    public MapView() {
        // GUI initializer generated by IntelliJ IDEA GUI Designer
        // >>> IMPORTANT!! <<<
        // DO NOT EDIT OR ADD ANY CODE HERE!
        $$$setupUI$$$();
    }

    /**
     * Method generated by IntelliJ IDEA GUI Designer >>> IMPORTANT!! <<< DO NOT
     * edit this method OR call it in your code!
     *
     * @noinspection ALL
     */
    private void $$$setupUI$$$() {
        panel1 = new JPanel();
        panel1.setLayout(new GridLayoutManager(1, 1, new Insets(0, 0, 0, 0), -1, -1));
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return panel1;
    }

    public void update(Observable observable, Object arg) {
        System.out.println("map update");

        Farm farm = (Farm) observable;
        ArrayList<ArrayList<Cell>> mapGrid = farm.getMap();

        JPanel mapPanel = new JPanel();

        mapPanel.setLayout(new GridBagLayout());

        int height = panel1.getHeight();
        int width = panel1.getWidth();

        int size = height < width ? height : width;
        int boxSize = size;

        size = size / mapGrid.size();

        Coop c = new Coop(1, 1);

        try {
            c.getSprite();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            System.out.println("a");
        }

        for (int j =0;j<mapGrid.size();j++){
            for(int i =0; i<mapGrid.get(j).size();i++){
                JPanel jp = new JPanel();
                JLabel isi = new JLabel();
                try {
                    isi = new JLabel(new ImageIcon(c.getSprite()));
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }

                jp.setLayout(new GridLayoutManager(1, 1, new Insets(0, 0, 0, 0), -1, -1));

                isi.setText("s");
                isi.setOpaque(true);
                isi.setBackground(mapGrid.get(j).get(i).getBGColor());
                isi.setMinimumSize(new Dimension(size,size));

                jp.add(isi, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW | GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW | GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
                jp.setSize(size, size);

                GridBagConstraints gbg = new GridBagConstraints();
                gbg.gridx = i;
                gbg.gridy = j;
                gbg.weightx = 1;
                gbg.weighty = 1;

                mapPanel.add(jp, gbg);
                // matrix[j][i] = temp.get(j).get(i).render();
            }
        }

        panel1.add(mapPanel,new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_WANT_GROW, null, null, new Dimension(boxSize,boxSize), 0, false));

        panel1.repaint();
        panel1.revalidate();



        // ArrayList<FarmAnimal> animal = map.getFarmAnimals();


        // for(FarmAnimal el : animal){
        //     String render = "";
        //     if(!el.getEatStatus()){
        //         //red back
        //         render = "\u001B[41m";
        //     }
        //     // matrix[el.getY()][el.getX()] = render + el.render() + "\u001B[0m";
        // }
        
        // for (int j =0;j<temp.size();j++){
        //     for(int i =0; i<temp.get(0).size();i++){
        //         // System.out.print(matrix[j][i]+' ');
        //     }
        //     // System.out.println();
        // }
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}