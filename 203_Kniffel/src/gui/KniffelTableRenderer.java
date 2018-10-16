package gui;

import bl.KniffelRow;
import java.awt.Component;
import javax.swing.JCheckBox;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

/**
 *
 * @author Matthias
 */
public class KniffelTableRenderer implements TableCellRenderer {

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        KniffelRow kniffelRow = (KniffelRow) value;
        if(column == 1) {
            JCheckBox cb = new JCheckBox();
            cb.setSelected(kniffelRow.isSelected());
            return cb;
        }
        
        JLabel label = new JLabel();
        
        switch(column) {
            case 0: label.setText(kniffelRow.getName().toString()); break;
            case 2: label.setText(kniffelRow.getPoints()+""); break;
            default: label.setText("?");
        }
        
        return label;
    }
    
}
