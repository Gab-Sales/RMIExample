package com.mycompany.rmiserver;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;
/**
 *
 * @author Gabriel
 */
public interface ClassificadosVeiculos extends Remote {

public List search2Ano (int anoVeiculo) throws RemoteException; 
public void add (Veiculo v) throws RemoteException; 
}