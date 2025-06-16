/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

import controller.Controller;
import java.util.ArrayList;
import java.util.Scanner;
import model.Admin;
import model.Meal;
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
        //Admin e refeições adicionadas no Menu temporariamente até a implementação do login do admin
        Admin admin = new Admin("Admin01");
        System.out.println("Admin:\n" + admin.toString() + "\n");
        System.out.print("==================================");
        
        ctrl.addMeal("Bolo de Carne Moida", MealType.OMNIVOROUS, 2.5);
        ctrl.addMeal("Fricasse de Frango", MealType.OMNIVOROUS, 2.5);
        ctrl.addMeal("Carne de Panela", MealType.OMNIVOROUS, 2.5);
        ctrl.addMeal("File de Frango Grelhado", MealType.OMNIVOROUS, 2.5);
        ctrl.addMeal("Carne Assada", MealType.OMNIVOROUS, 2.5);
        ctrl.addMeal("Ovos Mexidos com Ervilha", MealType.VEGETARIAN, 2.5);
        ctrl.addMeal("Strogonoff de Carnes", MealType.OMNIVOROUS, 2.5);
        
        int op;
        do {
            System.out.println("\nMENU INICIAL:");
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
                    break;
                case 0:
                    System.out.println("\nProcesso encerrado.");
                    break;
                default:
                    System.out.println("\nOpcao invalida. Tente novamente.");
                    break;
            }
        } while(op != 0);
    }
    
    public void addUser() {
        System.out.print("\nDigite o nome de usuario: ");
        String name = sc.nextLine();
        
        System.out.print("\nDigite o login: ");
        String login = sc.nextLine();
        
        System.out.print("\nDigite a senha: ");
        String password = sc.nextLine();
        
        MealType preference = null;
        int op1, op2;
        do {
            System.out.println("\n1 - Onivoro");
            System.out.println("2 - Vegetariano");
            System.out.println("3 - Vegano");
            System.out.print("Digite o numero correspondente a sua preferencia alimentar: ");
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
                   System.out.println("\nOpcao invalida. Tente novamente.");
                   break;
            }
        } while(op1 != 1 && op1 != 2 && op1 != 3);
        
        do {
            System.out.println("\n1 - Aluno Regular");
            System.out.println("2 - Aluno Preferencia");
            System.out.println("3 - Professor");
            System.out.print("Digite o numero correspondente ao seu tipo de usuario: ");
            op2 = sc.nextInt();
            sc.nextLine();
            switch(op2) {
                case 1:
                    if(ctrl.addRegularStudent(name, preference, login, password)) {
                        System.out.println("\nConta criada com sucesso.");
                    } else {
                        System.out.println("\nJa existe um usuario com o login inserido.");
                    }
                    break;
                case 2:
                    if(ctrl.addPermanenceStudent(name, preference, 0.30, login, password)) {
                        System.out.println("\nConta criada com sucesso.");
                    } else {
                        System.out.println("\nJa existe um usuario com o login inserido.");
                    }
                    break;
                case 3:
                    if(ctrl.addTeacher(name, preference, login, password)) {
                        System.out.println("\nConta criada com sucesso.");
                    } else {
                        System.out.println("\nJa existe um usuario com o login inserido.");
                    }
                    break;
                default:
                    System.out.println("\nOpcao invalida. Tente novamente.");
                    break;
            }
        } while(op2 != 1 && op2 != 2 && op2 != 3);
    }
    
    //Importante melhorar a validação do login
    public void userLogin() {
        System.out.print("\nDigite o login: ");
        String login = sc.nextLine();
        System.out.print("\nDigite a senha: ");
        String password = sc.nextLine();
        User user = ctrl.userLogin(login, password);
        if(user != null) {
            System.out.println("\nLogin efetuado com sucesso.");
            
            int op3;
            do {
                System.out.println("\nMENU DE USUARIO");
                System.out.println("1 - Adicionar credito");
                System.out.println("2 - Comprar refeicao");
                System.out.println("3 - Transferir refeicao");
                System.out.println("4 - Exibir informacoes do usuario");
                System.out.println("5 - Exibir lista de refeicoes disponiveis para compra");
                System.out.println("0 - Deslogar");
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
                    case 4:
                        displayUser(user);
                        break;
                    case 5:
                        displayMealList();
                        break;
                    case 0:
                        userLogout(user);
                        break;
                    default:
                        System.out.println("\nOpcao invalida. Tente novamente.");
                        break;
                }
            } while(op3 != 0);
            
        } else {
            System.out.println("\nLogin ou senha incorretos.");
        }
    }
    
    public void addCredit(User user) {
        System.out.print("\nDigite o valor a ser adicionado: ");
        double credit = sc.nextDouble();
        sc.nextLine();
        if(ctrl.addCredit(user, credit)) {
            System.out.println("\nCredito adicionado com sucesso.");
        } else {
            System.out.println("\nImpossivel adicionar credito negativo.");
        }
    }
    
    //Precisa mudar o método de compra de refeição ao implementar a venda
    public void buyMeal(User user) {
        System.out.print("\nDigite a descricao da refeicao: ");
        String description = sc.nextLine();
        if(ctrl.buyMeal(user, description)) {
            System.out.println("\nRefeicao comprada com sucesso.");
        } else {
            System.out.println("\nCredito insuficiente para a transacao.");
        }
    }
    
    public void transferMeal(User user) {
        System.out.print("\nDigite o login da conta alvo da transferencia: ");
        String login = sc.nextLine();
        System.out.print("\nDigite a descricao da refeicao a ser transferida: ");
        String description = sc.nextLine();
        switch(ctrl.transferMeal(user, login, description)) {
            case 1:
                System.out.println("\nRefeicao transferida com sucesso.");
                break;
            case -1:
                System.out.println("\nA refeicao nao existe na lista de refeicoes do usuario.");
                break;
            case -2:
                System.out.println("\nImpossivel transferir a refeicao para si mesmo.");
                break;
            case -3:
                System.out.println("\nConta com o login inserido nao encontrada.");
                break;
        }
    }
    
    public void displayUser(User user) {
        System.out.println("\nInformacoes do usuario:\n");
        System.out.println(ctrl.displayUser(user));
    }
    
    public void displayMealList() {
        System.out.println("\n" + ctrl.displayMealList());
    }
    
    public void userLogout(User user) {
        if(ctrl.userLogout(user)) {
            System.out.println("\nConta deslogada com sucesso.");
        } else {
            System.out.println("\nFalha ao deslogar.");
        }
    }
}
