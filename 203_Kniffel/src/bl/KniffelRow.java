package bl;


/**
 *
 * @author Matthias
 */
public class KniffelRow {
    private KniffelValue name;
    private boolean selected;
    private int points = 0;

    public KniffelRow(KniffelValue name, boolean selected) {
        this.name = name;
        this.selected = selected;
    }

    public KniffelValue getName() {
        return name;
    }

    public int getPoints() {
        return points;
    }

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }

    public void setPoints(int points) {
        this.points = points;
    }
    
    
}
