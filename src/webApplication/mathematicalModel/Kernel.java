package webApplication.mathematicalModel;
/*
    K(x, s)
 */
public interface Kernel {
    public double getKernel(double[] t, double[] s);
}
