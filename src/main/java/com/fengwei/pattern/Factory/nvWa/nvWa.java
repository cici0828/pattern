package com.fengwei.pattern.Factory.nvWa;

public class nvWa {
    public static void main(String[] args) {
       Human human = HumanFactory.createHuman();
       human.cry();
       human.talk();
       human.laugh();
    }
}
