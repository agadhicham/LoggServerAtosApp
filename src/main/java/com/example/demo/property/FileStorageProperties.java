package com.example.demo.property;

import org.springframework.boot.context.properties.ConfigurationProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@ConfigurationProperties(prefix="file")
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FileStorageProperties {
	
	private String uploadDir;

}
