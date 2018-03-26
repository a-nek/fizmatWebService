package webApplication.mathematicalModel.kernel;

import webApplication.mathematicalModel.Kernel;

public class Kernel3 implements Kernel{

    @Override
    public double getKernel(double t, double s) {
        return t*s;
    }
}
