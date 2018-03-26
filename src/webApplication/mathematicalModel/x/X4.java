package webApplication.mathematicalModel.x;

import webApplication.mathematicalModel.X;

public class X4 implements X {
    @Override
    public double getX(double s) {
        return Math.pow(1 - s*s, 2);
    }
}
