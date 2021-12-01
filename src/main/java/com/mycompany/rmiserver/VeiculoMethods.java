package com.mycompany.rmiserver;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author Gabriel
 */
public class VeiculoMethods implements ClassificadosVeiculos{
    private List<Veiculo> carList = new ArrayList<Veiculo>(); 
	
    public VeiculoMethods() {
        carList.add(new Veiculo("Gabriel", "Fiat","Monza", 201.00,2008));
        carList.add(new Veiculo("Pereira", "Fiat","Monza", 202.00,2009));
        carList.add(new Veiculo("Sales", "Fiat","Monza", 203.00,2010));
    }
        
    public static void main(String[] args) {
        try {
            VeiculoMethods server = new VeiculoMethods();
            ClassificadosVeiculos stub = (ClassificadosVeiculos) UnicastRemoteObject.exportObject(server, 0);
            Registry registry = LocateRegistry.createRegistry(1892);
            System.out.println(registry.toString());
            registry.bind("Server", stub);
            System.out.println("Servider running");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }    
    
    @Override
    public List<Veiculo> search2Ano(int ano) throws RemoteException {
        List<Veiculo> listReturn = new ArrayList<Veiculo>();
        listReturn = carList.stream().filter(c -> c.ano == ano).collect(Collectors.toList());
        return listReturn;
    }
    
    @Override
    public void add(Veiculo v) throws RemoteException {
        carList.add(v);
    }
    
}
