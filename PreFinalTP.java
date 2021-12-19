import java.util.*;
// Natanauan, Carlos Benedict || Object Oriented Programming || Text Based Console Game
interface StoryEnemy {
    void StrHp();
    void StrDamage();
}

interface SurvivalEnemy {
    void StrHp();
    void StrDamage();
}

interface UserStats {
    void hp();
    void damage();
    void Description();
}

public class TextBasedGame {

    public static void main(String[] args) {
        survival sur = new survival();
        story str = new story();
        Scanner s = new Scanner(System.in);

        String name, pressP;
        int selection;

        int advUserHp = 1000;//for the user in story mode
        int advUserDamage = 200;

        int strHp = 800;//for the randomAdv in story mode
        int strDamage = 200;

        int surUserHp = 1000;//for the user in survival mode
        int surUserDamage = 200;

        int surHp = 1000;//for the randomSur in adventure mode
        int surDamage = 200;

        Random rnd = new Random();

        String[] strEnemy = {"GENGHIS KHAN", "ALEXANDER THE GREAT", "CYRUS THE GREAT"};
        String[] surEnemy = {"CARDO DALISAY", "MULAWIN", "LASKTIKMAN"};

        System.out.print("Enter you name: ");
        name = s.nextLine();
        boolean toContinue = true;

        SELECT:
        while (toContinue) {
            System.out.println("Press 1 or 2 to select your game mode." + "\n1 - Story" + "\n2 - Survival");
            selection = s.nextInt();
            s.nextLine();
            System.out.println("Press P to start playing, " + name);
            pressP = s.nextLine();

            START:
            while (pressP.equalsIgnoreCase("P")) {

                if (selection == 1) {
                    System.out.println("\n\tWelcome to Story mode");
                    System.out.println("\tYou will face one of the greatest Conquerors of the world!");
                    System.out.println("\n\tPlayer Name: " + name);
                    str.playerStats();

                    System.out.println("\n-                   VS                -\n");
                    String randomAdv = strEnemy[rnd.nextInt(strEnemy.length)];
                    System.out.println("\tEnemy Name : " + randomAdv);
                    str.strEnemyStats();

                    OPTION:
                    while (strHp > 0) {
                        System.out.println("\nPress 1 to deal Damage:");
                        System.out.println("Press 2 to Escape");
                        String opts = s.nextLine();

                        int enemyDamage = rnd.nextInt(strDamage);

                        if (opts.contains("1")) {
                            advUserHp -= enemyDamage;
                            strHp -= advUserDamage;
                            System.out.println("#---------------------------------------------------#");
                            System.out.println("\n\t" + name + " deal " + advUserDamage + " Damage!");
                            System.out.println("\t" + randomAdv + " deal " + enemyDamage + " Damage!");
                            System.out.println("\n\tYour  HP: " + advUserHp);
                            System.out.println("\tEnemy HP: " + strHp);
                            System.out.println("#---------------------------------------------------#");

                        } else if (opts.contains("2")) {
                            System.out.println("You refuse to battle with " + randomAdv);
                            continue SELECT;
                        } else {
                            System.out.println("Invalid Command!");

                        }

                        if (advUserHp < 0) {
                            switch (randomAdv) {
                                case "GENGHIS KHAN":
                                    System.out.println("You lost to " + randomAdv);
                                    System.out.println("FOUNDER OF FIRST GREEK KJAN");
                                    break;
                                case "ALEXANDER THE GREAT":
                                    System.out.println("You lost to " + randomAdv);
                                    System.out.println("KING OF ANCIENT GREEK");
                                    break;
                                case "CYRUS THE GREAT":
                                    System.out.println("You lost to " + randomAdv);
                                    System.out.println("FOUNDER OF ACHAEMENID EMPIRE");
                                    break;
                            }
                            break;
                        }

                    }
                    if (strHp <= 0) {
                        switch (randomAdv) {
                            case "GENGHIS KHAN":
                                System.out.println("#-----------------------------------------------------------------------------------------------#");
                                System.out.println("\t\tYou beat " + randomAdv);
                                System.out.println("Genghis Khan was best known for unifying the Mongolian steppe\n"
                                        + " under a massive empire that was able to challenge the powerful Jin dynasty\n"
                                        + " in China and capture territory as far west as the Caspian Sea.");
                                System.out.println("#-----------------------------------------------------------------------------------------------#");
                                break;
                            case "ALEXANDER THE GREAT":
                                System.out.println("#-----------------------------------------------------------------------------------------------#");
                                System.out.println("\t\tYou beat " + randomAdv);
                                System.out.println("Alexander the Great changed the course of history. One of the world's\n"
                                        + " greatest military generals, he created a vast empire that stretched from Macedonia\n"
                                        + " to Egypt and from Greece to part of India. This allowed for Hellenistic culture to become widespread.");
                                System.out.println("#-----------------------------------------------------------------------------------------------#");
                                break;
                            case "CYRUS THE GREAT":
                                System.out.println("#-----------------------------------------------------------------------------------------------#");
                                System.out.println("\t\tYou beat " + randomAdv);
                                System.out.println("Cyrus is famous for freeing the Jewish captives in Babylonia and allowing them to return\n"
                                        + " to their homeland. Cyrus was also tolerant toward the Babylonians and others. He conciliated local\n"
                                        + " populations by supporting local customs and even sacrificing to local deities.");
                                System.out.println("#-----------------------------------------------------------------------------------------------#");
                                break;
                        }
                    }

                    toContinue = false;//to stop the first loop
                    break;

                } else if (selection == 2) {

                    System.out.println("\t\nWelcome to Survival mode");
                    System.out.println("You will face one of the Strongest Personality of the Philippines");
                    System.out.println("\n\tPlayer Name: " + name);
                    sur.playerStats();

                    System.out.println("\n-                   VS                -\n");
                    String randomSur = surEnemy[rnd.nextInt(surEnemy.length)];
                    System.out.println("\tEnemy Name : " + randomSur);
                    sur.strEnemyStats();

                    SUROPTION:
                    while (surUserHp > 0) {
                        System.out.println("\nPress 1 to deal Damage:");
                        System.out.println("Press 2 to Escape");
                        String opts = s.nextLine();

                        int userDamage = rnd.nextInt(surUserDamage);

                        if (opts.contains("1")) {
                            surHp -= userDamage;
                            surUserHp -= surDamage;
                            System.out.println("#---------------------------------------------------#");
                            System.out.println("\n\t" + name + " deal " + userDamage + " Damage!");
                            System.out.println("\t" + randomSur + " deal " + surDamage + " Damage!");
                            System.out.println("\n\tYour  HP: " + surUserHp);
                            System.out.println("\tEnemy HP: " + surHp);
                            System.out.println("#---------------------------------------------------#");
                        } else if (opts.contains("2")) {
                            System.out.println("You refuse to battle with " + randomSur);
                            continue SELECT;
                        } else {
                            System.out.println("Invalid Command!");

                        }

                        if (surHp < 0) {
                            switch (randomSur) {
                                case "CARDO DALISAY":
                                    System.out.println("You beat " + randomSur);
                                    System.out.println("THE IMMORTAL MAN");
                                    break;
                                case "MULAWIN":
                                    System.out.println("You beat " + randomSur);
                                    System.out.println("THE BIRD MAN");
                                    break;
                                case "LASKTIKMAN":
                                    System.out.println("You beat " + randomSur);
                                    System.out.println("THE ELACTIC MAN");
                                    break;
                            }
                            break;
                        }

                    }
                    if (surUserHp <= 0) {
                        switch (randomSur) {
                            case "CARDO DALISAY":
                                System.out.println("#-----------------------------------------------------------------------------------------------#");
                                System.out.println("\t\tYou lost to" + randomSur);
                                System.out.println("Ricardo \"Cardo\" Dalisay, or simply known as Cardo Dalisay, is the main\n"
                                        + " protagonist of 2015 longest running action crime drama Philippine television series\n"
                                        + ", FPJ's Ang Probinsyano. He is one of the strongest person in PH and considered as IMMORTAL");
                                System.out.println("#-----------------------------------------------------------------------------------------------#");
                                break;
                            case "MULAWIN":
                                System.out.println("#-----------------------------------------------------------------------------------------------#");
                                System.out.println("\t\tYou lost to " + randomSur);
                                System.out.println("Mulawin is a race of humanoid creatures with avian attributes. Mulawins live at Avalon\n"
                                        + " in Encantadia, and at Avila in the human world. Mulawins can be summoned by the Flute of Mulawin.\n"
                                        + " Mulawins usually leave behind a feather upon their arrival or departure.");
                                System.out.println("#-----------------------------------------------------------------------------------------------#");
                                break;
                            case "LASKTIKMAN":
                                System.out.println("#-----------------------------------------------------------------------------------------------#");
                                System.out.println("\t\tYou lost to " + randomSur);
                                System.out.println("Lastikman is a superhero who possesses the ability to stretch and distort his body, and takes\n"
                                        + " his alias from the word \"elastic\". He is a half-human/half-alien named \"Eskappar\" from an extragalactic\n"
                                        + " planet, though he was named Miguel when he came to Earth.");
                                System.out.println("#-----------------------------------------------------------------------------------------------#");
                                break;
                        }
                    }

                    toContinue = false;//to stop the first loop
                    break;

                }

            }
        }

    }

}

