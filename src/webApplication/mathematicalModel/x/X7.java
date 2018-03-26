package webApplication.mathematicalModel.x;

import webApplication.mathematicalModel.X;

public class X7 implements X {
    @Override
    public double getX(double s) {
        return 12*Math.pow(Math.PI, -2) * ((Math.pow(s, 4) - 2*Math.pow(s, 3) + s)*Math.PI*Math.PI / 12);
    }
}
