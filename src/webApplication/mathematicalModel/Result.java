package webApplication.mathematicalModel;

public interface Result {

    public double[] getPoints(); // возвращает узлы t_i
    public double[] geRightParts(); // возвращает правые части y(t_i)
    public double[] getExactSolution(); // возвращает точное решение x(t_i)
    public double[] getMethodSolution(); // возвращает решение метода при к-либо значении дельта

    public double getNorm1(); // 1-я норма
    public double getNorm2(); // 2-я норма
    public double getNorm3(); // 3-я норма


}
