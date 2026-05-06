import java.util.*;

public class Brackets {
    private static final Map<String, String> PAIRS = new HashMap<>();
    private static final List<String> OPENERS = Arrays.asList("(", "{", "[", "<", "/*", "begin");
    private static final List<String> CLOSERS = Arrays.asList(")", "}", "]", ">", "*/", "end");

    static {
        PAIRS.put(")", "(");
        PAIRS.put("}", "{");
        PAIRS.put("]", "[");
        PAIRS.put(">", "<");
        PAIRS.put("*/", "/*");
        PAIRS.put("end", "begin");
    }

    public static boolean isValid(String expression) {
        if (expression == null || expression.isEmpty()) return true;

        Stack<String> stack = new Stack<>(10);
        int i = 0;
        int len = expression.length();

        while (i < len) {
            boolean matched = false;

            // 1. Проверяем открывающие скобки (сначала длинные, потом короткие)
            for (String open : OPENERS) {
                if (expression.startsWith(open, i)) {
                    stack.push(open);
                    i += open.length();
                    matched = true;
                    break;
                }
            }
            if (matched) continue;

            // 2. Проверяем закрывающие скобки
            for (String close : CLOSERS) {
                if (expression.startsWith(close, i)) {
                    if (stack.isEmpty()) return false;
                    String lastOpen = stack.pop();
                    if (!PAIRS.get(close).equals(lastOpen)) return false;
                    i += close.length();
                    matched = true;
                    break;
                }
            }

            if (!matched) {
                i++;
            }
        }

        return stack.isEmpty();
    }
}