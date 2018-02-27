package webApplication.mathematicalModel.y;

import webApplication.mathematicalModel.Y;

public class Y6 implements Y {
    @Override
    public boolean isExist() {
        return true;
    }

    @Override
    public double getY(double t) {
        return 1./6 * (Math.pow(t, 3) - t);
    }
}
