import java.util.Scanner;

public class Calculator {
    static float add(float[] nargs) {
        float result = 0.0f;
        for (float val : nargs)
            result += val;
        return result;
    }

    static float sub(float[] nargs) {
        float result = 2*nargs[0];
        for (float val : nargs)
            result -= val;
        return result;
    }

    static float mul(float[] nargs, int n) {
        float result = 1.0f;
        for (int j = 0; j<n; j++)
            result *= nargs[j];
        return result;
    }

    static float div(float[] nargs, int n) {
        float result = nargs[0];
        for (int j = 1; j<n; j++)
            result /= nargs[j];
        return result;
    }

    static void sqrt(float[] nargs, int n) {
        for (int j = 0; j<n; j++)
            System.out.println("Square root of " + nargs[j] + " = " + Math.sqrt(nargs[j]));
    }

    static void pow(float[] nargs, int n) {
        for (int j = 0; j<n; j += 2)
            System.out.println(nargs[j] + "^" + nargs[j+1] + " = " + Math.pow(nargs[j], nargs[j+1]));
    }

    static float avg(int n) {
        Scanner sc = new Scanner(System.console().reader());
        String[] value = new String[10];
        float result = 0.0f;
        int cnt = 0;
        for(int i = 0; i < n; i++) {
            System.out.print("Enter no. ");
            value[i] = sc.next();
            if ("end".equals(value[i].toLowerCase()))
                return result/cnt;
            result += Float.parseFloat(value[i]);
            cnt++;
        }
        return result/cnt;
    }

    static float var(float[] nargs, int n) {
        float mean = 0.0f, numer = 0.0f;
        for (float x : nargs)
            mean += x;
        mean /= n;
        for (float x : nargs)
            numer += Math.pow((x - mean), 2);
        return numer/(n - 1);
    }
}