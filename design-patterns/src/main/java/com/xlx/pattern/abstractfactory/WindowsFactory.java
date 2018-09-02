package com.xlx.pattern.abstractfactory;

/**
 * Windows的工厂实现
 */
public class WindowsFactory implements PCAbstractFactory{
    public CPU createCPU() {
        return new WindowsCPUFactory().createCPU();
    }

    public RAM createRAM() {
        return new WindowsRAMFactory().createRAM();
    }
}
