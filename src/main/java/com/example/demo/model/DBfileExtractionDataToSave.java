package com.example.demo.model;

import javax.persistence.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class DBfileExtractionDataToSave {

	private String keyToSearshKey;
	private String searshDateKey;
	private String searshServerKey;
	private String dbFileName;
	private Long searshOccurenceKey;
	
}
