abstract class PercentageModifier {
    double modifier;

    public PercentageModifier(double modifier) {
        this.modifier = modifier;
    }

    public abstract double getModifier();
}