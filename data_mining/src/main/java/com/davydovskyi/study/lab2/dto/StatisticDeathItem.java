package com.davydovskyi.study.lab2.dto;

import lombok.Data;

import java.util.List;

@Data
public class StatisticDeathItem {
    private Integer year;
    private Double coefficient;
    private Integer aliveCount;
    private Integer diedDuringIteration;
    private Double chanceToDie;
    private Double chanceToSurvive;
    private Double alivePercentTotal;
    private Integer deadCount;
    private Double deadPercentTotal;
    private Double dx;
    private Double cx;
    private Double nx;
    private Double mx;


    public StatisticDeathItem(Integer year,
                       Integer initPopulation,
                       Double coefficient,
                       Double pecentCoef) {
        this.year = year;
        this.coefficient = coefficient;
        this.aliveCount = (int) (initPopulation * coefficient);
        this.deadCount = initPopulation - aliveCount;
        this.deadPercentTotal = (double) deadCount / (double) aliveCount;
        this.alivePercentTotal = 1 - deadPercentTotal;
        this.dx = aliveCount * Math.pow(1 + pecentCoef,
                year * -1);
        this.cx = deadCount * Math.pow(1 + pecentCoef,
                (year * -1) + 1);
    }


    public void setChances(Integer previousAlive) {
        this.diedDuringIteration = previousAlive - aliveCount;
        this.chanceToDie = (double) diedDuringIteration / (double) aliveCount;
        this.chanceToSurvive = 1. - chanceToDie;
    }

    public void setNx(List<Double> dx) {
        this.nx = dx.stream().reduce(Double::sum).orElse(0.);
    }

    public void setMx(List<Double> cx) {
        this.mx = cx.stream().reduce(Double::sum).orElse(0.);
    }
}
