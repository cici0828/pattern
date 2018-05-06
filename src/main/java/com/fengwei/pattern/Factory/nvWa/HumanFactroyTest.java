package com.fengwei.pattern.Factory.nvWa;

import org.junit.Test;

public class HumanFactroyTest {
    @Test
    public void testHumanFactory01(){
        Human yellowHuman = HumanFactory.createHuman(YellowHuman.class);
        yellowHuman.cry();
        yellowHuman.laugh();
        yellowHuman.talk();

        Human whiteHuman = HumanFactory.createHuman(WhiteHuman.class);
        whiteHuman.cry();
        whiteHuman.laugh();
        whiteHuman.talk();

        Human blackHuman = HumanFactory.createHuman(WhiteHuman.class);
        blackHuman.cry();
        blackHuman.laugh();
        blackHuman.talk();
    }

    @Test
    public void testHumanFactory02(){
        HumanFactory.createHuman();
    }
}
