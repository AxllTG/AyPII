package Search;

public class BinarySearch {
	public static boolean BinarySearch(int[] arr, int objetivo) {
		int izq = 0;
		int der = arr.length;

		while (izq <= der) {

			int medio = (izq + der) / 2;

			if (arr[medio] == objetivo) {
				return true;
			} else {
				izq = medio + 1;

			}

		}

		return false;
	}

}
