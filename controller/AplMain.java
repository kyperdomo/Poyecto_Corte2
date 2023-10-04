package co.edu.unbosque.controller;

import java.sql.Date;

import co.edu.unbosque.model.AlcoholicDTO;
import co.edu.unbosque.model.persistence.AlcoholicDAO;

public class AplMain {
	
	public static void main(String[] args) {
		AlcoholicDAO adao = new AlcoholicDAO();
		
		String[] data = {"Annie","2004-12-20","1019762671","Bogota","2","joan"};
		
		String name = "Annie";
		Date bir = new Date(2004, 12, 20);
		int ide = 1019762671;
		String city = "bogota";
		int ses =2;
		String nick = "Joan";
		
		
		adao.create(new AlcoholicDTO(name, ide, bir, city, ses, nick));
		
		System.out.println("Listo");
	}

}
