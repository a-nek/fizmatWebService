package webApplication.mathematicalModel.x;

import webApplication.mathematicalModel.X;

public class X6 implements X {
    @Override
    public double getX(double s) {
        return s*(1 - s);
    }
}
