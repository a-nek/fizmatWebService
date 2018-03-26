package webApplication.mathematicalModel;

/*
доп. параметры типа точности, дельта и т.д.
 */
public class Options {
    private double delta;

    public Options(double delta) {
        this.delta = delta;
    }

    public double getDelta() {
        return delta;
    }

    public void setDelta(double delta) {
        this.delta = delta;
    }
}
