package model;
import java.io.*;


public class Cat {
	
	public int catId;
	private String Name;
	private String Breed;
    private int Age;
	private String Personality;
	private String Past;
	private String Fur;
	private String EnvironmentNeeded;
	private boolean Foster;
	private boolean Adopted;
    //imagine
	public static int countC;
	//public static int count;
    
	public Cat(String Name, String Breed, int Age, String Personality, String Past, String Fur, String EnvironmentNeeded, boolean Foster, boolean Adopted) {
		//super();
		String fileName="";
		try {																																								//private final static String findStatementString = "SELECT * FROM product where id_p = ?";
			fileName = "keepIDcat.txt";

			FileReader fileReader = 
		            new FileReader(fileName);
			BufferedReader bufferedReader =
	                new BufferedReader(fileReader);
			countC=bufferedReader.read();
			System.out.println("***"+countC+"***");
			bufferedReader.close();
			}
			catch(FileNotFoundException ex) {
				 System.out.println(
			                "Unable to open file '" + 
			                fileName + "'");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		int catId=countC++;
		this.catId = catId;
		this.Name=Name;
		this.Breed = Breed;
		this.Age = Age;
		this.Personality = Personality;
		this.Past = Past;
		this.Fur = Fur;
		this.EnvironmentNeeded = EnvironmentNeeded;
		this.Foster=Foster;
		this.Adopted=Adopted;
	}

	public boolean isFoster() {
		return Foster;
	}

	public void setFoster(boolean foster) {
		Foster = foster;
	}

	public boolean isAdopted() {
		return Adopted;
	}

	public void setAdopted(boolean adopted) {
		Adopted = adopted;
	}

	public int getCatId() {
		return catId;
	}

	//public void setCatId(int catId) {
	//	this.catId = catId;
	//}

	public String getName() {
		return Name;
	}


	public void setName(String name) {
		this.Name = name;
	}


	public String getBreed() {
		return Breed;
	}


	public void setBreed(String breed) {
		this.Breed = breed;
	}


	public int getAge() {
		return Age;
	}


	public void setAge(int age) {
		this.Age = age;
	}


	public String getPersonality() {
		return Personality;
	}


	public void setPersonality(String personality) {
		this.Personality = personality;
	}


	public String getPast() {
		return Past;
	}


	public void setPast(String past) {
		this.Past = past;
	}


	public String getFur() {
		return Fur;
	}


	public void setFur(String fur) {
		this.Fur = fur;
	}


	public String getEnvironmentNeeded() {
		return EnvironmentNeeded;
	}


	public void setEnvironmentNeeded(String environmentNeeded) {
		this.EnvironmentNeeded = environmentNeeded;
	}

	
	public static int getCountC() {
		return countC;
	}

	public static void setCountC(int count) {
		Cat.countC = countC;
	}

	@Override
	public String toString() {
		return "Cat [catId=" + catId + ", name=" + Name + ", breed=" + Breed + ", age=" + Age
				+ ", personality=" +Personality+", past=" +Past+", fur=" +Fur+", environmentNeeded=" +EnvironmentNeeded +", foster=" +Foster+", adopted="+Adopted+"]";
	}

	

}
