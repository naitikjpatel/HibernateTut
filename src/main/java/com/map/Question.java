package com.map;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Question {
	@Id
	@Column(name="question_id")
	private int questionId;
	private String question;
	
	/*
//	one question have only one solution
	@OneToOne
	@JoinColumn(name="A_ID")
	private Answer answer;
	*/
//	oneTomany
//	one question can have many Answer
//	je join column banshe te answers ni question vari thi banshe etle answer table ma te field banshe
	@OneToMany(mappedBy = "question" ,fetch=FetchType.EAGER,cascade = CascadeType.ALL) //jo mappedby na lakhiye to ek navu table create thatu hatu e rokva mate apre mappedby no use karyo
	private List<Answer> answers;
	public Question() {
		super();
		// TODO Auto-generated constructor stub
	}



	public List<Answer> getAnswers() {
		return answers;
	}



	public void setAnswers(List<Answer> list) {
		this.answers = list;
	}



	public Question(int questionId, String question, List<Answer> answers) {
		super();
		this.questionId = questionId;
		this.question = question;
		this.answers = answers;
	}



	public int getQuestionId() {
		return questionId;
	}

	public void setQuestionId(int questionId) {
		this.questionId = questionId;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}


	
	
}
