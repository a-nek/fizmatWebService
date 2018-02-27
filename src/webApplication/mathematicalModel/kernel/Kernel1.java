package webApplication.mathematicalModel.kernel;

import webApplication.mathematicalModel.Kernel;

public class Kernel1 implements Kernel {
    @Override
    public double getKernel(double t, double s) {
        return (t + s)/2 + t*s + 1./3;
    }
}
