package webApplication.mathematicalModel;


/*
@param kernel - dfggfh
 */
public interface Method {
    public void calculate(Kernel kernel, X x, Y y, Options options);
    public Result getResult();
}
