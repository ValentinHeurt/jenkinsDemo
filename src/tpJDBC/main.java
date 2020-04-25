package tpJDBC;

import java.util.ArrayList;
import java.util.Scanner;

import tpJDBC.AccesDAO;

public class main {
	public static void main(String[] args) {
		AccesDAO dao = new AccesDAO();
		Scanner saisieUtilisateur = new Scanner(System.in);
		Acces truc = new Acces(65,"test3", "test3", "test5", "test2", 15);
	    dao.addAcces(truc);
		
		
		ArrayList<Acces> a = dao.getAllAcces();
		
		for (Acces acces : a) 
		{ 
		    System.out.println(acces);
		}
		
        
      /*  System.out.println("Veuillez saisir un id :");
        int id = saisieUtilisateur.nextInt(); 
        dao.deleteAcces(id);*/
        
        
        System.out.println("Id ");
        int idd = saisieUtilisateur.nextInt();
        System.out.println("puis new statut");
        String newStatut = saisieUtilisateur.next();
	}
	
	       


}