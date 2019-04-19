package id.backendk3.engifarm.View;

import com.intellij.uiDesigner.core.GridConstraints;
import com.intellij.uiDesigner.core.GridLayoutManager;
import id.backendk3.engifarm.Cell.Cell;
import id.backendk3.engifarm.Farm;
import id.backendk3.engifarm.FarmAnimal.FarmAnimal;
import id.backendk3.engifarm.Player;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

// import id.backendk3.engifarm.Cell.Land.Coop;

public class MapView extends JPanel implements Observer {
    final int ANIMAL_PADDING = 5;
    final int GRASS_PADDING = 15;
    final int PLAYER_PADDING = 5;

    private JPanel mainPanel;
    private JPanel[][] tiles;
    private JPanel oldPanel;

    private Player player;

    ArrayList<ArrayList<Cell>> mapGrid;
    ArrayList<FarmAnimal> animal;

    public MapView(Player p, Farm f) {
        mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayoutManager(1, 1, new Insets(0, 0, 0, 0), -1, -1));
        player = p;

        mapGrid = f.getMap();
        animal = f.getFarmAnimals();

        int row = mapGrid.size();
        int col = mapGrid.get(0).size();

        tiles = new JPanel[row][col];
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return mainPanel;
    }

    public void update(Observable observable, Object arg) {

        if(observable instanceof Farm){    
            Farm farm = (Farm) observable;
            mapGrid = farm.getMap();
            animal = farm.getFarmAnimals();

        }else if(observable instanceof Player){
            Player p = (Player) observable;
            player = p;
        }

        JPanel mapPanel = new JPanel();
    
        mapPanel.setLayout(new GridBagLayout());

        int height = mainPanel.getHeight();
        int width = mainPanel.getWidth();

        int size = height < width ? height : width;
        int boxSize = size;

        int row = mapGrid.size();
        int col = mapGrid.get(0).size();

        size = size / mapGrid.size();

        for (int j =0;j<row;j++){
            for(int i =0; i<col;i++){
                JPanel jp = new JPanel();
                JLabel isi = new JLabel();

                try {
                    isi = new JLabel(new ImageIcon(mapGrid.get(j).get(i).getSprite().getScaledInstance(size-GRASS_PADDING, size-GRASS_PADDING, Image.SCALE_FAST)));
                } catch (IOException e) {
                    System.out.println("Missing assets");
                    e.printStackTrace();
                } catch (NullPointerException e){
                    
                }

                
                jp.setLayout(new GridLayoutManager(1, 1, new Insets(0, 0, 0, 0), -1, -1));

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

                tiles[j][i] = jp;
                
                mapPanel.add(jp, gbg);
            }
        }
        
        for(FarmAnimal el : animal){
            JLabel temp = new JLabel();
            try {
                temp = new JLabel(new ImageIcon(el.getSprite().getScaledInstance(size-ANIMAL_PADDING,size-ANIMAL_PADDING, Image.SCALE_FAST)));
            } catch (IOException e) {
                System.out.println("Missing assets");
                e.printStackTrace();
                temp = new JLabel();
            }

            temp.setMinimumSize(new Dimension(size,size));
            tiles[el.getY()][el.getX()].add(temp,new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW | GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW | GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
            tiles[el.getY()][el.getX()].setComponentZOrder(temp, 0);
        }

        JLabel playerLabel = new JLabel();
        try {
            playerLabel = new JLabel(new ImageIcon(player.getSprite().getScaledInstance(size-PLAYER_PADDING,size-PLAYER_PADDING, Image.SCALE_FAST)));
        } catch (IOException e) {
            System.out.println("Missing assets");
            e.printStackTrace();
            playerLabel = new JLabel();
        }

        playerLabel.setMinimumSize(new Dimension(size,size));

        tiles[player.getY()][player.getX()].add(playerLabel,new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW | GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW | GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        tiles[player.getY()][player.getX()].setComponentZOrder(playerLabel, 0);
        
        mainPanel.add(mapPanel,new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_WANT_GROW, null, null, new Dimension(boxSize,boxSize), 0, false));
        mainPanel.setComponentZOrder(mapPanel, 0);

        mainPanel.revalidate();
        
        if(oldPanel!=null){
            mainPanel.remove(oldPanel);
        }

        oldPanel = mapPanel;        
    }
}
