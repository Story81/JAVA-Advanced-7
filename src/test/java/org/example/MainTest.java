package org.example;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.InputMismatchException;


/**
 * Unit test for simple App.
 */
public class MainTest
//extends TestCase

{

    @Test
    public void testSum() {
        Сalculating calc = new Сalculating();
        float a = 2.5f;
        float b = 3.5f;
        int errorCode = calc.result(a, b, "+");
        Assertions.assertEquals(Сalculating.ERROR_no, errorCode);
        Assertions.assertEquals(a + b, calc.getValue(), 0.0001);
    }

    @Test
    public void testSubtract() {
        Сalculating calc = new Сalculating();
        float a = 5.5f;
        float b = 2.2f;
        int errorCode = calc.result(a, b, "-");
        Assertions.assertEquals(Сalculating.ERROR_no, errorCode);
        Assertions.assertEquals(a - b, calc.getValue(), 0.0001);
    }

    @Test
    public void testMultiply() {
        Сalculating calc = new Сalculating();
        float a = 2.0f;
        float b = 4.0f;
        int errorCode = calc.result(a, b, "*");
        Assertions.assertEquals(Сalculating.ERROR_no, errorCode);
        Assertions.assertEquals(8, calc.getValue(), 0.0001);
    }

    @Test
    public void testDivide() {
        Сalculating calc = new Сalculating();
        float a = 10.0f;
        float b = 2.0f;
        int errorCode = calc.result(a, b, "/");
        Assertions.assertEquals(Сalculating.ERROR_no, errorCode);
        Assertions.assertEquals(5, calc.getValue(), 0.0001);
    }

    // Проверка некорректного формата ввода математического знака (ввод больше 1 знака)
    @Test
    void testInvalidInputFormatOperator2Znak() {
        Сalculating calc = new Сalculating();
        float a = 5.0f;
        float b = 3.0f;
        String operator = "+-";
        int errorCode = calc.result(a, b, operator);
        Assertions.assertEquals(Сalculating.ERROR_not_sup, errorCode);
        Assertions.assertEquals(0.0, calc.getValue(), 0.0001);
    }

    // Проверка вывода текста ошибки по коду ошибки
    @Test
    void testTextOfError() {
        Сalculating calc = new Сalculating();
        Assertions.assertEquals("", calc.getErrorText(Сalculating.ERROR_no));
        Assertions.assertEquals("Необходимо ввести один из знаков: +, -, * или /", calc.getErrorText(Сalculating.ERROR_not_sup));
        Assertions.assertEquals("Делить на ноль нельзя", calc.getErrorText(Сalculating.ERROR_zero));
    }


    @Test
    // Проверка операции деления на 0 (выброс исключения)
    public void testDivideByZero() {
        Сalculating calc = new Сalculating();
        float a = 5.0f;
        float b = 0.0f;
        Assertions.assertThrows(ArithmeticException.class, () -> {
            calc.result(a, b, "/");
        });
    }

    // Проверка на ввод некорректных данных (выброс исключения)
    @Test
    void testInvalidInputFormatOperator() {
        Сalculating calc = new Сalculating();
        float a = 5.0f;
        float b = 3.0f;
        String operator = ".";

        Assertions.assertThrows(InputMismatchException.class, () -> {
            int errorCode = calc.result(a, b, operator);
        });
    }




    }






// блок для себя (старые проверки)


//     Проверка некорректного формата ввода математического знака
//    @Test
//    public void testInvalidOperator() {
//        Сalculating calc = new Сalculating();
//        float a = 2.5f;
//        float b = 3.5f;
//        int errorCode = calc.result(a, b, "x");
//        Assertions.assertEquals(Сalculating.ERROR_not_sup, errorCode);
//    }

//    @Test
//    public void testInvalidOperator3() {
//        Сalculating calc = new Сalculating();
//        float a = 2.5f;
//        float b = 3.5f;
//
//        // Используем метод assertThrows для проверки, что при выполнении данного кода будет выброшено исключение
//        Assertions.assertThrows(IllegalArgumentException.class, () -> {
//            calc.result(a, b, "x");
//        });
//    }

//    @Test
//    public void testInvalidOperator5() {
//        Сalculating calc = new Сalculating();
//        float a = 2.5f;
//        float b = 3.5f;
//        Assertions.assertThrows(ArithmeticException.class, () -> {
//            calc.result(a, b, "x");
//        });
//    }


//    @Test
//    public void testInvalidOperator2() {
//        Сalculating calculator = new Сalculating();
//        int result = calculator.result(10, 5, "&");
//        Assertions.assertEquals(Сalculating.ERROR_not_sup, result);
//        double value = calculator.getValue();
//        Assertions.assertEquals(0.0, value);
//    }


