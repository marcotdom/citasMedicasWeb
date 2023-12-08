package com.citasmedicas.util;

import java.util.Date;
import java.text.SimpleDateFormat;
import java.text.ParseException;

public class FechaUtileria {
	
	public static String formatearFecha(String fechaEntrada) {
		String textDate = "03/18/01";
        Date actualDate = null;
  
        SimpleDateFormat yy = new SimpleDateFormat( "dd-MM-yyyy" );
        SimpleDateFormat yyyy = new SimpleDateFormat( "yyyy-MM-dd" );
  
        try {
            actualDate = yy.parse( fechaEntrada );
        }
        catch ( ParseException pe ) {
            System.out.println( pe.toString() );
        }
        return yyyy.format(actualDate);
	}

}
