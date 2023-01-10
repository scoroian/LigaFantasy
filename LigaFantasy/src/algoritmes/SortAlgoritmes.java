package algoritmes;

import bean.Team;

public class SortAlgoritmes {

	public static Team[] shellSort(Team[] param) {
		Team[] data = param;
		int pasada = 1;
		for (int k = data.length / 2; k >= 1; k = data.length / (2 * pasada)) {
			for (int j = 0; j + k < data.length; j++) {
				Team aux = null;
				int i = j;
				if (data[i].greaterThan(data[i + k])) {
					aux = data[i];
					data[i] = data[i + k];
					data[i + k] = aux;
					backTracking(k, i, data);
				}
			}
			pasada++;
		}
		return data;
	}

	private static void backTracking(int gap, int i, Team[] data) {
		Team aux = null;
		while (i - gap >= 0 && data[i - gap].greaterThan(data[i])) {
			aux = data[i];
			data[i] = data[i - gap];
			data[i - gap] = aux;
			i -= gap;
		}
	}

}
