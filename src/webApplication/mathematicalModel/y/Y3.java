package webApplication.mathematicalModel.y;

import webApplication.mathematicalModel.Y;

public class Y3 implements Y {
    @Override
    public boolean isExist() {
        return true;
    }

    @Override
    public double getY(double t) {
        return t/6;
    }
}
