package bl;


import javax.swing.table.AbstractTableModel;


/**
 *
 * @author Matthias
 */
public class KniffelTableModel extends AbstractTableModel{
    
    private static String[] columns = {"Spiel", "Wahl", "Punkte"};
    
    private KniffelRow[] rows;
    
    {
        KniffelValue[] values = KniffelValue.values();
        rows = new KniffelRow[values.length];
        for (int i = 0; i < values.length; i++) {
            rows[i] = new KniffelRow(values[i], false);
        }
    }

    @Override
    public int getRowCount() {
        return rows.length;
    }

    @Override
    public int getColumnCount() {
        return columns.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        KniffelRow row = rows[rowIndex];
        
        switch(columnIndex) {
            case 0: return row.getName();
            case 1: return row.isSelected();
            case 2: return row.getPoints();
        }
        return "?";
    }

    @Override
    public String getColumnName(int column) {
        return columns[column];
    }
}
