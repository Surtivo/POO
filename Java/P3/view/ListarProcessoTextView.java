package view;

import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import control.ProcessoController;
import dtos.AudienciaDto;
import dtos.DespesaDto;
import dtos.ProcessoDtoCompleto;
import exceptions.AudienciaException;
import exceptions.NumProcException;
import exceptions.ProcessoException;

public class ListarProcessoTextView extends JFrame {
	
	private static final long serialVersionUID = -2977056161590057795L;

	public ListarProcessoTextView(ProcessoController p, String numero) throws ProcessoException, AudienciaException, NumProcException {
        super("Listagem do Processo");

        setSize(500, 500);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JTextArea areaTexto = new JTextArea();
        areaTexto.setEditable(false);
        StringBuilder sb = new StringBuilder();
        
        ProcessoDtoCompleto PC = p.getFullProcesso(numero);
        
        if(PC != null) {
    		String aux = "Numero do Processo: " + PC.getNumero() + "\nData de abertura: " + PC.getDataAbertura() + " - Fase do processo: " + PC.getFase() + 
    				"\nCliente: " + PC.getClienteNome() + " - Registro: " + PC.getClienteCadastro() + "\nParte Contraria: " + PC.getParteContrariaNome() + 
    				" - Registro: " + PC.getParteContrariaCadastro() + "\nTribunal: " + PC.getTribunalSigla() + " - " + PC.getTribunalDescricao() + " - " + PC.getTribunalSecao();
            sb.append(aux);
            
            ArrayList<AudienciaDto> adtos = p.getAudienciasDto(numero);
            sb.append("\n------------------------------------------------------------------------------------------------------------------------\nAudiencias do processo:  " + PC.getNumero() + ":");
            for(AudienciaDto ad : adtos) {
        		sb.append("\nRecomendação: " + ad.getRecomendacao());
        		sb.append(" - Registro do Advogado: " + ad.getAdvogado());
            }
            ArrayList<DespesaDto> ddtos = p.getCustasDto(PC.getNumero());
            sb.append("\n------------------------------------------------------------------------------------------------------------------------\nDespesas do Processo:  " + PC.getNumero() + ":");
            for(DespesaDto dd : ddtos) {
        		sb.append("\nRecomendação: " + dd.getMotivo());
        		sb.append(" - Registro do Advogado: " + dd.getValor());
            } 
            sb.append("\nTotal dos custos R$: " + p.getProcesso(numero).getTotalCustas2() + "\n"); 
        }   
        
        areaTexto.setText(sb.toString());
//        areaTexto.setEnabled(false);

        JScrollPane scroll = new JScrollPane(areaTexto);
        add(scroll);
    }
}