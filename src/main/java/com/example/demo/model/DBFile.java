package com.example.demo.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.validator.constraints.Length;

import com.example.demo.entities.ServerCategorie;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data

public class DBFile {
	@Id
	@GeneratedValue(generator="uuid")
   @GenericGenerator(name="uuid",strategy="uuid2")
	private String id;
	private String fileName;
	private String fileType;
	@Lob
	private byte [] data;
	@Temporal(TemporalType.TIMESTAMP)
    private Date currrent = new Date(); 
	@ManyToOne(cascade=CascadeType.ALL)
	private ServerCategorie serverCategorie;
    public DBFile(String fileName, String fileType, byte[] data) {
        this.fileName = fileName;
        this.fileType = fileType;
        this.data = data;
    }

}
