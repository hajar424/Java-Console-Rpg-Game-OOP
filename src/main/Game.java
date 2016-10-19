package main;
import Monster.Monster;
import monsters.Dog;
import monsters.Dragon;
import shop.*;
import shops.*;
import Monster.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

import Item.*;

public class Game {

    //ATTRIBUTES
	
	//Game
    Scanner sc = new Scanner(System.in);
    Random rn = new Random();
    ArmourShop shop1 = new ArmourShop();
    
    //Player
    Player p1 = new Player("Player", 1, 100, 10);
    ArrayList<Armour>  playerArmour = new ArrayList<Armour>();
    
    //Monsters
	ArrayList<Monster> monsterList = new ArrayList<Monster>();
    Dog d0 = new Dog("Pitbull",1, 100, 5 );
    Dragon d1 = new Dragon("Baby dragon", 1, 20, 2);
    Dragon d2 = new Dragon("Red dragon", 1, 40, 4);
    Dragon d3 = new Dragon("Purple dragon", 1, 60 , 6);
    Dragon d4 = new Dragon("Swedish dragon", 1, 80, 8);

   
    //Behaviors

    void start(){
    	line();
        System.out.println("-------------Welcome to The Game!--------------*");
        line();
        System.out.println("Enter your name: ");
        arrow();
        p1.setName(sc.next());
        menu();
            
    }
    
    void menu(){
    	line();
        System.out.println("Hello " + p1.getName() + "!");
        line();
        System.out.println("1. Go for a Adventure");
        System.out.println("2. Show Stats");
        System.out.println("3. Shop");
        System.out.println("4. End Game");
        arrow();
        switch (sc.nextInt()) {
            case 1:
                goAdventure();
                break;
            case 2:
                playerInfo();
                break;
            case 3:
            	//shop1.display();
                break;
            case 4:
            	System.out.println("Thanks for playing!");
                break;
        }
    }
    
     void goBack(){
    	System.out.println("1. Menu");
    	arrow();
    	switch(sc.nextInt()){
    		case 1:
    			menu();
    			break;
    	}
    }

   
     void goAdventure() {
    	 Monster randMonster = randomMonster();
    	 adventure(randMonster);
   
     }
     
     void adventure(Monster m){
    	 line();
    	 System.out.println("Would you like to attack: " + m.getName().toUpperCase() + " ?");
    	 line();
    	 System.out.println("(1). Yes, (2). Inspect " + m.getName() + ", (3) Leave");
    	 arrow();
 
    	 switch(sc.nextInt()){
    	 case 1:
    		 battle(p1, m);
    		 break;
    	 case 2: 
    		 monsterInfo(m);
    		 adventure(m);
    		 break;
    	 }
     }
    
     void monsterInfo(Monster m){
    	 System.out.println("-----------[MONSTER]-["+ m.getName() +"]------------");
    	 System.out.println("Name: " + m.getName());
    	 System.out.println("Health: " + m.getHealth());
    	 System.out.println("Level: " + m.getLevel());
    	 System.out.println("Damage: " + m.getDamage());
    	 adventure(m);
     }
        
    /**
     * Randomly generates a Monster
     * This is a bad way of generating a random object!
     * It take much processing power if you have a big ArrayList to shuffle all of it.
     * I solve it when i have more time.
     * @return a instant of monster class
     * */
    Monster randomMonster() {
    	monsterList.clear();
    	monsterList.add(d0);
    	monsterList.add(d1);
		monsterList.add(d2);
		monsterList.add(d3);
		monsterList.add(d4);
    	Collections.shuffle(monsterList);
    	Monster randomMonster = monsterList.get(0);
        return randomMonster;
    }
    
    
    void battle(Player p, Monster m) {
    	line();
    	System.out.println("- Player attacked the monster: " + p1.attack(m) );
    	System.out.println("- " + m.getName() + " attacked you: " + m.attack(p) + " damage");
    	line();
    	System.out.println("/- Player has: " + p.getHealth() + " left");
    	System.out.println("/- Monster has: " + m.getHealth() + " left");
    	line();
    	System.out.println("(1). Hit again , (2) Inspect monster, (3) Inventory, (4) Leave");
    	arrow();
    	switch (sc.nextInt()) {
		case 1:
			battle(p, m);
			break;
			
		case 2:
			 monsterInfo(m);
			 break;
		case 3:
			break;
		case 4: 
			escapeBattle();
			break;
		default:
			break;
		}
    	
    }
    
    void leaveBattle(){
    	System.out.println("You are back in main menu");
    	menu();
    }
    
    void escapeBattle(){
    	System.out.println("Are you sure you want to escape?");
    	System.out.println("You will lose 10 health!");
    	System.out.println("(1) YES | (2) NO");
    }
    

    void playerInfo(){
    	System.out.println(" ");
    	System.out.println("-------------Player Information-----------------");
    	System.out.println("Name: " + p1.getName());
    	System.out.println("Level: " + p1.getLevel());
    	System.out.println("Health: " + p1.getHealth());
    	System.out.println("Max Damage: " + p1.getDamage());
    	System.out.println("Defence: " + p1.getDefence());
    	System.out.println("-------------Inventory-----------------");
    	System.out.println("---Armour----");
    	p1.showArmours();
    	line();
    	goBack();
    		
    }
    
	public void shop(){
		System.out.println("------------------[SHOP]-----------------------");
		System.out.println("What would you like to buy?");
		System.out.println("(1) Health Potions");
		System.out.println("(2) Armour");
		System.out.println(">>>------------------------------------------>>>");
		switch (sc.nextInt()){
			case 1:
				
				break;
			case 2:
				
				break;
		}
		
	}
    

    
    void arrow(){
    	System.out.println(">>>------------------------------------------>>>");
    }
    void line(){
    	System.out.println("------------------------------------------------");
    }
}
