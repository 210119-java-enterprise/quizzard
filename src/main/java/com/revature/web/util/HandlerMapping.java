package com.revature.web.util;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class HandlerMapping {

    private Map<RequestContext, Method> methodMap = new HashMap<>();

    public Method getMethodByRequestContext(RequestContext reqContext) {
        return null;
    }
}
