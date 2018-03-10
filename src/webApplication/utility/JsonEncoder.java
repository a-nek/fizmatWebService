package webApplication.utility;

import webApplication.mathematicalModel.Result;

/*
Будет представлять объекты, которые являются
реализацией интерфейса Result, в JSON формате
 */
public class JsonEncoder {
    public String toJson(Result result) {
        String json = "{";

        json += "\"methodSolution\":" + arrToString(result.getMethodSolution()) + ","
                + "\"exactSolution\":" + arrToString(result.getExactSolution()) + ","
                + "\"rightParts\":" + arrToString(result.getRightParts()) + ","
                + "\"points\":" + arrToString(result.getPoints()) + ","
                + "\"numberOfIterations\":" + result.getNumberOfIterations() + ","
                + "\"norm1\":" + result.getNorm1() + ","
                + "\"norm2\":" + result.getNorm2() + ","
                + "\"norm3\":" + result.getNorm3();

        json += "}";
        return json;
    }

    // возвращает массив строкой в квадратных скобках [23.4,23.3,43.34  ... ]
    private String arrToString(double[] array){
        String string = "[";

        for (int i = 0; i < array.length-2; i++) {// перебираем до пред. последнего эл-та
            string += array[i] + ",";
        }
        string += array[array.length-1];
        return string + "]";
    }
}
