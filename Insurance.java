	//package nan;
	
	public class Insurance {
	private String userId;
	private String fullName;
	private String firstName;
	private String lastName;
	private int userVersion;
	private String insuranceName;
	
	//ID
	public String getId() {
	return userId;
	}
	public void setId(String id) {
	this.userId = id;
	}
	
	//Name
	public String getFullName() {
	return fullName;
	}
	public void setFullName(String fullName) {
	this.fullName = fullName;
	}
	
	//Version
	public int getVersion() {
	return userVersion;
	}
	public void setVersion(int version) {
	this.userVersion = version;
	}
	
	//Insurance
	public String getInsurance() {
	return insuranceName;
	}
	public void setInsurance(String insurance) {
	this.insuranceName = insurance;
	}
	
	public void UpdateUserInformation(Insurance userToAdd) {
	this.setVersion(userToAdd.getVersion());
	}
	
	@Override
	public String toString(){
	return getId()+","+getFullName()+","+getVersion()+","+getInsurance();
	}
	public String getFirstName() {
	return firstName;
	}
	public void setFirstName(String firstName) {
	this.firstName = firstName;
	}
	public String getLastName() {
	return lastName;
	}
	public void setLastName(String lastName) {
	this.lastName = lastName;
	}
	}


