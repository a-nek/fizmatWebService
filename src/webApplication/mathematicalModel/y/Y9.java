package webApplication.mathematicalModel.y;

import webApplication.mathematicalModel.Y;

public class Y9 implements Y {
    @Override
    public boolean isExist() {
        return true;
    }

    @Override
    public double getY(double t) {
        return t * (t - 1) * (t * t - t - 1) / 12;
    }
}
