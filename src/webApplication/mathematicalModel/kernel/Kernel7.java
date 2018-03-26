package webApplication.mathematicalModel.kernel;

import webApplication.mathematicalModel.Kernel;

public class Kernel7 implements Kernel {
    @Override
    public double getKernel(double t, double s) {
        return 1/(Math.PI*Math.pow((s-t),2) + 1);
    }
}
