package webApplication.mathematicalModel.kernel;

import webApplication.mathematicalModel.Kernel;

public class Kernel9 implements Kernel {
    @Override
    public double getKernel(double t, double s) {
        return kernel(t, s);
    }

    private double kernel(double t, double s){
        if(s <= t){
            return s*(t - 1);
        }else{
            return t*(s - 1);
        }
    }
}
