import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.List;

public class SpravceZakazniku extends AbstractTableModel {
    private List<Zakaznik> customerList = new ArrayList<>();
    public SpravceZakazniku(){
        customerList.addAll(List.of(new Zakaznik("Karel"), new Zakaznik("Eva"), new Zakaznik("Petr")));
    }
    public void addCustomer(Zakaznik zakaznik){
        customerList.add(zakaznik);
        fireTableDataChanged();
    }

    public int getRowCount() {
        return customerList.size();
    }

    public int getColumnCount() {
        return 2;
    }

    public Object getValueAt(int rowIndex, int columnIndex) {
        Zakaznik currentZakaznik = customerList.get(rowIndex);
        switch (columnIndex){
            case 0: return currentZakaznik.getId();
            case 1: return currentZakaznik.getName();
        }
        throw new RuntimeException("Požadavek na číslo sloupce " + columnIndex + " nelze splnit.");
    }
}
