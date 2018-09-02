package com.xlx.pattern.abstractfactory;

public class MacCPUFactory implements CPUFactory {
    public CPU createCPU() {
        return new MacCPU();
    }
}
