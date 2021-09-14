/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unicundi.model;

import co.edu.unicundi.dto.PersonDto;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author tatia
 */
public class PersonList {
    
    public static final String DATA_FILE = "data.txt";
    
    private List<PersonDto> personList;
   
    
    public PersonList() {
        
        personList = new ArrayList<>();
    }
    
    public boolean savePerson(PersonDto personDto) {
       
        try {
            
            File inFile = new File(DATA_FILE);
            
            BufferedReader br = new BufferedReader(new InputStreamReader(
                    new FileInputStream(inFile)));
            
            String data = personDto.toString();
            
            FileUtil util = new FileUtil();           
            util.writeToFile(DATA_FILE, data, true, true);
            
            br.close();
             
            return true;
            
          } catch (Exception exc) {

            System.out.println(" An error has occurred "
                    + exc.getMessage());
            
            return false;
        }
        
    }
      
}
