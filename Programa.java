package listas;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Programa {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		List<Funcionario> list = new ArrayList<>();

		System.out.print("Quantos funcionarios serão registrados? ");
		int n = sc.nextInt();

		for (int i = 1; i <= n; i++) {
			System.out.println();
			System.out.println("Funcionario #" + i + ": ");

			System.out.print("Id: ");
			int id = sc.nextInt();
			while (temID(list, id)) {
				System.out.print("Este ID já está em uso. Tente outro: ");
				id = sc.nextInt();
			}

			System.out.print("Nome: ");
			sc.nextLine();
			String nome = sc.nextLine();
			System.out.print("Salário: ");
			double salario = sc.nextDouble();
			list.add(new Funcionario(nome, id, salario));
		}

		System.out.println();
		System.out.print("Digite o ID do funcionário que irá alterar o salário: ");
		int id = sc.nextInt();
		Funcionario func = list.stream().filter(x -> x.getId() == id).findFirst().orElse(null);
		if (func == null) {
			System.out.println("Esse ID não existe!");
		} else {
			System.out.print("Digite a porcentagem: ");
			double porcentagem = sc.nextDouble();
			func.alterarSalario(porcentagem);
		}

		System.out.println();
		System.out.println("Lista de Funcionários:");
		for (Funcionario obj : list) {
			System.out.println(obj);
		}

		sc.close();
	}

	public static boolean temID(List<Funcionario> list, int id) {
		Funcionario func = list.stream().filter(x -> x.getId() == id).findFirst().orElse(null);
		return func != null;
	}
}