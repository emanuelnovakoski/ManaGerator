package interfaces;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import javax.swing.SortOrder;
import javax.swing.RowSorter;



import control.FileControl;
import data.Food;


public class Important extends JFrame {
	private static final long serialVersionUID = 1L;

	private JPanel contentPane;
	FileControl fileControl = new FileControl();
	WindowManager windowManager = new WindowManager();
	
	String selectedFood;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Important frame = new Important();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Important() {
		selectedFood = "";
		window();
		texts();
		table();
		//JCheckBox[] checkbox = checkBox();
		buttons();
	}

	private void window() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
	}

	private void texts() {
		contentPane.setLayout(null);
		JLabel lblSubtitle = new JLabel("Selecione os produtos que deseja ser notificado!");
		lblSubtitle.setBounds(98, 32, 312, 14);
		contentPane.add(lblSubtitle);

		JLabel lblTitle = new JLabel("Produtos importantes");
		lblTitle.setBounds(173, 11, 158, 14);
		contentPane.add(lblTitle);
	}

	private void buttons() {

		JButton bntGoBack = new JButton("VOLTAR AO MENU PRINCIPAL");
		bntGoBack.setBounds(73, 227, 284, 23);
		bntGoBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				windowManager.homeMenu();
				dispose();
			}
		});
		contentPane.add(bntGoBack);
	}
	
	private void table() {
		
	
		DefaultTableModel model = new DefaultTableModel(new String[]{"Alimento", "Porção", "Categoria", "Data", "Favorito"}, 0);
		
		ArrayList<Food> foods = fileControl.getFoods();
		
		for(int i=0; i<foods.size();i++) {
			Food food = foods.get(i);
			model.addRow(new Object[]{food.nameToString(), food.minPortionToString(), food.categoryToString(), food.dateToString(), fileControl.isFavoriteFood(food.nameToString())});
		}
			
		
        JTable table = new JTable(model) {
        	private static final long serialVersionUID = 1L;

            @Override
            public Class getColumnClass(int column) {
                switch (column) {
                    case 0:
                        return String.class;
                    case 1:
                        return String.class;
                    case 2:
                        return String.class;
                    case 3:
                        return String.class;
                    default:
                        return Boolean.class;
                }
            }
        };

        TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(table.getModel());
        table.setRowSorter(sorter);

        List<RowSorter.SortKey> sortKeys = new ArrayList<>(foods.size());
        sortKeys.add(new RowSorter.SortKey(4, SortOrder.ASCENDING));
        sortKeys.add(new RowSorter.SortKey(0, SortOrder.ASCENDING));
        sorter.setSortKeys(sortKeys);
        
        
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(21, 52, 389, 130);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		contentPane.add(scrollPane);
		
		table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {

			@Override
			public void valueChanged(ListSelectionEvent e) {

				selectedFood = table.getValueAt(table.getSelectedRow(), 0).toString();
			}	
		});
		
		
		model.addTableModelListener(new TableModelListener() {
			
			@Override
			public void tableChanged(TableModelEvent e) {
				
				if (table.getSelectedColumn() == 4) {
					
					String foodName = (String) table.getValueAt(table.getSelectedRow(), 0);
					boolean value = (boolean) table.getValueAt(table.getSelectedRow(), 4);
					System.out.println(value);
					fileControl.setFavorite(foodName, value);
					
				} else {
					
					String foodName = (String) table.getValueAt(table.getSelectedRow(), 0);
					String minValue = (String) table.getValueAt(table.getSelectedRow(), 1);
					String category = (String) table.getValueAt(table.getSelectedRow(), 2);
					String date = (String) table.getValueAt(table.getSelectedRow(), 3);
					boolean value = (boolean) table.getValueAt(table.getSelectedRow(), 4);
								
					fileControl.removeFood(selectedFood);
					fileControl.saveFoodFile(foodName, minValue, category, date);
					
					if(value) 
						fileControl.setFavorite(foodName, value);
					
					
				}
			}	
		});
		
	}
}


    
    