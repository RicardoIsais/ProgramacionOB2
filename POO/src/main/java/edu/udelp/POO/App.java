package edu.udelp.POO;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;
import java.util.Calendar;

import com.google.gson.reflect.TypeToken;

import edu.udelp.POO.util.Utileria;


public class App {
    public static void main(String[] args) {
    	
    	
    	
        Persona p = new Persona();
        p.setNombre("Ricardo Isais Hernandez");
        Persona p2 = new Persona();
        p2.setNombre("Slash");
        p2.setID("1232123");
        p2.setPeso(1.2);
        
        
        List<Persona> listP = new ArrayList<>();
        listP.add(p);
        listP.add(p2);
        
       
        Utileria.guardaArchivo(Persona.class.getName(), listP);
        System.out.print(Utileria.leerArchivo(Persona.class.getName()));

}
}
