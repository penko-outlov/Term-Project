package ui2;

import ui2.queries.QueryPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.List;

public class TableSidePanel extends JPanel implements ItemListener {

    private List<String> queryNames = new ArrayList<>();
    private List<JPanel> queryPanels = new ArrayList<>();

    private JPanel cards;

    public TableSidePanel() {
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
    }

    public void addQueryPanel(QueryPanel panel, String name) {
        JPanel temp = new JPanel();
        temp.add(panel);
        queryPanels.add(temp);
        queryNames.add(name);
    }

    public void initialize() {
        JPanel comboBoxPanel = new JPanel();
        JComboBox comboBox = new JComboBox(queryNames.toArray());
        comboBox.setEditable(false);
        comboBox.addItemListener(this);
        comboBoxPanel.add(comboBox);

        cards = new JPanel(new CardLayout());
        for(int i = 0; i < queryPanels.size(); i++) {
            cards.add(queryPanels.get(i), queryNames.get(i));
        }

        this.add(comboBoxPanel);
        this.add(cards);
    }

    public void itemStateChanged(ItemEvent evt) {
        CardLayout cl = (CardLayout)(cards.getLayout());
        cl.show(cards, (String)evt.getItem());
    }
}
