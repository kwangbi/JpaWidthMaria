package com.kwang.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.Getter;

@Getter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class BaseTimeEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@CreatedDate
	@Column(name = "regdtm")
	private LocalDateTime createDate;

	@LastModifiedDate
	@Column(name = "auditdtm")
	private LocalDateTime modifiedDate;

}