class story implements UserStats, StoryEnemy {

    String c1;

    @Override
    public void hp() {
        System.out.println("\tHP    : 1000");
    }

    @Override
    public void damage() {
        System.out.println("\tDAMAGE: 200");
    }

    @Override
    public void Description() {
        System.out.println("\tDescription: A normal Student, but a Great Adventurer");

    }

    void playerStats() {
        hp();
        damage();
        Description();
    }

    //Enemy
    @Override
    public void StrHp() {
        System.out.println("\tHP     : 1000");
    }

    @Override
    public void StrDamage() {
        System.out.println("\tDAMAGE : 1-200");
    }

    void strEnemyStats() {
        StrHp();
        StrDamage();

    }

    void GENGHISKHAN() {

    }

    void ALEXANDER() {

    }

    void CYRUS() {

    }

}

class survival implements UserStats, SurvivalEnemy {

    @Override
    public void hp() {
        System.out.println("\tHP    : 800");
    }

    @Override
    public void damage() {
        System.out.println("\tDAMAGE: 1-200");
    }

    @Override
    public void Description() {
        System.out.println("\tDescription: A normal Student and have low Suvibability");
    }

    void playerStats() {
        hp();
        damage();
        Description();
    }

    @Override
    public void StrHp() {
        System.out.println("\tHP    : 800");
    }

    @Override
    public void StrDamage() {
        System.out.println("\tDAMAGE: 200");
    }

    void strEnemyStats() {
        StrHp();
        StrDamage();
    }

}
