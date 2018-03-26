package webApplication.mathematicalModel.method.alternatingStep;

import webApplication.mathematicalModel.*;
import webApplication.mathematicalModel.utility.RightRectangles;

public class AlternatingStep implements Method {
    final double ALPHA = 0.8;
    final double BETTA = 4.4;
    private int m;
    private double delta, epsilon, h;
    private double norm1, norm2, norm3;
    private double[] current;
    private double[] rightP;
    private int iterations;
    Kernel kernel;
    X x;
    ResultTable resultTable;

    public AlternatingStep() {
        m = 32;
        h = 1. / m;
        current = new double[m];
        rightP = new double[m];
    }

    public void solveMethod() {
        double[] previous = new double[m];
        epsilon = 1.5 * delta;

        do {
            iterations++;

            for (int i = 0; i < m; i++) {
                double element = 0;
                double sum = 0;

                for (int j = 0; j < m; j++) {
                    sum += kernel.getKernel(i * h, j * h) * previous[j];
                }
                sum *= h;
                element = new RightPart().getApproximateY(rightP[i], delta) - sum;

                //Смена параметра в зависимости от четности/нечетности шага
                if (iterations % 2 == 0)
                    element *= BETTA;
                else element *= ALPHA;

                element += previous[i];
                current[i] = element;
            }

            //Вычисление всех необходимых норм результирующего вектора
            norm1 = new Norm(m, h).DiscreteNorm(current, kernel, rightP, delta);
            norm2 = new Norm(m, h).ApproximateNorm(current);
            norm3 = new Norm(m, h).DifferenceNorm(current, x);

            System.arraycopy(current, 0, previous, 0, m);

        } while (norm1 > epsilon);

        resultTable = new ResultTable(createNodes(), rightP, createExactSolution(), current, norm1, norm2, norm3, iterations);
    }

    private double[] createNodes() {
        double[] t = new double[m];
        for (int i = 0; i < m; i++) {
            t[i] = i * h;
        }
        return t;
    }

    private void createRightPart(Y y, double[] vector) {
        for (int i = 0; i < m; i++)
            vector[i] = y.getY(i * h);
    }

    private double[] createExactSolution() {
        double[] vector = new double[m];
        for (int i = 0; i < m; i++) {
            vector[i] = x.getX(i * h);
        }
        return vector;
    }

    @Override
    public void calculate(Kernel kernel, X x, Y y, Options options) {
        this.delta = options.getDelta();
        this.kernel = kernel;
        this.x = x;
        if (y.isExist())
            createRightPart(y, rightP);
        else
            new RightRectangles().getRightPart(kernel, x, rightP, m, h);
        solveMethod();
    }

    @Override
    public Result getResult() {
        return resultTable;
    }
}
