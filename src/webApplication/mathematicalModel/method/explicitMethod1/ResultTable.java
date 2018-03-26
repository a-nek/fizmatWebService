package webApplication.mathematicalModel.method.explicitMethod1;

import webApplication.mathematicalModel.Result;

public class ResultTable implements Result {
    int m = 32;
    double t[] = new double[m];
    double y[] = new double[m];
    double x[] = new double[m];
    double xm[] = new double[m];
    double norm1, norm2, norm3;

    ResultTable(double t[], double y[], double x[], double xm[], double norm1, double norm2, double norm3) {
        this.t = t;
        this.y = y;
        this.x = x;
        this.xm = xm;
        this.norm1 = norm1;
        this.norm2 = norm2;
        this.norm3 = norm3;
    }

    @Override
    public double[] getPoints() {
        return t;
    }

    @Override
    public double[] getRightParts() {
        return y;
    }

    @Override
    public double[] getExactSolution() {
        return x;
    }

    @Override
    public double[] getMethodSolution() {
        return xm;
    }

    @Override
    public int getNumberOfIterations() {
        return 0;
    }

    @Override
    public double getNorm1() {
        return norm1;
    }

    @Override
    public double getNorm2() { return norm2; }

    @Override
    public double getNorm3() {
        return norm3;
    }
}
