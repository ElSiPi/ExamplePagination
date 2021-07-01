package com.example.pagination.models;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Table
@Entity(name = "CourseTable")
@Getter @Setter @NoArgsConstructor @ToString
public class Course {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Setter(value = AccessLevel.NONE)
	@Column(name = "Cid")	
	private long cid;
	
	@NotNull // visiem referenču mainīgajiem, bet ne primitīvajiem tipiem
	@NotEmpty(message = "Lauks nedrīkst būt tukšs!") // uz String - nevar būt tukšs
	@Size(min = 3, max = 50, message = "Simbolu skaitam jābūt no 4 līdz 60") // simbolu min un max skaits stringā
	@Column(name = "title")
	private String title;
	
	@Min(value=1)
	@Max(value=20)
	@Column(name="creditPoints")
	private int creditPoints;
	
	private String professor;

	public Course(String title, int creditPoints, String professor) {
		this.title = title;
		this.creditPoints = creditPoints;
		this.professor = professor;
	}
}
