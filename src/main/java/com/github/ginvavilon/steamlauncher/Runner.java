package com.github.ginvavilon.steamlauncher;

import java.awt.EventQueue;

import javax.swing.JFrame;

import com.github.ginvavilon.steamlauncher.parser.VdfParser;

import javax.swing.JButton;
import java.awt.CardLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.awt.event.ActionEvent;

public class Runner {

	private JFrame frmLauncher;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Runner window = new Runner();
					window.frmLauncher.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Runner() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		frmLauncher = new JFrame();
		frmLauncher.setTitle("Launcher");
		frmLauncher.setResizable(false);
		frmLauncher.setAutoRequestFocus(false);
		frmLauncher.setBounds(100, 100, 450, 300);
		frmLauncher.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmLauncher.getContentPane().setLayout(null);
		
		JButton btnPlay = new JButton("Play");
		btnPlay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnPlay.setBounds(362, 220, 64, 25);
		frmLauncher.getContentPane().add(btnPlay);
	}
}
