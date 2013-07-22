import java.lang.*;
import java.util.*;

class Main {
    public static void main (String[] args) {
        Main main = new Main();
        main.run();
    }

    public void run() {

        String test_string = "java strategy pattern";

        ArrayList<Strategy> stringStrategies = new ArrayList<Strategy>();
        stringStrategies.add(new StrategyOne());
        stringStrategies.add(new StrategyTwo());
        stringStrategies.add(new StrategyThree());

        for (Strategy strategy : stringStrategies) {
            System.out.println(strategy.call(test_string));
        }
    }

    private interface Strategy {
        public String call(String string);
    }

    private class StrategyOne implements Strategy {
        public String call(String string) {
            char[] chars = string.toCharArray();
            StringBuilder builder_string = new StringBuilder();
            for (char c : chars) {
                builder_string.append(Character.isLowerCase(c) ? Character.toUpperCase(c) : c);
            }
            return builder_string.toString();
        }
    }

    private class StrategyTwo implements Strategy {
        public String call(String string) {
            StringBuilder builder_string = new StringBuilder(string);
            return builder_string.reverse().toString();
        }
    }

    private class StrategyThree implements Strategy {
        public String call(String string) {
            return string.substring(0, 1).toUpperCase() + string.substring(1);
        }
    }
}
