package webApplication.mathematicalModel;

import org.knowm.xchart.BitmapEncoder;
import org.knowm.xchart.QuickChart;
import org.knowm.xchart.SwingWrapper;
import org.knowm.xchart.XYChart;
import webApplication.mathematicalModel.kernel.Kernel10;
import webApplication.mathematicalModel.method.alternatingStep.AlternatingStep;
import webApplication.mathematicalModel.method.test.ResultTest;
import webApplication.mathematicalModel.x.X1;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        AlternatingStep alternatingStep = new AlternatingStep();
        alternatingStep.calculate(new Kernel10(),new X1(), );
        alternatingStep.getResult();

        System.out.println(alternatingStep.getResult().getNorm1());



















        double[] xData = new ResultTest().getPoints();
        double[] yData = new ResultTest().getExactSolution();

        // Create Chart
        XYChart chart = QuickChart.getChart("Exact", "X", "Y", "y(x)", xData, yData);

        chart.addSeries("mpi", xData, new ResultTest().getMethodSolution());

        // Show it
        new SwingWrapper(chart).displayChart();

        try {
            BitmapEncoder.saveBitmap(chart, "picture", BitmapEncoder.BitmapFormat.JPG);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    // возвращает массив строкой в квадратных скобках [23.4,23.3,43.34  ... ]
    private static String arrToString(double[] array){
        String string = "[";

        for (int i = 0; i < array.length-2; i++) {// перебираем до пред. последнего эл-та
            string += array[i] + ",";
        }
        string += array[array.length-1];
        return string + "]";
    }
}
