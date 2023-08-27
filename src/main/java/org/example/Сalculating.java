package org.example;

import org.example.operations.*;

import java.util.InputMismatchException;

public class Сalculating {

    // Объявляем константы для кодов ошибок
    public static final int ERROR_no= 0;
    public static final int ERROR_not_sup = 1;
    public static final int ERROR_zero = 2;

    private double val = 0.0;
    public double getValue() {
        return val;
    } // Метод для получения значения результата вычислений


    /**
     * @see #result(float, float, String)  Метод для выполнения арифметической операции
     * @param a Значение первого числа
     * @param b Значение второго числа
     * @param znak Символ математической операции
     * @return возвращает код ошибки вычислений
     */

    public int result(float a, float b, String znak) {
        if (znak.length() !=1) {  //Если длина переменной znak не равно 1, выводим ошибку с кодом ERROR_NOT_SUP
            return ERROR_not_sup;
        }
        MathOperation someOp;   //объявляется переменная someOp типа MathOperation. Эта переменная будет использоваться для создания экземпляров классов, реализующих интерфейс MathOperation
        switch (znak.charAt(0)) {
            case '+':
                someOp = new Sum();
                val = someOp.result(a, b);
                return ERROR_no;
            case '-':
                someOp = new Subtract();
                val = someOp.result(a, b);
                return ERROR_no;
            case '*':
                someOp = new Multiply();
                val = someOp.result(a, b);
                return ERROR_no;
            case '/':
                if (b == 0) {
                    throw new ArithmeticException("Ошибка: деление на ноль");
                }
                someOp = new Divide();
                val = someOp.result(a, b);
                return ERROR_no;
        }
        throw new InputMismatchException("ОШИБКА: Некорректный формат введенных данных");
//return ERROR_not_sup; -убрать
    }

    /**
     * @see #getErrorText(int) Метод для получения текста ошибки по коду ошибки
     * @param errorCode код ошибки
     * @return Возвращает текст ошибки
     */
    public String getErrorText(int errorCode) {
        switch(errorCode) {
            case ERROR_no:
                return "";
            case ERROR_not_sup:
                return "Необходимо ввести один из знаков: +, -, * или /";
            case ERROR_zero:
                return "Делить на ноль нельзя";
        }
        return "Ошибка. Обратитесь к разработчику";
    }
}
