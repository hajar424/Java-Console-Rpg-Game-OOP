package Monster;

import main.Player;


public abstract class Monster implements IMonster {

    private String name;
    private int level;
    private int health;
    private int damage;
    
    /**
     * @param When a instant of Monster is created this parameters are required
     * Name, level, health, damage
     * */
    public Monster(String name, int level, int health, int damage) {
    	this.name = name;
    	this.level = level;
    	this.health = health;
    	this.damage = damage;
    	
    }
    
    //Monster attacks player
    public int attack(Player p) {
    	
    	if (p.getHealth() <= 0) {
			won();
		}else{
	    	p.setHealth(p.getHealth() - damage + (p.getDefence()));
	    	System.out.println("Player health: " + p.getHealth());
		}
    	return damage;
    }
    
    
	void won(){
		System.out.println("Monster won");
		
		
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
    
    
    
    
    
    
    
}
