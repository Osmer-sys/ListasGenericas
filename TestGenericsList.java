import java.util.Scanner;

public class TestGenericsList {
	class Nodo {
		int data;
		Nodo next;
	}

	public static Nodo root;
	public Scanner obj;

	public TestGenericsList() {
		root = null;
	}

	private void list(int pos, int x) {
		if (pos <= amount() + 1) {
			Nodo newNode = new Nodo();
			newNode.data = x;
			if (pos == 1) {
				root = newNode;
				newNode.next = null;
			} else {
				Nodo move = root;
				while (move.next != null) {
					move = move.next;
				}
				move.next = newNode;
				newNode.next = null;
			}
		}
	}

	private void firstList(int data_1) {
		System.out.println("\nSe inserta el número cero en la primera posición de la lista.\n");
		Nodo nFirst = new Nodo();
		nFirst.data = data_1;
		if (isListEmpty()) {
			root = nFirst;
			nFirst.next = null;
		} else {
			nFirst.next = root;
			root = nFirst;
		}
	}

	private void endList(int eData) {
		System.out.println("\nSe inserta el número 3 en la última posición de la lista.\n");
		Nodo eList = new Nodo();
		eList.data = eData;
		Nodo aux = root;
		while (aux.next != null) {
			aux = aux.next;
		}
		aux.next = eList;
		eList.next = null;

	}

	private void secondPosition(int spData) {
		if (isListEmpty()) {
			System.out.println("\nLa lista está vacía\n");
		} else {
			System.out.println("\nSe inserta el número 2 en segunda posición de la lista.\n");
			Nodo sPos = new Nodo();
			sPos.data = spData;
			if (amount() == 1) {
				root.next = sPos;
				sPos.next = null;
			} else {
				sPos.next = root.next;
				root.next = sPos;
			}
		}

	}

	private void beforeLast(int nblData) {
		System.out.println("\nSe inserta el número 100 en la ante última posición.\n");
		Nodo blData = new Nodo();
		blData.data = nblData;
		Nodo blAux = root;
		if (amount() == 1) {
			blData.next = root;
			root = blData;
		} else {
			for (int f = 1; f < amount() - 1; f++) {
				blAux = blAux.next;
			}
			blData.next = blAux.next;
			blAux.next = blData;
		}
	}

	public void deleteFirstNode() {
		int dFirst = root.data;
		System.out.println("\nSe eliminará el primer nodo de la lista. El número " + dFirst);
		root = root.next;
	}

	private void deleteSecond() {
		System.out.println("\nSe eliminará el segundo nodo de la lista.");
		root.next = root.next.next;
	}

	private void deleteLastOne() {
		System.out.println("\nSe eliminará el último nodo de la lista.");
		Nodo dloAux = root;
		for (int f = 1; f < amount() - 1; f++) {
			dloAux = dloAux.next;
		}
		dloAux.next = null;
	}

	private void deleteHigher() {
		System.out.println("\nSe eliminará el número mayor de la lista.");
		if (root != null) {
			Nodo reco = root;
			int may = root.data;
			while (reco != null) {
				if (reco.data > may) {
					may = reco.data;
				}
				reco = reco.next;
			}
			reco = root;
			Nodo atras = root;
			while (reco != null) {
				if (reco.data == may) {
					if (reco == root) {
						root = root.next;
						atras = root;
						reco = root;
					} else {
						atras.next = reco.next;
						reco = reco.next;
					}
				} else {
					atras = reco;
					reco = reco.next;
				}
			}
		}
	}

	private void print() {
		Nodo move = root;
		while (move != null) {
			System.out.print(move.data + "-");
			move = move.next;
		}
		System.out.println();
	}

	public static boolean isListEmpty() {
		return root == null;
	}

	public int amount() {
		int amountNode = 0;
		Nodo move = root;
		while (move != null) {
			move = move.next;
			amountNode++;
		}
		return amountNode;
	}

	public void begin() {
		System.out.println("\n===BIENVENIDO A LISTAS GENERICAS===\n");
		obj = new Scanner(System.in);
		if (isListEmpty() == true) {
			System.out.println("\nIngrese la cantidad de números\na tener en lista aleatoria: ");
			int nNumb = obj.nextInt();
			System.out.println("\nLa lista aleatoria es: \n");
			if (nNumb > 0) {
				int cont = 1;
				for (int f = 1; f <= nNumb; f++) {
					int poz = cont++;
					int n = (int) Math.floor(Math.random() * (10 - 1 + 1) + 1);
					list(poz, n);
				}
			} else {
				System.out.println("Por favor ingrese un número mayor a cero");
				begin();
			}
		}
	}

	public static void main(String[] args) {
		TestGenericsList lgs = new TestGenericsList();
		lgs.begin();
		lgs.print();
		lgs.firstList(1);
		lgs.print();
		lgs.endList(3);
		lgs.print();
		lgs.secondPosition(2);
		lgs.print();
		lgs.beforeLast(100);
		lgs.print();
		lgs.deleteFirstNode();
		lgs.print();
		lgs.deleteSecond();
		lgs.print();
		lgs.deleteLastOne();
		lgs.print();
		lgs.deleteHigher();
		lgs.print();
	}
}
