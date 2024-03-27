import com.xxj.PropertyReader;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.List;

public class TestDemo {
    @BeforeAll
    static void contextLoads() {
        System.out.println("Start testing...");
    }

    @Test
    void testProperties() {
        PropertyReader propertyReader = new PropertyReader();
        List<String> propertyNames = propertyReader.getPropertyNames();
        System.out.println("Property names: " + propertyNames);
        for (String propertyName : propertyNames) {
            System.out.println(propertyName + ": " + propertyReader.getProperty(propertyName));
        }
    }
}
