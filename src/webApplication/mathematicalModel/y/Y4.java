package webApplication.mathematicalModel.y;

import webApplication.mathematicalModel.Y;

public class Y4 implements Y {
    @Override
    public boolean isExist() {
        return true;
    }

    @Override
    public double getY(double t) {
        return (3*t - 5*Math.pow(t, 3) + 3*Math.pow(t, 5) - Math.pow(t, 6))/30;
    }
}
