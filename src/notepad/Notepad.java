package notepad;

import java.awt.FileDialog;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

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
	
	String  openFile=null;
	String openPath=null;
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
		frame=new JFrame("Notepad-Clone");
		frame.setSize(700,500);
		frame.setVisible(true);
		Image icon=Toolkit.getDefaultToolkit().getImage("C:\\Users\\user\\internship\\NotepadClone\\notepadicon.PNG");
		frame.setIconImage(icon);
		
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
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
		
		itemNew.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		
		itemNewWindow=new JMenuItem("New Window");
		fileMenu.add(itemNewWindow);
		
		itemNewWindow.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Notepad n1=new Notepad();
				n1.frame.setTitle("Untitled");
				
			}
		});
		
		
		itemOpen=new JMenuItem("Open");
		fileMenu.add(itemOpen);
		
		itemOpen.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				FileDialog fd=new FileDialog(frame, "Open",FileDialog.LOAD);
				fd.setVisible(true);
				String path=fd.getDirectory();
				String fileName =fd.getFile();
				
				System.out.println(path+fileName);
				
				if (fileName != null) {
					frame.setTitle(fileName);
					openFile=fileName;
					openPath=path;
					
					}
				BufferedReader br = null;
				try {
					br = new BufferedReader(new FileReader(openPath+openFile));
					String line = br.readLine();
					while (line != null) {
						textArea.append(line + "\n");

						line = br.readLine();
					}

					System.out.println("Successfully found file for reading");
				} catch (FileNotFoundException e1) {
					System.out.println("Failed to find file for reading");
				} catch (IOException e1) {
					System.out.println("File reading failed");
				}

				finally {
					try {
						br.close();
						System.out.println("br closed successfully");
					} catch (IOException e1) {
						System.out.println("Failed to close br");
					} catch (NullPointerException np) {
						System.out.println("br object not initialized");
					}
				}
				
				
			}
		});
		
		itemSaveAs=new JMenuItem("Save as");
		fileMenu.add(itemSaveAs);
		
		itemSaveAs.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				FileDialog fd=new FileDialog(frame, "Save as", FileDialog.SAVE);
				
				fd.setVisible(true);
				String path =fd.getDirectory();
				String file=fd.getFile();
				
				if(file!=null && path!=null)
				{
					writeData(path, file);
				}
				
			}
		});
		
		
		itemSave=new JMenuItem("Save");
		fileMenu.add(itemSave);
		itemSave.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(openFile!=null && openPath!=null)
				{
					writeData(openPath, openFile);
				}
				else
				{
					FileDialog fd=new FileDialog(frame, "Save AS", FileDialog.SAVE);
					fd.setVisible(true);
					String path=fd.getDirectory();
					String fileName=fd.getFile();
					if(path!=null && fileName!=null)
					{
						writeData(path, fileName);
					}
				}
				
			}
		});
		
		itemExit=new JMenuItem("Exit");
		fileMenu.add(itemExit);
		itemExit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				
			}
		});
		
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
	
	public void writeData(String path,String file)
	{
		if(file!=null && path!=null)
		{
			BufferedWriter bw=null;
			try {
				 bw=new BufferedWriter(new FileWriter(path+file));
				String data =textArea.getText();
				
				bw.write(data);
				
			} catch (IOException e1) {
				System.out.println("Data failed to write");
			}
			finally {
				try {
					bw.close();
				} catch (IOException e1) {
					System.out.println("Failed to close");
				}
				catch(NullPointerException np)
				{
					System.out.println("file not found to close");
				}
			}
		}
		
		
	}
}
