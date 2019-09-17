package clases.arboles;

import java.util.List;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

public class ArbolComprobantesxZonas {
    
    DefaultTreeModel arbol;
    
    public DefaultTreeModel ArbolComprobantesxZonas(int idLoteComprobantes) {
        DefaultMutableTreeNode padre = new DefaultMutableTreeNode("Lote Nº "+String.valueOf(idLoteComprobantes));
        arbol = new DefaultTreeModel(padre);
        List<modelos.Zona> lz = dao.Zonas.listaZonasxLote(idLoteComprobantes);
        for(modelos.Zona z:lz){
            DefaultMutableTreeNode hijo = new DefaultMutableTreeNode(z);
            padre.add(hijo);
        }
        return arbol;
    }
    
}
