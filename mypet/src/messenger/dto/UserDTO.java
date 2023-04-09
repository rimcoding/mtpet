package messenger.dto;

public class UserDTO {
	private String id;
	private String password;
	private String username;
	private String animalname;
	private String brithday;
	private String email;
	private String phone;
	
	@Override
	public String toString() {
		return "UserDTO [id=" + id + ", password=" + password + ", username=" + username + ", animalname=" + animalname
				+ ", brithday=" + brithday + ", email=" + email + ", phone=" + phone + "]";
	}
	
	public UserDTO() {
	}
	
	public UserDTO(String id) {
		this.id = id;
	}

	public UserDTO(String id,String password) {
		this.id = id;
		this.password = password;
	}

	public UserDTO(String id, String password, String username, String animalname, String brithday, String email,
			String phone) {
		this.id = id;
		this.password = password;
		this.username = username;
		this.animalname = animalname;
		this.brithday = brithday;
		this.email = email;
		this.phone = phone;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAnimalname() {
		return animalname;
	}

	public void setAnimalname(String animalname) {
		this.animalname = animalname;
	}

	public String getBrithday() {
		return brithday;
	}

	public void setBrithday(String brithday) {
		this.brithday = brithday;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	
}
