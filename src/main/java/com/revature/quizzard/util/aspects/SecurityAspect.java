package com.revature.quizzard.util.aspects;

import com.revature.quizzard.dtos.Principal;
import com.revature.quizzard.exceptions.AuthenticationException;
import com.revature.quizzard.exceptions.AuthorizationException;
import com.revature.quizzard.web.security.Secured;
import net.bytebuddy.implementation.bytecode.Throw;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;

@Aspect
@Component
public class SecurityAspect {

    private HttpServletRequest request;

    @Autowired
    public SecurityAspect(HttpServletRequest request) {
        this.request = request;
    }

    @Around("@annotation(com.revature.quizzard.web.security.Secured)")
    public Object secureEndpoint(ProceedingJoinPoint pjp) throws Throwable {
        Method method = ((MethodSignature) pjp.getSignature()).getMethod();
        Secured securedAnno = method.getAnnotation(Secured.class);

        List<String> allowedRoles = Arrays.asList(securedAnno.allowedRoles());
        Principal principal = (Principal) request.getSession().getAttribute("principal");

        if (principal == null) {
            throw new AuthenticationException("An unauthenticated request was made to a protected endpoint!");
        }

        if (!allowedRoles.contains(principal.getRole())) {
            throw new AuthorizationException();
        }

        return pjp.proceed();

    }

}
