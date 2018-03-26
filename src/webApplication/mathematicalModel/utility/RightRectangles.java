package webApplication.mathematicalModel.utility;

import webApplication.mathematicalModel.Kernel;
import webApplication.mathematicalModel.X;

public class RightRectangles {

    public void getRightPart(Kernel kernel, X x, double[] y, int m, double h) {
        for (int i = 0; i < m; i++) {
            double coordinate = 0;
            for (int j = 0; j < m; j++) {
                coordinate += h * kernel.getKernel(i * h, j * h) * x.getX(j * h);
            }
            y[i] = coordinate;
        }
    }
}
