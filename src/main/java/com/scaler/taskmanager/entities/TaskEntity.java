package com.scaler.taskmanager.entities;

import java.util.Date;
import java.util.List;

import lombok.Data;

@Data
public class TaskEntity {
	private int id;
	private String title;
	private String description;
	private Date deadline;
	private boolean completed;
	private List<NoteEntity> notes;
	
	public List<NoteEntity> getNotes() {
		return notes;
	}
	public void setNotes(List<NoteEntity> notes) {
		this.notes = notes;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Date getDeadline() {
		return deadline;
	}
	public void setDeadline(Date deadline) {
		this.deadline = deadline;
	}
	public boolean isCompleted() {
		return completed;
	}
	public void setCompleted(boolean completed) {
		this.completed = completed;
	}
}
