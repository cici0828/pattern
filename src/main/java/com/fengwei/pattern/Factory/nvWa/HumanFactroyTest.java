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
        for(int i = 0; i<500; i++){
            Human human = HumanFactory.createHuman();
            human.cry();;
            human.laugh();
            human.talk();
        }

    }
}
