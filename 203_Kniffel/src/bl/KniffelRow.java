package bl;


/**
 *
 * @author Matthias
 */
public class KniffelRow {
    private KniffelValue name;
    private boolean selected;

    public KniffelRow(KniffelValue name, boolean selected) {
        this.name = name;
        this.selected = selected;
    }

    public KniffelValue getName() {
        return name;
    }

    public int getPoints() {
        return 0;
    }

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }
}
