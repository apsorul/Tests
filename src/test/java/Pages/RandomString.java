package Pages;

import java.util.Random;

public class RandomString {
    private static final String mCHAR = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private final int STR_LENGTH = 5;
    Random random = new Random();

    public String createRandomString() {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < STR_LENGTH; i++) {
            int number = random.nextInt(mCHAR.length());
            char ch = mCHAR.charAt(number);
            builder.append(ch);
        }
        return builder.toString();
    }
}
