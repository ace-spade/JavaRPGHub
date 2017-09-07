/**
 * Created by spade on 2017-07-17.
 */
public class Gear {
    static MainWorld mw = new MainWorld();
    static int[] aRat = new int[7];
    static int[] wDam = new int[7];

    public static void ironArmor()
    {
        aRat[0]=6;
        if(aRat[0]>mw.soak) {
            mw.armorName = "Iron Armor";
            mw.soak = 6;
            System.out.println("You found Iron Armor");
        }
    }
    public static void chainArmor()
    {
        aRat[1]=8;
        if(aRat[1]>mw.soak) {
            mw.armorName = "Chain Armor";
            mw.soak = 8;

            System.out.println("You found Chain Armor");
        }
    }
    public static void plateArmor()
    {
        aRat[2]=10;
        if(aRat[2]>mw.soak) {
            mw.armorName = "Plate Armor";
            mw.soak = 10;
            System.out.println("You found Plate Armor");
        }
    }
    public static void magicArmor1()
    {
        aRat[3]=12;
        if(aRat[3]>mw.soak) {
            mw.armorName = "Magic Armor I";
            mw.soak = 12;
            System.out.println("You found Magic Armor I");
        }
    }
    public static void magicArmor2()
    {
        aRat[4]=14;
        if(aRat[4]>mw.soak) {
            mw.armorName = "Magic Armor II";
            mw.soak = 14;
            System.out.println("You found Magic Armor II");
        }
    }
    public static void magicArmor3()
    {
        aRat[5]=18;
        if(aRat[5]>mw.soak) {
            mw.armorName = "Magic Armor III";
            mw.soak = 18;
            System.out.println("You found Magic Armor III");
        }
    }
    public static void legendaryArmor()
    {
        aRat[6]=25;
        if(aRat[6]>mw.soak) {
            mw.armorName = "Legendary Armor";
            mw.soak = 25;
            System.out.println("You found Legendary Armor ");
        }
    }
    public static void woodSword()
    {
        wDam[0]=2;
        if(wDam[0]>mw.weapBonus)
        {
            mw.weapBonus=2;
            mw.weaponName="Wood Sword";
            System.out.println("You found " + mw.weaponName);
        }
    }
    public static void ironSword()
    {
        wDam[1]=5;
        if(wDam[1]>mw.weapBonus)
        {
            mw.weapBonus=5;
            mw.weaponName="Iron Sword";
            System.out.println("You found " + mw.weaponName);
        }
    }
    public static void steelSword()
    {
        wDam[2]=7;
        if(wDam[2]>mw.weapBonus){
            mw.weapBonus = 7;
            mw.weaponName="Steel Sword";
            System.out.println("You found " + mw.weaponName);
        }
    }
    public static void magicSword() {
        wDam[3] = 10;
        if (wDam[3] > mw.weapBonus)
        {
            mw.weapBonus=10;
            mw.weaponName="Magic Sword";
            System.out.println("You found " + mw.weaponName);
        }
    }
    public static void lightSword()
    {
        wDam[4]=15;
        if(wDam[4]>mw.weapBonus) {
                mw.weapBonus = 15;
                mw.weaponName = "Light Sword";
                System.out.println("You found " + mw.weaponName);
        }
    }
    public static void vineSword()

    {
        wDam[5]=20;
        if(wDam[5]>mw.weapBonus) {
            mw.weapBonus = 20;
            mw.weaponName = "Vine Sword";
            System.out.println("You found " + mw.weaponName);
        }
    }
    public static void titaniumSword()
    {
        wDam[6]=50;
        if(wDam[6]>mw.weapBonus) {
            mw.weapBonus = 50;
            mw.weaponName = "Titanium Sword";
            System.out.println("You found " + mw.weaponName);
        }
    }

}
