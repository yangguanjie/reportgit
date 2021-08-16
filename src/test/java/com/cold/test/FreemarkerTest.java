package com.cold.test;


import freemarker.template.Configuration;
import freemarker.template.Template;

import java.io.File;
import java.io.FileWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FreemarkerTest {
    public static void main(String[] args) throws Exception {
        //创建freemarker的配置对象
        Configuration configuration = new Configuration(Configuration.getVersion());
        //2.设置模板所在的目录
        configuration.setDirectoryForTemplateLoading(new File("E:\\ftl"));
        //3.设置字符集
        configuration.setDefaultEncoding("utf-8");
        //4.加载模板
        Template template = configuration.getTemplate("test.ftl");
        //5.创建数据模型
        Map map = new HashMap();
        map.put("name", "张三");
        map.put("message", "welcome freemarker");
        //list数据
        List goodsList = new ArrayList();
        Map goods1 = new HashMap();
        goods1.put("name", "苹果");
        goods1.put("price", 5.8);
        Map goods2 = new HashMap();
        goods2.put("name", "香蕉");
        goods2.put("price", 2.5);
        Map goods3 = new HashMap();
        goods3.put("name", "橘子");
        goods3.put("price", 3.2);
        goodsList.add(goods1);
        goodsList.add(goods2);
        goodsList.add(goods3);
        map.put("goodsList", goodsList);
        //准备输出流对象，用于输出静态文件
        Writer writer = new FileWriter("e:\\ftl\\test.html");
        //输出
        template.process(map, writer);
        //关闭流
        writer.close();
    }
}
