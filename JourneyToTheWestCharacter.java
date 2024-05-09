package com.atguigu.class_experiment;
public class JourneyToTheWestCharacter {
	private String name;
	private String weapon;
	private String ability; // 构造函数

	public JourneyToTheWestCharacter(String name, String weapon, String ability) {
		this.name = name;
		this.weapon = weapon;
		this.ability = ability;
	} // Getter 和 Setter 方法

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getWeapon() {
		return weapon;
	}

	public void setWeapon(String weapon) {
		this.weapon = weapon;
	}

	public String getAbility() {
		return ability;
	}

	public void setAbility(String ability) {
		this.ability = ability;
	} // 展示角色信息的方法

	public void showInfo() {
		System.out.println("Name: " + name);
		System.out.println("Weapon: " + weapon);
		System.out.println("Ability: " + ability);
	}

	// 静态方法，用于创建师徒四人的实例
	public static void main(String[] args) { 
		JourneyToTheWestCharacter tangSeng = new JourneyToTheWestCharacter("TangSeng", "None", "Leadership"); 
		JourneyToTheWestCharacter sunWuKong = new JourneyToTheWestCharacter("SunWuKong", "Golden Cudgel", "72 Transformations"); 
		JourneyToTheWestCharacter zhuBaJie = new JourneyToTheWestCharacter("ZhuBaJie", "Nine-Toothed Mace", "Super Strength");
		JourneyToTheWestCharacter shaWukong = new JourneyToTheWestCharacter("ShaWukong", "Moon-Sander Staff", "Endurance"); 
		// 展示师徒四人的信息
		tangSeng.showInfo(); 
		sunWuKong.showInfo(); 
		zhuBaJie.showInfo();
		shaWukong.showInfo(); 
	}
}