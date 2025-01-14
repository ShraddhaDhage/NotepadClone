package notepad;

import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class Notepad
{
	JFrame frame;
	JTextArea textArea;
	JMenuBar menubar;
	JMenu fileMenu,editMenu,formatMenu,commandPromptMenu;
	
	//File MenuItems
	JMenuItem itemNew,itemNewWindow,itemOpen,itemSaveAs,itemSave,itemExit;
	
	//Format menu items
	JMenuItem itemWordWrap,itemFont,itemFontsize;
	
	//Command Prompt menu items
	JMenuItem itemCMD;
	
	public Notepad()
	{
		createFrame();
		createTextArea();
		createScrollBars();
		createMenuBar();
		createFileMenuItems();
		createFormatItems();
		createCommandPromptItem();
	}
	

	public void createFrame()
	{
		frame=new JFrame();
		frame.setSize(700,500);
		frame.setVisible(true);
		Image icon=Toolkit.getDefaultToolkit().getImage("C:\\Users\\user\\internship\\NotepadClone\\notepadicon.PNG");
		frame.setIconImage(icon);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
	public void createTextArea()
	{
		textArea=new JTextArea();
		frame.add(textArea);
	}
	
	public void createScrollBars()
	{
		JScrollPane scroll=new JScrollPane(textArea,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		frame.add(scroll);
	}
	
	public void createMenuBar()
	{
		menubar=new JMenuBar();
		frame.setJMenuBar(menubar);
		
		fileMenu=new JMenu("File");
		menubar.add(fileMenu);
		
		editMenu=new JMenu("Edit");
		menubar.add(editMenu);
		
		formatMenu=new JMenu("Format");
		menubar.add(formatMenu);
		
		commandPromptMenu=new JMenu("Command Prompt");
		menubar.add(commandPromptMenu);
		
		
	}
	
	
	public void createFileMenuItems()
	{
		itemNew=new JMenuItem("New");
		fileMenu.add(itemNew);
		
		itemNewWindow=new JMenuItem("New Window");
		fileMenu.add(itemNewWindow);
		
		itemNewWindow.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Notepad n1=new Notepad();
				
			}
		});
		
		itemOpen=new JMenuItem("Open");
		fileMenu.add(itemOpen);
		
		itemSaveAs=new JMenuItem("Save as");
		fileMenu.add(itemSaveAs);
		
		itemSave=new JMenuItem("Save");
		fileMenu.add(itemSave);
		
		itemExit=new JMenuItem("Exit");
		fileMenu.add(itemExit);
		
	}
	
	public void createFormatItems()
	{
	
		itemWordWrap=new JMenuItem("Word Wrap");
		formatMenu.add(itemWordWrap);
		
		itemFontsize=new JMenuItem("Font Size");
		formatMenu.add(itemFontsize);
		
		itemFont=new JMenuItem("Font");
		formatMenu.add(itemFont);
		
	}
	
	public void createCommandPromptItem()
	{
		itemCMD=new JMenuItem("Open Command Prompt");
		commandPromptMenu.add(itemCMD);
	}
}
