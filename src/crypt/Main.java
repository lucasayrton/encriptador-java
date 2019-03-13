package crypt;

public class Main {

	public static void main(String[] args) {
		
		try {
			String id = "154";

			String fraseEncriptada = Encriptar.encriptar(id);
			System.out.println("Frase Encriptada: " + fraseEncriptada);

			Integer idFinal = Desencriptar.desencriptar(fraseEncriptada);
			System.out.println("Id: " + idFinal);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
