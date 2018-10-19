package bl;


import javax.swing.table.AbstractTableModel;


/**
 *
 * @author Matthias
 */
public class KniffelTableModel extends AbstractTableModel{
    
    private static String[] columns = {"Spiel", "Wahl", "Punkte"};

    private KniffelRow[] rows;
    private KniffelBL bl = new KniffelBL();
    
    {
        KniffelValue[] values = KniffelValue.values();
        rows = new KniffelRow[values.length];
        for (int i = 0; i < values.length; i++) {
            rows[i] = new KniffelRow(values[i], false);
        }
    }

    public boolean selectGame(int i, int[] dice) {
        KniffelRow row = rows[i];
        if(row.isSelected())
            return false;
        row.setSelected(true);
        row.setPoints(bl.getPoints(row.getName(), dice));
        fireTableCellUpdated(i, 1);
        fireTableCellUpdated(i, 2);
        return true;
    }
    
    public int upperSum() {
        int sum = 0;
        for (int i = 0; i < 6; i++) {
            sum += rows[i].getPoints();
        }
        return sum;
    }
    
    public int upperBonus() {
        if(upperSum() >= 63) {
            return 35;
        }
        return 0;
    }
    
    public int lowerSum() {
        int sum = 0;
        for (int i = 6; i < rows.length; i++) {
            sum += rows[i].getPoints();
        }
        return sum;
    }
    
    public int totalSum() {
        return upperBonus() + upperSum() + lowerSum();
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
        return rows[rowIndex];
    }

    @Override
    public String getColumnName(int column) {
        return columns[column];
    }
}
