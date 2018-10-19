package gui;

import java.awt.Component;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.TableCellRenderer;

/**
 *
 * @author Matthias
 */
public class DiceTableRenderer implements TableCellRenderer {

    private ImageIcon[] images = new ImageIcon[7];

    public DiceTableRenderer() {
        images[0] = null;
        images[1] = new ImageIcon("res/Alea_1.png");
        images[2] = new ImageIcon("res/Alea_2.png");
        images[3] = new ImageIcon("res/Alea_3.png");
        images[4] = new ImageIcon("res/Alea_4.png");
        images[5] = new ImageIcon("res/Alea_5.png");
        images[6] = new ImageIcon("res/Alea_6.png");
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        JLabel label = new JLabel();
        label.setHorizontalAlignment(SwingConstants.CENTER);
        ImageIcon icon = images[(int) value];
        if (icon != null) {
            icon = new ImageIcon(icon.getImage().getScaledInstance(table.getRowHeight(), table.getRowHeight(), Image.SCALE_DEFAULT));
        }
        label.setIcon(icon);
        return label;
    }

}
