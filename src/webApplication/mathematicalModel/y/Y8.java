package webApplication.mathematicalModel.y;

import webApplication.mathematicalModel.Y;

public class Y8 implements Y {
    @Override
    public boolean isExist() {
        return true;
    }

    @Override
    public double getY(double t) {
        return (-Math.pow(t, 6)/3 + Math.pow(t, 5) - 5*Math.pow(t, 3)/3 + t)*Math.PI*Math.PI /10;
    }
}
