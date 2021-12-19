package com.bs.tools;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.GregorianCalendar;

public class CalenderTrain extends JFrame implements ActionListener {

	// 年份
	private JLabel YearLabel = new JLabel("年份:");
	private JComboBox YearBox = new JComboBox();

	// 月份
	private JLabel MonthLabel = new JLabel("月份:");
	private JComboBox MonthBox = new JComboBox();

	// 查看
	JButton button_ok = new JButton("查看");

	// 今天
	JButton button_today = new JButton("今天");

	// 今天的日期,年份,月份
	private Date now_date = new Date();
	private int now_year = now_date.getYear() + 1900;
	private int now_month = now_date.getMonth();
	private boolean todayFlag = false; // 是否显示今天的日期

	// 用一行来显示日期
	private JButton[] button_day = new JButton[42];
	private final String[] week = { "日", "一", "二", "三", "四", "五", "六" };
	private JButton[] button_week = new JButton[7];

	// 用户选择年份和月份
	private String year_int = null;
	private int month_int;

	public CalenderTrain() {
		super();
		setTitle("日历");
		init();
		setLocation(500, 300);
		setResizable(false);
		pack();
	}

	// ----->初始化日历
	private void init() {
		Font font = new Font("Dialog", Font.BOLD, 14);
		YearLabel.setFont(font);
		MonthLabel.setFont(font);
		button_ok.setFont(font);
		button_today.setFont(font);

		// 当前年份前10年和未来20年时间区间
		for (int i = now_year - 10; i <= now_year + 20; i++) {
			YearBox.addItem(i + "");
		}
		YearBox.setSelectedIndex(10);

		// 12个月的月份区间
		for (int i = 1; i < 13; i++) {
			MonthBox.addItem(i + "");
		}
		MonthBox.setSelectedIndex(now_month);

		// 年份,月份,查看,今天
		JPanel panel_ym = new JPanel();
		panel_ym.add(YearLabel);
		panel_ym.add(YearBox);
		panel_ym.add(MonthLabel);
		panel_ym.add(MonthBox);
		panel_ym.add(button_ok);
		panel_ym.add(button_today);
		button_ok.addActionListener(this);
		button_today.addActionListener(this);
		

		// 星期 "日", "一", "二", "三", "四", "五", "六"
		JPanel panel_day = new JPanel();
		panel_day.setLayout(new GridLayout(7, 7, 3, 3));
		for (int i = 0; i < 7; i++) {
			button_week[i] = new JButton(week[i]);
			button_week[i].setForeground(Color.black);
			panel_day.add(button_week[i]);
		}
		button_week[0].setForeground(Color.red);
		button_week[6].setForeground(Color.red);

		// 1,2,3..30等日
		for (int i = 0; i < 42; i++) {
			button_day[i] = new JButton(" ");
			panel_day.add(button_day[i]);
		}
		printDay();

		//
		JPanel panel_main = new JPanel();
		panel_main.setLayout(new BorderLayout());
		panel_main.add(panel_ym, BorderLayout.NORTH);
		panel_main.add(panel_day, BorderLayout.SOUTH);

		getContentPane().add(panel_main);
	}

	// ----->显示当前年月的日期
	private void printDay() {
		clearBtns();

		if (todayFlag) {
			year_int = now_year + "";
			month_int = now_month;
		} else {
			year_int = YearBox.getSelectedItem().toString();
			month_int = MonthBox.getSelectedIndex();
		}

		int year_sel = Integer.parseInt(year_int) - 1900;

		/**
		 * Date构造函数
		 * 
		 * @param year
		 *            the year minus 1900.
		 * @param month
		 *            the month between 0-11.
		 * @param date
		 *            the day of the month between 1-31.
		 */
		Date firstDay = new Date(year_sel, month_int, 1);
		GregorianCalendar cal = new GregorianCalendar();
		cal.setTime(firstDay);

		//
		int days = 0; // 本月有多少天
		int day_week = firstDay.getDay(); // 星期几
		if (month_int == 0 || month_int == 2 || month_int == 4 || month_int == 6 || month_int == 7 || month_int == 9
				|| month_int == 11) {
			days = 31;
		} else if (month_int == 3 || month_int == 5 || month_int == 8 || month_int == 10) {
			days = 30;
		} else {
			if (cal.isLeapYear(year_sel)) {
				days = 29;
			} else {
				days = 28;
			}
		}

		// 根据选定月份第一天是星期几来确定按钮的绘制位置 day_week就是我们绘制的起始位置。
		int count = 1;

		for (int i = day_week; i < day_week + days; count++, i++) {
			if (i % 7 == 0 || i == 6 || i == 13 || i == 20 || i == 27 || i == 34 || i == 41) { // 6+31
																								// =
																								// 37
				if (i == day_week + now_date.getDate() - 1) {
					button_day[i].setForeground(Color.blue);
					button_day[i].setText(count + "");
				} else {
					button_day[i].setForeground(Color.red);
					button_day[i].setText(count + "");
				}
			} else {
				if (i == day_week + now_date.getDate() - 1) {
					button_day[i].setForeground(Color.blue);
					button_day[i].setText(count + "");
				} else {
					button_day[i].setForeground(Color.black);
					button_day[i].setText(count + "");
				}
			}
		}

		//
		if (day_week == 0) {
			for (int i = days; i < 42; i++) {
				button_day[i].setText("");
			}
		} else {
			// 第一天不是周日,则将第一天前面的按钮置空
			for (int i = 0; i < day_week; i++) {
				button_day[i].setText("");
			}
			// 最后一天后面的按钮置空
			for (int i = day_week + days; i < 42; i++) {
				button_day[i].setText("");
			}
		}
	}

	private void clearBtns() {
		for (int i = 0; i < 42; i++) {
			button_day[i].setText("");
		}
	}

	// ----->按钮监听函数
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == button_ok) {
			todayFlag = false;
			printDay();
		} else if (e.getSource() == button_today) {
			todayFlag = true;
			YearBox.setSelectedIndex(10);
			MonthBox.setSelectedIndex(now_month);
			printDay();
		}else{
			JButton jButton = (JButton)e.getSource();
			String text = jButton.getText();
			JOptionPane.showMessageDialog(null, text, "标题条文字串", JOptionPane.ERROR_MESSAGE); 
		}
	}

	// ----->主函数
	public static void main(String[] args) {
		CalenderTrain ct = new CalenderTrain();
		ct.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ct.setVisible(true);
	}
}
