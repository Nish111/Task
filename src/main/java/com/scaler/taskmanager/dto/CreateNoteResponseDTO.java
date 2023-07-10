package com.scaler.taskmanager.dto;

import com.scaler.taskmanager.entities.NoteEntity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CreateNoteResponseDTO {
    public CreateNoteResponseDTO(Integer taskId, NoteEntity note) {
		super();
		this.taskId = taskId;
		this.note = note;
	}
	public Integer getTaskId() {
		return taskId;
	}
	public void setTaskId(Integer taskId) {
		this.taskId = taskId;
	}
	public NoteEntity getNote() {
		return note;
	}
	public void setNote(NoteEntity note) {
		this.note = note;
	}
	private Integer taskId;
    private NoteEntity note;
}