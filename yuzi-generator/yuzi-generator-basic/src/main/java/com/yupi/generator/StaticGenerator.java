package com.yupi.generator;


import cn.hutool.core.io.FileUtil;
import java.io.File;
/*
 静态文件生成器
 */
public class StaticGenerator {
    public static void main(String[] args) {
        String projectPath   = System.getProperty("user.dir");  //Java中获取当前工作目录的路径。
        File projectFile =new File(projectPath);   //一个文件或目录在文件系统中的路径
        //输入路径
        String inputPath = new File(projectFile,"yuzi-generator-demo-projects/acm-template").getAbsolutePath();
        //System.out.println(inputPath);
        //输出路径
        String outputPath = projectPath;
        copyFilesByHutool(inputPath,outputPath);
    }
//*
// 输入路径和输出路径
// 将输入目录完整拷贝到输出目录下*/
    public static  void copyFilesByHutool(String inputPath,String outputPath){
        FileUtil.copy(inputPath,outputPath,false);
    }
}

