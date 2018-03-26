package webApplication.mathematicalModel.method.alternatingStep;

import webApplication.mathematicalModel.Result;

public class ResultTable implements Result {
    int iterations;
    double[] t;
    double[] x;
    double[] y;
    double[] result;
    double norm1, norm2, norm3;

    public ResultTable(double t[], double y[], double x[], double result[], double norm1, double norm2, double norm3, int iterations) {
        this.iterations = iterations;
        this.t = t;
        this.y = y;
        this.x = x;
        this.result = result;
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
        return result;
    }

    @Override
    public int getNumberOfIterations() {
        return iterations;
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
