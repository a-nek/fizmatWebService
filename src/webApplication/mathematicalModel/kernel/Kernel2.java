package webApplication.mathematicalModel.kernel;

import webApplication.mathematicalModel.Kernel;

public class Kernel2 implements Kernel {

    @Override
    public double getKernel(double t, double s) {
        return Math.exp(t*s);
    }
}
