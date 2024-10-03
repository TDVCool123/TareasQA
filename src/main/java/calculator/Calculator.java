package calculator;

public class Calculator {
    private int a;
    private int b;

    public int add(int a, int b){
        int result;
        result = a + b;
        return result;
    }

    public int subs(int a, int b){
        int result;
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        result = a - b;
        return result;
    }

    public int mult(int a,int b){
        return a*b;
    }
    public int div(int a,int b){
        if (b==0){
            throw new ArithmeticException("La div entre 0 no es aceptada");
        }
        return a/b;

    }
}
