//import java.util.ArrayList;
//import java.util.Scanner;
//
//class Player{
//	public static void main(String[] args){
//
//	}
//
//	public static ArrayList<String> getValues(){
//		boolean quit = false;
//		int index = 0;
//		ArrayList<String> values = new ArrayList<String>();
//
//		System.out.println("Choose any option:\n"+
//				"0 - Quit\n"+
//				"1 - Enter value");
//
//		while(!quit){
//			Scanner sc = new Scanner(System.in);
//			int a = sc.nextInt();
//			switch(a){
//				case 0:
//					quit = true;
//					break;
//				case 1:
//					String strValue = sc.nextLine();
//					values.add(index, strValue);
//					index++;
//					break;
//			}
//		}
//		return values;
//	}
//
//	public static void saveObject(ISaveable objectToSave){
//		for(int i=0;i< objectToSave.write().size();i++){
//			System.out.println("Saving "+ objectToSave.write().get(i)+" to device...");
//		}
//	}
//
//	public static void loadObject(ISaveable objectToLoad){
//		ArrayList<String> values = getValues();
//		objectToLoad.read(values);
//	}
//
//}
//
//interface ISaveable{
//	ArrayList<String> write();
//	void read(ArrayList<String> savedValues);
//}
//
//class PlayerDetails implements ISaveable{
//	private String name;
//	private int hitPoints;
//	private int strength;
//	private String weapon;
//
//	public PlayerDetails(String name, int hitPoints, int strength){
//		this.name = name;
//		this.hitPoints = hitPoints;
//		this.strength = strength;
//		this.weapon = "Sword";
//	}
//
//	public String getName(){
//		return this.name;
//	}
//	public int getHitPoints(){
//		return this.hitPoints;
//	}
//	public int getStrength(){
//		return this.strength;
//	}
//	public String getWeapon(){
//		return this.weapon;
//	}
//	public void setName(String name){
//		this.name = name;
//	}
//	public void setHitPoints(int hitPoints){
//		this.hitPoints = hitPoints;
//	}
//	public void setStrength(int strength){
//		this.strength = strength;
//	}
//	public void setWeapon(String weapon){
//		this.weapon = weapon;
//	}
//
//	@Override
//	public String toString(){
//		return this.name + "\n" +
//				this.hitPoints+"\n"+
//				this.strength+"\n"+
//				this.weapon;
//	}
//
//
//	@Override
//	public ArrayList<String> write() {
//		ArrayList<String> values = new ArrayList<String>();
//		values.add(0, this.name+"");
//		values.add(1,  this.hitPoints+"");
//		values.add(2, this.strength+"");
//		values.add(3, this.weapon+"");
//		return values;
//	}
//
//	@Override
//	public void read(ArrayList<String> savedValues) {
//		if(savedValues!= null && savedValues.size() > 0){
//			this.name = savedValues.get(0);
//			this.hitPoints = Integer.parseInt(savedValues.get(1));
//			this.strength = Integer.parseInt(savedValues.get(2));
//			this.weapon = savedValues.get(3);
//		}
//	}
//}
//
//class Monster implements ISaveable{
//	private String name;
//	private int hitPoints;
//	private int strength;
//
//	public Monster(String name, int hitPoints, int strength) {
//		this.name = name;
//		this.hitPoints = hitPoints;
//		this.strength = strength;
//	}
//
//	public String getName() {
//		return name;
//	}
//
//	public int getHitPoints() {
//		return hitPoints;
//	}
//
//	public int getStrength() {
//		return strength;
//	}
//
//	@Override
//	public String toString() {
//		return "name='" + name + '\n' +
//				"hitPoints=" + hitPoints +'\n'+
//				"strength=" + strength ;
//	}
//
//	@Override
//	public ArrayList<String> write() {
//		ArrayList<String> values = new ArrayList<String>();
//		values.add(0, this.name);
//		values.add(1, this.hitPoints+"");
//		values.add(2, this.strength+"");
//		return null;
//	}
//
//	@Override
//	public void read(ArrayList<String> savedValues) {
//		this.name = savedValues.get(0);
//		this.hitPoints = Integer.parseInt(savedValues.get(1));
//		this.strength = Integer.parseInt(savedValues.get(2));
//	}
//}
