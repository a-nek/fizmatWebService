package webApplication.mathematicalModel.method.alternatingStep;

public class RightPart {

    private double approximation(double element, double delta) {
        return Math.floor(element / delta + 0.5) * delta;
    }

    public double getApproximateY(double element, double delta) {
        return approximation(element, delta);
    }
}
