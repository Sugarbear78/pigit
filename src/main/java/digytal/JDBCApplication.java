/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package digytal;

import digytal.dao.CadastroDao;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author patyf
 */
public class JDBCApplication {

    public static void main(String[] args) {

    System.out.println("Exemplo JDBC com Maven");
    CadastroDao dao = new CadastroDao();
    Scanner entrada= new Scanner(System.in);
   

    System.out.println("Exemplo JDBC com Maven");  
    

  
    do{
        System.out.println("*******DIGITE UMA OPÇÃO*********");
        System.out.println("(1)Listar");
        System.out.println("(2)Incluir novo");
        System.out.println("(9)Sair");
        System.out.println("Opção");
        
        String opcaoStr= entrada.nextLine();
        
     try{
            int opcao = Integer.parseInt(opcaoStr);
            switch(opcao){
                case 1 :
                    List<Cadastro> resultados = dao.listar();

    for (Cadastro cad : resultados) {

      System.out.println("ID: " + cad.getId() +

          ", Nome: " + cad.getNome() + 

          ", Data Nascimento: " + cad.getDataNascimento() + 

          ", Data cadastro: " + cad.getDataCadastro());
    }
            break;
                case 2 :
                    System.out.println("Digite o nome completo");
                    String nome = entrada.nextLine();
                    System.out.println("Digite a data de nascimento no formato aaaa-MM-dd");
                    String dtNascStr = entrada.nextLine();
                    Cadastro cad = new Cadastro();
                    cad.setNome(nome);
                    cad.setDataNascimento(LocalDate.parse(dtNascStr));
                    cad.setDataCadastro(LocalDateTime.now());
                    dao.incluir(cad);
                    System.out.println("=====Cadastro Incluido=====");
                    break;
                case 9 : entrada.close();
                System.exit(0);
                default:
                    System.out.println("System.out.println(\"=======opção inválida=======\");");
                
                    
            }     
                    
                    

        }
            catch(NumberFormatException ex){
            System.out.println("=======opção inválida=======");
            
            
        }
        
        
        
    
             
             
             
        

        
    }while(true);

  

     

    

    }

    }
