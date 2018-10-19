package bl;

import java.util.Random;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Matthias
 */
public class DiceTableModel extends AbstractTableModel {

    int[] dice = new int[6];

    @Override
    public int getRowCount() {
        return 1;
    }

    @Override
    public int getColumnCount() {
        return dice.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return dice[columnIndex];
    }

    public void toss() {
        Random rand = new Random();
        for (int i = 0; i < dice.length; i++) {
            dice[i] = rand.nextInt(6)+1;
        }
        fireTableRowsUpdated(0, 0);
    }

}
