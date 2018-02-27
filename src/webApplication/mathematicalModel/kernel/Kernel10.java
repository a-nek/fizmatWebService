package webApplication.mathematicalModel.kernel;

import webApplication.mathematicalModel.Kernel;

public class Kernel10 implements Kernel {
    @Override
    public double getKernel(double t, double s) {
        return kernel(t, s);
    }
    private double kernel (double t, double s){
        if(s <= t){
            return Math.PI*Math.PI*s*(1-t);
        }else{
            return Math.PI*Math.PI*t*(1-s);
        }
    }

}
