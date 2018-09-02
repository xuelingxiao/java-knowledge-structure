package com.xlx.pattern.abstractfactory;

public class MacRAMFactory implements RAMFactory {
    public RAM createRAM() {
        return new MacRAM();
    }
}
