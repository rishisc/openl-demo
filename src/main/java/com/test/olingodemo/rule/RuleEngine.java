package com.test.olingodemo.rule;

import org.openl.rules.runtime.RulesEngineFactory;
import org.openl.runtime.EngineFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;


public class RuleEngine {



    public void setiRule(IRule iRule) {
        this.iRule = iRule;
    }

    IRule iRule;

    public Object process(String functionName, Object... args) {
        try {
            Method method = iRule.getClass().getMethod(functionName);
            return method.invoke(iRule, args);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
