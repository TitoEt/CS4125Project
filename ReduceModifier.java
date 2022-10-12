public class ReduceModifier extends PercentageModifier{
    
    public ReduceModifier(double modifier) {
        super(modifier);
    }

    public double getModifier() {
        return modifier * -1.0;
    }
}
