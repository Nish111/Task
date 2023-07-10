package com.scaler.taskmanager.controller;

import java.text.ParseException;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.scaler.taskmanager.dto.CreateTaskDTO;
import com.scaler.taskmanager.dto.ErrorResponseDTO;
import com.scaler.taskmanager.entities.TaskEntity;
import com.scaler.taskmanager.service.TaskService;


@RestController
@RequestMapping("/tasks")
public class TasksController {

	private final TaskService taskService;
	public TasksController(TaskService taskService) {
		this.taskService = taskService;
	}
	
	@GetMapping("")
	public ResponseEntity<List<TaskEntity>> getTasks(){
		var tasks = taskService.getTasks();
		return ResponseEntity.ok(tasks);
	}
	@GetMapping("/{id}")
	public ResponseEntity<TaskEntity> getTaskById(@PathVariable("id") Integer id){
		var task = taskService.getTaskById(id);
		if(task == null) return ResponseEntity.notFound().build();
		return ResponseEntity.ok(task);
	}
	@PostMapping("")
	public ResponseEntity<TaskEntity> addTask(@RequestBody CreateTaskDTO body) throws ParseException{
		taskService.addTask(body.getTitle(), body.getDescription(), body.getDeadline());
		return  ResponseEntity.ok().build();
	}
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorResponseDTO> handleParseErrors(Exception e){
		if(e instanceof ParseException) {
			return ResponseEntity.badRequest().body(new ErrorResponseDTO("Invalid date format"));
		}
		e.printStackTrace();
		return ResponseEntity.internalServerError().body(new ErrorResponseDTO("Internal Server Error"));
	}
	
}
