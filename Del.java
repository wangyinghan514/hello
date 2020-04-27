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
	Font fo = new Font("宋体",Font.BOLD,25);
	Font fo2 = new Font("宋体",Font.PLAIN,20);
	Font fo3 = new Font("宋体",Font.PLAIN,16);
	JLabel id1,title;
	JButton end,jb1,jb2;
	final JTextField str1 = new JTextField();
	public Del()
	{
		f = new Frame("下架商品",600,300);
		init();
		f.setVisible(false);
		jb2.addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent arg0) {
				if(str1.getText().equals(""))
					return;
				int n = JOptionPane.showConfirmDialog(null, "该操作无法撤回是否继续？", "提示",JOptionPane.YES_NO_OPTION);
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
		title = new JLabel("请输入下架的商品编号",JLabel.CENTER);
		id1 = new JLabel("编号:",JLabel.LEFT);
		title.setFont(fo);
		id1.setFont(fo2);
		str1.setFont(fo2);
		title.setBounds(100, 20, 400, 50);
		id1.setBounds(200,100,50,50);
		str1.setBounds(250, 100, 150, 50);
		jb1 = new JButton("返回菜单");
		jb2 = new JButton("确认下架");
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
			JOptionPane.showMessageDialog(null, "下架成功","下架商品",JOptionPane.PLAIN_MESSAGE);
			First.f.setVisible(true);
			f.setVisible(false);
		}
		else
			JOptionPane.showMessageDialog(null, "下架失败，请确认正确编号！","下架商品",JOptionPane.ERROR_MESSAGE);
	}
}
