package com.xlx.pattern.abstractfactory;

public class WindowsRAMFactory implements RAMFactory {
    public RAM createRAM() {
        return new WindowsRAM();
    }
}
