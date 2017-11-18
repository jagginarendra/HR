import java.util.HashMap;
import java.util.Scanner;

public class RansomNotes {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		int m = scanner.nextInt(), n = scanner.nextInt();
		String magazine[] = new String[m];
		HashMap<String, Integer> magazineMap = new HashMap<String, Integer>();
		for (int i = 0; i < m; i++) {
			magazine[i] = scanner.next();
			if (magazineMap.get(magazine[i]) == null) 
				magazineMap.put(magazine[i], 1);
			else
				magazineMap.put(magazine[i], magazineMap.get(magazine[i]) + 1);
		}
		int flag = 0;
		String temp;
		for (int i = 0; i < n; i++) {
			temp = scanner.next();
			if (magazineMap.get(temp) == null || magazineMap.get(temp) == 0) {
				System.out.println("No");
				flag = 1;
				break;
			} else 
				magazineMap.put(temp, magazineMap.get(temp) - 1);
		}

		if (flag == 0)
			System.out.println("Yes");

		scanner.close();
	}

}

