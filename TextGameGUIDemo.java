import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
/**
 * Created by spade on 2017-09-05.
 */

public class TextGameGUIDemo extends JFrame implements ActionListener
{

    static JTextArea textAreaBig;
    static JTextField textField;
    static JPanel panel;
    //player position stored on a string
    static String[][][] world = new String[10][10][5];
    //player attributes
    static int health;
    static int attack=1;
    static int soak=0;
    static int xp = 0;
    static int lv=0;
    static int weapBonus=0;
    static double stealth=0;
    static String weaponName="None";
    static String armorName="None";
    static boolean gameOver;
    static String name;
    static int x,y,z;
    static boolean exit = false;
    static String fileName = "Load.txt";
    static String input="";
    public static void main(String[] args)
    {
        new TextGameGUIDemo();
        textAreaBig.append("To move, type u for up, d for down, l for left, r for right");
        textAreaBig.append("Yes is y, No is n.");
        textAreaBig.append("Load File?");
        textAreaBig.setCaretPosition(textAreaBig.getDocument().getLength());
        if(input.equals(""))
        {
            while (input.equals("")){
                try {
                    Thread.sleep(250);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
            String chooseLoad = input;
            input="";
            if (chooseLoad.equals("y")) {
                load();
            }
        textAreaBig.append("Enter your name: ");
        textAreaBig.setCaretPosition(textAreaBig.getDocument().getLength());
        if(input.equals(""))
        {
            while (input.equals("")){
                try {
                    Thread.sleep(250);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        name = textField.getText();
        input="";
        world[0][0][0]="Player";
        health=10;
        place(world);

    }

    public TextGameGUIDemo()
    {
        //sets frame size, location and close operation
        this.setSize(1000,550);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //gets info on the computers settings like screen size
        Toolkit tk = Toolkit.getDefaultToolkit();
        //new dimension that gets the screen size and makes a program that fits on the computer
        Dimension dim = tk.getScreenSize();
        //puts the window in the middle of the screen
        int xPos	= (dim.width /	2)	- (this.getWidth() /	2);
        int yPos	= (dim.height / 2) -	(this.getHeight()	/ 2);
        this.setLocation(xPos,yPos);
        panel = new JPanel();
        panel.setBackground(new	Color(30,30,25));

        textAreaBig= new JTextArea(20,80);
        panel.add(textAreaBig);
        textAreaBig.setLineWrap(true);
        textAreaBig.setWrapStyleWord(true);
        JScrollPane mainScroll = new JScrollPane(textAreaBig, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        panel.add(mainScroll);

        textField = new JTextField(40);
        panel.add(textField);
        JScrollPane fieldScroll =new JScrollPane(textField,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        panel.add(fieldScroll);

        textField.addActionListener(this);

        this.add(panel);
        this.setVisible(true);

    }
    private static void load()
    {
        if(gameOver==false)

            try {

                File saveFile = new File(fileName);
                Scanner fileIn = new Scanner(saveFile);
                name = fileIn.nextLine();
                textAreaBig.append(name);
                textAreaBig.setCaretPosition(textAreaBig.getDocument().getLength());
                x=fileIn.nextInt();
                y=fileIn.nextInt();
                z=fileIn.nextInt();
                health=fileIn.nextInt();
                attack=fileIn.nextInt();
                soak=fileIn.nextInt();
                armorName=fileIn.nextLine();
                weaponName=fileIn.nextLine();
                textAreaBig.append("");
                weapBonus=fileIn.nextInt();
                stealth=fileIn.nextDouble();
                xp=fileIn.nextInt();
                fileIn.close();
            } catch (IOException e){
                e.printStackTrace();
            }
        place(world);
    }public static void lvlUp()
{
    if(xp>500 && lv<1){
        lv=1;
        health+=20;
        attack+=3;
    }
    if(xp>1000 && lv<2){
        lv=2;
        health+=20;
        attack+=3;
    }
    if(xp>2000 && lv<3){
        lv=3;
        health+=20;
        attack+=2;
    }
    if(xp>3500 && lv<4){
        lv=4;
        health+=20;
        attack+=2;
    }
    if(xp>5000){
        lv=5;
        health+=10;
    }
}

    private static void place (String[][][] w) {
        if(gameOver==false)
        {

            int randArmor = ((int) Math.floor(Math.random()*10));
            if(randArmor==9){
                int armorChoice = ((int) Math.floor(Math.random()*7));
                switch (armorChoice)
                {
                    case 0:
                        if(Gear.aRat[0]>soak)

                            Gear.ironArmor();
                        break;
                    case 1:
                        if(Gear.aRat[1]>soak)
                            Gear.chainArmor();
                        break;
                    case 2:
                        if(Gear.aRat[2]>soak)
                            Gear.plateArmor();
                        break;
                    case 3:
                        if(Gear.aRat[3]>soak)
                            Gear.magicArmor1();
                        break;

                    case 4:
                        if(Gear.aRat[4]>soak)
                            Gear.magicArmor2();
                        break;
                    case 5:
                        if(Gear.aRat[5]>soak)
                            Gear.magicArmor3();
                        break;
                    case 6:
                        if(Gear.aRat[6]>soak)
                            Gear.legendaryArmor();
                        break;
                }
            }
            int randWeapon=((int) Math.floor(Math.random()*10));
            if(randWeapon==9)
            {
                int weaponChoice=((int) Math.floor(Math.random()*7));
                switch (weaponChoice){
                    case 0:
                        if(Gear.wDam[weaponChoice]>weapBonus)
                        {
                            Gear.woodSword();
                        }
                        break;
                    case 1:
                        if(Gear.wDam[weaponChoice]>weapBonus)
                        {
                            Gear.ironSword();
                        }
                        break;
                    case 2:
                        if(Gear.wDam[weaponChoice]>weapBonus)
                        {
                            Gear.steelSword();
                        }
                        break;
                    case 3:
                        if(Gear.wDam[weaponChoice]>weapBonus)
                        {
                            Gear.magicSword();
                        }
                        break;
                    case 4:
                        if(Gear.wDam[weaponChoice]>weapBonus)
                        {
                            Gear.lightSword();
                        }
                        break;
                    case 5:
                        if(Gear.wDam[weaponChoice]>weapBonus)
                        {
                            Gear.vineSword();
                        }
                        break;
                    case 6:
                        if(Gear.wDam[weaponChoice]>weapBonus)
                        {
                            Gear.titaniumSword();
                        }
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
                    textAreaBig.append("Do you want to climb up the cliff?");
                    textAreaBig.setCaretPosition(textAreaBig.getDocument().getLength());
                    if(input.equals(""))
                {
                    while (input.equals("")){
                        try {
                            Thread.sleep(250);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
                    String climbChoose = input;
                    input="";
                    if (climbChoose.equals("y")) {
                        z++;
                    }
                }
                if (z == 1)
                {
                    textAreaBig.append("Do you want to climb down the cliff?");
                    textAreaBig.setCaretPosition(textAreaBig.getDocument().getLength());
                    if(input.equals(""))
                    {
                        while (input.equals("")){
                            try {
                                Thread.sleep(250);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                    String climbChoose = input;
                    input="";
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
                if(x>=5 && y<=3)
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
                writer.println(x);
                writer.println(y);
                writer.println(z);
                writer.println(health);
                writer.println(attack);
                writer.println(soak);
                writer.println(armorName);
                writer.println(weaponName);
                writer.println(weapBonus);
                writer.println(stealth);
                writer.println(xp);
                writer.close();
            } catch (IOException e) {
                // do something
            }
            textAreaBig.append("Check Stats?");
            textAreaBig.setCaretPosition(textAreaBig.getDocument().getLength());
            if(input.equals(""))
            {
                while (input.equals("")){
                    try {
                        Thread.sleep(250);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
            String statCheck = input;
            input="";
            if (statCheck.equals("y")) {
                textAreaBig.append(name);
                textAreaBig.append("Health: " + health);
                textAreaBig.append("Attack: " + attack);
                textAreaBig.append("Stealth: "+ stealth);
                textAreaBig.append("Armor: " + armorName + ": " + soak);
                textAreaBig.append("Weapon: " +weaponName+ ": " + weapBonus);
                textAreaBig.append(x + "," + y + "," + z);
                textAreaBig.append("Level: " + lv);
                textAreaBig.append("XP: " + xp);
                textAreaBig.setCaretPosition(textAreaBig.getDocument().getLength());
            }
            textAreaBig.append("Where do you want to go?");
            textAreaBig.setCaretPosition(textAreaBig.getDocument().getLength());
            if(input.equals(""))
            {
                while (input.equals("")){
                    try {
                        Thread.sleep(250);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
            String dir = input;
            input="";
            switch (dir) {
                case "u":
                    if (y <= 8) {
                        y++;
                    }

                    place(world);
                    break;
                case "d":
                    if (y >= 1) {
                        y--;
                    }

                    place(world);
                    break;
                case "l":
                    if (x >= 1) {
                        x--;
                    }

                    place(world);
                    break;
                case "r":
                    if (x <= 8) {
                        x++;
                    }

                    place(world);
                    break;
                default:
                    place(world);
                    break;

            }
        }else {
            textAreaBig.append("Game Over.");
            textAreaBig.setCaretPosition(textAreaBig.getDocument().getLength());
        }
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()==textField)
        {
            textAreaBig.append("\n" +textField.getText()+"\n");
            textAreaBig.setCaretPosition(textAreaBig.getDocument().getLength());

            input=textField.getText();
            textField.setText("");

            textField.requestFocus();
        }
    }
}


