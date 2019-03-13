package util;

import java.util.Collections;
import java.util.List;

public class Helper {

	/*
	 * Metodo para realizar a regra de SE numero par = +1 | SE numero impar = -1
	 */
	public static int regraParImpar(Integer num) {
		return num % 2 == 0 ? ++num : --num;
	}

	/* Método para realizar a regra da troca de lugares dos numeros no array */
	public static List<Integer> trocaArray(List<Integer> array) {
		if (array.size() == 4) {
			Collections.swap(array, 0, 2);
			Collections.swap(array, 1, 3);
		} else if (array.size() == 3) {
			Collections.swap(array, 1, 2);
		} else if (array.size() == 2) {
			Collections.swap(array, 0, 1);
		}
		return array;
	}
}
