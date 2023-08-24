package org.example.operations;


/**
 * @author Соломенникова Н.М.
 * @see MathOperation Интерфейс, который наследуется классами наследниками Divide, Multiply, Substract, Sum
 */
public interface MathOperation {
    /**
     * @see #result(float, float) метод принимает на выход два параметра для последующих вычислений
     * @param a Значение первого числа
     * @param b Значение второго числа
     */

    float result( float a, float b);
}
