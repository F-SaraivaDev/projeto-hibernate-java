package com.abctreinamentos;

import java.util.List;
import java.util.Scanner;

public class CursoApp {

public static void main(String[] args) {
		
		try {
			CursoDAO dao = new CursoDAO();
						
			int opcao = 0; 	long cdcurso, valor;
			String nome, url;
			Scanner entrada = new Scanner(System.in);
						
			while(opcao != 6){
				
				System.out.println("\nSistema de Gerenciamento de Cursos");
				System.out.println("====================================");
				System.out.println("Digite [1] para Consultar Todos os Cursos");
				System.out.println("Digite [2] para Consultar um Curso Específico");
				System.out.println("Digite [3] para Cadastrar um Novo Curso");
				System.out.println("Digite [4] para Alterar um Curso");
				System.out.println("Digite [5] para Excluir um Curso");
				System.out.println("Digite [6] para Sair");
				System.out.println("====================================");
				opcao = entrada.nextInt();
				
				switch(opcao)
				{
					case 1: //Consultar Todos
					{
						System.out.println("[1] Consultar Todos");
						List<Curso> cursos = dao.findAll();
						cursos.forEach(System.out::println);
						break;
					}
					case 2: //Consultar
					{
						System.out.println("[2] Consultar um Curso Específico");
						System.out.println("Favor informar o CDCURSO: ");
						cdcurso =  entrada.nextLong();
					    System.out.println(dao.find(cdcurso));
						break;						
					}
					case 3: //Cadastrar 
					{
						System.out.println("[3] Cadastrar um Novo Curso");
						System.out.println("Favor informar o CDCURSO: ");
						cdcurso = entrada.nextLong();
						entrada.nextLine(); //esvaziar o buffer do teclado
						System.out.println("Favor informar o Nome: ");
						nome = entrada.nextLine();
						System.out.println("Favor informar o Valor R$ : ");
						valor = entrada.nextLong();
						entrada.nextLine();
						System.out.println("Favor informar a URL: ");
						url = entrada.nextLine();	
						Curso curso = new Curso(cdcurso,nome, valor, url);
						dao.persist(curso);
						break;					
					}
					case 4: //Alterar
					{
						System.out.println("Favor informar o CDCURSO: ");
						cdcurso = entrada.nextLong();
						entrada.nextLine(); //esvaziar o buffer do teclado
						System.out.println("Favor informar o Nome: ");
						nome = entrada.nextLine();
						System.out.println("Favor informar o Valor R$ : ");
						valor = entrada.nextLong();
						entrada.nextLine();
						System.out.println("Favor informar a URL: ");
						url = entrada.nextLine();	
						Curso curso = new Curso(cdcurso,nome, valor, url);
					    dao.merge(curso);
						break;
					}
					case 5: //Excluir
					{
						System.out.println("[5] Excluir um Curso");
						System.out.println("Favor informar o CDCURSO: ");
						cdcurso = entrada.nextLong();
						dao.delete(dao.find(cdcurso));
						break;						
					}
					case 6: //Sair
					{
						System.out.println("Encerrando o Sistema...");
						break;
					}
				}	
			}
			entrada.close();
			
		}catch(Exception e) {
			
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		
	}
}
