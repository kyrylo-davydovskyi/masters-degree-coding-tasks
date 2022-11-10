package com.davydovskyi.study.lab2.util;

import com.davydovskyi.study.lab2.dto.StatisticDeathItem;
import lombok.SneakyThrows;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;

public class WindowManager {
    @SneakyThrows
    public static void draw(List<StatisticDeathItem> itemList) {
        JFrame f = new JFrame("Laba #2 Davydovskogo Kyryla");
        f.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {System.exit(0);}
        });
        JApplet applet = new ImgPrinter(itemList);
        f.getContentPane().add("Center", applet);
        applet.init();
        f.pack();
        f.setSize(new Dimension(1200,1000));
        f.setVisible(true);
        Thread.sleep(10000);
    }
}
