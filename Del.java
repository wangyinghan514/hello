package com.sdut.page;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Del {
	static Frame f;
	Font fo = new Font("����",Font.BOLD,25);
	Font fo2 = new Font("����",Font.PLAIN,20);
	Font fo3 = new Font("����",Font.PLAIN,16);
	JLabel id1,title;
	JButton end,jb1,jb2;
	final JTextField str1 = new JTextField();
	public Del()
	{
		f = new Frame("�¼���Ʒ",600,300);
		init();
		f.setVisible(false);
		jb2.addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent arg0) {
				if(str1.getText().equals(""))
					return;
				int n = JOptionPane.showConfirmDialog(null, "�ò����޷������Ƿ������", "��ʾ",JOptionPane.YES_NO_OPTION);
				if(n==0)
				{
					try {
						deal(); 
					} catch (ClassNotFoundException | SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				str1.setText("");
			}
		});
	}
	public void init()
	{
		end = f.end();
		title = new JLabel("�������¼ܵ���Ʒ���",JLabel.CENTER);
		id1 = new JLabel("���:",JLabel.LEFT);
		title.setFont(fo);
		id1.setFont(fo2);
		str1.setFont(fo2);
		title.setBounds(100, 20, 400, 50);
		id1.setBounds(200,100,50,50);
		str1.setBounds(250, 100, 150, 50);
		jb1 = new JButton("���ز˵�");
		jb2 = new JButton("ȷ���¼�");
		end.setBounds(450, 180, 100, 50);
		jb1.setBounds(250, 180, 100, 50);
		jb2.setBounds(50, 180, 100, 50);
		end.setFont(fo3);
		jb1.setFont(fo3);
		jb2.setFont(fo3);
		jb1.addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent arg0) {
				First.f.setVisible(true);
				f.setVisible(false);
				str1.setText("");
			}
		});
		f.add(title);
		f.add(id1);
		f.add(str1);
		f.add(end);
		f.add(jb2);
		f.add(jb1);
	}
	void deal() throws ClassNotFoundException, SQLException
	{
		String id;
		id = str1.getText();
		if(id.equals(""))
			return;
		if(f.mo.del(id)==1)
		{
			JOptionPane.showMessageDialog(null, "�¼ܳɹ�","�¼���Ʒ",JOptionPane.PLAIN_MESSAGE);
			First.f.setVisible(true);
			f.setVisible(false);
		}
		else
			JOptionPane.showMessageDialog(null, "�¼�ʧ�ܣ���ȷ����ȷ��ţ�","�¼���Ʒ",JOptionPane.ERROR_MESSAGE);
	}
}
