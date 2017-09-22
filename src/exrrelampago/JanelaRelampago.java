/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exrrelampago;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 *
 * @author 11944413600
 */
public class JanelaRelampago extends JFrame{
    private final List<Relampago> relampagos;
    private final JList<Relampago> lstRelampagos= new JList<>(new DefaultListModel<>());
    private final JButton btnClear = new JButton("Novo relampago");
    private final JButton excluiRelampago = new JButton("Exclui relampago");
    private final JButton criaRelampago = new JButton("Salvar");
    
    private final JLabel lblLatitude = new JLabel("Latitude");
    private JTextField latitude = new JTextField(30);
    private final JLabel lblLongitude = new JLabel("Longitude");
    private JTextField longitude = new JTextField(30);
    private final JLabel lblData = new JLabel("Data e hora");
    private JTextField hora = new JTextField(30);
    private final JLabel lblDescricao = new JLabel("Descricao");
    private JTextArea descricao = new JTextArea(10,20);
    
    public JanelaRelampago() {
        
        super("Relampagos");
        
        relampagos = new ArrayList<Relampago>();
        
        setMinimumSize(new Dimension(500,300));
        
        lstRelampagos.setModel(new RelampagoListModel(relampagos));
        
        
        lstRelampagos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        
        //Box botoes = Box.createHorizontalBox();
        
        JPanel botoes = new JPanel(new GridLayout(1,4));
        
        botoes.add(excluiRelampago);
        botoes.add(btnClear);
        botoes.add(criaRelampago);
        add(botoes,BorderLayout.SOUTH);
        
        JPanel form = new JPanel(new GridLayout(8,1));
        form.add(lblLatitude);
        form.add(latitude);
        form.add(lblLongitude);
        form.add(longitude);
        form.add(lblData);
        form.add(hora);
        form.add(lblDescricao);
        form.add(descricao);
        add(form,BorderLayout.CENTER);
        
        add(new JScrollPane(lstRelampagos),BorderLayout.WEST);
        
        lstRelampagos.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                Relampago selecionado = lstRelampagos.getSelectedValue();
                if(selecionado != null){
                    latitude.setText(Float.toString(selecionado.getLatitude()));
                    longitude.setText(Float.toString(selecionado.getLongtitude()));
                    SimpleDateFormat sdf= new SimpleDateFormat("dd/MM/yyyy HH:mm");
                    hora.setText(sdf.format(selecionado.getData()));
                    descricao.setText(selecionado.getDesc());
                }else{
                    latitude.setText("");
                    longitude.setText("");
                    hora.setText("");
                    descricao.setText("");
                }
            }
        });
        
        criaRelampago.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                
                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
                sdf.setLenient(false);
                Date data = new Date();
                try {
                    data = sdf.parse(hora.getText());
                } catch (ParseException ex) {
                    Logger.getLogger(JanelaRelampago.class.getName()).log(Level.SEVERE, null, ex);
                }
                Relampago selecionado = lstRelampagos.getSelectedValue();
                if(selecionado!=null){
                    selecionado.setLatitude(Float.parseFloat(latitude.getText()));
                    selecionado.setLongtitude(Float.parseFloat(longitude.getText()));
                    selecionado.setData(data);
                    selecionado.setDesc(descricao.getText());
                }else{
                    Relampago r=new Relampago(Float.parseFloat(latitude.getText()),Float.parseFloat(longitude.getText()),data,descricao.getText());
                    relampagos.add(r);
                }
                lstRelampagos.updateUI();
                
            }
            
        });
        
        excluiRelampago.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!lstRelampagos.isSelectionEmpty()){
                    relampagos.remove(lstRelampagos.getSelectedValue());
                    lstRelampagos.clearSelection();
                    lstRelampagos.updateUI();
                }
            }
            
        });
        
         btnClear.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                
                latitude.setText("");
                longitude.setText("");
                hora.setText("");
                descricao.setText("");
                lstRelampagos.clearSelection();
                
            }
            
        });
         
    }
    
}
