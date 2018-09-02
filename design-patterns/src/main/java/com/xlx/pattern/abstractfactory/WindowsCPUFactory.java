package com.xlx.pattern.abstractfactory;

public class WindowsCPUFactory implements CPUFactory {
    public CPU createCPU() {
        return new WindowsCPU();
    }
}
