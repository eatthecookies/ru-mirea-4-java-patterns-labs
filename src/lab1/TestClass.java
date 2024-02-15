package lab1;

import java.util.Arrays;

public class TestClass{
    public static void main(String[] args) {
        String[] array = new String[]  {"123", "321", "привет"};

        Mirror mirror = new Mirror();

        String[] mirrorArray = mirror.apply(array);

        System.out.println(Arrays.toString(mirrorArray));
    }
}

