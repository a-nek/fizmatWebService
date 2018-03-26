package webApplication.mathematicalModel.y;

import webApplication.mathematicalModel.Y;

public class Y5 implements Y {
    @Override
    public boolean isExist() {
        return true;
    }

    @Override
    public double getY(double t) {
        return (t - 2*Math.pow(t, 3) + Math.pow(t, 4))/4;
    }
}
