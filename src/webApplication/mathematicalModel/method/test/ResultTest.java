package webApplication.mathematicalModel.method.test;

import webApplication.mathematicalModel.Result;

public class ResultTest implements Result {
    private double[] methodSolution = {
            0.02749566085305775,
            0.05037440949547715,
            0.06746946776854099,
            0.0965832658621399,
            0.12166323328573965,
            0.16049349277113695,
            0.18059685016464583,
            0.2166822821221058,
            0.2532786434208375,
            0.2750844309019056,
            0.3173252748565976,
            0.3483474133081435,
            0.37014525095741707,
            0.40153404782159746,
            0.42813878889317947,
            0.4526632786745562,
            0.46054496675327367,
            0.45266283760351084,
            0.42813743899147305,
            0.4015308323490632,
            0.37013874414762593,
            0.34833596738810624,
            0.3173079666892893,
            0.27506383189275657,
            0.25326793744352993,
            0.2167220514960506,
            0.18079175328712266,
            0.16108535980023236,
            0.1231563201865052,
            0.09989283781133962,
            0.07387638212845436,
            0.06071129445610398,
            0.0013304945616626025,
            0.28347977161690013,
            0.013105723523906633

    };

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
        return methodSolution;
    }

    @Override
    public double[] getNumberOfIterations() {
        return new double[0];
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
