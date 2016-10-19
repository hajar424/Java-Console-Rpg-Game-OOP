package main;
import java.util.ArrayList;

import Monster.Monster;


public class Player {
    //Attributes
	Game gm;
	
	ArrayList<Armour> playerArmour = new ArrayList();
	Armour boots = new Armour("Steel boots",10);
	Armour helmet = new Armour("Frozen Helmet", 25);
	
    private String name;
    private int level;
    private int health;
    private int damage;
    private int gold;
    private int defence;

    //BEHAVIORS
    
    public Player(String name, int level, int health, int damage) {
		this.name = name;
		this.level = level;
		this.health = health;
		this.damage = damage;
		playerArmour.add(helmet);
		playerArmour.add(boots);
		totalArmour();
	}
    
    //Getters and Setters
    
	public ArrayList<Armour> getArmour() {
		return playerArmour;
	}

	public void setArmour(ArrayList<Armour> armour) {
		this.playerArmour = armour;
	}
    
    public String getName() {
        return name;
    }

	public void setName(String name) {
        this.name = name;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }
    
    public int getGold() {
    	return gold;
    }
    
    public void setGold(int gold){
    	this.gold = gold;
    }
    
    public int getDefence() {
		return defence;
	}

	public void setDefence(int defence) {
		this.defence = defence;
	}

    
    int attack(Monster m1){
    	m1.setHealth(m1.getHealth() - damage);
    	
    	if (m1.getHealth() <= 0) {
			won();		
    	}
    
     	return damage;  
     	
     	
    }
    
    void showArmours(){
    	System.out.println("[ID] [NAME] [DEFENCE]");
    	for(int i = 0; i < playerArmour.size(); i++){
    		System.out.println("[" + (i+1) + "] " + "Item: " + playerArmour.get(i).getName() + " - Defence: " + playerArmour.get(i).getDefence());
    	}
    }
    
    void totalArmour(){
    	for(int i = 0; i < playerArmour.size(); i++){
    		defence += playerArmour.get(i).getDefence();
    	}
    }
    
	void won(){
    	gm = new Game();
    	System.out.println("- You won the battle!");
    	gm.line();
      	gm.goBack();
    
    }








}
