package webApplication.mathematicalModel.method.explicitMethod1;

import webApplication.mathematicalModel.Result;

public class ResultTable implements Result {
    private double t[];
    private double y[];
    private double xExact[];
    private double xSolution[];
    private double norm1, norm2, norm3;
    private int n;

    ResultTable(double t[], double y[], double xExact[], double xSolution[], double norm1, double norm2, double norm3, int n) {
        this.t = t;
        this.y = y;
        this.xExact = xExact;
        this.xSolution = xSolution;
        this.norm1 = norm1;
        this.norm2 = norm2;
        this.norm3 = norm3;
        this.n = n;
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
        return xExact;
    }

    @Override
    public double[] getMethodSolution() {
        return xSolution;
    }

    @Override
    public int getNumberOfIterations() {
        return n;
    }

    @Override
    public double getNorm1() {
        return norm1;
    }

    @Override
    public double getNorm2() {
        return norm2;
    }

    @Override
    public double getNorm3() {
        return norm3;
    }
}
