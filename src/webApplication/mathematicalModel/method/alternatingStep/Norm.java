package webApplication.mathematicalModel.method.alternatingStep;

import webApplication.mathematicalModel.Kernel;
import webApplication.mathematicalModel.X;
import webApplication.mathematicalModel.method.alternatingStep.RightPart;

public class Norm {
    int m;
    double h;

    public Norm(int m, double h) {
        this.m = m;
        this.h = h;
    }

    //Дискретная норма невязки.
    public double DiscreteNorm(double[] x, Kernel kernel, double[] y, double delta) {
        double norm = 0;
        for (int i = 0; i < m; i++) {
            double sum = 0;
            for (int j = 0; j < m; j++) {
                sum += kernel.getKernel(i * h, j * h) * x[j];
            }
            sum *= h;
            sum -= new RightPart().getApproximateY(y[i], delta);
            sum *= sum * h;
            norm += sum;
        }
        return Math.sqrt(norm);
    }

    //Норма приближенного решения
    public double ApproximateNorm(double[] x) {
        double norm = 0;
        for (int i = 0; i < m; i++) {
            norm += x[i] * x[i];
        }
        norm *= h;
        return Math.sqrt(norm);
    }

    //Дискретная норма разности между точным и приближенным решениями
    public double DifferenceNorm(double[] apprX, X x) {
        double norm = 0;
        for (int i = 0; i < m; i++) {
            norm += Math.pow(x.getX(i * h) - apprX[i], 2);
        }
        norm *= h;
        return Math.sqrt(norm);
    }
}
