package com.kwang.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "board")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BoardEntity extends BaseTimeEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "boardId")
	private Long id;

	@Column(name = "title", nullable = false, length = 200)
	private String title;

	@Column(name = "contents", nullable = false, length = 4000)
	private String contents;
	
	@Builder
	public BoardEntity(String title,String contents) {
		this.title = title;
		this.contents = contents;
	}
	
	public void update(String title,String contents) {
		this.title = title;
		this.contents = contents;
	}
	
}
