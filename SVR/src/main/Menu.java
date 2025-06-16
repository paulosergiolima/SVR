/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

import controller.Controller;
import java.util.Scanner;
import model.MealType;
import model.User;

/**
 *
 * @author Roberto Augusto
 */
public class Menu {
    private final Controller ctrl;
    private final Scanner sc;
    
    public Menu() {
        ctrl = new Controller();
        sc = new Scanner(System.in);
    }
    
    public void displayMenu() {
        int op;
        do {
            System.out.println("MENU INICIAL:");
            System.out.println("1 - Criar conta de usuario");
            System.out.println("2 - Criar conta de admin"); //W.I.P
            System.out.println("3 - Logar na conta de usuario");
            System.out.println("4 - Logar na conta de admin"); //W.I.P
            System.out.println("0 - Sair");
            System.out.print("Digite o numero correspondente a opcao desejada: ");
            op = sc.nextInt();
            sc.nextLine();
            
            switch(op) {
                case 1:
                    addUser();
                    break;
                case 2:
                    //W.I.P
                    break;
                case 3:
                    userLogin();
                    break;
                case 4:
                    //W.I.P
                case 0:
                    System.out.println("Processo encerrado.");
                    break;
                default:
                    System.out.println("Opcao invalida. Tente novamente.");
                    break;
            }
        } while(op != 0);
    }
    
    public void addUser() {
        System.out.print("Digite o nome de usuario: ");
        String name = sc.nextLine();
        
        MealType preference = null;
        int op1, op2;
        do {
            System.out.println("1 - Onivoro");
            System.out.println("2 - Vegetariano");
            System.out.println("3 - Vegano");
            System.out.print("Digite o numero correspondente a opcao desejada: ");
            op1 = sc.nextInt();
            sc.nextLine();
            switch(op1) {
                case 1:
                   preference = MealType.OMNIVOROUS;
                   break;
                case 2:
                   preference = MealType.VEGETARIAN;
                   break;
                case 3:
                   preference = MealType.VEGAN;
                   break;
                default:
                   System.out.println("Opcao invalida. Tente novamente.");
                   break;
            }
        } while(op1 != 1 && op1 != 2 && op1 != 3);
        
        System.out.print("Digite o login: ");
        String login = sc.nextLine();
        
        System.out.print("Digite a senha: ");
        String password = sc.nextLine();
        
        do {
            System.out.println("1 - Aluno Regular");
            System.out.println("2 - Aluno Preferência");
            System.out.println("3 - Professor");
            System.out.print("Digite o numero correspondente a opcao desejada: ");
            op2 = sc.nextInt();
            sc.nextLine();
            switch(op2) {
                case 1:
                    ctrl.addRegularStudent(name, preference, login, password);
                    System.out.println("Conta criada com sucesso.");
                    break;
                case 2:
                    ctrl.addPermanenceStudent(name, preference, 0.30, login, password);
                    System.out.println("Conta criada com sucesso.");
                    break;
                case 3:
                    ctrl.addTeacher(name, preference, login, password);
                    System.out.println("Conta criada com sucesso.");
                    break;
                default:
                    System.out.println("Opcao invalida. Tente novamente.");
                    break;
            }
        } while(op2 != 1 && op2 != 2 && op2 != 3);
    }
    
    public void userLogin() {
        System.out.print("Digite o login: ");
        String login = sc.nextLine();
        System.out.print("Digite a senha: ");
        String password = sc.nextLine();
        User user = ctrl.userLogin(login, password);
        
        int op3;
        do {
            System.out.println("MENU DE USUARIO");
            System.out.println("1 - Adicionar credito");
            System.out.println("2 - Comprar refeicao");
            System.out.println("3 - Transferir refeicao");
            System.out.println("0 - Voltar");
            System.out.print("Digite o numero correspondente a opcao desejada: ");
            op3 = sc.nextInt();
            sc.nextLine();
            switch(op3) {
                case 1:
                    addCredit(user);
                    break;
                case 2:
                    buyMeal(user);
                    break;
                case 3:
                    transferMeal(user);
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Opcao invalida. Tente novamente.");
                    break;
            }
        } while(op3 != 0);
    }
    
    public void addCredit(User user) {
        System.out.print("Digite o valor a ser adicionado: ");
        double credit = sc.nextDouble();
        sc.nextLine();
        ctrl.addCredit(user, credit);
    }
    
    //Precisa mudar o método de compra de refeição ao implementar a venda
    public void buyMeal(User user) {
        System.out.print("Digite a descricao da refeicao: ");
        String description = sc.nextLine();
        ctrl.buyMeal(user, description);
    }
    
    public void transferMeal(User user) {
        System.out.print("Digite o login da conta alvo da transferencia: ");
        String login = sc.nextLine();
        System.out.print("Digite a descricao da refeicao a ser transferida: ");
        String description = sc.nextLine();
        ctrl.transferMeal(user, login, description);
    }  
}
