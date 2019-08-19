package clases;

import java.util.Vector;
import javax.swing.table.DefaultTableModel;

    public class CustomTableModel extends DefaultTableModel {

        public void removeColumn(int column) {
            // for each row, remove the column
            Vector rows = dataVector;
            for (Object row : rows) {
                ((Vector) row).remove(column);
            }

            // remove the header
            columnIdentifiers.remove(column);

            // notify
            fireTableStructureChanged();
        }
    }