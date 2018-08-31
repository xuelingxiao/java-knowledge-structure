package com.xlx.mvn.plugin;

import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.plugins.annotations.LifecyclePhase;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;

import java.util.List;

@Mojo(name="xlxTest",defaultPhase = LifecyclePhase.PACKAGE)
public class Test extends AbstractMojo {

    /**
     * 接收的参数
     */
    @Parameter
    private String message;

    /**
     * 接收多个值的参数
     */
    @Parameter
    private List<String> options;

    /**
     * 命令行中接收,注意必须有property mvn:package -Dargs=this is from cmd
     */
    @Parameter(property = "args")
    private String args;

    public void execute() throws MojoExecutionException, MojoFailureException {
        System.out.println("my first maven plugin message is : " + message);
        System.out.println("my first maven plugin options is : " + options);
        System.out.println("my first maven plugin args from evm is : " + args);

    }

}
