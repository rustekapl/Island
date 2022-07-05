package ru.javarush.island.sheff.view;

import ru.javarush.island.sheff.entities.map.Cell;
import ru.javarush.island.sheff.entities.map.GameMap;

import javax.swing.*;
import java.awt.*;

public class SimulatorView extends JFrame {

    private JLabel stepLabel, population;
    private Cell[][] cells;
    private int rows;
    private int cols;
    private JPanel panel;
    private JTextArea[][] fields;
    private JPanel infoPane;
    private Container contents;

    public void startView(GameMap gameMap, String statistics) {
        cells = gameMap.getCells();
        rows = gameMap.getRowsLength();
        cols = gameMap.getColsLength();

        setTitle(ViewConstants.TITLE.toString());

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        contents = getContentPane();
        setLocationRelativeTo(null);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setVisible(true);
        updateView(0, statistics);
    }

    public void updateView(int day, String statistics) {

        contents.removeAll();

        EventQueue.invokeLater(() -> {
            stepLabel = new JLabel(ViewConstants.STEP_PREFIX.toString() + day, JLabel.CENTER);
            population = new JLabel(ViewConstants.POPULATION_PREFIX + statistics, JLabel.CENTER);
            infoPane = new JPanel(new BorderLayout());

            infoPane.add(stepLabel, BorderLayout.WEST);
            infoPane.add(population, BorderLayout.CENTER);

            fields = new JTextArea[rows][cols];
            panel = new JPanel(new GridLayout(rows, cols));

            for (int row = 0; row < rows; row++) {
                for (int col = 0; col < cols; col++) {
                    fields[row][col] = new JTextArea();
                    fields[row][col].setLineWrap(true);
                    fields[row][col].setWrapStyleWord(false);
                    //TODO Coding. Magic values or methods. Bad reading and understanding
                    fields[row][col].setFont(fields[row][col].getFont().deriveFont(9f));
                    fields[row][col].setText(cells[row][col].toString());
                    String text = fields[row][col].getText();
                    if (text.contains("\uD83C\uDF3F")) {
                        fields[row][col].setBackground(new Color(200, 255, 0));
                    } else {
                        fields[row][col].setBackground(new Color(255, 200, 0));
                    }
                    fields[row][col].revalidate();
                    fields[row][col].setRows(16);
                    fields[row][col].setColumns(5);
                    panel.add(fields[row][col]);
                    panel.revalidate();
                }
            }

            contents.add(infoPane, BorderLayout.NORTH);
            add(panel);
            pack();
            invalidate();
            setVisible(true);
        });
    }

    public void getMessage(String message) {
        JOptionPane.showMessageDialog(this, message);
    }
}
