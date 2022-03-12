import javax.swing.*;
public  class CaixaLapis extends Produto implements Manipulacao {
    
    private int quantidade;
    private boolean colorido;
    
    CaixaLapis(){}
    CaixaLapis(int q , boolean c ,String m , float v)
    {
        super(m , v);
      this.quantidade = q;
      this.colorido = c;
    }
     public int getQuantidade() {
        return quantidade;
    }

    
    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

   
    public boolean getColorido() {
        return colorido;
    }

    
    public void setColorido(boolean colorido) {
        
       
        this.colorido = colorido;
    }
    
    public boolean cadastro()
    {
       
          super.setMarca(JOptionPane.showInputDialog("*************Digite a marca dos lapis***********"));
          super.setValor(Float.parseFloat(JOptionPane.showInputDialog("Digite o valor da caixa de lapis :")));
          this.setColorido(JOptionPane.showConfirmDialog(null,"Deseja que o lapis seja colorido (S / N)" )< 1);
          this.setQuantidade(Integer.parseInt(JOptionPane.showInputDialog("Digite a quantidade desejada :")));
       
       
          return true;
    }
    
    public String consulta()
    {
     String out ="\n*************Dados da compra das Caixas de Lapis**************";
            out +="\nMarca :" + super.getMarca();
            out +="\nValor :"+ super.getValor();
            out +="\nQuantidade de caxas que foram obtidas :"+ this.getQuantidade();
            out +="\nColorido :" + this.getColorido();
           
            
          
     
     return out;
    }
      public String toString()
    {
      return this.consulta();
    }
    
}
