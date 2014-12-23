package model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="COLLEGE")
public class College implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name="college_id",unique=true,nullable=false,length=20)
	private int collegeId;
	@Column(name="name",nullable=false,length=20)
	private String collegeName;
	@ElementCollection
	@CollectionTable(name="student",joinColumns=@JoinColumn(name="college_id"))
	@Column(name="student_name")
	private Set<String> students;
	
	public College() {
		super();
	}
	
	public College(int collegeId, String collegeName) {
		super();
		this.collegeId = collegeId;
		this.collegeName = collegeName;
	}
	
	public int getCollegeId() {
		return collegeId;
	}
	public void setCollegeId(int collegeId) {
		this.collegeId = collegeId;
	}
	public String getCollegeName() {
		return collegeName;
	}
	public void setCollegeName(String collegeName) {
		this.collegeName = collegeName;
	}
	public Set<String> getStudents() {
		return students;
	}
	public void setStudents(Set<String> students) {
		this.students = students;
	}
	
	

	
}
