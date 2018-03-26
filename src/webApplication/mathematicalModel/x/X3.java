package webApplication.mathematicalModel.x;

import webApplication.mathematicalModel.X;

public class X3 implements X {
    @Override
    public double getX(double s) {
        return s - 2*Math.pow(s, 3) + Math.pow(s, 4);
    }
}
