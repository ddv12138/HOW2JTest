package tk.ddvudo.Spring;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component("LoggerAspect")
public class LoggerAspect {
    @Around(value = "execution(* tk.ddvudo.Spring.*.*(..)) ")
    public Object log(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("start log:" + joinPoint.getSignature().getName());
        long t1 = System.currentTimeMillis();
        Object object = joinPoint.proceed();
        t1 = System.currentTimeMillis() - t1;
        System.out.println("end log:" + joinPoint.getSignature().getName());
        System.out.println("耗时" + t1 + "ms");
        return object;
    }
}
