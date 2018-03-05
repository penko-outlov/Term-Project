package visual;

import database.TableModel;

public class DepartmentPanel extends TablePanel {
    public DepartmentPanel(TableModel tableModel) {
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
