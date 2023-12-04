package com.yupi.cli.command;

import cn.hutool.core.bean.BeanUtil;
import com.yupi.generator.MainGenerator;
import com.yupi.model.MainTemplateConfig;
import lombok.Data;
import picocli.CommandLine;

import java.util.concurrent.Callable;


@CommandLine.Command(name="generate",mixinStandardHelpOptions = true)
@Data
public class GenerateCommand  implements Callable {

    @CommandLine.Option(names = {"-l", "--loop"}, arity = "0..1",description = "是否循环", interactive = true,echo = true)
    private boolean loop;

    @CommandLine.Option(names = {"-a", "--author"}, arity = "0..1",description = "作者名称", interactive = true,echo = true)
    private String auther="yupi";

    @CommandLine.Option(names = {"-o", "--outputText"}, arity = "0..1",description = "输出结果", interactive = true,echo = true)
    private String outputText="sum =";



    @Override
    public Integer  call() throws Exception {
        MainTemplateConfig mainTemplateConfig= new MainTemplateConfig();
        BeanUtil.copyProperties(this,mainTemplateConfig);
        MainGenerator.doGenerate(mainTemplateConfig);
        return 0;
    }
}
