import static javax.swing.JOptionPane.showMessageDialog; //Exibir mensagens
import static javax.swing.JOptionPane.showInputDialog; //receber dados do usiario
import static java.lang.Integer.parseInt; //Converter String -> int
import static java.lang.Float.parseFloat; //Converter String -> float
import static java.lang.String.valueOf;//??? -> string
import java.util.Scanner;
import javafx.scene.control.Alert;
import javax.swing.JOptionPane;




public class Naval{
    
    public static void main(String[] args) {
        /*Tabuleiro
            1-Jogador1
            1-Jogador2
        */
        Scanner input = new Scanner(System.in);
        int[] tabuleiro = new int[10];
        int[] tabuleiro2 = new int[10];
        String mensagem = " ";
        int posicao;
        int posicao2;
        
        String X = "x";
        int totalJogadas = 0;
        int atingidas = 0;
        int atingidas2 = 0;
        boolean foiAfundado = false;
        
        
        
        String J1 = showInputDialog("Jogador1 Digite seu nome:");
        
        int posicaoNavio = receberInt( J1 + " digite a posição do seu navio: ");
        
        String J2 = showInputDialog("Jogador2 Digite seu nome: ");
        
        int posicaoNavio2 = receberInt( J2 + " digite a posição do seu navio: ");
        

        while (foiAfundado == false) {
                      
         
         posicao  = receberInt( J1 + " digite a posição onde você quer atirar: ");
         
         posicao2  = receberInt( J2 + " digite a posição onde você quer atirar: ");
         
         int parte1= posicaoNavio;
         int parte2 = parte1+1;
         int parte3 = parte1+2;
         int parte4 = parte1+3;
         
         int parte10= posicaoNavio2;
         int parte20 = parte10+1;
         int parte30 = parte10+2;
         int parte40 = parte10+3;
         
         System.out.print("*****"+J1+"******\n");
         for (int i = 0; i < 10; i++) {
             
            tabuleiro[i] = i;
            System.out.print(tabuleiro[i] + "[");
            
            if (posicao2==tabuleiro[i]) {
                System.out.print(X);
            }else if(parte1==tabuleiro[i]){
                System.out.print("+");
                if(parte1==posicao){
                    System.out.print("  ");
                }
                
            }else if(parte2==tabuleiro[i]){
                System.out.print("+");
            }else if(parte3==tabuleiro[i]){
                System.out.print("+");
            }else if(parte4==tabuleiro[i]){
                System.out.print("+");
            }
                  
            System.out.print("]\n");  
        }
         
            System.out.print("*****"+J2+"******\n");
            for (int i = 0; i < 10; i++) {
            
            tabuleiro2[i] = i;
            System.out.print(tabuleiro[i] + "[");
            
            if (posicao==tabuleiro2[i]) {
                System.out.print(X);
            }
            
            System.out.print("]\n");
            }
         
            /*for (int i = 0; i < 10; i++) {
                mensagem += tabuleiro[i] + "[";
                
                if (posicao==tabuleiro[i]) {
                    mensagem+=(X);
            }
                
                mensagem += "]\n";
                
            }exibir(mensagem);*/
         
         
         
        
        
        if (posicao < 0 || posicao > 9  &&  posicao2 < 0 || posicao2 > 9) {
          
            while(posicao < 0 || posicao > 9  &&  posicao2 < 0 || posicao2 > 9){
            exibir("Jogada inválida. Tenta de novo!");
            posicao = receberInt("Digite a posição onde você quer atirar: ");
            }
        }else{
        
        totalJogadas = totalJogadas + 1;
        
        if (posicao == parte10 || posicao == parte20 || posicao == parte30 || posicao == parte40) {
                  
            exibir(J1 + "Afundo uma parte do parco inimigo");
            
            
            atingidas = atingidas +1;
            
            

            
            if(atingidas == 4 ){
                
             foiAfundado = true;
             
             exibir( J1 + " VENCEU, parco inimigo totalmente afundado!");
            }
            
            
            
            
          
            
        }else{exibir(J1 + " acertou a água!!! ");};
        
        if(posicao2 == parte1 || posicao2 == parte2 || posicao2 == parte3 || posicao2 == parte4){
            exibir( J2 + "Afundou uma parte do parco inimigo");
            
            
            
            atingidas2 = atingidas2 +1;
            
            if( atingidas2 == 4){
                
             foiAfundado = true;
             
             
            exibir( J2 + " VENCEU, parco inimigo totalmente afundado!");
            
            }
            
         
            
            
        }else{exibir(J2 + " acertou a água!!! ");};
        
             
        }
        
     
          if(atingidas<4 && atingidas2<4){  
          posicaoNavio = receberInt(J1 + " digite a posição do seu navio: ");
             
          posicaoNavio2 = receberInt(J2 + " digite a posição do seu navio: ");
          }
        }//fim whileS
        
        
        
        
            
                    
        
       
        
    }//fim main
    
    public static int receberInt(String mansagemProUsuario) {
        try {
            //codigo normal
            return parseInt(showInputDialog(mansagemProUsuario));
            
        } catch (Exception e) {
            //se deu errado :(
        }
        
        return 0;
    }
    
     public static void exibir(String mansagemProUsuario) {
        showMessageDialog(null, mansagemProUsuario);
    }

    private static void clear() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private static void cls() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}//fim class