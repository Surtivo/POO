//package view;
//
//import javax.swing.JFrame;
//import javax.swing.JScrollPane;
//import javax.swing.JTextArea;
//
//import control.ProcessoController;
//import exceptions.AudienciaException;
//import exceptions.ProcessoException;
//
//public class ListarProcessoTextView extends JFrame {
//	
//	private static final long serialVersionUID = -2977056161590057795L;
//
//	public ListarProcessoTextView(ProcessoController p, String numero) throws ProcessoException, AudienciaException {
//        super("Listagem do Processo");
//
//        setSize(400, 300);
//        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
//        setLocationRelativeTo(null);
//
//        JTextArea areaTexto = new JTextArea();
//        areaTexto.setEditable(false);
//
//        //Não posso fazer isso, pois a view é quem decide como os dados vão aparecer?
//        StringBuilder sb = new StringBuilder();
//        sb.append(p.getProcesso(numero).toString());
//        sb.append(p.getProcesso(numero).getAudiencias());
//        sb.append(p.getProcesso(numero).getTotalCustas2());
//
//        areaTexto.setText(sb.toString());
//        areaTexto.setEnabled(false);
//
//        JScrollPane scroll = new JScrollPane(areaTexto);
//        add(scroll);
//    }
//}