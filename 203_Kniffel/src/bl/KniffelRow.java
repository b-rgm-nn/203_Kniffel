package bl;


/**
 *
 * @author Matthias
 */
public class KniffelRow {
    private KniffelValue name;
    private boolean selected;
    private int points;

    public KniffelRow(KniffelValue name, boolean selected, int points) {
        this.name = name;
        this.selected = selected;
        this.points = points;
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
