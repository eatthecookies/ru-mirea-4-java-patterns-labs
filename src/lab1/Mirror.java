package lab1;

import java.util.function.Function;

public class Mirror implements Function<String[], String[]> {
    @Override
    public String[] apply(String[] strArray) {
        for (int i = 0; i < strArray.length; i++){
            strArray[i] = new StringBuilder(strArray[i]).reverse().toString();
        }
        return strArray;
    }
}
