package src;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class ProcesadorNombres {

	private String inputPath;
	private String outputPath;
	private Map<String, Integer> map = new HashMap<String, Integer>();

	public ProcesadorNombres(String path) {
		this.inputPath = path + ".in";
		this.outputPath = path + ".out";
	}

	public void procesar() {
		int cantNombres = 0, cantApariciones = 0;
		try {
			Scanner sc = new Scanner(new File(inputPath));
			Integer valor = 0;
			cantNombres = sc.nextInt();
			cantApariciones = sc.nextInt();
			sc.nextLine();
			for (int i = 0; i < cantNombres; i++) {
				String nombre = sc.nextLine();
				if (map.containsKey(nombre)) {
					valor = map.get(nombre);
					map.remove(nombre);
					map.put(nombre, valor + 1);
				} else
					map.put(nombre, 1);
			}
			sc.close();
			obtenerGanadores(cantApariciones);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

	}

	private void obtenerGanadores(int cA) {
		List<Nombre> array = new ArrayList<Nombre>();
		Nombre nm;
		for (String s : map.keySet()) {
			if (map.get(s) >= cA) {
				nm = new Nombre(s, map.get(s));
				array.add(nm);
			}
		}
		Collections.sort((List<Nombre>) array);
		try {
			PrintWriter pw = new PrintWriter(new File(outputPath));
			for (Nombre n : array) {
				pw.println(n.getNombre() + " " + n.getApariciones());
			}
			pw.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

	}

}
