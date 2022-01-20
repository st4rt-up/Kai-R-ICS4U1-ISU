package isu;

import java.util.Hashtable;

public class BattleData {
	Hashtable<String, int[]>weak = new Hashtable<String, int[]>();
	Hashtable<String, int[]>resist = new Hashtable<String, int[]>();
	Hashtable<String, int[]>immune = new Hashtable<String, int[]>();
	Hashtable<Integer, String>typeIDToString = new Hashtable<Integer, String>();
	
	BattleData() {	
		weak.put("bug", new int[] {7,8,16});
		weak.put("dark", new int[] {6,1,5});
		weak.put("dragon", new int[] {12,3,5});
		weak.put("electric", new int[] {11});
		weak.put("fairy", new int[] {14,17});
		weak.put("fighting", new int[] {8,15,5});
		weak.put("fire", new int[] {18,11,16});
		weak.put("flying", new int[] {4,12,16});
		weak.put("ghost", new int[] {9,2});
		weak.put("grass", new int[] {7,12,14,8,1});
		weak.put("ground", new int[] {18,10,12});
		weak.put("ice", new int[] {7,6,16,17});
		weak.put("normal", new int[] {6});
		weak.put("poison", new int[] {11,15});
		weak.put("psychic", new int[] {1,9,2});
		weak.put("rock", new int[] {18,10,6,11,17});
		weak.put("steel", new int[] {7,6,11});
		weak.put("water", new int[] {10,4});
		
		resist.put("bug", new int[] {10,6,11});
		resist.put("dark", new int[] {9,2});
		resist.put("dragon", new int[] {7,18,10,4});
		resist.put("electric", new int[] {4,8,17});
		resist.put("fairy", new int[] {6,1,2});
		resist.put("fighting", new int[] {1,16,2});
		resist.put("fire", new int[] {7,10,12,1,17,5});
		resist.put("flying", new int[] {10,6,1});
		resist.put("ghost", new int[] {14,1});
		resist.put("grass", new int[] {18,10,4,11});
		resist.put("ground", new int[] {14,16});
		resist.put("ice", new int[] {12});
		resist.put("normal", new int[] {0});
		resist.put("poison", new int[] {10,6,5,1});
		resist.put("psychic", new int[] {6,15});
		resist.put("rock", new int[] {13,7,8,14});
		resist.put("steel", new int[] {13,10,12,8,15,1,16,3,17,5});
		resist.put("water", new int[] {7,18,12,17});
		
		immune.put("bug", new int[] {0});
		immune.put("dark", new int[] {15});
		immune.put("dragon", new int[] {0});
		immune.put("electric", new int[] {0});
		immune.put("fairy", new int[] {3});
		immune.put("fighting", new int[] {0});
		immune.put("fire", new int[] {0});
		immune.put("flying", new int[] {11});
		immune.put("ghost", new int[] {13,6});
		immune.put("grass", new int[] {0});
		immune.put("ground", new int[] {4});
		immune.put("ice", new int[] {0});
		immune.put("normal", new int[] {9});
		immune.put("poison", new int[] {0});
		immune.put("psychic", new int[] {0});
		immune.put("rock", new int[] {0});
		immune.put("steel", new int[] {14});
		immune.put("water", new int[] {0});
		
		typeIDToString.put(1, "bug");
		typeIDToString.put(2, "dark");
		typeIDToString.put(3, "dragon");
		typeIDToString.put(4, "electric");
		typeIDToString.put(5, "fairy");
		typeIDToString.put(6, "fighting");
		typeIDToString.put(7, "fire");
		typeIDToString.put(8, "flying");
		typeIDToString.put(9, "ghost");
		typeIDToString.put(10, "grass");
		typeIDToString.put(11, "ground");
		typeIDToString.put(12, "ice");
		typeIDToString.put(13, "normal");
		typeIDToString.put(14, "poison");
		typeIDToString.put(15, "psychic");
		typeIDToString.put(16, "rock");
		typeIDToString.put(17, "steel");
		typeIDToString.put(18, "water");
	}
	
	public int[] getWeak(String input) {
		return weak.get(input);
	}
	
	public int[] getWeak(int id) {
		return getWeak(typeIDToString.get(id));
	}
	
	public int[] getResist(String input) {
		return resist.get(input);
	}
	
	public int[] getResist(int id) {
		return getResist(typeIDToString.get(id));
	}
	
	public int[] getImmune(String input) {
		return immune.get(input);
	}
	
	public int[] getImmune(int id) {
		return getImmune(typeIDToString.get(id));
	}
	
	public String typeIDToString(int id) {
		return typeIDToString.get(id);
	}
	
}
