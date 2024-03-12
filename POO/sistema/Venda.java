package com.mycompany.sistema;

public class Venda {
    
    private int registraVenda;

    public int getRegistraVenda() {
        return registraVenda;
    }

    public void setRegistraVenda(int registraVenda) {
        this.registraVenda += registraVenda;
    }
    
    
    public boolean venda(String codigo, String codigoUnico){
        if(codigo.equals(codigoUnico)){
            return true;
        }else{
            return false;
        }
    }
}
