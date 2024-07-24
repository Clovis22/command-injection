import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Command_Injection extends Principal {
	
	public  JFrame     Form_Command_Injection;
	private JTextField Text_Field_Command_Injection;
	private JLabel     Label_Command_Injection;
	private JButton    Button_Executar_Command_Injection;
	
	public Command_Injection() {

		Form_Command_Injection = new JFrame("Command Injection");
		Form_Command_Injection.setLayout(null);
		
		Label_Command_Injection = new JLabel("Linha de Comando");
    	
		Text_Field_Command_Injection = new JTextField();
		
		Button_Executar_Command_Injection = new JButton("Executar");
		
		Form_Command_Injection.add(Label_Command_Injection);
		Form_Command_Injection.add(Text_Field_Command_Injection);
		Form_Command_Injection.add(Button_Executar_Command_Injection);
		
		Form_Command_Injection.setSize(522,170);
		Form_Command_Injection.setLocationRelativeTo(null);
		Form_Command_Injection.setResizable(false);
		Form_Command_Injection.setVisible(true);
		
		Label_Command_Injection.setBounds(215,10,200,24);
		Text_Field_Command_Injection.setBounds(03,35,510,24);
		Button_Executar_Command_Injection.setBounds(215,80,100,24);
		
		Button_Executar_Command_Injection.addMouseListener(new MouseAdapter (){
	        public void mouseClicked(MouseEvent me){
	        	try {
					Executar();
				} catch (IOException | InterruptedException e) {
					e.printStackTrace();
				}
			}});
		
	}
	
	boolean teste1, teste2;
	public void Executar() throws IOException, InterruptedException {
		
    	String linhaDeComando = Text_Field_Command_Injection.getText();
    	
    	if((linhaDeComando.equals("notepad")) && (linhaDeComando.length() == 7)){
    		
    	   String CargaUnica = "cmd /c "+ linhaDeComando +" C:\\teste\\arquivo.txt";

    	   Process p = Runtime.getRuntime().exec(CargaUnica);

   		   System.out.printf("TESTE DE CARGA ÚNICA: %s\n", CargaUnica);
   		
    	}else {
    		
    		if(linhaDeComando.length() > 7) {
    		   teste1 = true;
    		}
    		
    		if(linhaDeComando.length() == 4) {
     		   teste1 = true;
     		   teste2 = true;
     		}
    		
    	}
    	
    	if((linhaDeComando.equals("calc")) && (linhaDeComando.length() == 4)) {
    	   
    	   String CargaUnica = "cmd /c "+ linhaDeComando +" C:\\teste\\arquivo.txt";
    		
     	   Process p = Runtime.getRuntime().exec(CargaUnica);

     	   System.out.printf("TESTE DE CARGA ÚNICA: %s\n", CargaUnica);

    	}else {
    		
    		if(linhaDeComando.length() > 4) {
    		   teste1 = true;
    		   teste2 = false;
    		}
    		
    		if(linhaDeComando.length() == 7) {
     		   teste1 = true;
     		   teste2 = true;
     		}
    		
    		if(linhaDeComando.length() > 7) {
    		   teste1 = false;
    		   teste2 = true;
    		}
    		
    	}
    	
    	if(teste1 == false) {
    		JOptionPane.showMessageDialog(null, "Restrição de 7 caracteres");
    	}
    	
    	if(teste2 == false) {
    	   JOptionPane.showMessageDialog(null, "Restrição de 4 caracteres");
    	}
		
    	
	}
    

}
