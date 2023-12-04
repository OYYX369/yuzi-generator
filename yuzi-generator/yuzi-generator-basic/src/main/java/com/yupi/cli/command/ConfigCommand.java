package com.yupi.cli.command;


import cn.hutool.core.util.ReflectUtil;
import com.yupi.generator.MainGenerator;
import picocli.CommandLine;

import java.lang.reflect.Field;



@CommandLine.Command(name = "config", description = "查看参数信息", mixinStandardHelpOptions = true)
public class ConfigCommand  implements Runnable{
    @Override
    public void run() {
       Field[] fields= ReflectUtil.getFields(MainGenerator.class);
       for (Field field : fields){
           System.out.println("字段类型： "+field.getType());
           System.out.println("字段名称： "+  field.getName());
       }
    }
}
