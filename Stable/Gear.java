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
        mw.armorName="Iron Armor";
        mw.soak=6;
        System.out.println("You found Iron Armor");
    }
    public static void chainArmor()
    {
        aRat[1]=8;
        mw.armorName="Chain Armor";
        mw.soak=8;

        System.out.println("You found Chain Armor");
    }
    public static void plateArmor()
    {
        aRat[2]=10;
        mw.armorName="Plate Armor";
        mw.soak=10;
        System.out.println("You found Plate Armor");
    }
    public static void magicArmor1()
    {
        aRat[3]=12;
        mw.armorName="Magic Armor I";
        mw.soak=12;
        System.out.println("You found Magic Armor I");
    }
    public static void magicArmor2()
    {
        aRat[4]=14;
        mw.armorName="Magic Armor II";
        mw.soak=14;
        System.out.println("You found Magic Armor II");
    }
    public static void magicArmor3()
    {
        aRat[5]=18;
        mw.armorName="Magic Armor III";
        mw.soak=18;
        System.out.println("You found Magic Armor III");
    }
    public static void legendaryArmor()
    {
        aRat[6]=25;
        mw.armorName="Legendary Armor";
        mw.soak=25;
        System.out.println("You found Legendary Armor ");
    }
    public static void woodSword()
    {
        wDam[0]=2;
        mw.attack=2;
        mw.weaponName="Wood Sword";
        System.out.println("You found " + mw.weaponName);
    }
    public static void ironSword()
    {
        wDam[1]=5;
        mw.attack=5;
        mw.weaponName="Iron Sword";
        System.out.println("You found " + mw.weaponName);
    }
    public static void steelSword()
    {
        wDam[2]=7;
        mw.attack=7;
        mw.weaponName="Steel Sword";
        System.out.println("You found " + mw.weaponName);
    }
    public static void magicSword()
    {
        wDam[3]=10;
        mw.attack=10;
        mw.weaponName="Magic Sword";
        System.out.println("You found " + mw.weaponName);
    }
    public static void lightSword()
    {
        wDam[4]=15;
        mw.attack=15;

        mw.weaponName="Light Sword";
        System.out.println("You found " + mw.weaponName);
    }
    public static void vineSword()

    {
        wDam[5]=20;
        mw.attack=20;
        mw.weaponName="Vine Sword";
        System.out.println("You found " + mw.weaponName);
    }
    public static void titaniumSword()
    {
        wDam[6]=50;
        mw.attack=50;
        mw.weaponName="Titanium Sword";
        System.out.println("You found " + mw.weaponName);
    }

}
