package com.example.designpatterns.proxy;

//ProxyImage类代理了RealImage 实现了对RealImage类的控制 主要是使用ProxyImage类来获取RealImage类的对象
public class ProxyImage implements Image {
    private RealImage realImage;
    private String fileName;

    public ProxyImage(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void display() {
//        第一次进入时realImage没有被创建 会先进行创建
        if (realImage == null) {
            realImage = new RealImage(fileName);
        }
        realImage.display();
    }
}
