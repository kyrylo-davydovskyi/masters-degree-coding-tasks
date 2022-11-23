package com.davydovskyi.study.lab2.util;

import com.davydovskyi.study.lab2.dto.StatisticDeathItem;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.chart.AreaChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;

import java.util.Comparator;
import java.util.List;

//TODO FIX ME
public class ChartDisplayer extends Application {
    private static volatile boolean javaFxLaunched = false;

    private static List<StatisticDeathItem> data;
    private static String header = "DeathRate calculator by Davydovskyi";
    private static String title;

    @Override
    public void start(Stage stage) {
        Platform.setImplicitExit(false);
        stage.setTitle(header);
        final NumberAxis xAxis = new NumberAxis(1, data.size(), 1);
        final NumberAxis yAxis = new NumberAxis();
        final AreaChart<Number, Number> ac =
                new AreaChart<Number, Number>(xAxis, yAxis);
        ac.setTitle("");

        var seriesApril = new XYChart.Series();
        seriesApril.setName(title);
        data.stream()
                .sorted(Comparator.comparing(StatisticDeathItem::getYear))
                .forEach(x -> seriesApril.getData().add(new XYChart.Data(x.getYear(), x.getAliveCount())));

        Scene scene = new Scene(ac, 800, 600);
        ac.getData().addAll(seriesApril);
        stage.setScene(scene);
        stage.show();
    }

    public static void display(List<StatisticDeathItem> arg, String chartName) {
        data = arg;
        title= chartName;
        if (!javaFxLaunched) { // First time
            Platform.setImplicitExit(false);
            new Thread(() ->Application.launch("")).start();
            javaFxLaunched = true;
        } else { // Next times
            Platform.runLater(()->{
                try {
                    Application application = Application.class.newInstance();
                    Stage primaryStage = new Stage();
                    application.start(primaryStage);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
        }
    }
}
