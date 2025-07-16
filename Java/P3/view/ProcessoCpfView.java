package view;

import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import control.ProcessoController;
import dtos.AudienciaDto;
import dtos.ProcessoDtoCompleto;
import exceptions.AudienciaException;
import exceptions.NumProcException;
import exceptions.ProcessoException;

public class ProcessoCpfView extends JFrame {
	
	private static final long serialVersionUID = 8423902193581131693L;

	public ProcessoCpfView(ProcessoController p, String numero) throws ProcessoException, AudienciaException, NumProcException {
        super("Listagem do Processo");

        setSize(500, 500);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JTextArea areaTexto = new JTextArea();
        areaTexto.setEditable(false);
        StringBuilder sb = new StringBuilder();
        
        ProcessoDtoCompleto PC = p.getFullProcesso(numero);;
        
        if(PC != null) {
    		String aux = "Numero do Processo: " + PC.getNumero() + "\nData de abertura: " + PC.getDataAbertura() + " - Fase do processo: " + PC.getFase() + 
    				"\nCliente: " + PC.getClienteNome() + " - Registro: " + PC.getClienteCadastro() + "\nParte Contraria: " + PC.getParteContrariaNome() + 
    				" - Registro: " + PC.getParteContrariaCadastro() + "\nTribunal: " + PC.getTribunalSigla() + " - " + PC.getTribunalDescricao();
            sb.append(aux);
            
            ArrayList<AudienciaDto> adtos = p.getAudienciasDto(numero);
            sb.append("\n------------------------------\nAudiencias do processo:  " + PC.getNumero() + ":");
            for(AudienciaDto ad : adtos) {
        		sb.append("\nRecomendação: " + ad.getRecomendacao());
        		sb.append(" - Registro do Advogado: " + ad.getAdvogado());
            }      
            sb.append("\nTotal dos custos R$: " + p.getProcesso(numero).getTotalCustas2() + "\n"); 
        }   
        
        areaTexto.setText(sb.toString());
        areaTexto.setEnabled(false);

        JScrollPane scroll = new JScrollPane(areaTexto);
        add(scroll);
    }
}