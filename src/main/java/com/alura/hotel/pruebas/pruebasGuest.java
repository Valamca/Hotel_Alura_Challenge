package com.alura.hotel.pruebas;

import java.sql.Connection;
import java.sql.Date;

import com.alura.hotel.CreateConnection.ConnectionFactory;
import com.alura.hotel.Dao.guestDAO;
import com.alura.hotel.Model.Guest;

public class pruebasGuest {

	public static void main(String[] args) {
		//"afgano-afgana", "alemán-alemana", "árabe-árabe", "argentino-argentina", "australiano-australiana", "belga-belga", "boliviano-boliviana", "brasileño-brasileña", "camboyano-camboyana", 
		//"canadiense-canadiense", "chileno-chilena", "chino-china", "colombiano-colombiana", "coreano-coreana", "costarricense-costarricense", "cubano-cubana", "danés-danesa", "ecuatoriano-ecuatoriana", 
		//"egipcio-egipcia", "salvadoreño-salvadoreña", "escocés-escocesa", "español-española", "estadounidense-estadounidense", "estonio-estonia", "etiope-etiope", "filipino-filipina", "finlandés-finlandesa", 
		//"francés-francesa", "galés-galesa", "griego-griega", "guatemalteco-guatemalteca", "haitiano-haitiana", "holandés-holandesa", "hondureño-hondureña", "indonés-indonesa", "inglés-inglesa", "iraquí-iraquí", 
		//"iraní-iraní", "irlandés-irlandesa", "israelí-israelí", "italiano-italiana", "japonés-japonesa", "jordano-jordana", "laosiano-laosiana", "letón-letona", "letonés-letonesa", "malayo-malaya", "marroquí-marroquí", 
		//"mexicano-mexicana", "nicaragüense-nicaragüense", "noruego-noruega", "neozelandés-neozelandesa", "panameño-panameña", "paraguayo-paraguaya", "peruano-peruana", "polaco-polaca", "portugués-portuguesa", 
		//"puertorriqueño-puertorriqueño", "dominicano-dominicana", "rumano-rumana", "ruso-rusa", 
		//"sueco-sueca", "suizo-suiza", "tailandés-tailandesa", "taiwanes-taiwanesa", "turco-turca", "ucraniano-ucraniana", "uruguayo-uruguaya", "venezolano-venezolana", "vietnamita-vietnamita
		String name = "Robert";
		String last_name = "Downey";
		Date birth_day = Date.valueOf("1999-05-02");
		String nationality = "francés-francesa" ;
		String phone_number = "9164835279";
		Long id_reservation = 8l; //No se puede generar un Cliente sí su clave foranea no tiene un valor creando antes que este
		
		ConnectionFactory cf = new ConnectionFactory();
		Connection con = cf.recoverConnection();
		
		guestDAO gD = new guestDAO(con);
		Guest guest = new Guest(name, last_name, birth_day, nationality, phone_number, id_reservation);
		System.out.println(gD.saveGuest(guest));
	}
}
