package com.example.demo.interfece;

import java.util.Collection;

import com.example.demo.model.DBfileExtractionDataToSave;

public interface KeySearsh {
	
	public Collection<DBfileExtractionDataToSave> searshByKey (String searshKey,String fileId);

}
