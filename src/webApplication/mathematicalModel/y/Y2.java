package webApplication.mathematicalModel.y;

import webApplication.mathematicalModel.Y;

public class Y2 implements Y {
    @Override
    public boolean isExist() {
        return true;
    }

    @Override
    public double getY(double t) {
        return (Math.exp(t) - 1)/t;
    }
}
