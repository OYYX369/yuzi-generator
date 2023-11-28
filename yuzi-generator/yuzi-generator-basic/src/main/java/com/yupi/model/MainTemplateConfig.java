package com.yupi.model;


import lombok.Data;
//静态模板配置
@Data
public class MainTemplateConfig {
    /*
    * 作者（字符串，填充值）*/
    private String author="yupi";
    /*输出信息
    */
    private String outputText ="sum =";
    /*
    * 是否循环
    */
    private boolean loop=true;
}
