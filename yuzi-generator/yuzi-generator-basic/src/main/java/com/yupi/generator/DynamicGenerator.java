package com.yupi.generator;

import com.yupi.model.MainTemplateConfig;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DynamicGenerator {
    public static void main(String[] args) throws IOException, TemplateException {
        //File.separator  路径分割符window和Linux
        String projectPath = System.getProperty("user.dir") + File.separator + "yuzi-generator-basic";
        String inputPath = projectPath + File.separator + "src/main/resources/templates/MainTemplate.java.ftl";
        String outputPath = projectPath + File.separator + "MainTemplate.java";
        MainTemplateConfig mainTemplateConfig = new MainTemplateConfig();
        mainTemplateConfig.setAuthor("yupi");
        mainTemplateConfig.setLoop(false);
        mainTemplateConfig.setOutputText("求和结果：");
        doGenerate(inputPath, outputPath, mainTemplateConfig);
    }

    /*生成文件
    @param inputPath模板文件输入路径
    @param outputPath输出路径
    @param model数据模型
    @throws IOException
    @throws TemplateException
    */
    public static void doGenerate(String inputPath,String outputPath,Object model)throws IOException,TemplateException{

        Configuration configuration = new Configuration(Configuration.VERSION_2_3_32);

        File templateDir =new File(inputPath).getParentFile();
        configuration.setDirectoryForTemplateLoading(templateDir);

        //设置模板文件使用的字符集
        configuration.setDefaultEncoding("UTF-8");
        configuration.setNumberFormat("0.#######");   //解决逗号2，023

        //创建模板对象，加载指定模板
        String templateName =new File(inputPath).getName();
        Template template=configuration.getTemplate(templateName);


        Writer out=new FileWriter(outputPath);

        template.process(model,out);
        //生成文件后别忘了关闭哦
        out.close();
    }
}
