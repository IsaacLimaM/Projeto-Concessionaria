import java.util.*;
import javax.swing.*;

public class Pedido implements Manipulacao {
     
  private Data data;
  private Cliente cliente;
  private  ArrayList<CaixaLapis> cxlapis = new ArrayList();
  private  ArrayList<Papel> papel = new ArrayList();
  private  ArrayList<Caderno> caderno = new ArrayList();
  //CaixaLapis adicionarCxLapis;
  
 
  Pedido(){ }
   
    public Data getData() {
        return data;
    }

    
    public void setData(Data data) {
        this.data = data;
    }

   
    public Cliente getCliente() {
        return cliente;
    }

    
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    
    public List getCxlapis() {
        return cxlapis;
    }

    public void setCxlapis(ArrayList cxlapis) {
        this.cxlapis = cxlapis;
    }

    
    public List getPapel() {
        return papel;
    }

    
    public void setPapel(ArrayList papel) {
        this.papel = papel;
    }

    
    public List getCaderno() {
        return caderno;
    }

     
    public void setCaderno(ArrayList caderno) {
        this.caderno = caderno;
    }
    
 @Override
  public boolean cadastro()
  { 
      String m , op,op2,op3,op4;
     int subm; 
     
     CaixaLapis adicionarCxLapis;
     Papel adicionarPapel ;
     Caderno adicionarCaderno;
    data = new Data();  
    cliente = new Cliente();
    
     m  ="\n1 = Cadastrar caixa de lapis";
     m +="\n2 = Cadastrar pacote de papel";
     m +="\n3 = Cadastrar caderno";
    
   //Função solicita para o usuário informe o dia mês e ano do pedido
    data.setDia(Integer.parseInt(JOptionPane.showInputDialog("Informe o Dia do Pedido :")));
    data.setMes(Integer.parseInt(JOptionPane.showInputDialog("Informe o Mês :")));
    data.setAno(Integer.parseInt(JOptionPane.showInputDialog("Informe o Ano")));
    
    cliente.setNome(JOptionPane.showInputDialog("Digite o Nome do Cliente:"));
    cliente.setCpf(JOptionPane.showInputDialog("Digite o CPF do Cliente:"));
    cliente.setTelefone(JOptionPane.showInputDialog("Digite o Telefone do Cliente:"));
      do{
       subm = Integer.parseInt( JOptionPane.showInputDialog("Selecione uma função do menu\n"+ m));
         if( subm ==1){
             do{
                //Adiciona a caixa de lapis no ArrayList  
                adicionarCxLapis = new CaixaLapis();
                adicionarCxLapis.cadastro();
                cxlapis.add(adicionarCxLapis);
                op2 = JOptionPane.showInputDialog("Deseja adicionar mais caixas de lapis ? (S / N )");
             }while(op2.equalsIgnoreCase("s"));
         }
         else if(subm ==2){
             do{
                //Adiciona o papel ao arrayList
                 adicionarPapel = new Papel() ;
                 adicionarPapel.cadastro();
                 papel.add(adicionarPapel);
                 op3 = JOptionPane.showInputDialog("Deseja adicionar mais pacote de papel? (S / N)");
               }while(op3.equalsIgnoreCase("s"));
               }
         else if(subm ==3){
                 
             do{
                 //Adiciona o caderno no ArrayList
                 adicionarCaderno = new Caderno();
                 adicionarCaderno.cadastro();
                 caderno.add(adicionarCaderno);
                 op4 = JOptionPane.showInputDialog("Deseja adicionar mais cadernos ? (S / N)");
             }while(op4.equalsIgnoreCase("s"));
         }
     op = JOptionPane.showInputDialog("Deseja cadastrar itens(S / N)");
     }while(op.equalsIgnoreCase("s"));
         return true;
  }
  @Override
  
  //Método retorna todos os Valores que foram cadastrados no ArrayList
  public String consulta()
  {
    String imprimir = "";
           imprimir  +="\n****************Data que foi efetuado o pedido**************";
           imprimir  +="\nDia " + data.getDia()+"/"+" Mês " + data.getMes()+"/"+"Ano" + data.getAno(); 
           imprimir  +="\n****************Dados do Cliente**************";
           imprimir  +="\nNome do Cliente :"+ cliente.getNome();
           imprimir  +="\nCPF  do Cliente :" + cliente.getCpf();
           imprimir  +="\nTelefone do Cliente :" + cliente.getTelefone();
           imprimir +="\n************************************************";
         
         //Percorre o ArrayList papel e imprime
         for(Papel c : papel)
         {
             
          imprimir +=(c);
         }
         //Percorre o ArrayList caixa de lapis e imprime
         for(CaixaLapis cx : cxlapis){
             
             imprimir+=(cx);
         }
         //Percorre o ArrayList caderno e imprime
         for(Caderno ca : caderno)
         {
           imprimir += (ca);
         }
          
      return imprimir;
  }
  /*Metodo calcular pedido
     **calcula o total de itens que foi adicionado no pedido e
     **adiciona uma taxa de 18% de imposto no total do pedido.
  */
  public void calcularTotalPedido()
  {
     
    float totalCompraPapel   = 0;
    float totalCompraCxLapis = 0;
    float totalCompraCaderno = 0;
    float totalCompra = 0;
    
    
        for(Papel soma : papel)
        {
          totalCompraPapel += soma.getValor();
        }
        
        for(CaixaLapis somacx : cxlapis){
            totalCompraCxLapis += somacx.getValor()* somacx.getQuantidade();
        }
        for(Caderno somaCaderno :caderno)
        {
          totalCompraCaderno += somaCaderno.getValor();
        }
        
        totalCompra = (totalCompraPapel + totalCompraCxLapis + totalCompraCaderno);
        
        //Imprime todos os valores do pedido
        
        JOptionPane.showMessageDialog(null,"\n***********Total por item**************"+
                                           "\nValor Total da quantidade de papel : $" + totalCompraPapel +
                                           "\nValor Total das caixas de lapis : $"+ totalCompraCxLapis+
                                           "\nValor Total de cadernos : $"+ totalCompraCaderno +
                                           "\n****************************************"+
                                           "\nValor Total do Pedido :$"+ (totalCompra+=totalCompra*0.18)+
                                           "\n*****************************************"
                );
        }
}
