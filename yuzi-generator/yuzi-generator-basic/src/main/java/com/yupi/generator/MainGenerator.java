package com.yupi.generator;

import com.yupi.model.MainTemplateConfig;
import freemarker.template.TemplateException;

import java.io.File;
import java.io.IOException;

public class MainGenerator {
    public static void main(String[] args) throws TemplateException, IOException {

        //1.静态文件生成
        String projectPath   = System.getProperty("user.dir");  //Java中获取当前工作目录的路径。
        File projectFile =new File(projectPath);   //一个文件或目录在文件系统中的路径
        //输入路径
        String inputPath = new File(projectFile,"yuzi-generator-demo-projects/acm-template").getAbsolutePath();
        //System.out.println(inputPath);
        //输出路径
        String outputPath = projectPath;
        StaticGenerator.copyFilesByHutool(inputPath,outputPath);


        //2.动态文件生成
        String dynamicInputPath = projectPath +File.separator + "yuzi-generator-basic"+ File.separator + "src/main/resources/templates/MainTemplate.java.ftl";
        String dynamicOutputPath = projectPath + File.separator + "acm-template/src/com/yupi/acm/MainTemplate.java";

        MainTemplateConfig mainTemplateConfig = new MainTemplateConfig();
        mainTemplateConfig.setAuthor("yupi");
        mainTemplateConfig.setLoop(false);
        mainTemplateConfig.setOutputText("游戏借宿：");
        DynamicGenerator.doGenerate(dynamicInputPath, dynamicOutputPath, mainTemplateConfig);

    }
}
