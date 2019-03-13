package crypt;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import util.Helper;

public class Encriptar {

	/*
	 * Metodo para encriptar o id, transformando em uma string encriptada
	 * (conjunto de chave + id encriptado)
	 */
	public static String encriptar(String id) throws Exception {
		
		if (id == null || id.isEmpty() || id.length() > 4 ) {
			throw new Exception("Frase inválida");
		}
		
		List<String> idArray = Arrays.asList(id.split(""));
		Integer chave = gerarChave();

		List<Integer> arrayAscii = new ArrayList<>();
		for (String item : idArray) {
			Integer num = Helper.regraParImpar(Integer.parseInt(item));
			Character aux = Integer.toString(num).charAt(0);
			Integer ascii = (int) aux;
			arrayAscii.add(ascii);
		}
		;
		return Encriptar.criarFrase(Encriptar.encriptarArray(Helper.trocaArray(arrayAscii), chave), chave);
	}

	/* Metodo para gerar uma chave random entre 1000 e 9999 */
	private static Integer gerarChave() {
		return 1000 + (int) (Math.random() * (9999 - 1000));
	}

	/*
	 * Metodo para transformar a lista em um numero da tabela ASCII, a chave e
	 * utilizada para randomizar qual valor cada item ira valer a partir de
	 * agora.
	 */
	private static List<Integer> encriptarArray(List<Integer> array, Integer chave) {
		List<Integer> arrayCriptografado = new ArrayList<>();
		for (Integer item : array) {
			item += chave;
			while (item > 126 || item < 32) {
				if (item > 126) {
					item -= 126;
				} else {
					item += 94;
				}
			}
			arrayCriptografado.add(item);
		}
		;

		return arrayCriptografado;
	}

	/*
	 * Metodo para criar a frase encriptada, junta a lista de inteiros em uma
	 * string junto da chave gerada
	 */
	private static String criarFrase(List<Integer> array, Integer chave) {
		List<String> arrayAux = new ArrayList<>();
		for (Integer item : array) {
			String aux = Character.toString((char) item.intValue());
			arrayAux.add(aux);
		}
		String idEncriptado = String.join("", arrayAux);
		return Integer.toString(chave) + idEncriptado;
	}
}