/**
 * Created by spade on 2017-06-26.
 */
//imports classes
import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

import java.io.IOException;
import java.util.Scanner;
import java.io.File;
import java.io.PrintWriter;
//the hub class for the world
public class MainWorld  {
    //player position stored on a string
    static String[][][] world = new String[10][10][5];
    //player attributes
    static int health;
    static int attack = 1;
    static int soak = 0;
    static int xp = 0;
    static int lv = 1;
    static int weapBonus=1;
    static double stealth=0;
    static String weaponName="None";
    static String armorName="None";
    static boolean gameOver;
    static String name;
    static int x,y,z;
    static String fileName = "Load.txt";
    static Scanner in = new Scanner(System.in);
    private static void load()
    {


        try {

            File saveFile = new File(fileName);
            Scanner fileIn = new Scanner(saveFile);
            name = fileIn.nextLine();
            armorName=fileIn.nextLine();
            weaponName=fileIn.nextLine();
            System.out.println(name);
            x=fileIn.nextInt();
            y=fileIn.nextInt();
            z=fileIn.nextInt();
            health=fileIn.nextInt();
            attack=fileIn.nextInt();
            soak=fileIn.nextInt();
            weapBonus=fileIn.nextInt();
            stealth=fileIn.nextDouble();
            xp=fileIn.nextInt();
            fileIn.close();
        } catch (IOException e){
            e.printStackTrace();
        }
        place(world);
    }

    public static void main(String[] args)
    {
        System.out.println("To move, type u for up, d for down, l for left, r for right");
        System.out.println("Yes is y, No is n.");
        System.out.print("Load File?");

        String chooseLoad = in.nextLine();
        if(chooseLoad.equals("y"))
        {
            load();
        }
        System.out.print("Enter your name: ");
        name = in.nextLine();
        world[0][0][0]="Player";
        health=10;
        place(world);

    }
    public static void lvlUp()
    {
        if(xp>500 && lv<1){
            lv=1;
            health+=20;
            attack+=3;
            System.out.println("You Levelled Up!");
        }
        if(xp>1000 && lv<2){
            lv=2;
            health+=20;
            attack+=3;
            System.out.println("You Levelled Up!");
        }
        if(xp>2000 && lv<3){
            lv=3;
            health+=20;
            attack+=2;
            System.out.println("You Levelled Up!");
        }
        if(xp>3500 && lv<4){
            lv=4;
            health+=20;
            attack+=2;
            System.out.println("You Levelled Up!");
        }
        if(xp>5000&& lv<5){
            lv=5;
            health+=10;
            System.out.println("You Levelled Up!");
        }
    }

