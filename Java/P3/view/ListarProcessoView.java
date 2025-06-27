package view;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import control.ProcessoController;
import exceptions.AudienciaException;
import exceptions.ProcessoException;

public class ListarProcessoView extends JFrame {
	
	private static final long serialVersionUID = -2977056161590057795L;

	public ListarProcessoView(ProcessoController p, String numero) throws ProcessoException, AudienciaException {
        super("Listagem do Processo");

        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JTextArea areaTexto = new JTextArea();
        areaTexto.setEditable(false);

        StringBuilder sb = new StringBuilder();
        sb.append(p.getProcesso(numero).toString());
        sb.append(p.getProcesso(numero).getAudiencias());
        sb.append(p.getProcesso(numero).getTotalCustas2());

        areaTexto.setText(sb.toString());

        JScrollPane scroll = new JScrollPane(areaTexto);
        add(scroll);
    }
}