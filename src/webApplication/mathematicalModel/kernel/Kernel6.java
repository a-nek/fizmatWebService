package webApplication.mathematicalModel.kernel;

import webApplication.mathematicalModel.Kernel;

public class Kernel6 implements Kernel {
    @Override
    public double getKernel(double t, double s) {
        return kernel(t, s);
    }

    private double kernel(double t, double s){
        if(t <= s){
            return t*(1 - s)*(2*s - s*s - t*t);
        }else{
            return s*(1 - t)*(2*t - s*s - t*t);
        }
    }
}
