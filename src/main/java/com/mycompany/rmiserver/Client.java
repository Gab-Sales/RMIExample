package com.mycompany.rmiserver;

import java.net.InetAddress;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Gabriel
 */
public class Client {
    public static void main(String[] args) {
        try {
            Registry registry = LocateRegistry.getRegistry(InetAddress.getLocalHost().getHostAddress(),1892);
            ClassificadosVeiculos stub = (ClassificadosVeiculos) registry.lookup("Server");
            Scanner sc= new Scanner(System.in);
            System.out.println("Informe a ação que deseja efetuar\n1 - Buscar Veiculo por ano\n2 - Adicionar Veiculo");
            int option = sc.nextInt();
            int terminar = 1;
            while(terminar == 1){
                if(option == 1){
                    System.out.println("Ano para pesquisa:");
                    int a = sc.nextInt();
                    System.err.println("");
                    List<Veiculo> msg = (List) stub.search2Ano(a);
                    for (int i=0; i < msg.size(); i++) { 
                        Veiculo v = msg.get(i);
                        System.out.println("vendedor: " + v.nomeCliente + "\nMarca: " + v.marcaVeiculo + "\nModelo: " + v.modelo + "\nAno: " + v.ano + "\nValor: " + v.valorVenda);
                    }
                } else {
                    System.err.println("");
                    System.err.println("Nome do Vendedor");
                    String Nome = sc.next();
                    System.err.println("Marca do Veiculo");
                    String marcaVeiculo = sc.next();
                    System.err.println("Modelo do Veiculo");
                    String modelo = sc.next();
                    System.err.println("Ano do Veiculo");
                    int ano = sc.nextInt();
                    System.err.println("Valor do Veiculo");
                    double valorVenda = sc.nextDouble();
                    stub.add(new Veiculo(Nome,marcaVeiculo,modelo,valorVenda,ano));
                }              
                System.out.println("\nDeseja Continuar usando a aplicação?\n1 - Sim\n2 - Não");             
                terminar = sc.nextInt();
                if(terminar == 1){
                  System.out.println("\nInforme a ação que deseja efetuar\n1 - Buscar Veiculo por ano\n2 - Adicionar Veiculo");
                    option = sc.nextInt();  
                }
            }
            
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
