package isu;

import java.awt.Image;

class Monster {
	// to do - every mon has a list of types it is weak to and by how much
	String name;
	int type1;
	int type2;
	int health;
	int totalHealth;
	int atk;
	int spAtk;
	int def;
	int spDef;
	int speed;
	Image frontSprite = null;
	Image backSprite = null;
	Attack attack1;
	Attack attack2;
	Attack attack3;
	Attack attack4;
	
	/* type
	 * 1 = bug
	 * 2 = dark
	 * 3 = dragon
	 * 4 = electric
	 * 5 = fairy
	 * 6 = fighting
	 * 7 = fire
	 * 8 = flying
	 * 9 = ghost
	 * 10 = grass
	 * 11 = ground
	 * 12 = ice
	 * 13 = normal
	 * 14 = poison
	 * 15 = psychic
	 * 16 = rock
	 * 17 = steel
	 * 18 = water
	 */
	
	public Monster(String name) {
		this.name = name;
	}
	
	public Monster() {
		
	}
	
	public void setStats(int health, int atk, int def, int spAtk, int spDef, int speed) {
		this.atk = atk;
		this.spAtk = spAtk;
		this.def = def;
		this.spDef = spDef;
		this.speed = speed;
		this.health = health;
		this.totalHealth = health;
	}
	public void setTypes(int type1, int type2) {
		this.type1 = type1;
		this.type2 = type2;
	}
	public int[] getTypes() {
		int[] typeArray = {type1,type2};
		return typeArray;
	}
	public void setSprites(Image front, Image back) {
		frontSprite = front;
		backSprite = back;
	}
	public Image getFrontSprite() {
		return frontSprite;
	}
	public Image getBackSprite() {
		return backSprite;
	}
 	public int getTotalHP() {
		return totalHealth;
	}
	public int getHP() {
		return health;
	}
	public void setHP(int health) {
		this.health = health;
	}
	public int getAtkStat() {
		return atk;
	}
	public int getspAtkStat() {
		return spAtk;
	}
	public int getDefStat() {
		return def;
	}
	public int getspDefStat() {
		return spDef;
	}
	public int getSpeedStat() {
		return speed;
	}
	public String getMonName() {
		return this.name;
	}
	public Attack getFirstAtk() {
		return attack1;
	}	
	public Attack getSecondAtk() {
		return attack2;
	}
	public Attack getThirdAtk() {
		return attack3;
	}
	public Attack getFourthAtk() {
		return attack4;
	}
	public void setAllAtks(int atk1, int atk2, int atk3, int atk4) {
		attack1 = new Attack(atk1);
		attack2 = new Attack(atk2);
		attack3 = new Attack(atk3);
		attack4 = new Attack(atk4);
	}
}
