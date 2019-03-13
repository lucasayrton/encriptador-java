package crypt;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import util.Helper;

public class Desencriptar {
	public static Integer desencriptar(String fraseEncriptada) throws Exception {
		
		if (fraseEncriptada == null || fraseEncriptada.isEmpty() || fraseEncriptada.length() > 8 || fraseEncriptada.length() < 5 ) {
			throw new Exception("Frase inválida");
		}
		
		Integer chave = Integer.parseInt(fraseEncriptada.substring(0, 4));
		List<String> idArray = Arrays.asList(fraseEncriptada.substring(4, fraseEncriptada.length()).split(""));

		List<Integer> arrayAscii = new ArrayList<>();
		for (String item : idArray) {
			Character aux = item.charAt(0);
			Integer numAscii = (int) aux;
			arrayAscii.add(numAscii);
		}

		List<String> idArrayFinal = new ArrayList<>();
		for (Integer item : Helper.trocaArray(Desencriptar.desencriptarArray(arrayAscii, chave))) {
			idArrayFinal.add(Integer.toString(Helper.regraParImpar(item)));
		}

		return Integer.parseInt(String.join("", idArrayFinal));
	}

	private static List<Integer> desencriptarArray(List<Integer> array, Integer chave) {
		List<Integer> arrayDescriptografado = new ArrayList<>();
		for (Integer item : array) {
			item -= chave;
			while (item > 126 || item < 32) {
				if (item > 126) {
					item -= 94;
				} else {
					item += 126;
				}
			}
			arrayDescriptografado.add(Integer.parseInt(Character.toString((char) item.intValue())));
		}
		;
		return arrayDescriptografado;
	}
}
