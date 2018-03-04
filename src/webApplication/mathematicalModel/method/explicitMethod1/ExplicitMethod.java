package webApplication.mathematicalModel.method.explicitMethod1;

import webApplication.mathematicalModel.*;

public class ExplicitMethod implements Method {
    int m = 32;
    double t[] = new double[m];
    double K[][] = new double[m][m];

    double y[] = new double[m];
    double x[] = new double[m];
    double y1[] = new double[m];

    double xm[] = new double[m];

    ResultTable result;

    public void yApproximate(int k) {
        for (int i = 0; i < m; i++) {
            y1[i] = ((int) (y[i] * Math.pow(10, k) + 0.5)) * (1. / Math.pow(10, k));
        }
    }

    public void firstMethod(int k) {
        int n = 0;
        double h = 1. / m;

        double xp[] = new double[m];
        double sum1[] = new double[m];
        double sum2[] = new double[m];
        double sum3[] = new double[m];
        double sum4[] = new double[m];
        double norma1, norma2, norma3;
        double l = 0.8;

        for (int i = 0; i < m; i++) {
            xm[i] = 0;
        }

        do {
            norma1 = 0;
            norma2 = 0;
            norma3 = 0;
            for (int i = 0; i < m; i++) {
                xp[i] = xm[i];
                sum1[i] = 0;
                sum2[i] = 0;
                sum3[i] = 0;
                sum4[i] = 0;
            }

            for (int i = 0; i < m; i++) {

                for (int j = 0; j < m; j++) {
                    for (int t = 0; t < m; t++) {
                        sum1[j] += K[j][t] * h * xp[t];
                    }
                    sum2[i] += K[i][j] * h * sum1[j];
                    sum1[j] = 0;
                    sum3[i] += K[i][j] * h * y1[j];
                    sum4[i] += K[i][j] * h * xp[j];
                }
                xm[i] = xp[i] - l * sum2[i] + l * sum3[i];
                norma1 += Math.pow(sum4[i] - y1[i], 2) * h;
                norma2 += Math.pow(xp[i], 2) * h;
                norma3 += Math.pow(x[i] - xp[i], 2) * h;
            }
            n++;
        } while (Math.pow(norma1, 1. / 2) > 1.5 * Math.pow(10, (-1) * k));

      //  System.out.println("******************************Метод X(n+1) ********************************");
      //  System.out.println("Узлы t[i]" + "\t" + "Правые части y[i]" + "\t" + "Точные решения x[i]" + "\t" + "Приближённые решения x*[i]");
        result = new ResultTable(t, y, x, xm, Math.pow(norma1, 1. / 2), Math.pow(norma2, 1. / 2), Math.pow(norma3, 1. / 2));
//        for (int i = 0; i < m; i++) {
//            System.out.println(t[i] + "\t\t" + y[i] + "\t" + x[i] + "\t\t\t" + xm[i]);
//        }
//        System.out.println("Количество итераций = " + n);
//        System.out.println("норма 1 = " + Math.pow(norma1, 1. / 2));
//        System.out.println("норма 2 = " + Math.pow(norma2, 1. / 2));
//        System.out.println("норма 3 = " + Math.pow(norma3, 1. / 2));

    }


    @Override
    public void calculate(Kernel kernel, X x, Y y, Options options) {
        this.K = kernel;
        this.x = x;
        this.y = y;
        yApproximate(k);
        firstMethod(k);

    }

    @Override
    public Result getResult() {
        return result;
    }
}
