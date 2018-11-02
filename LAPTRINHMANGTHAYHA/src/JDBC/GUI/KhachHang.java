package JDBC.GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;

public class KhachHang extends JFrame {
	ArrayList<KhachHangBean> arrayList = null;
	private JPanel contentPane;
	private JTextField txtjdbc;
	private JTextField txtSQL;
	private JTable tblKH;
	DefaultTableModel defaultTableModel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					KhachHang frame = new KhachHang();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public KhachHang() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 781, 433);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblNhpThngTin = new JLabel("Nh\u1EADp Th\u00F4ng Tin");
		lblNhpThngTin.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNhpThngTin.setForeground(Color.BLUE);
		
		txtjdbc = new JTextField();
		txtjdbc.setColumns(10);
		
		JLabel lblSql = new JLabel("SQL :");
		lblSql.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblSql.setForeground(Color.BLUE);
		
		txtSQL = new JTextField();
		txtSQL.setColumns(10);
		
		JLabel lblKhachHang = new JLabel("KHACH HANG");
		lblKhachHang.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblKhachHang.setForeground(Color.BLUE);
		
		JButton btnSubmit = new JButton("Submit");
		boolean check = false;
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					
					defaultTableModel = (DefaultTableModel) tblKH.getModel();

					// *******************//
					arrayList = DataObject.data();
					for (KhachHangBean khachHangBean : arrayList) {
						defaultTableModel.addRow(new Object[] {
							khachHangBean.getId(),khachHangBean.getName(),khachHangBean.getDiachi(),khachHangBean.getLuong()
						});
					}
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		btnSubmit.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnSubmit.setForeground(Color.BLUE);
		
		JButton btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					for (int i = 0; i < arrayList.size(); i++) {
						defaultTableModel.removeRow(0);
					}
				} catch (Exception e2) {
					// TODO: handle exception
				}
					
				
			}
		});
		btnReset.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnReset.setForeground(Color.BLUE);
		
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		btnExit.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnExit.setForeground(Color.BLUE);
		
		JScrollPane scrollPane = new JScrollPane();
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(305)
					.addComponent(lblKhachHang)
					.addContainerGap(352, Short.MAX_VALUE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(320, Short.MAX_VALUE)
					.addComponent(btnSubmit)
					.addGap(36)
					.addComponent(btnReset)
					.addGap(38)
					.addComponent(btnExit)
					.addGap(166))
				.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
					.addGap(71)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 583, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNhpThngTin)
								.addComponent(lblSql))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
								.addComponent(txtSQL)
								.addComponent(txtjdbc, GroupLayout.DEFAULT_SIZE, 470, Short.MAX_VALUE))))
					.addContainerGap(101, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNhpThngTin)
						.addComponent(txtjdbc, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblSql)
						.addComponent(txtSQL, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(31)
					.addComponent(lblKhachHang)
					.addGap(18)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 186, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnExit)
						.addComponent(btnReset)
						.addComponent(btnSubmit))
					.addContainerGap(21, Short.MAX_VALUE))
		);
		
		tblKH = new JTable();
		tblKH.setEnabled(false);
		
		tblKH.setModel(new DefaultTableModel(
			new Object[][] {
				
			},
			new String[] {
				"ID", "Ten Khach Hang", "Dia Chi", "Luong"
			}
		));
		
		scrollPane.setViewportView(tblKH);
		contentPane.setLayout(gl_contentPane);
	}
}
