package visual;

import database.TableModel;

public class TaskPanel extends TablePanel {
    public TaskPanel(TableModel tableModel) {
        super(tableModel);
        makeSidePanel();
    }

    @Override
    protected void makeSidePanel() {
        sidePanel.add(info);
        sidePanel.add(controls);
        sidePanel.add(execute);
        add(sidePanel);
    }
}
