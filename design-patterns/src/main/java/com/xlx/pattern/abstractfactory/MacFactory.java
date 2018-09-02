package com.xlx.pattern.abstractfactory;

/**
 * Mac的工厂实现
 */
public class MacFactory implements PCAbstractFactory{
    public CPU createCPU() {
        return new MacCPUFactory().createCPU();
    }

    public RAM createRAM() {
        return new MacRAMFactory().createRAM();
    }
}
