package com.javarush.task.task37.task3702.female;

import com.javarush.task.task37.task3702.Human;
import com.javarush.task.task37.task3702.male.KidBoy;
import com.javarush.task.task37.task3702.male.Man;
import com.javarush.task.task37.task3702.male.TeenBoy;

public class FemaleFactory {
    public Human getPerson(int age){
        if(age <= KidGirl.MAX_AGE){
            return new KidGirl();
        } else if(KidGirl.MAX_AGE < age
        && age <= TeenGirl.MAX_AGE){
            return new TeenGirl();
        } else {
            return new Woman();
        }
    }
}
