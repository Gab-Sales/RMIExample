package com.mycompany.rmiserver;
import java.io.Serializable;
/**
 *
 * @author Gabriel
 */
public class Veiculo implements Serializable {
    String nomeCliente; 
    String marcaVeiculo; 
    String modelo;
    double valorVenda; 
    int ano;
    
    public Veiculo (String n,String m,String md,double v,int a){
        nomeCliente = n;
        marcaVeiculo = m;
        modelo = md;
        valorVenda = v;
        ano = a;
    }
}
