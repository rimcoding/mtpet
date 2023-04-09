package messenger.dto;

public class AnimalDTO {
	
	private String id;
	private String animal_name;
	private String animal_type;
	private String animal_age;
	private String animal_information;
	private String date;
	
	public AnimalDTO(String animal_name, String animal_type, String animal_age, String animal_information) {
		this.animal_name = animal_name;
		this.animal_type = animal_type;
		this.animal_age = animal_age;
		this.animal_information = animal_information;
	}
	
	
	public AnimalDTO(String animal_name, String animal_type, String animal_age) {
		super();
		this.animal_name = animal_name;
		this.animal_type = animal_type;
		this.animal_age = animal_age;
	}


	public AnimalDTO() {
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getAnimal_name() {
		return animal_name;
	}
	public void setAnimal_name(String animal_name) {
		this.animal_name = animal_name;
	}
	public String getAnimal_type() {
		return animal_type;
	}
	public void setAnimal_type(String animal_type) {
		this.animal_type = animal_type;
	}
	public String getAnimal_age() {
		return animal_age;
	}
	public void setAnimal_age(String animal_age) {
		this.animal_age = animal_age;
	}
	public String getAnimal_information() {
		return animal_information;
	}
	public void setAnimal_information(String animal_information) {
		this.animal_information = animal_information;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	
	
	
}