    private static void place (String[][][] w) {
        if(gameOver==false)
        {

            int randArmor = (int) Math.floor(Math.random()*20);
            if(randArmor==9){
                int armorChoice = (int) Math.floor(Math.random()*7);
                switch (armorChoice)
                {
                    case 0:
                            Gear.ironArmor();
                        break;
                    case 1:
                            Gear.chainArmor();
                        break;
                    case 2:
                            Gear.plateArmor();
                        break;
                    case 3:
                            Gear.magicArmor1();
                        break;
                    case 4:
                            Gear.magicArmor2();
                        break;
                    case 5:
                            Gear.magicArmor3();
                        break;
                    case 6:
                            Gear.legendaryArmor();
                        break;
                }
            }
            int randWeapon=(int) Math.floor(Math.random()*20);
            if(randWeapon==9)
            {
                int weaponChoice=(int)Math.floor(Math.random()*7) ;
                switch (weaponChoice){
                    case 0:
                            Gear.woodSword();

                        break;
                    case 1:
                            Gear.ironSword();

                        break;
                    case 2:

                            Gear.steelSword();

                        break;
                    case 3:
                            Gear.magicSword();

                        break;
                    case 4:
                            Gear.lightSword();

                        break;
                    case 5:
                            Gear.vineSword();

                        break;
                    case 6:
                            Gear.titaniumSword();

                        break;
                }
            }
            w[x][y][z] = "Player";

            if (z == 0)
            {
                if (y <=5 && x <=6 )
                {
                    Monsters.snake();
                }
                if (y >= 4 && x >= 3)
                {
                    Monsters.zombie();

                }
            }

            if (y + x == 18)
            {
                if (z == 0)
                {
                    System.out.println("Do you want to climb up the cliff?");
                    String climbChoose = in.nextLine();
                    if (climbChoose.equals("y")) {
                        z++;
                    }
                }
                if (z == 1)
                {
                    System.out.println("Do you want to climb down the cliff?");
                    String climbChoose = in.nextLine();
                    if (climbChoose.equals("y")) {
                        z--;
                    }
                    System.out.println("Do you want to climb up the cliff?");
                    climbChoose = in.nextLine();
                    if (climbChoose.equals("y")) {
                        z++;
                    }
                }
                if (z == 2)
                {
                    System.out.println("Do you want to climb down the cliff?");
                    String climbChoose = in.nextLine();
                    if (climbChoose.equals("y")) {
                        z--;
                    }
                    System.out.println("Do you want to climb up the cliff?");
                    climbChoose = in.nextLine();
                    if (climbChoose.equals("y")) {
                        z++;
                    }
                }
                if (z == 3)
                {
                    System.out.println("Do you want to climb down the cliff?");
                    String climbChoose = in.nextLine();
                    if (climbChoose.equals("y")) {
                        z--;
                    }
                }
            }

            if (z == 1)
            {
                if (x >= 4 && y <=5)
                {
                    Monsters.zombie();
                }
                if(x>=5 && y>=3)
                {
                    Monsters.snake();
                }
                if (x<=3)
                {
                    Monsters.pirate();
                }
            }


            if (z == 2)
            {
                if(x<=3)
                {
                    Monsters.pirate();
                }
                if(x>=5 && y>=5)
                {
                    Monsters.witch();
                }
                if(x>=6 && y<=3)
                {
                    Monsters.zombie();
                }
            }
            if(z==3)
            {
                if(x+y<=6)
                {
                    Monsters.ghost();
                }
                if(x<=7 && y>=2)
                {
                    Monsters.snake();
                }
                if(x<=4 && y>=8)
                {
                    Monsters.zombie();
                }
                if(x<=5 && x>=8 && y>=6)
                {
                    Monsters.witch();
                }

            }
            if(z==4)
            {
                if(x<=5 && y<6)
                {
                    Monsters.demon();
                }
                if(x>5 && x<8 && y>6 && y<9)
                    {
                        Monsters.dragon();
                    }
            }

            try {
                PrintWriter writer = new PrintWriter(fileName, "UTF-8");
                writer.println(name);
                writer.println(armorName);
                writer.println(weaponName);
                writer.println(x);
                writer.println(y);
                writer.println(z);
                writer.println(health);
                writer.println(attack);
                writer.println(soak);
                writer.println(weapBonus);
                writer.println(stealth);
                writer.println(xp);
                writer.close();
            } catch (IOException e)
            {
                // do something
            }
            System.out.println("Check Stats?");
            String statCheck = in.nextLine();
            if (statCheck.equals("y"))
            {
                System.out.println(name);
                System.out.println("Health: " + health);
                System.out.println("Attack: " + attack);
                System.out.println("Stealth: "+ stealth);
                System.out.println("Armor: " + armorName + ": " + soak);
                System.out.println("Weapon: " +weaponName+ ": " + weapBonus);
                System.out.println(x + "," + y + "," + z);
                System.out.println("Level: " + lv);
                System.out.println("XP: " + xp);
            }
            System.out.println("Where do you want to go?");
            String dir = in.nextLine();
            switch (dir)
            {
                case "u":
                    if (y <= 8)
                    {
                        y++;
                    }

                    place(world);
                    break;
                case "d":
                    if (y >= 1)
                    {
                        y--;
                    }

                    place(world);
                    break;
                case "l":
                    if (x >= 1)
                    {
                        x--;
                    }

                    place(world);
                    break;
                case "r":
                    if (x <= 8)
                    {
                        x++;
                    }

                    place(world);
                    break;
                default:
                    place(world);
                    break;

            }
            in.close();
        }else {
            System.out.println("Game Over.");
        }
    }
}
