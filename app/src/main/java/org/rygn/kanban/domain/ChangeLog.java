package org.rygn.kanban.domain;

import java.time.LocalDateTime;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;
import lombok.ToString;

@Data
@Entity
public class ChangeLog {

	private @Id @GeneratedValue Long id;
	
	private LocalDateTime occured;
	
	@ManyToOne
	@JsonIgnoreProperties("changeLogs")
	@ToString.Exclude	
	private Task task;
	
	@ManyToOne
	private TaskStatus targetStatus;
	
	@ManyToOne
	private TaskStatus sourceStatus;
	
	public ChangeLog() {
	}
}
