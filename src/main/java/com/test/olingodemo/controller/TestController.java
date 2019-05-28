package com.test.olingodemo.controller;

import com.test.olingodemo.rule.IRule;
import com.test.olingodemo.rule.RuleEngine;
import org.openl.rules.runtime.RulesEngineFactory;
import org.openl.runtime.EngineFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.SingletonBeanRegistry;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.Method;

/**
 * Created by ripplehire-user12 on 8/5/19.
 */
@RestController
public class TestController {

    @Autowired
    ApplicationContext context;



    @GetMapping("/message")
    public Object message() {
        try{
            IRule iRule = (IRule) context.getBean("iRule");
            return iRule.getEmpType("xyz", "abc", "Full Time");
        }catch(Exception e){
e.printStackTrace();
        }
        return null;
    }

    @GetMapping("/reset")
    public void reset(){
        try{

            EngineFactory<IRule> engineFactory = new RulesEngineFactory<>(
                    getClass().getClassLoader()
                            .getResource("GetName.xlsx"), IRule.class);
            IRule iRule =engineFactory.newEngineInstance();
            ConfigurableApplicationContext configContext = (ConfigurableApplicationContext)context;
            DefaultListableBeanFactory beanRegistry = (DefaultListableBeanFactory) configContext.getBeanFactory();
            beanRegistry.removeBeanDefinition("iRule");
            beanRegistry.registerSingleton("iRule", iRule);
        }catch(Exception e){
            e.printStackTrace();
        }

    }


}
