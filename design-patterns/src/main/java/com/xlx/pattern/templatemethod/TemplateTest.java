package com.xlx.pattern.templatemethod;

public class TemplateTest {
    public static void main(String[] args) {
        MillTemplate millTemplate = new WheatMill();
        millTemplate.produce();

        millTemplate = new CoreMill();
        millTemplate.produce();
    }
}
