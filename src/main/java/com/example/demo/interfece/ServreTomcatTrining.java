package com.example.demo.interfece;

import java.io.IOException;
import java.util.Date;

public interface ServreTomcatTrining {
	

	public String tomcatFiltrageToGetServer(String fieldId);
	public String tomcatFiltrageToGetEstimation(String fieldId) throws IOException;
	public String[] tomcatFiltrageToGetDate(String fieldId);
	public String tomcatFiltrageToGetOccurence(String fieldId,String motCle) throws IOException;
	

}
