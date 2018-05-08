package com.fengwei.pattern.Factory.nvWa;

import com.fengwei.pattern.utils.ClassUtils;

import java.util.List;
import java.util.Random;

public class HumanFactory {
    public static Human createHuman(Class clzz) {
        Human human = null;

        try {
            human = (Human) Class.forName(clzz.getName()).newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return human;
    }

    public static Human createHuman() {
        Human human = null;
        List<Class> concreteHumanList = ClassUtils.getAllClassByInterface(Human.class);
        System.out.println(concreteHumanList.size());
        for(Class c: concreteHumanList){
            System.out.println(c.getName());
        }
        Random random = new Random();
        int rand = random.nextInt(concreteHumanList.size());
        human = createHuman(concreteHumanList.get(rand));
        return human;
    }
}
