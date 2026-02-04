package application.config;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

import java.lang.reflect.Method;
import java.util.Map;

public class DynamicInvoker {

    private final Object bean;
    private final Method method;

    public DynamicInvoker(Object bean, Method method) {
        this.bean = bean;
        this.method = method;
    }

    public ResponseEntity<?> invoke()
            throws Exception {

        Object result = method.invoke(bean);

        return ResponseEntity.ok(result);
    }
}
