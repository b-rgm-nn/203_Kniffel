package bl;

import java.util.Random;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Matthias
 */
public class DiceTableModel extends AbstractTableModel {

    private Dice[] dice = new Dice[6];
    private int tosses;

    {
        resetTosses();
        for (int i = 0; i < dice.length; i++) {
            dice[i] = new Dice(0, false);
        }
    }

    public void toggleSelected(int col) {
        if(dice[col].getValue() == 0)
            return;
        dice[col].toggleFixed();
        fireTableCellUpdated(0, col);
    }

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
        if(--tosses < 0)
            return;
        
        Random rand = new Random();
        for (int i = 0; i < dice.length; i++) {
            if(dice[i].isFixed())
                continue;
            dice[i].setValue(rand.nextInt(6) + 1);
        }
        fireTableRowsUpdated(0, 0);
    }

    public void resetTosses() {
        tosses = 3;
    }
}
