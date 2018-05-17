package com.javarush.task.task16.task1627;

import java.util.ArrayList;
import java.util.List;

import static com.javarush.task.task16.task1627.Solution.OnlineGame.isWinnerFound;
import static com.javarush.task.task16.task1627.Solution.OnlineGame.steps;

public class Solution {
    public static void main(String[] args)   {
        OnlineGame onlineGame = new OnlineGame();
        onlineGame.start();
    }

    public static class OnlineGame extends Thread {
        public static volatile boolean isWinnerFound = false;


        public static List<String> steps = new ArrayList<String>();

        static {
            steps.add("Начало игры");
            steps.add("Сбор ресурсов");
            steps.add("Рост экономики");
            steps.add("Убийство врагов");
        }

        protected Gamer gamer1 = new Gamer("Ivanov", 3);
        protected Gamer gamer2 = new Gamer("Petrov", 1);
        protected Gamer gamer3 = new Gamer("Sidorov", 5);

        public void run() {
            gamer1.start();
            gamer2.start();
            gamer3.start();

            while (!isWinnerFound) {}

            gamer1.interrupt();
            gamer2.interrupt();
            gamer3.interrupt();

        }
    }

    public static class Gamer extends Thread {
        private int rating;
        private static volatile String getNames = null;
        public Gamer(String name, int rating) {
            super(name);
            this.rating = rating;
        }

        @Override
        public void run() {



            for (Object d : steps) {
                if( !isWinnerFound) {
                    System.out.println(getName() + ":" + d);
                    try {
                        Thread.sleep((long) 1000 / rating);
                    } catch (InterruptedException e) {
                        System.out.println("["+getName()+":проиграл]");
                    }
                }
            }

            if(!isWinnerFound){
                isWinnerFound =true;
                System.out.println("["+getName()+":победитель!");
                getNames=getName();
            }

        }
    }
}