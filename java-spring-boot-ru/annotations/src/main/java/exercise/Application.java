package exercise;

import exercise.annotation.Inspect;
import exercise.model.Address;
import java.lang.reflect.Method;

public class Application {
    public static void main(String[] args) {
        var address = new Address("London", 12345678);

        // BEGIN


        // Итерируем все методы класса
        for (Method method : Address.class.getDeclaredMethods()) {

            // Проверяем, есть ли у метода аннотация @Inspect
            if (method.isAnnotationPresent(Inspect.class)) {
                try {
                    method.invoke(address);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                System.out.println("Method " + method.getName() + " returns a value of type " + method.getReturnType().getSimpleName());
            }
        }
        // END
    }
}
