package com.example.demo.controller;

import com.example.demo.config.ConfigurationPropertiesExample;
import com.example.demo.config.PropertySourceExample;
import com.example.demo.config.ValueExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;


@RestController
@RequestMapping("/")
public class IndexConfigController {

    @Autowired
    private ConfigurationPropertiesExample configurationPropertiesExample;

//    @Autowired
//    private PropertySourceExample propertySourceExample;

    @Autowired
    private ValueExample valueExample;

    @RequestMapping("/config")
    public String getAllConfigInfo() {
        return configurationPropertiesExample + "\t" + new PropertySourceExample().toString() + "\t" + new ValueExample().toString();
//        + "\t" + valueExample;
    }
}
