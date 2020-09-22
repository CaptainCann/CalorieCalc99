package com.example.caloriecalculatorapp;

public class Burger
{
    public static final int SINGLE_PATTY_CAL = 204;
    public static final int DOUBLE_PATTY_CAL = 408;
    public static final int VEGGIE_PATTY_CAL = 124;
    public static final int CHEESE_CAL = 104;
    public int meatChoice;
    boolean cheese = false;
    public int finalBbqCal;

    public void setCheese(boolean cheese)
    {
        this.cheese = cheese;
    }
    public int getCheeseCal()
    {
        if(cheese == true)
        {
            return CHEESE_CAL;
        }
        else
        {
            return 0;
        }
    }

    public void bbqCalGetter(int bbq)
    {
        finalBbqCal = bbq;
    }

    public int meatCalGetter()
    {
        if(meatChoice == 1)
        {
            return SINGLE_PATTY_CAL;
        }
        else if(meatChoice == 2)
        {
            return DOUBLE_PATTY_CAL;
        }
        else if(meatChoice == 3)
        {
            return VEGGIE_PATTY_CAL;
        }
        else
        {
            return 0;
        }
    }
    public void meatNum(int i)
    {
        meatChoice = i;
    }

    public int totalBurgerCal()
    {
        return getCheeseCal() + finalBbqCal + meatCalGetter();
    }
}