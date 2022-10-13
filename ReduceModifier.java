public class ReduceModifier extends PercentageModifier {
    
    public ReduceModifier(double modifier) {
        super(modifier);
    }

    public double getModifier() {
        return 1.0 - modifier;
    }
}
