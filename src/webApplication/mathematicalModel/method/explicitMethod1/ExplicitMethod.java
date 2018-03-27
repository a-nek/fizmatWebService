package webApplication.mathematicalModel.method.explicitMethod1;

import webApplication.mathematicalModel.*;
import webApplication.mathematicalModel.utility.RightRectangles;

public class ExplicitMethod implements Method {
    private int m;
    private double h;
    private double delta;
    private double t[];
    private double x[];
    private double xExact[];
    private double[] y;
    private double yApprox[];
    private X xModel;
    private Kernel kernel;
    private ResultTable result;

    public ExplicitMethod() {
        m = 32;
        h = 1. / m;
        t = new double[m];
        x = new double[m];
        y = new double[m];
        xExact = new double[m];
        yApprox = new double[m];
        setT();
    }

    private void yApproximate() {
        for (int i = 0; i < m; i++) {
            yApprox[i] = ((int) (y[i] / delta) + 0.5) * delta;
        }
    }

    private void solutionMethod() {
        int n = 0;
        double xPrevious[] = new double[m];
        double sum1, sum2, sum3, sum4;
        double norm1, norm2, norm3;
        double alpha = 0.8;

        do {
            norm1 = 0;
            norm2 = 0;
            norm3 = 0;
            System.arraycopy(x, 0, xPrevious, 0, m);
            for (int i = 0; i < m; i++) {
                sum1 = 0;
                sum2 = 0;
                sum3 = 0;
                sum4 = 0;
                for (int j = 0; j < m; j++) {
                    for (int k = 0; k < m; k++) {
                        sum1 += kernel.getKernel(t[j], k * h) * h * xPrevious[k];
                    }
                    sum2 += kernel.getKernel(t[i], j * h) * h * sum1;
                    sum3 += kernel.getKernel(t[i], j * h) * h * yApprox[j];
                    sum4 += kernel.getKernel(t[i], j * h) * h * xPrevious[j];
                    sum1 = 0;
                }
                x[i] = xPrevious[i] - alpha * sum2 + alpha * sum3;
                norm1 += Math.pow(sum4 - yApprox[i], 2) * h;
                norm2 += Math.pow(x[i], 2) * h;
                norm3 += Math.pow(xExact[i] - x[i], 2) * h;
            }
            n++;
        } while (Math.pow(norm1, 1. / 2) > 1.5 * delta);
        result = new ResultTable(t, y, xExact, x, Math.pow(norm1, 1. / 2), Math.pow(norm2, 1. / 2), Math.pow(norm3, 1. / 2), n);
    }

    private void setY(Y yModel) {
        for (int i = 0; i < m; i++)
            y[i] = yModel.getY(t[i]);
    }

    private void setXExact() {
        for (int i = 0; i < m; i++) {
            xExact[i] = xModel.getX(t[i]);
        }
    }

    private void setT() {
        for (int i = 0; i < m; i++) {
            t[i] = h + i * h;
        }
    }

    @Override
    public void calculate(Kernel kernel, X xModel, Y yModel, Options options) {
        this.delta = options.getDelta();
        this.kernel = kernel;
        this.xModel = xModel;
        setXExact();
        if (yModel.isExist()) {
            setY(yModel);
        } else {
            new RightRectangles().getRightPart(kernel, xModel, y, m, h);
        }
        yApproximate();
        solutionMethod();
    }

    @Override
    public Result getResult() {
        return result;
    }
}
