package Item;

public class Potion extends Item{
	
	private String name;
	private int healing;
	
	public Potion(String name, int healing) {
		super(name);
		this.name = name;
		this.healing = healing;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getHealing() {
		return healing;
	}
	public void setHealing(int healing) {
		this.healing = healing;
	}
	
	
}
