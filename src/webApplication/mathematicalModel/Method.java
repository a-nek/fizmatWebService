package webApplication.mathematicalModel;


public interface Method {
    public void calculate(Kernel kernel, X x, Y y, Options options);
    public Result getResult();
}
