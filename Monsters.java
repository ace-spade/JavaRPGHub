/**
 * Created by spade on 2017-06-26.
 */
public class Monsters {
    static int monsterHealth;
    static int monsterDamage;
    static TextGameGUIDemo mw;
    static String attackChoose;
    static int notice;
    //done
    public static void snake()
    {
        monsterHealth=3;
        notice =0;

        mw.textAreaBig.append("A snake Appears! Will you attack?");
        if(mw.input.equals(""))
        {
            while (mw.input.equals("")){
                try {
                    Thread.sleep(250);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        attackChoose = mw.input;
        mw.input="";
        if(attackChoose.equals("y"))
        {

            mw.textAreaBig.append("The Snake Is Dead.");
            mw.xp+=50;
            mw.lvlUp();
            mw.stealth+=0.5;
        }else
        {
            mw.textAreaBig.append("You Escaped.");
            mw.stealth++;
        }
    }
    //done
    public static void zombie()
    {

        monsterHealth=10;
        monsterDamage=2;
        notice=2;
        mw.textAreaBig.append("Out shambles a zombie! Will you attack?");
        if(mw.input.equals(""))
        {
            while (mw.input.equals("")){
                try {
                    Thread.sleep(250);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        attackChoose = mw.input;
        mw.input="";
        while(attackChoose.equals("y") && monsterHealth>0)
        {
            monsterHealth-=mw.attack;
            if(monsterHealth<=0){
                monsterHealth=0;

                mw.textAreaBig.append("The Zombie Is Dead.");
                mw.xp+=100;
                mw.lvlUp();
                mw.stealth+=0.5;
            }else{

                damage(mw.health,mw.soak,monsterDamage);
                mw.textAreaBig.append("You hit the zombie, doing "+ mw.attack + " damage. It hits you with " + monsterDamage + " damage.");
                if(mw.health<=0)
                {
                    mw.textAreaBig.append("You Died.");
                    mw.gameOver=true;
                }
            }

        }
        if(attackChoose.equals("n"))
        {
            if(mw.stealth>notice) {
                mw.textAreaBig.append("You Escaped.");
                mw.stealth++;
            }
            else{
                while(monsterHealth>0)
                {
                    monsterHealth-=mw.attack;
                    if(monsterHealth<=0){
                        monsterHealth=0;
                        mw.textAreaBig.append("The Zombie Is Dead.");
                        mw.xp+=100;
                        mw.lvlUp();
                        mw.stealth+=0.5;
                    }else{

                        damage(mw.health,mw.soak,monsterDamage);
                        mw.textAreaBig.append("You hit the zombie, doing "+ mw.attack + " damage. It hits you with " + monsterDamage + " damage.");
                        if(mw.health<=0)
                        {
                            mw.textAreaBig.append("You Died.");
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
        monsterDamage=3;
        notice=3;
        mw.textAreaBig.append("From the water comes a Pirate, do you want to fight?");
        if(mw.input.equals(""))
        {
            while (mw.input.equals("")){
                try {
                    Thread.sleep(250);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        attackChoose = mw.input;
        mw.input="";
        while(attackChoose.equals("y") && monsterHealth>0)
        {
            if(mw.attack>monsterDamage)
            {
                monsterHealth -= mw.attack;
                if (monsterHealth <= 0) {
                    monsterHealth = 0;
                    mw.textAreaBig.append("The Pirate Is Dead.");
                    mw.xp += 200;
                    mw.lvlUp();
                    mw.stealth+=0.5;
                } else {

                    damage(mw.health, mw.soak, monsterDamage);
                    mw.textAreaBig.append("You hit the pirate, doing " + mw.attack + " damage. It hits you with " + monsterDamage + " damage.");
                    if (mw.health <= 0) {
                        mw.textAreaBig.append("You Died.");
                        mw.gameOver = true;
                    }
                }
            }
        }
        if(attackChoose.equals("n"))
        {
            if(mw.stealth>notice){
                mw.textAreaBig.append("You Escaped.");
                mw.stealth++;
            }
            else
            {
                while(monsterHealth>0)
                {
                    if(mw.attack>monsterDamage)
                    {
                        monsterHealth -= mw.attack;
                        if (monsterHealth <= 0) {
                            monsterHealth = 0;
                            mw.textAreaBig.append("The Pirate Is Dead.");
                            mw.xp += 200;
                            mw.lvlUp();
                            mw.stealth+=0.5;
                        } else {

                            damage(mw.health, mw.soak, monsterDamage);
                            mw.textAreaBig.append("You hit the pirate, doing " + mw.attack + " damage. It hits you with " + monsterDamage + " damage.");
                            if (mw.health <= 0) {
                                mw.textAreaBig.append("You Died.");
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
        notice=5;
        mw.textAreaBig.append("A Witch flies in on a broomstick. Will you attack?");
        if(mw.input.equals(""))
        {
            while (mw.input.equals("")){
                try {
                    Thread.sleep(250);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        attackChoose = mw.input;
        mw.input="";
        while(attackChoose.equals("y") && monsterHealth>0)
        {
            if(mw.attack>monsterDamage)
            {
                monsterHealth -= mw.attack;
                if (monsterHealth <= 0) {
                    monsterHealth = 0;
                    mw.textAreaBig.append("The Witch Is Dead.");
                    mw.xp += 500;
                    mw.lvlUp();
                    mw.stealth+=1;
                } else {

                    damage(mw.health, mw.soak, monsterDamage);
                    mw.textAreaBig.append("You hit the witch, doing " + mw.attack + " damage. It hits you with " + monsterDamage + " damage.");
                    if (mw.health <= 0) {
                        mw.textAreaBig.append("You Died.");
                        mw.gameOver = true;
                    }
                }
            }
        }
        if(attackChoose.equals("n"))
        {
            if(mw.stealth>notice){
                mw.textAreaBig.append("You Escaped.");
                mw.stealth++;
            }
            else
            {
                while(monsterHealth>0)
                {
                    if(mw.attack>monsterDamage)
                    {
                        monsterHealth -= mw.attack;
                        if (monsterHealth <= 0) {
                            monsterHealth = 0;
                            mw.textAreaBig.append("The Witch Is Dead.");
                            mw.xp += 500;
                            mw.lvlUp();
                            mw.stealth+=0.5;
                        } else {

                            damage(mw.health, mw.soak, monsterDamage);
                            mw.textAreaBig.append("You hit the witch, doing " + mw.attack + " damage. It hits you with " + monsterDamage + " damage.");
                            if (mw.health <= 0) {
                                mw.textAreaBig.append("You Died.");
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
        mw.textAreaBig.append("A Ghost appears from the ground. Will you attack?");
        if(mw.input.equals(""))
        {
            while (mw.input.equals("")){
                try {
                    Thread.sleep(250);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        attackChoose = mw.input;
        mw.input="";
        while(attackChoose.equals("y") && monsterHealth>0)
        {
            if(mw.attack>monsterDamage)
            {
                monsterHealth -= mw.attack;
                if (monsterHealth <= 0) {
                    monsterHealth = 0;
                    mw.textAreaBig.append("The Ghost Is Dead.");
                    mw.xp += 750;
                    mw.lvlUp();
                    mw.stealth+=1;
                } else {

                    damage(mw.health, mw.soak, monsterDamage);
                    mw.textAreaBig.append("You hit the ghost, doing " + mw.attack + " damage. It hits you with " + monsterDamage + " damage.");
                    if (mw.health <= 0) {
                        mw.textAreaBig.append("You Died.");
                        mw.gameOver = true;
                    }
                }
            }
        }
        if(attackChoose.equals("n"))
        {
            if(mw.stealth>notice){
                mw.textAreaBig.append("You Escaped.");
                mw.stealth++;
            }
            else
            {
                while(monsterHealth>0)
                {
                    if(mw.attack>monsterDamage)
                    {
                        monsterHealth -= mw.attack;
                        if (monsterHealth <= 0) {
                            monsterHealth = 0;
                            mw.textAreaBig.append("The Ghost Is Dead.");
                            mw.xp += 750;
                            mw.lvlUp();
                            mw.stealth+=0.5;
                        } else {

                            damage(mw.health, mw.soak, monsterDamage);
                            mw.textAreaBig.append("You hit the ghost, doing " + mw.attack + " damage. It hits you with " + monsterDamage + " damage.");
                            if (mw.health <= 0) {
                                mw.textAreaBig.append("You Died.");
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
        mw.textAreaBig.append("A dragon swoops up from a cliff. Will you attack?");
        if(mw.input.equals(""))
        {
            while (mw.input.equals("")){
                try {
                    Thread.sleep(250);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        attackChoose = mw.input;
        mw.input="";
        while(attackChoose.equals("y")&& monsterHealth>0)
        {
            monsterHealth-=mw.attack;
            if(monsterHealth<=0) {
                monsterHealth=0;
                mw.textAreaBig.append("The dragon is dead. You get 2 life.");
                mw.health += 2;
                mw.stealth+=1;
            }else{
                damage(mw.health,mw.soak,monsterDamage);
                mw.textAreaBig.append("You hit the Dragon, doing "+ mw.attack + " damage. It hits you with " + monsterDamage + " damage.");
                if(mw.health<=0)
                {
                    mw.textAreaBig.append("You Died.");
                    mw.gameOver=true;
                }
            }

        }
        if(attackChoose.equals("n"))
        {
            if(mw.stealth>notice){
                mw.textAreaBig.append("You Escaped.");
                mw.stealth++;
            }
            else
            {
                while(monsterHealth>0)
                {
                    if(mw.attack>monsterDamage)
                    {
                        monsterHealth -= mw.attack;
                        if (monsterHealth <= 0) {
                            monsterHealth = 0;
                            mw.textAreaBig.append("The Ghost Is Dead.");
                            mw.xp += 750;
                            mw.lvlUp();
                            mw.stealth+=0.5;
                        } else {

                            damage(mw.health, mw.soak, monsterDamage);
                            mw.textAreaBig.append("You hit the ghost, doing " + mw.attack + " damage. It hits you with " + monsterDamage + " damage.");
                            if (mw.health <= 0) {
                                mw.textAreaBig.append("You Died.");
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
        mw.textAreaBig.append("You see a Demon. Will you Attack?");
        if(mw.input.equals(""))
        {
            while (mw.input.equals("")){
                try {
                    Thread.sleep(250);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        attackChoose = mw.input;
        mw.input="";
        while(attackChoose.equals("y")&& monsterHealth>0)
        {
            monsterHealth-=mw.attack;
            if(monsterHealth<=0){
                monsterHealth=0;
                mw.textAreaBig.append("The Demon is dead. You get 2 life.");
                mw.health+=2;
                mw.stealth+=2;
            }else{
                damage(mw.health,mw.soak,monsterDamage);
                mw.textAreaBig.append("You hit the Demon, doing "+ mw.attack + " damage. It hits you with " + monsterDamage + " damage.");
                if(mw.health<=0)
                {
                    mw.textAreaBig.append("You Died.");
                    mw.gameOver=true;
                }
            }

        }
        if(attackChoose.equals("n"))
        {
            mw.textAreaBig.append("The demon draws you into itself. You Die.");
            mw.gameOver=true;
        }
    }
    private static void damage(int h,int s,int d)
    {
        h-=(d-s);
    }
}
