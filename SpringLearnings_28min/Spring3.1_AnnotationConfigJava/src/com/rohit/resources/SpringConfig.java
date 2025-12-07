package com.rohit.resources;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

@Component
//@ComponentScan("com.rohit.beans")
//@ComponentScan({ "com.rohit.beans", "----", "----" })
@ComponentScan(basePackages = { "com.rohit.beans" })
public class SpringConfig {

}
