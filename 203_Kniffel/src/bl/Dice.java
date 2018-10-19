package bl;

/**
 *
 * @author Matthias
 */
public class Dice {
    private int value;
    private boolean fixed;

    public Dice(int value, boolean fixed) {
        this.value = value;
        this.fixed = fixed;
    }
    
    public void toggleFixed() {
        fixed = !fixed;
    }

    public boolean isFixed() {
        return fixed;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
