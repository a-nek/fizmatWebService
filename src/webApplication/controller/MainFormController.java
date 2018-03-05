package webApplication.controller;

import webApplication.exceptions.IncorrectNumber;
import webApplication.mathematicalModel.*;
import webApplication.mathematicalModel.kernel.*;
import webApplication.mathematicalModel.x.*;
import webApplication.mathematicalModel.y.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/formcontroller")
public class MainFormController extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //RequestDispatcher requestDispatcher = req.getRequestDispatcher("/view/main.jsp");
        //requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // получаем значения полей формы
        String method = req.getParameter("method");
        String kernel = req.getParameter("kernel");
        String x = req.getParameter("x");
        String y = req.getParameter("y");
        String delta = req.getParameter("delta");

        System.out.println(method);
        System.out.println(kernel);
        System.out.println(x);
        System.out.println(y);
        System.out.println(delta);

        //Method m = numberToMethod(method);
        //m.calculate(numberToKernel(kernel), numberToX(x), numberToY(y), new Options(parseDouble(delta)));

    }
    // возвращает метод, который соотв. value из формы
    private Method numberToMethod(String num){
        Method method = null;

        try{
            int n = Integer.parseInt(num);

            switch (n){
                case 1: // TODO вызвать метод
                        break;
                case 2: // TODO
                        break;
                case 3: // TODO
                        break;
                case 4: // TODO
                        break;
                case 5: // TODO
                        break;
                case 6: // TODO
                        break;
                case 7: // TODO
                        break;
            }
        }catch (NumberFormatException e){
            // TODO добавить перенаправдение на страницу ошибки
        }
        return method;
    }

    // возвращает ядро, которое соответствует value из формы
    private Kernel numberToKernel(String num){
        Kernel kernel = null; // ядро, которе нужно будет вернуть

        try {
            int n = Integer.parseInt(num); // парсим число

            // выбираем ядро в соответствии с числом
            switch (n){
                case 1: kernel = new Kernel1();
                        break;
                case 2: kernel = new Kernel2();
                        break;
                case 3: kernel = new Kernel3();
                        break;
                case 4: kernel = new Kernel4();
                        break;
                case 5: kernel = new Kernel5();
                        break;
                case 6: kernel = new Kernel6();
                        break;
                case 7: kernel = new Kernel7();
                        break;
                case 8: kernel = new Kernel8();
                        break;
                case 9: kernel = new Kernel9();
                        break;
                case 10: kernel = new Kernel10();
                        break;
                case 11: kernel = new Kernel11();
                        break;
                default: throw new IncorrectNumber(); // бросаем ошибку, если нет ядра с таким номером
            }
        } catch (NumberFormatException e) { // если не смогли спарсить
            // TODO добавить перенаправдение на страницу ошибки
        } catch (IncorrectNumber incorrectNumber) {
            // TODO добавить перенаправдение на страницу ошибки
        }

        return kernel;
    }

    // возвращает X, который соответствует value из формы
    private X numberToX(String num){
        X x = null; // x, который нужно вернуть

        try {
            int n = Integer.parseInt(num);

            switch (n){
                case 1: x = new X1();
                        break;
                case 2: x = new X2();
                        break;
                case 3: x = new X3();
                        break;
                case 4: x = new X4();
                        break;
                case 5: x = new X5();
                        break;
                case 6: x = new X6();
                        break;
                case 7: x = new X7();
                        break;
                default: throw new IncorrectNumber();
            }
        } catch (NumberFormatException e) { // если не смогли спарсить
            // TODO добавить перенаправдение на страницу ошибки
        } catch (IncorrectNumber incorrectNumber) {
            // TODO добавить перенаправдение на страницу ошибки
        }
        return x;
    }

    // возвращает Y, который соответствует value из формы
    private Y numberToY(String num){
        Y y = null; // y, который нужно вернуть

        try {
            int n = Integer.parseInt(num);

            switch (n){
                case 1: y = new Y1();
                    break;
                case 2: y = new Y2();
                    break;
                case 3: y = new Y3();
                    break;
                case 4: y = new Y4();
                    break;
                case 5: y = new Y5();
                    break;
                case 6: y = new Y6();
                    break;
                case 7: y = new Y7();
                    break;
                case 8: y = new Y8();
                    break;
                case 9: y = new Y9();
                    break;
                default: throw new IncorrectNumber();
            }
        } catch (NumberFormatException e) { // если не смогли спарсить
            // TODO добавить перенаправдение на страницу ошибки
        } catch (IncorrectNumber incorrectNumber) {
            // TODO добавить перенаправдение на страницу ошибки
        }
        return y;
    }

    private double parseDouble(String s){
        double d = 0;
        try{
            d = Double.parseDouble(s);
        }catch (NumberFormatException e){
            //TODO добавить перенаправдение на страницу ошибки
        }
        return d;
    }
}
