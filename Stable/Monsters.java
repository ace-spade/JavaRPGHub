/**
 * Created by spade on 2017-06-26.
 */
public class Monsters {
    static int monsterHealth;
    static int monsterDamage;
    static MainWorld mw;
    static String attackChoose;
    static int notice;
    //done
    public static void snake()
    {
        monsterHealth=2;
        notice =0;

        System.out.println("A snake Appears! Will you attack?");
        attackChoose = mw.in.nextLine();
        while(attackChoose.equals("y") && monsterHealth>0)
        {
            monsterHealth-=mw.attack+mw.weapBonus;
            if(monsterHealth<=0){
                monsterHealth=0;

                System.out.println("The Snake Is Dead.");
                mw.xp+=100;
                mw.lvlUp();
                mw.stealth+=0.5;
            }else{

                damage(mw.health,mw.soak,monsterDamage);
                System.out.println("You hit the Snake, doing "+ mw.attack+mw.weapBonus + " damage. It hits you with " + monsterDamage + " damage.");
                if(mw.health<=0)
                {
                    System.out.println("You Died.");
                    mw.gameOver=true;
                }
            }

        }
    }
    //done
    public static void zombie()
    {

        monsterHealth=10;
        monsterDamage=3;
        notice=2;
        System.out.println("Out shambles a zombie! Will you attack?");
        attackChoose = mw.in.nextLine();
        while(attackChoose.equals("y") && monsterHealth>0)
        {
            monsterHealth-=mw.attack+mw.weapBonus;
            if(monsterHealth<=0){
                monsterHealth=0;

                System.out.println("The Zombie Is Dead.");
                mw.xp+=100;
                mw.lvlUp();
                mw.stealth+=0.5;
            }else{

                damage(mw.health,mw.soak,monsterDamage);
                System.out.println("You hit the zombie, doing "+ mw.attack+mw.weapBonus + " damage. It hits you with " + monsterDamage + " damage.");
                if(mw.health<=0)
                {
                    System.out.println("You Died.");
                    mw.gameOver=true;
                }
            }

        }
        if(attackChoose.equals("n"))
        {
            if(mw.stealth>notice) {
                System.out.println("You Escaped.");
                mw.stealth++;
            }
            else{
                while(monsterHealth>0)
                {
                    monsterHealth-=mw.attack+mw.weapBonus;
                    if(monsterHealth<=0){
                        monsterHealth=0;
                        System.out.println("The Zombie Is Dead.");
                        mw.xp+=100;
                        mw.lvlUp();
                        mw.stealth+=0.5;
                    }else{

                        damage(mw.health,mw.soak,monsterDamage);
                        System.out.println("You hit the zombie, doing "+ mw.attack+mw.weapBonus + " damage. It hits you with " + monsterDamage + " damage.");
                        if(mw.health<=0)
                        {
                            System.out.println("You Died.");
                            mw.gameOver=true;
                        }
                    }

                }
            }
        }
    }
    public static void pirate()
    {
        monsterHealth=12;
        monsterDamage=4;
        notice=3;
        System.out.println("From the water comes a Pirate, do you want to fight?");
        attackChoose = mw.in.nextLine();
        while(attackChoose.equals("y") && monsterHealth>0)
        {
            if(mw.attack+mw.weapBonus>monsterDamage)
            {
                monsterHealth -= mw.attack+mw.weapBonus;
                if (monsterHealth <= 0) {
                    monsterHealth = 0;
                    System.out.println("The Pirate Is Dead.");
                    mw.xp += 200;
                    mw.lvlUp();
                    mw.stealth+=0.5;
                } else {

                    damage(mw.health, mw.soak, monsterDamage);
                    System.out.println("You hit the pirate, doing " + mw.attack+mw.weapBonus + " damage. It hits you with " + monsterDamage + " damage.");
                    if (mw.health <= 0) {
                        System.out.println("You Died.");
                        mw.gameOver = true;
                    }
                }
            }
        }
        if(attackChoose.equals("n"))
        {
            if(mw.stealth>notice){
                System.out.println("You Escaped.");
                mw.stealth++;
            }
            else
            {
                while(monsterHealth>0)
                {
                    if(mw.attack+mw.weapBonus>monsterDamage)
                    {
                        monsterHealth -= mw.attack+mw.weapBonus;
                        if (monsterHealth <= 0) {
                            monsterHealth = 0;
                            System.out.println("The Pirate Is Dead.");
                            mw.xp += 200;
                            mw.lvlUp();
                            mw.stealth+=0.5;
                        } else {

                            damage(mw.health, mw.soak, monsterDamage);
                            System.out.println("You hit the pirate, doing " + mw.attack+mw.weapBonus + " damage. It hits you with " + monsterDamage + " damage.");
                            if (mw.health <= 0) {
                                System.out.println("You Died.");
                                mw.gameOver = true;
                            }
                        }
                    }
                }
            }
        }

    }
    public static void witch(){
        monsterHealth=15;
        monsterDamage=5;
        notice=10;
        System.out.println("A Witch flies in on a broomstick. Will you attack?");
        attackChoose=mw.in.nextLine();
        while(attackChoose.equals("y") && monsterHealth>0)
        {
            if(mw.attack+mw.weapBonus>monsterDamage)
            {
                monsterHealth -= mw.attack+mw.weapBonus;
                if (monsterHealth <= 0) {
                    monsterHealth = 0;
                    System.out.println("The Witch Is Dead.");
                    mw.xp += 500;
                    mw.lvlUp();
                    mw.stealth+=1;
                } else {

                    damage(mw.health, mw.soak, monsterDamage);
                    System.out.println("You hit the witch, doing " + mw.attack+mw.weapBonus + " damage. It hits you with " + monsterDamage + " damage.");
                    if (mw.health <= 0) {
                        System.out.println("You Died.");
                        mw.gameOver = true;
                    }
                }
            }
        }
        if(attackChoose.equals("n"))
        {
            if(mw.stealth>notice){
                System.out.println("You Escaped.");
                mw.stealth++;
            }
            else
            {
                while(monsterHealth>0)
                {
                    if(mw.attack+mw.weapBonus>monsterDamage)
                    {
                        monsterHealth -= mw.attack+mw.weapBonus;
                        if (monsterHealth <= 0) {
                            monsterHealth = 0;
                            System.out.println("The Witch Is Dead.");
                            mw.xp += 500;
                            mw.lvlUp();
                            mw.stealth+=0.5;
                        } else {

                            damage(mw.health, mw.soak, monsterDamage);
                            System.out.println("You hit the witch, doing " + mw.attack+mw.weapBonus + " damage. It hits you with " + monsterDamage + " damage.");
                            if (mw.health <= 0) {
                                System.out.println("You Died.");
                                mw.gameOver = true;
                            }
                        }
                    }
                }
            }
        }

    }
    public static void ghost()
    {
        monsterHealth=17;
        monsterDamage=7;
        notice=8;
        System.out.println("A Ghost appears from the ground. Will you attack?");
        attackChoose=mw.in.nextLine();
        while(attackChoose.equals("y") && monsterHealth>0)
        {
            if(mw.attack+mw.weapBonus+mw.weapBonus>monsterDamage)
            {
                monsterHealth -= mw.attack+mw.weapBonus+mw.weapBonus;
                if (monsterHealth <= 0) {
                    monsterHealth = 0;
                    System.out.println("The Ghost Is Dead.");
                    mw.xp += 750;
                    mw.lvlUp();
                    mw.stealth+=1;
                } else {

                    damage(mw.health, mw.soak, monsterDamage);
                    System.out.println("You hit the ghost, doing " + mw.attack+mw.weapBonus+mw.weapBonus + " damage. It hits you with " + monsterDamage + " damage.");
                    if (mw.health <= 0) {
                        System.out.println("You Died.");
                        mw.gameOver = true;
                    }
                }
            }
        }
        if(attackChoose.equals("n"))
        {
            if(mw.stealth>notice){
                System.out.println("You Escaped.");
                mw.stealth++;
            }
            else
            {
                while(monsterHealth>0)
                {
                    if(mw.attack+mw.weapBonus+mw.weapBonus>monsterDamage)
                    {
                        monsterHealth -= mw.attack+mw.weapBonus+mw.weapBonus;
                        if (monsterHealth <= 0) {
                            monsterHealth = 0;
                            System.out.println("The Ghost Is Dead.");
                            mw.xp += 750;
                            mw.lvlUp();
                            mw.stealth+=0.5;
                        } else {

                            damage(mw.health, mw.soak, monsterDamage);
                            System.out.println("You hit the ghost, doing " + mw.attack+mw.weapBonus+mw.weapBonus + " damage. It hits you with " + monsterDamage + " damage.");
                            if (mw.health <= 0) {
                                System.out.println("You Died.");
                                mw.gameOver = true;
                            }
                        }
                    }
                }
            }
        }
    }
    public static void dragon()
    {
        monsterHealth=20;
        monsterDamage=10;
        notice=4;
        System.out.println("A dragon swoops up from a cliff. Will you attack?");
        attackChoose = mw.in.nextLine();
        while(attackChoose.equals("y")&& monsterHealth>0)
        {
            monsterHealth-=mw.attack+mw.weapBonus+mw.weapBonus;
            if(monsterHealth<=0) {
                monsterHealth=0;
                System.out.println("The dragon is dead. You get 2 life.");
                mw.health += 2;
                mw.stealth+=1;
            }else{
                damage(mw.health,mw.soak,monsterDamage);
                System.out.println("You hit the Dragon, doing "+ mw.attack+mw.weapBonus+mw.weapBonus + " damage. It hits you with " + monsterDamage + " damage.");
                if(mw.health<=0)
                {
                    System.out.println("You Died.");
                    mw.gameOver=true;
                }
            }

        }
        if(attackChoose.equals("n"))
        {
            if(mw.stealth>notice){
                System.out.println("You Escaped.");
                mw.stealth++;
            }
            else
            {
                while(monsterHealth>0)
                {
                    if(mw.attack+mw.weapBonus+mw.weapBonus>monsterDamage)
                    {
                        monsterHealth -= mw.attack+mw.weapBonus+mw.weapBonus;
                        if (monsterHealth <= 0) {
                            monsterHealth = 0;
                            System.out.println("The Ghost Is Dead.");
                            mw.xp += 750;
                            mw.lvlUp();
                            mw.stealth+=0.5;
                        } else {

                            damage(mw.health, mw.soak, monsterDamage);
                            System.out.println("You hit the ghost, doing " + mw.attack+mw.weapBonus+mw.weapBonus + " damage. It hits you with " + monsterDamage + " damage.");
                            if (mw.health <= 0) {
                                System.out.println("You Died.");
                                mw.gameOver = true;
                            }
                        }
                    }
                }
            }
        }
    }
    public static void demon ()
    {
        monsterDamage=30;
        monsterHealth=15;
        notice=7;
        System.out.println("You see a Demon. Will you Attack?");
        attackChoose = mw.in.nextLine();
        while(attackChoose.equals("y")&& monsterHealth>0)
        {
            monsterHealth-=mw.attack+mw.weapBonus+mw.weapBonus;
            if(monsterHealth<=0){
                monsterHealth=0;
                System.out.println("The Demon is dead. You get 2 life.");
                mw.health+=2;
                mw.stealth+=2;
            }else{
                damage(mw.health,mw.soak,monsterDamage);
                System.out.println("You hit the Demon, doing "+ mw.attack+mw.weapBonus + " damage. It hits you with " + monsterDamage + " damage.");
                if(mw.health<=0)
                {
                    System.out.println("You Died.");
                    mw.gameOver=true;
                }
            }

        }
        if(attackChoose.equals("n"))
        {
            System.out.println("The demon draws you into itself. You Die.");
            mw.gameOver=true;
        }
    }
    private static void damage(int h,int s,int d)
    {
        h-=(d-s);
    }
}
