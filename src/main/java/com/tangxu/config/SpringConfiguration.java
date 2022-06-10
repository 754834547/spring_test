package com.tangxu.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

//spring配置类
@Configuration
// <context:component-scan base-package="com.tangxu"/>
@ComponentScan("com.tangxu")
//<import resource=""/>
@Import(DataSourceConfiguration.class)
public class SpringConfiguration {
}
