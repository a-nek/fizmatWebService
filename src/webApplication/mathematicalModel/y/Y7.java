package webApplication.mathematicalModel.y;

import webApplication.mathematicalModel.Y;

public class Y7 implements Y {
    @Override
    public boolean isExist() {
        return true;
    }

    @Override
    public double getY(double t) {
        return (Math.pow(t, 4) - 2*Math.pow(t, 3) + t)*Math.PI*Math.PI / 12;
    }
}
