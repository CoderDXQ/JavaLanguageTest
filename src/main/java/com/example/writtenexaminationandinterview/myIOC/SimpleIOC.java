package com.example.writtenexaminationandinterview.myIOC;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.FileInputStream;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/4/19 10:30 下午
 */
public class SimpleIOC {

    //    容器
    private Map<String, Object> beanMap = new HashMap<>();

    //    构造方法
    public SimpleIOC(String location) throws Exception {
        loadBean(location);
    }

    public Object getBean(String name) {
        Object bean = beanMap.get(name);
        if (bean == null) {
            throw new IllegalArgumentException("There is no bean with name " + name);
        }
        return bean;
    }

    private void loadBean(String location) throws Exception {

//        加载xml文件
//        读入文件
        InputStream inputStream = new FileInputStream(location);

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = factory.newDocumentBuilder();
        Document doc = documentBuilder.parse(inputStream);
        Element root = doc.getDocumentElement();
        NodeList nodes = root.getChildNodes();

//        遍历<bean>标签
        for (int i = 0; i < nodes.getLength(); i++) {

            Node node = nodes.item(i);
            if (node instanceof Element) {
                Element element = (Element) node;
                String id = element.getAttribute("id");
                String className = element.getAttribute("class");

//                加载beanClass
                Class beanClass = null;

                try {
                    beanClass = Class.forName(className);
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
//                    创建类失败就返回
                    return;
                }

//                创建bean
                Object bean = beanClass.newInstance();

//                遍历<property>标签
                NodeList propertyNodes = element.getElementsByTagName("property");
                for (int j = 0; j < propertyNodes.getLength(); j++) {
                    Node propertyNode = propertyNodes.item(j);
                    if (propertyNode instanceof Element) {
                        Element propertyElement = (Element) propertyNode;
                        String name = propertyElement.getAttribute("name");
                        String value = propertyElement.getAttribute("value");

//                        利用反射将bean相关字段访问权限设为可访问
                        Field declaredField = bean.getClass().getDeclaredField(name);
                        declaredField.setAccessible(true);

                        if (value != null && value.length() > 0) {
                            declaredField.set(bean, value);
                        } else {
                            String ref = propertyElement.getAttribute("ref");
                            if (ref == null || ref.length() == 0) {
                                throw new IllegalArgumentException("ref config err");
                            }
                            declaredField.set(bean, getBean(ref));
                        }
                    }
                }
//                将bean注册到bean容器
                registerBean(id, bean);
            }

        }

    }

    //    放入容器
    private void registerBean(String id, Object bean) {
        beanMap.put(id, bean);
    }


}
