package com.davydovskyi.study.lab2.util;


import com.davydovskyi.study.lab2.dto.StatisticDeathItem;
import lombok.extern.slf4j.Slf4j;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Line2D;
import java.util.List;

/*
 * This is like the FontDemo applet in volume 1, except that it
 * uses the Java 2D APIs to define and render the graphics and text.
 */

@Slf4j
public class ImgPrinter extends JApplet {

    ImgPrinter(List<StatisticDeathItem> items) {
        this.deathItems = items;
    }
    private List<StatisticDeathItem> deathItems;

    private final int windowHeight = 800;
    private final int windowWidth = 1020;

    private final int borderX = 30;
    private final int borderY = 30;

    private final Color bg = Color.white;
    private final Color fg = Color.black;

    public void init() {
        //Initialize drawing colors
        setBackground(bg);
        setForeground(fg);
    }



    public void paint(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        Color fg3D = Color.black;

        g2.setPaint(fg3D);

        drawXYBasis(g2);
        drawChart(g2);
    }

    private void drawChart(Graphics2D g2) {
        var stepSize = (windowWidth - borderX) / deathItems.size();
        var populationSize = (((double) windowHeight - borderY) / (double) deathItems.get(0).getAliveCount());
        for(int i = 0; i < deathItems.size() - 1; i++) {
            var currentX = (i + 1) * stepSize;
            var currentY = windowHeight - deathItems.get(i).getAliveCount() * populationSize;
            var nextY = windowHeight - deathItems.get(i + 1).getAliveCount() * populationSize;
            var nextX = currentX + stepSize;
            g2.draw(new Line2D.Double(currentX, currentY, nextX, nextY));
        }
    }

    private void drawXYBasis(Graphics2D g2) {
        g2.draw(new Line2D.Double(borderX, windowHeight - borderY, windowWidth - borderX, windowHeight - borderY));
        g2.draw(new Line2D.Double(borderX, windowHeight - borderY, borderX, borderY));
        g2.drawString("Population", 15, windowHeight / 2);
        g2.drawString("Ages", windowWidth / 2, windowHeight - 15);
    }

}