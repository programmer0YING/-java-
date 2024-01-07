package cn.edu.nuc.corejava;
// 封装表里的数据
public class Lawyer {
	int id;
	String lawyername;
	String gender;
	String nation;
	String school;
	
	@Override
	public String toString() {
		return "律师 [id=" + id + ", lawyername=" + lawyername + ", gender=" + gender + ", nation=" + nation
				+ ", school=" + school + "]";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getLawyername() {
		return lawyername;
	}
	public void setLawyername(String lawyername) {
		this.lawyername = lawyername;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getNation() {
		return nation;
	}
	public void setNation(String nation) {
		this.nation = nation;
	}
	public String getSchool() {
		return school;
	}
	public void setSchool(String school) {
		this.school = school;
	}
	
}
