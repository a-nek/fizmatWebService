package webApplication.mathematicalModel.method.alternatingStep;

import webApplication.mathematicalModel.Result;

public class ResultTable implements Result {
    @Override
    public double[] getPoints() {
        return new double[0];
    }

    @Override
    public double[] getRightParts() {
        return new double[0];
    }

    @Override
    public double[] getExactSolution() {
        return new double[0];
    }

    @Override
    public double[] getMethodSolution() {
        return new double[0];
    }

    @Override
    public int getNumberOfIterations() {
        return 0;
    }


    @Override
    public double getNorm1() {
        return 0;
    }

    @Override
    public double getNorm2() {
        return 0;
    }

    @Override
    public double getNorm3() {
        return 0;
    }
}
