package com.test.olingodemo;

import com.test.olingodemo.rule.IRule;
import com.test.olingodemo.rule.RuleEngine;
import org.openl.rules.runtime.RulesEngineFactory;
import org.openl.runtime.EngineFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

/**
 * Created by ripplehire-user12 on 10/5/19.
 */
@Configuration
public class WebServiceConfig {
    @Bean
    public IRule iRule(){
        EngineFactory<IRule> engineFactory = new RulesEngineFactory<>(
                getClass().getClassLoader()
                        .getResource("GetName.xlsx"), IRule.class);
        return engineFactory.newEngineInstance();
    }






}
