/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

import catalog.Catalog;
import controller.Controller;
import java.util.ArrayList;
import java.util.Scanner;
import model.Admin;
import model.Meal;
import model.MealType;
import model.Sale;
import model.User;

/**
 *
 * @author Roberto Augusto
 */
public class Menu {
    private final Catalog ctg;
    private final Controller ctrl;
    private final Scanner sc;
    
    public Menu() {
        ctg = new Catalog();
        ctrl = new Controller(ctg);
        sc = new Scanner(System.in);
    }
    
    public void displayMenu() {
        //Admin e refeições adicionadas no Menu para fins de teste
        
        Admin admin01 = new Admin("Admin01", "meulogin", "minhasenha");
        ctrl.setAdmin(admin01);
        ctrl.addMeal("Bolo de Carne Moida", MealType.OMNIVOROUS, 2.5);
        ctrl.addMeal("Fricasse de Frango", MealType.OMNIVOROUS, 2.5);
        ctrl.addMeal("Carne de Panela", MealType.OMNIVOROUS, 2.5);
        ctrl.addMeal("File de Frango Grelhado", MealType.OMNIVOROUS, 2.5);
        ctrl.addMeal("Carne Assada", MealType.OMNIVOROUS, 2.5);
        ctrl.addMeal("Strogonoff de Carnes", MealType.OMNIVOROUS, 2.5);
        ctrl.addMeal("Ovos Mexidos com Ervilha", MealType.VEGETARIAN, 2.5);
        ctrl.addMeal("Lentilha de Forno", MealType.VEGETARIAN, 2.5);
        ctrl.addMeal("Grao de Bico ao Cheiro Verde", MealType.VEGETARIAN, 2.5);
        ctrl.addMeal("Ervilha ao Vinagrete", MealType.VEGETARIAN, 2.5);
        ctrl.addMeal("Hamburguer de Soja", MealType.VEGETARIAN, 2.5);
        ctrl.addMeal("Lasanha de Berinjela com Queijo", MealType.VEGETARIAN, 2.5);
        
        int op;
        do {
            System.out.println("\nMENU INICIAL:");
            System.out.println("1 - Cadastrar usuario");
            System.out.println("2 - Cadastrar admin"); //W.I.P
            System.out.println("3 - Logar como usuario");
            System.out.println("4 - Logar como admin"); //W.I.P
            System.out.println("0 - Sair");
            System.out.print("Digite o numero correspondente a opcao desejada: ");
            op = sc.nextInt();
            sc.nextLine();
            
            switch(op) {
                case 1:
                    addUser();
                    break;
                case 2:
                    addAdmin();
                    break;
                case 3:
                    userLogin();
                    break;
                case 4:
                    adminLogin();
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
                    if(ctrl.addPermanenceStudent(name, preference, login, password)) {
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
                System.out.println("\nMENU DE USUARIO:");
                System.out.println("1 - Adicionar credito");
                System.out.println("2 - Comprar refeicoes");
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
    
    public void buyMeal(User user) {
        if(ctrl.getCurrentSale() == null) {
            System.out.println("\nNao ha venda disponivel no momento.");
            return;
        }
        displayCurrentSale();
        System.out.println("Voce podera comprar ate 5 refeicoes entre as disponiveis.");
        int i = 0;
        boolean breakFlag = false;
        ArrayList<Integer> purchasedIndexes = new ArrayList<>();
        while(i < 5 && !breakFlag) {
            System.out.print("Digite o indice correspondente a " + (i + 1) + "a refeicao que deseja comprar: ");
            int index = sc.nextInt();
            sc.nextLine();
            if(index < 1 || index > ctrl.getCurrentSale().getMealList().size()) {
                System.out.println("\nIndice fora do intervalo. Escolha outro indice.");
                continue;
            }
            if(purchasedIndexes.contains(index)) {
                System.out.println("\nEssa refeicao ja foi comprada. Escolha outro indice.");
                continue;
            }
            if(!ctrl.buyMeal(user, index)) {
                System.out.println("\nCredito insuficiente para a transacao.");
                break;
            }
            purchasedIndexes.add(index);
            i++;
            System.out.println("\nRefeicao comprada com sucesso.");
            if(i < 5) {
                int op4;
                do {
                    System.out.println("\n1 - Continuar comprando");
                    System.out.println("2 - Encerrar compra");
                    System.out.print("Digite o numero correspondente a opcao desejada: ");
                    op4 = sc.nextInt();
                    sc.nextLine();
                    if(op4 == 1) {
                        break;
                    } else if (op4 == 2) {
                        breakFlag = true;
                    } else {
                        System.out.println("\nOpcao invalida. Tente novamente.");
                    }
                } while(!breakFlag);
            }
        }
        System.out.println("\nCompra encerrada.");
    }
  
    
    public void transferMeal(User user) {
        System.out.print("\nDigite o login da conta alvo da transferencia: ");
        String login = sc.nextLine();
        displayUserMealList(user);
        System.out.print("Digite o indice correspondente a refeicao a ser transferida: ");
        int index = sc.nextInt();
        sc.nextLine();
        switch(ctrl.transferMeal(user, login, index)) {
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
    
    public void displayUserMealList(User user) {
        System.out.println("\n" + ctrl.displayUserMealList(user));
    }
    
    public void userLogout(User user) {
        if(ctrl.userLogout(user)) {
            System.out.println("\nConta deslogada com sucesso.");
        } else {
            System.out.println("\nFalha ao deslogar.");
        }
    }
    
    public void addAdmin() { 
        System.out.print("\nDigite o nome do admin: ");
        String name = sc.nextLine();
        System.out.print("\nDigite o login: ");
        String login = sc.nextLine();
        System.out.print("\nDigite a senha: ");
        String password = sc.nextLine();
        Admin admin = new Admin(name, login, password);
        if(ctrl.setAdmin(admin)) {
            System.out.println("\nAdmin cadastrado com sucesso.");
        } else {
            System.out.println("\nJa existe um admin cadastrado no sistema.");
        }
    }
    
    public void adminLogin() {
        System.out.print("\nDigite o login: ");
        String login = sc.nextLine();
        System.out.print("\nDigite a senha: ");
        String password = sc.nextLine();
        Admin admin = ctrl.adminLogin(login, password);
        if(admin != null) {
            System.out.println("\nLogin efetuado com sucesso.");
            
            int op5;
            do {
                System.out.println("\nMENU DE ADMIN:");
                System.out.println("1 - Adicionar refeicao ao cardapio");
                System.out.println("2 - Remover refeicao do cardapio");
                System.out.println("3 - Iniciar venda");
                System.out.println("4 - Terminar venda");
                System.out.println("5 - Alterar o valor padrao de desconto");
                System.out.println("6 - Exibir informacoes do admin");
                System.out.println("7 - Exibir cardapio");
                System.out.println("0 - Deslogar");
                System.out.print("Digite o numero correspondente a opcao desejada: ");
                op5 = sc.nextInt();
                sc.nextLine();
                switch(op5) {
                    case 1:
                        addMealToMealList();
                        break;
                    case 2:
                        removeMealFromMealList();
                        break;
                    case 3:
                        startSale();
                        break;
                    case 4:
                        endSale();
                        break;
                    case 5:
                        setPermanenceDiscount();
                        break;
                    case 6:
                        displayAdmin();
                        break;
                    case 7:
                        displayMealList();
                        break;
                    case 0:
                        adminLogout();
                        break;
                    default:
                        System.out.println("\nOpcao invalida. Tente novamente.");
                        break;
                }                
                
            } while(op5 != 0);
            
        } else {
            System.out.println("\nLogin ou senha incorretos.");
        }
    }
    
    public void addMealToMealList() {
        System.out.print("\nDigite a descricao da refeicao: ");
        String description = sc.nextLine();
        System.out.print("\nDigite o preco da refeicao: ");
        double price = sc.nextDouble();
        sc.nextLine();
        
        MealType mealType = null;
        int op5;
        do {
            System.out.println("\n1 - Onivoro");
            System.out.println("2 - Vegetariano");
            System.out.println("3 - Vegano");
            System.out.print("Digite o numero correspondente ao tipo da refeicao: ");
            op5 = sc.nextInt();
            sc.nextLine();
            switch(op5) {
                case 1:
                   mealType = MealType.OMNIVOROUS;
                   break;
                case 2:
                   mealType = MealType.VEGETARIAN;
                   break;
                case 3:
                   mealType = MealType.VEGAN;
                   break;
                default:
                   System.out.println("\nOpcao invalida. Tente novamente.");
                   break;
            }
        } while(op5 != 1 && op5 != 2 && op5 != 3);

        if(ctrl.addMeal(description, mealType, price)) {
            System.out.println("\nRefeicao adiciona ao cardapio com sucesso.");
        } else {
            System.out.println("\nFalha ao adiconar refeicao ao cardapio.");
        }
    }
    
    public void removeMealFromMealList() {
        displayMealList();
        System.out.print("Digite o indice do cardapio correspondente a refeicao a ser removida: ");
        int index = sc.nextInt() - 1;
        sc.nextLine();
        if(ctrl.removeMealByIndex(index)) {
            System.out.println("\nRefeicao removida do cardapio com sucesso.");
        } else {
            System.out.println("\nIndice fora do intervalo.");
        }
    }
    
    public void startSale() {
        displayMealList();
        Sale sale = new Sale();

        int i;
        System.out.println("\nAdicione 5 refeicoes do tipo Onivoro:");
        for(i = 0; i < 5; i++) {
            System.out.print("Digite o indice do cardapio correspondente a " + (i + 1) + "a refeicao a ser adicionada: ");
            int index = sc.nextInt();
            sc.nextLine();

            if(index >= 1 && index <= ctrl.getMealList().size()) {
                sale.addMeal(ctrl.getMealList().get(index - 1));
            } else {
                System.out.println("Indice invalido. Tente novamente.");
                i--;
            }
        }

        System.out.println("\nAdicione 5 refeicoes do tipo Vegetariano/Vegano:");
        for(i = 0; i < 5; i++) {
            System.out.print("Digite o indice do cardapio correspondente a " + (i + 1) + "a refeicao a ser adicionada: ");
            int index = sc.nextInt();
            sc.nextLine();

            if(index >= 1 && index <= ctrl.getMealList().size()) {
                sale.addMeal(ctrl.getMealList().get(index - 1));
            } else {
                System.out.println("Indice invalido. Tente novamente.");
                i--;
            }
        }

        if(ctrl.isValidSale(sale)) {
            ctrl.setCurrentSale(sale);
            System.out.println("\nVenda iniciada com sucesso.");
        } else {
            System.out.println("\nVenda invalida.");
        }
    }
    
    public void endSale() {
        if(ctrl.getCurrentSale() != null) {
            ctrl.setCurrentSale(null);
            System.out.println("\nVenda terminada com sucesso.");
        } else {
            System.out.println("\nNao ha venda ocorrendo no momento.");
        }
    }
    
    public void setPermanenceDiscount() {
        System.out.print("Digite o novo valor padrao de desconto para alunos da permanencia: ");
        double permanenceDiscount = sc.nextDouble();
        sc.nextLine();
        if(ctrl.setPermanenceDiscount(permanenceDiscount)) {
            System.out.println("Valor de desconto alterado com sucesso.");
        } else {
            System.out.println("O valor de desconto deve ser maior que 0 e menor que 1.");
        }
    }
    
    public void adminLogout() {
        if(ctrl.adminLogout()) {
            System.out.println("\nAdmin deslogado com sucesso.");
        } else {
            System.out.println("\nFalha ao deslogar.");
        }
    }
    
    public void displayAdmin() {
        System.out.println("\nInformacoes do admin:\n");
        System.out.println(ctrl.displayAdmin());
    }
    
    public void displayCurrentSale() {
        System.out.println("\n" + ctrl.getCurrentSale().displayMealList());
    }
}
