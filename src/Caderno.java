import javax.swing.*;
public  class Caderno extends Produto implements Manipulacao {
    private int qtdefolhas;
    private String tamanho;
    private String tipo;
    private boolean capadura;
    
    Caderno(){}
    Caderno( int q , String ta , String t , boolean c, String m, float v)
      {
         super(m , v);
         this.qtdefolhas = q;
         this.tamanho = ta;
         this.tipo = t;
         this.capadura = c;
      }

   
    public int getQtdefolhas() {
        return qtdefolhas;
    }

    
    public void setQtdefolhas(int qtdefolhas) {
        this.qtdefolhas = qtdefolhas;
    }

   
    public String getTamanho() {
        return tamanho;
    }


    public void setTamanho(String tamanho) {
        this.tamanho = tamanho;
    }

   
    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    
    public boolean getCapadura() {
        return capadura;
    }

   
    public void setCapadura(boolean capadura) {
        this.capadura = capadura;
    }
    
    //Método cadastro ira solicitar para o usuário detalhes do caderno
    public boolean Cadastro()
    {
      
      super.setMarca(JOptionPane.showInputDialog("**********Cadastro de Caderno***********"+" \nDigite a marca do caderno:"));
      super.setValor(Float.parseFloat(JOptionPane.showInputDialog("Digite o valor do caderno:")));
      this.setQtdefolhas(Integer.parseInt(JOptionPane.showInputDialog("Digite a quantidade de folhas:")));
      this.setTamanho(JOptionPane.showInputDialog("Digite o tamanho do caderno :"));
      this.setTipo(JOptionPane.showInputDialog("Digite o tipo de caderno :"));
      this.setCapadura(JOptionPane.showConfirmDialog(null,"Caderno de Capa dura?")< 1);
      
      return true;
    }
    
    @Override
    
    //Método consulta ira  imprimir todos os detalhes do caderno que foram cadastrados
    public String consulta()
    {
       
        String imprimir = "\n*******Dados detalhados do caderno********";
                          imprimir +="\nMarca do caderno :"+ super.getMarca();
                          imprimir +="\nValor do caderno :"+ super.getValor();
                          imprimir +="\nQuantidade de folhas:" + this.getQtdefolhas();
                          imprimir +="\nTamanho do caderno:" + this.getTamanho();
                          imprimir +="\nTipo do caderno :" + this.getTipo();
                          imprimir +="\nTipo de Capa:"+ this.getCapadura();
                          
            return imprimir;
    }
     public String toString()
    {
      return this.consulta();
    }
}
