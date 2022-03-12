 import javax.swing.*;
   public  class Papel extends Produto implements Manipulacao  {
 
    private String cor;
    private String tipo;
    private float  largura;
    private float  altura;
    private int    gramatura;
    private boolean pautado;
    
    
    Papel( ){}
    Papel(String c, String t, float l, float a, int g, boolean p , String m, float v)
    {
        super(m, v);
               
       this.cor = c;
       this.tipo = t;
       this.largura = l;
       this.altura  = a;
       this.gramatura = g;
       this.pautado = p;
       
    }

  
    public String getCor() {
        return cor;
    }

 
    public void setCor(String cor) {
        this.cor = cor;
    }

  
    public String getTipo() {
        return tipo;
    }


    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    /**
     * @return the largura
     */
    public float getLargura() {
        return largura;
    }

   
    public void setLargura(float largura) {
        this.largura = largura;
    }

    
    public float getAltura() {
        return altura;
    }

   
    public void setAltura(float altura) {
        
        this.altura = altura;
    }

   
    public int getGramatura() {
        return gramatura;
    }

   
    public void setGramatura(int gramatura) {
        this.gramatura = gramatura;
    }

    
    public boolean getPautado() {
        return pautado;
    }
    
    public void setPautado(boolean pautado) {
      
    
           
           
             this.pautado = pautado;
         
    
        
       
    }
    
    @Override
    public boolean cadastro()
    {
      
        super.setMarca(JOptionPane.showInputDialog("************Cadastro de Papel************"+" \nDigite a marca do papel:"));
        super.setValor(Float.parseFloat(JOptionPane.showInputDialog("Digite o valor do papel:")));
        this.setCor(JOptionPane.showInputDialog("Informe a cor das folhas:"));
        this.setTipo(JOptionPane.showInputDialog("Informe o tipo de folha:"));
        this.setAltura(Float.parseFloat(JOptionPane.showInputDialog("Informe a altura das folhas:")));
        this.setLargura(Float.parseFloat(JOptionPane.showInputDialog("Informe a largura:")));
        this.setGramatura(Integer.parseInt(JOptionPane.showInputDialog("Informe a gramatura:")));
        this.setPautado(JOptionPane.showConfirmDialog(null,"Deseja que o papel  seja pautado?") < 1);
        
       return true;
    }

    /**
     *
     * @return
     */
    @Override
    public String consulta()
    {
      String resultado ="\n*****Detalhes do papel*****";
             resultado +="\nMarca do papel:"+super.getMarca();
             resultado +="\nValor do papel:"+super.getValor();
             resultado +="\nCor das folhas:"+this.getCor();
             resultado +="\nTipo do papel:"+this.getTipo();
             resultado +="\nAltura:"+this.getAltura();
             resultado +="\nLargura:"+this.getLargura();
             resultado +="\nGramatura:"+this.getGramatura();
             resultado +="\nPaltado:"+this.getPautado();
             
      return resultado;
    }
    
    @Override
    public String toString()
    {
      return this.consulta();
    }
}
