package isu;

class Attack {
	String name;
	String desc;
	int type;
	int power;
	int id;
	int critChance = 15;
	int accuracy = 100;
	boolean canFlinch = false;
	String moveType;
	
	public Attack() {
		
	}
	
	public Attack(int id) {
		this.id = id;
		setAttackData(id);
	}
	
	public String getAtkName() {
		return this.name;
	}
	
	public String getAtkDesc() {
		return this.desc;
	}
	public int getAtkID() {
		return id;
	}
	public int getAtkPower() {
		return power;
	}
	public int getAtkType() {
		return type;
	}
	public int getCritChance() {
		return critChance;
	}
	public int getAccuracy() {
		return accuracy;
	}
	
	public String getMoveType() {
		 return moveType;
	}
	public boolean getFlinch() {
		return canFlinch;
	}
	
	public void setAttackData(int id) {
		switch (id) {
		case 1:
			this.name = "Air Slash";
			this.desc = "The user attacks with a blade of air that slices the sky. Can flinch the target.";
			this.type = 8;
			this.power = 75;
			this.accuracy = 95;
			this.moveType = "special";
			this.canFlinch = true;
			break;
		case 2:
			this.name = "Blizzard";
			this.desc = "Hits the foe with a howling blizzard.";
			this.type = 12;
			this.power = 100;
			this.accuracy = 70;
			this.moveType = "special";
			break;
		case 3:
			this.name = "Body Press";
			this.desc = "Uses defense instead of attack in damage calculations.";
			this.type = 6;
			this.power = 85;
			this.moveType = "physical";
			break;
		case 4:
			this.name = "Body Slam";
			this.desc = "The user slams themself into their foe. Does devastating damage.";
			this.type = 6;
			this.power = 85;
			this.accuracy = 95;
			this.moveType = "physical";
			break;
		case 5:
			this.name = "Crunch";
			this.desc = "The user crunches up the foe with sharp fangs.";
			this.type = 2;
			this.power = 90;
			this.accuracy = 95;
			this.moveType = "physical";
			break;
		case 6:
			this.name = "Earthquake";
			this.desc = "A strong earthquake that doesn't hit flying opponents.";
			this.type = 11;
			this.power = 100;
			this.moveType = "physical";
			break;
		case 7:
			this.name = "Extrasensory";
			this.desc = "The user attacks with an odd, unseeable power.";
			this.type = 15;
			this.power = 80;
			this.moveType = "special";
			break;
		case 8:
			this.name = "Flamethrower";
			this.desc = "The target is scorched with an intense blast of fire.";
			this.type = 7;
			this.power = 90;
			this.moveType = "special";
			break;
		case 9:
			this.name = "Flash Cannon";
			this.desc = "The user gathers all its light energy and releases it at once. ";
			this.type = 17;
			this.power = 80;
			this.moveType = "special";
			break;
		case 10:
			this.name = "Heat Wave";
			this.desc = "The user attacks by exhaling hot breath its foe.";
			this.type = 7;
			this.power = 95;
			this.accuracy = 95;
			this.moveType = "special";
			break;
		case 11:
			this.name = "Hurricane";
			this.desc = "The user attacks by wrapping its opponent in a fierce wind that flies up into the sky.";
			this.type = 8;
			this.power = 120;
			this.accuracy = 70;
			this.moveType = "physical";
			break;
		case 12:
			this.name = "Hydro Pump";
			this.desc = "The target is blasted by a huge volume of water.";
			this.type = 18;
			this.power = 110;
			this.accuracy = 80;
			this.moveType = "special";
			break;
		case 13:
			this.name = "Ice Beam";
			this.desc = "The target is struck with a icy-cold beam of energy.";
			this.type = 12;
			this.power = 90;
			this.moveType = "special";
			break;
		case 14:
			this.name = "Ice Punch";
			this.desc = "The target is punched by an icy punch.";
			this.type = 12;
			this.power = 75;
			this.moveType = "physical";
			break;
		case 15:
			this.name = "Moonblast";
			this.desc = "The user uses the power of the moon to attack the target.";
			this.type = 5;
			this.power = 95;
			this.moveType = "special";
			break;
		case 16:
			this.name = "Night Slash";
			this.desc = "The user slashes the target the instant an oppurtunity arises.";
			this.type = 2;
			this.power = 70;
			this.critChance = 40;
			this.moveType = "physical";
			break;
		case 17:
			this.name = "Return";
			this.desc = "This attack grows more powerful the more the user likes its Trainer";
			this.type = 13;
			this.power = 100;
			this.moveType = "physical";
			break;
		case 18:
			this.name = "Shadow Claw";
			this.desc = "The user slash with a sharp claw made of shadows.";
			this.type = 9;
			this.power = 70;
			this.critChance = 40;
			this.moveType = "physical";
			break;
		case 19:
			this.name = "Surf";
			this.desc = "The battlefield is swamped by a giant wave.";
			this.type = 18;
			this.power = 90;
			this.moveType = "physical";
			break;
		case 20:
			this.name = "Thunder";
			this.desc = "A strong electric type attack that crashes down on the foe.";
			this.type = 4;
			this.power = 110;
			this.accuracy = 70;
			this.moveType = "special";
			break;
		case 21:
			this.name = "Tri Attack";
			this.desc = "The user strikes with a simultaneous three-beam attack.";
			this.type = 13;
			this.power = 80;
			this.moveType = "special";
			break;
		case 22:
			this.name = "Poison Jab";
			this.desc = "The target is stabbed with a tentacle steeped in poison.";
			this.type = 14;
			this.power = 80;
			this.moveType = "physical";
			break;
		case 23:
			this.name = "Fire Blast";
			this.desc = "The target is attacked with an intense blast of all-consuming fire.";
			this.type = 7;
			this.power = 110;
			this.accuracy = 85;
			this.moveType = "special";
			break;
		case 24:
			this.name = "Stone Edge";
			this.desc = "The user stabs the target with sharpened stones from below.";
			this.type = 16;
			this.power = 100;
			this.accuracy = 80;
			this.critChance = 40;
			this.moveType = "physical";
			break;
		case 25:
			this.name = "Close Combat";
			this.desc = "The user fights the target up close without guarding itself.";
			this.type = 6;
			this.power = 120;
			this.accuracy = 75;
			this.moveType = "physical";
			break;
		case 26:
			this.name = "Iron Head";
			this.desc = "The user fights the target up close without guarding itself.";
			this.type = 17;
			this.power = 80;
			this.moveType = "physical";
			this.canFlinch = true;
			break;
		case 27:
			this.name = "Psychic Fangs";
			this.desc = "The user bites the target with its psychic capabilities.";
			this.type = 15;
			this.power = 85;
			this.moveType = "physical";
			break;
		case 28:
			this.name = "Liquidation";
			this.desc = "The user slams into the target using a full-force blast of water.";
			this.type = 18;
			this.power = 80;
			this.moveType = "physical";
			break;		
		}
	}
}
