package com.example.demo.property;

import org.springframework.boot.context.properties.ConfigurationProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//le role de cette aanotation est de lier automatiquement  les propriétés définis dans le application.propreties fichier avec des classes pojo de java
//faire leur travail au démarrage de l'application 
@ConfigurationProperties(prefix = "file")
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
//class pour lier tous les propriétes de stockage de l'application
public class FileStorageProperties {

	private String uploadDir;

}
