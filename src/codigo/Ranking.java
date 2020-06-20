package codigo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.*;

public class Ranking {

	private static Ranking mRanking = null;
	private HashMap<Integer, String> hash;
	private ArrayList<Integer> arrayList;
	private int[] a;
	
	
	private Ranking() {
		hash = new HashMap<>();
		arrayList = new ArrayList<>();
		leerFichero();
	}

	public static Ranking getRanking() {
		if(mRanking == null) {
			mRanking = new Ranking();
		}return mRanking;
	}
	
	private void leerFichero() {
		
		try {
			FileReader f = new FileReader("puntuaciones.txt");
			BufferedReader entrada = new BufferedReader(f);
			String line = null;
			while((line = entrada.readLine()) != null) {
				String[] split = line.split(" --> ");
				int i = Integer.parseInt(split[1]);
				hash.put(i, split[0]);
				arrayList.add(i);
			}
			a = new int[arrayList.size()];
			for (int i = 0; i < a.length; i++) {
				a[i] = arrayList.get(i);
			}
			if(!arrayList.isEmpty()) {
				quickSort(a, 0, arrayList.size()-1);
			}
			arrayList = new ArrayList<>();
			for (int i = 1; i <= a.length; i++) {
				arrayList.add(a[a.length - i]);
			}
			entrada.close();
			f.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	private void quickSort(int[] array, int left, int right) {
		 
		int i = left;
		int j = right;
		// find pivot number, we will take it as mid
		int pivot = array[left+(right-left)/2];
 
		while (i <= j) {
			/**
			 * In each iteration, we will increment left until we find element greater than pivot
			 * We will decrement right until we find element less than pivot
			 */
			while (array[i] < pivot) { i++; } while (array[j] > pivot) {
				j--;
			}
			if (i <= j) {
				exchange(array, i, j);
				//move index to next position on both sides
				i++;
				j--;
			}
		}
		// call quickSort() method recursively
		if (left < j)
			quickSort(array, left, j);
		if (i < right)
			quickSort(array, i, right);
		
	}
 
	private void exchange(int[] array, int i, int j) {
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}
	
	public ArrayList<Integer> getArray(){
		return arrayList;
	}
	
	private void guardarEnArray(String s, int n) {
		hash.put(n, s);
		if (arrayList.get(arrayList.size()-1) >= n) {
			arrayList.add(n);
		} else if (arrayList.get(0) <= n) {
			arrayList.add(0, n);
		}else {
			int i = 1;
			boolean puesto = false;
			while (i <= arrayList.size() && !puesto) {
				if (arrayList.get(i - 1) > n && arrayList.get(i) < n) {
					arrayList.add(i, n);
					puesto = true;
				} else if (arrayList.get(i - 1) == n) {
					arrayList.add(i, n);
					puesto = true;
				} else {
					i++;

				}
			}
		}
		
		
	}
	
	public void guardarEnFichero(String s, int n) {
		guardarEnArray(s, n);
		try {
			BufferedWriter wr = new BufferedWriter(new FileWriter("puntuaciones.txt"));
			for (int i = 0; i < arrayList.size(); i++) {
				wr.write(hash.get(arrayList.get(i)) + " --> " + arrayList.get(i) +"\n");
			}
			wr.close();
		} catch(Exception e){
			
		}
	}
}
