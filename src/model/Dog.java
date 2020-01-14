package model;
import java.io.*;


public class Dog {
	
	public int dogId;
	private String Name;
	private String Breed;
    private int Age;
	private String Personality;
	private String Past;
	private String Size;
	private String EnvironmentNeeded;
	private boolean Foster;
	private boolean Adopted;
	public static int countD;
    
	public Dog(String Name, String Breed, int Age, String Personality, String Past, String Size, String EnvironmentNeeded, boolean Foster, boolean Adopted) {
		//super();
		String fileName="";
		try {																							
			fileName = "keepIDdog.txt";

			FileReader fileReader = 
		            new FileReader(fileName);
			BufferedReader bufferedReader =
	                new BufferedReader(fileReader);
			countD=bufferedReader.read();
			System.out.println("***"+countD+"***");
			bufferedReader.close();
			}
			catch(FileNotFoundException ex) {
				 System.out.println(
			                "Unable to open file '" + 
			                fileName + "'");
			} catch (IOException e) {
				
				e.printStackTrace();
			}
		int dogId=countD++;
		this.dogId = dogId;
		this.Name=Name;
		this.Breed = Breed;
		this.Age = Age;
		this.Personality = Personality;
		this.Past = Past;
		this.Size = Size;
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
	
	public String getName() {
		return Name;
	}


	public void setName(String name) {
		this.Name = name;
	}


	public int getDogId() {
		return dogId;
	}

	public void setDogId(int dogId) {
		this.dogId = dogId;
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


	public String getSize() {
		return Size;
	}


	public void setSize(String Size) {
		this.Size = Size;
	}


	public String getEnvironmentNeeded() {
		return EnvironmentNeeded;
	}


	public void setEnvironmentNeeded(String environmentNeeded) {
		EnvironmentNeeded = environmentNeeded;
	}

	
	public static int getCountC() {
		return countD;
	}

	public static void setCountC(int count) {
		Dog.countD = countD;
	}

	@Override
	public String toString() {
		return "dog [dogId=" + dogId + ", name=" + Name + ", breed=" + Breed + ", age=" + Age
				+ ", personality=" +Personality+", past=" +Past+", size=" +Size+", environmentNeeded=" +EnvironmentNeeded +"]";
	}

	

}
