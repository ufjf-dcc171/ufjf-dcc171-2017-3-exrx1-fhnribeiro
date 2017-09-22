/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exrrelampago;

import java.util.ArrayList;
import java.util.List;
import javax.swing.ListModel;
import javax.swing.event.ListDataListener;

/**
 *
 * @author 11944413600
 */
public class RelampagoListModel implements ListModel<Relampago> {
    
    List<Relampago> relampagos;
    private final List<ListDataListener> dataListeners;

    public RelampagoListModel(List<Relampago> relampagos) {
        this.relampagos=relampagos;
        dataListeners = new ArrayList<>();
    }

    RelampagoListModel() {
        dataListeners = new ArrayList<>();
    }

    @Override
    public int getSize() {
        return relampagos.size();
    }

    @Override
    public Relampago getElementAt(int index) {
        return relampagos.get(index);
    }

    @Override
    public void addListDataListener(ListDataListener l) {
        dataListeners.add(l);
    }

    @Override
    public void removeListDataListener(ListDataListener l) {
        dataListeners.remove(l);
    }
    
}
