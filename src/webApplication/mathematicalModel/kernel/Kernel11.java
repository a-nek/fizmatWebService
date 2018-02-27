package webApplication.mathematicalModel.kernel;

import webApplication.mathematicalModel.Kernel;

public class Kernel11 implements Kernel {
    @Override
    public double getKernel(double t, double s) {
        return Math.log((t+s)/(t+s+1));
    }
}
