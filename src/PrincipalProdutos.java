import javax.swing.*;
import java.util.*;
import java.util.stream.Collectors;


public class PrincipalProdutos {

    public static void main(String[] args) {
         
       
        int opmenu, pos;
        String menu, op ,cliente;
        Pedido addpedido;    
       
     ArrayList<Pedido> pedido = new ArrayList();   // ArrayList Pedido armazena os todos 
                                                  //os valores que foram digitados pelo usuáiro
        //Menu informa qual ação deverá ser tomada
        menu  ="1 = Cadastrar  \n";
        menu +="2 = Listar     \n";
        menu +="3 = Consultar  \n";
        menu +="4 = Sair       \n";
        
        do
        {
            
         opmenu = Integer.parseInt(JOptionPane.showInputDialog("---Escolha uma Opçao do Menu---\n"+ menu));
         
        switch(opmenu)
                 {
            case 1:
                do{
                    /*Depois de efetuado o cadastro do cliente , data  e dos itens o sistema perguntar se o cliente
                     * deseja cadastrar mais itens .
                     * Se caso o cliente digite N  o sistema retornara para o menu principal
                    */
                   addpedido = new Pedido();
                   addpedido.cadastro();
                   pedido.add(addpedido);
                   op = JOptionPane.showInputDialog("Deseja continuar cadastrando produtos (S / N )");
                }while(op.equalsIgnoreCase("S"));
                  
                break;
            case 2:
                  //Imprime todos os pedidos que foram cadastrados
                  // e o  total dos itens.
                   for(Pedido imprimir : pedido)
                   {
                   System.out.println(imprimir.consulta());
                   imprimir.calcularTotalPedido();
                   } 
                       
               break;
                
            case 3:
               //Consulta o pedido pelo nome do Cliente .
                pos =-1;
                
                cliente = JOptionPane.showInputDialog("Digite o nome do Cliente:");
                // Percorre o arrayList procurando a posição que o cliente foi adicionado
                for(int i = 0; i < pedido.size(); i++)
                {
                  if(pedido.get(i).getCliente().getNome().equals(cliente))
                  {
                    pos = i;
                  }
                }
                //Imprime  o pedido se o Cliente foi encontrado.
                if(pos >= 0){
                      JOptionPane.showMessageDialog(null,pedido.get(pos).consulta());
                  
                      pedido.get(pos).calcularTotalPedido();
                                       
                    }else{
                        //Se o nome digitado nao for encontrado retorná      
                        //uma mensagem informando que o pedido não foi encontrado
                        JOptionPane.showMessageDialog(null,"Pedido não encontrado!");
                }
                   break;
             
                   case  4:
                       break;
                   default:
                           JOptionPane.showMessageDialog(null,"Digite um opção valida!");
         }
        }while(opmenu !=1 || opmenu !=2 || opmenu != 3 || opmenu !=4 );
          
        
        
    
    }
    
}
