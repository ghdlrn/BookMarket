package com.market.main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.market.member.UserInIt;


public class GuestWindow extends JFrame {

	public GuestWindow(String title, int x, int y, int width, int height) {
		initContainer(title, x, y, width, height);	//initConainer()메서드 호출
		setVisible(true);	//프레임 보이기 설정
		setResizable(true);	//프레임 크기 조절 기능 설정
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);	//프레임 닫기 기능 설정
		setIconImage(new ImageIcon("./images/shop.png").getImage());	//프레임 아이콘 표시
	}

	private void initContainer(String title, int x, int y, int width, int height) {
		setTitle(title);	//프레임 제목 설정
		setBounds(x, y, width, height);	//프레임 위치, 크기 설정
		setLayout(null);	//프레임 레이아웃(특정 공간 안에 문자, 이미지 등의 구성 요소를 보기 쉽게 효과적으로 배치) 미설정
		
		Font ft;	//ft -> 글씨체(글꼴 : 함초록 돋움, 스타일 : BOLD, 크기 15)
		ft = new Font("함초록돋움", Font.BOLD, 15);
		
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		setLocation( (screenSize.width - 1000)/2, (screenSize.height - 750)/2 );	//컴퓨터 화면에 맞춰 프레임 창 화면 중앙 출력
		
		JPanel userPanel = new JPanel();	//user.png 이미지 표시 패널 영역 설정
		userPanel.setBounds(0, 100, 1000, 256);	//user.png패널 절대위치와 크기(x좌표 0, y좌표 100, 가로 크기 1000, 세로 크기 256)
		ImageIcon imageIcon = new ImageIcon("./images/user.png"); //userPanel에 넣을 user.png 이미지
		imageIcon.setImage(imageIcon.getImage().getScaledInstance(160, 160, Image.SCALE_SMOOTH));	//user.png이미지 가로크기 160, 세로크기 160, 이미지 변환방법->크기에 맞춰서
		JLabel userLabel = new JLabel(imageIcon);	//JLabel-> 텍스트 한줄 읽음 (user.png) 읽기
		userPanel.add(userLabel);	//패널에 user.png를 읽은 Label추가 
		add(userPanel);	//패널 추가
				
		JPanel titlePanel = new JPanel();	
		titlePanel.setBounds(0, 350, 1000, 50);
		add(titlePanel);
		JLabel titleLabel = new JLabel("--고객 정보를 입력하세요.--");
		titleLabel.setFont(ft);
		titleLabel.setForeground(Color.BLUE);
		titlePanel.add(titleLabel);
		
		JPanel namePanel = new JPanel();
		namePanel.setBounds(0, 400, 1000, 50);
		add(namePanel);
		JLabel nameLabel = new JLabel("이  름 : ");
		nameLabel.setFont(ft);
		namePanel.add(nameLabel);
		JTextField nameField = new JTextField(10);
		nameField.setFont(ft);
		namePanel.add(nameField);
		
		JPanel phonePanel = new JPanel();
		phonePanel.setBounds(0, 450, 1000, 50);
		add(phonePanel);
		JLabel phoneLabel = new JLabel("연락처 : ");
		phoneLabel.setFont(ft);
		phonePanel.add(phoneLabel);
		JTextField phoneField = new JTextField(10);
		phoneField.setFont(ft);
		phonePanel.add(phoneField);
		
		JPanel buttonPanel = new JPanel();
		buttonPanel.setBounds(0, 500, 1000, 100);
		add(buttonPanel);
		JLabel buttonLabel = new JLabel("쇼핑하기", new ImageIcon("images/shop.png"), JLabel.LEFT);
		buttonLabel.setFont(ft);
		JButton enterButton = new JButton();
		enterButton.add(buttonLabel);
		buttonPanel.add(enterButton);
		
		enterButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
			
				JLabel message = new JLabel("고객 정보를 입력하세요");
				message.setFont(ft);	//대화상자의 메세지 글꼴 설정
				
				if(nameField.getText().isEmpty()||phoneField.getText().isEmpty())
					JOptionPane.showMessageDialog(enterButton, message, "고객 정보", JOptionPane.ERROR_MESSAGE);
				else {
					UserInIt.init(nameField.getText(), Integer.parseInt(phoneField.getText()));	//입력한 고객 정보 저장
					dispose();	//대화상자 닫기
					new MainWindow("온라인 서점", 0, 0, 1000, 750);
					//MainWindow 프레임 호출
				}
			}
		});
	}
}
