import java.lang.reflect.Method;

public class RunSimpleTests {
    public static void main(String[] args) {
        Class<?> type = null;
        int passed = 0;
        try {
            type = Class.forName(args[0]);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return;
        }
        Method[] methods = type.getDeclaredMethods();
        for (Method m : methods) {
            if (m.isAnnotationPresent(SimpleTest.class)) {
                try {
                    m.invoke(null);
                    passed++;
                } catch (Throwable ex) {
                    System.out.printf(
                            "%s failed: %s %n",
                            m.getName(), ex.getCause()
                    );
                }

            }
        }
        System.out.printf("%d passed out of %d %n", passed, methods.length);
    }
}