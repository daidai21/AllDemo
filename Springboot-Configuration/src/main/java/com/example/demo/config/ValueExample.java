package com.example.demo.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import java.net.URL;
import java.util.Arrays;
import java.util.List;


@Getter
@Setter
@Component
public class ValueExample {
    /**
     * config file inject
     */
    @Value("${stringValue}")
    private String stringValue;

    @Value("${StringArrayValue}")
    private String[] StringArrayValue;

    @Value("${StringListValue}")
    private List<String> StringListValue;

    // 注入普通字符串，相当于直接给属性默认值
    @Value("程序新视界")
    private String wechatSubscription;

    /**
     * other inject
     */

    // 注入操作系统属性
    @Value("#{systemProperties['os.name']}")
    private String systemPropertiesName;

    /**
     * 注入表达式结果
     */
    @Value("#{ T(java.lang.Math).random() * 100.0 }")
    private double randomNumber;

    /**
     * 注入其他Bean属性：注入config对象的属性tool
     */
    @Value("#{config.tool}")
    private String tool;

    /**
     * 注入列表形式（自动根据"|"分割）
     */
    @Value("#{'${words}'.split('\\|')}")
    private List<String> numList;

    /**
     * 注入文件资源
     */
    @Value("classpath:resourceFile-config.xml")
    private Resource resourceFile;

    /**
     * 注入URL资源
     */
    @Value("http://www.choupangxia.com")
    private URL homePage;

    /**
     * 如果属性中未配置ip，则使用默认值
     */
    @Value("${ip:127.0.0.1}")
    private String ip;

    /**
     * 如果系统属性中未获取到port的值，则使用8888。
     */
    @Value("#{systemProperties['port']?:'8888'}")
    private String port;

    @Override
    public String toString() {
        return "ValueExample{" +
                "stringValue='" + stringValue + '\'' +
                ", StringArrayValue=" + Arrays.toString(StringArrayValue) +
                ", StringListValue=" + StringListValue +
                ", wechatSubscription='" + wechatSubscription + '\'' +
                ", systemPropertiesName='" + systemPropertiesName + '\'' +
                ", randomNumber=" + randomNumber +
                ", tool='" + tool + '\'' +
                ", numList=" + numList +
                ", resourceFile=" + resourceFile +
                ", homePage=" + homePage +
                ", ip='" + ip + '\'' +
                ", port='" + port + '\'' +
                '}';
    }
}
