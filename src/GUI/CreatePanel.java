package GUI;

import PatternRecognition.MatrixCalculate;

import javax.swing.*;
import javax.swing.plaf.FontUIResource;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;

public class CreatePanel {

    public static CreatePanel myGUI = new CreatePanel();

    private JButton calButton;
    private JButton setButton;
    private  LinkedList<JTextField> textFieldLinkedList = new LinkedList<JTextField>();
    private JLabel jLabel1;
    private JLabel jLabel2;
    JFrame application;
    public void create()
    {
        application = new JFrame();

        JLabel idLabel = new JLabel("标志符");
        idLabel.setFont(new Font("宋体", Font.PLAIN, 20));
        JLabel attr1Label = new JLabel("成绩1");
        attr1Label.setFont(new Font("宋体", Font.PLAIN, 20));
        JLabel attr2Label = new JLabel("成绩2");
        attr2Label.setFont(new Font("宋体", Font.PLAIN, 20));
        JLabel attr3Label = new JLabel("成绩3");
        attr3Label.setFont(new Font("宋体", Font.PLAIN, 20));
        JLabel attr4Label = new JLabel("成绩4");
        attr4Label.setFont(new Font("宋体", Font.PLAIN, 20));
        JLabel attr5Label = new JLabel("成绩5");
        attr5Label.setFont(new Font("宋体", Font.PLAIN, 20));
        JLabel attr6Label = new JLabel("成绩6");
        attr6Label.setFont(new Font("宋体", Font.PLAIN, 20));

        JLabel figure1 = new JLabel("明  镜");
        figure1.setFont(new Font("宋体", Font.PLAIN, 20));
        JLabel figure2 = new JLabel("明  楼");
        figure2.setFont(new Font("宋体", Font.PLAIN, 20));
        JLabel figure3 = new JLabel("明  台");
        figure3.setFont(new Font("宋体", Font.PLAIN, 20));
        JLabel figure4 = new JLabel("于曼丽");
        figure4.setFont(new Font("宋体", Font.PLAIN, 20));
        JLabel figure5 = new JLabel("汪曼春");
        figure5.setFont(new Font("宋体", Font.PLAIN, 20));
        JLabel figure6 = new JLabel("程锦云");
        figure6.setFont(new Font("宋体", Font.PLAIN, 20));

        setButton = new JButton("填充数值");
        setButton.setFont(new Font("宋体",Font.PLAIN,20));
        calButton = new JButton("计算");
        calButton.setFont(new Font("宋体", Font.PLAIN, 20));

        //使用GridBagLayout布局管理器
        GridBagLayout layout = new GridBagLayout();
        //用于设置此布局中指定组件的约束条件
        GridBagConstraints constraints = new GridBagConstraints();
        //若组件所在的区域比组件本身要大时则使组件完全填满其显示区域
        constraints.fill = GridBagConstraints.BOTH;
        //设置组件水平所占用的格子数，如果为0，就说明该组件是该行的最后一个
        constraints.gridwidth = 1;
        //设置组件水平的拉伸幅度，如果为0就说明不拉伸，不为0就随着窗口增大进行拉伸，0到1之间
        constraints.weightx = 0;
        //设置组件垂直的拉伸幅度，如果为0就说明不拉伸，不为0就随着窗口增大进行拉伸，0到1之间
        constraints.weighty = 0;
        //组件彼此之间的距离，参数分别为上左下右
        constraints.insets = new Insets(20,20,20,20);

        for (int i = 0; i < 36; i++)
        {
            JTextField textField = new JTextField();
            textFieldLinkedList.add(textField);
        }

        layout.setConstraints(idLabel, constraints);
        layout.setConstraints(attr1Label, constraints);
        layout.setConstraints(attr2Label, constraints);
        layout.setConstraints(attr3Label, constraints);
        layout.setConstraints(attr4Label, constraints);
        layout.setConstraints(attr5Label, constraints);
        constraints.gridwidth = 0;
        layout.setConstraints(attr6Label, constraints);

        constraints.gridwidth = 1;
        layout.setConstraints(figure1, constraints);
        for (int i = 0; i < 5; i++)
            layout.setConstraints(textFieldLinkedList.get(i), constraints);
        constraints.gridwidth = 0;
        layout.setConstraints(textFieldLinkedList.get(5), constraints);

        constraints.gridwidth = 1;
        layout.setConstraints(figure2, constraints);
        for (int i = 6; i < 11; i++)
            layout.setConstraints(textFieldLinkedList.get(i), constraints);
        constraints.gridwidth = 0;
        layout.setConstraints(textFieldLinkedList.get(11), constraints);

        constraints.gridwidth = 1;
        layout.setConstraints(figure3, constraints);
        for (int i = 12; i < 17; i++)
            layout.setConstraints(textFieldLinkedList.get(i), constraints);
        constraints.gridwidth = 0;
        layout.setConstraints(textFieldLinkedList.get(17), constraints);

        constraints.gridwidth = 1;
        layout.setConstraints(figure4, constraints);
        for (int i = 18; i < 23; i++)
            layout.setConstraints(textFieldLinkedList.get(i), constraints);
        constraints.gridwidth = 0;
        layout.setConstraints(textFieldLinkedList.get(23), constraints);

        constraints.gridwidth = 1;
        layout.setConstraints(figure5, constraints);
        for (int i = 24; i < 29; i++)
            layout.setConstraints(textFieldLinkedList.get(i), constraints);
        constraints.gridwidth = 0;
        layout.setConstraints(textFieldLinkedList.get(29), constraints);

        constraints.gridwidth = 1;
        layout.setConstraints(figure6, constraints);
        for (int i = 30; i < 35; i++)
            layout.setConstraints(textFieldLinkedList.get(i), constraints);
        constraints.gridwidth = 0;
        layout.setConstraints(textFieldLinkedList.get(35), constraints);

        layout.setConstraints(calButton, constraints);
        layout.setConstraints(setButton, constraints);

        application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        application.setLayout(layout);

        //把组件添加至JFrame
        application.add(idLabel);
        application.add(attr1Label);
        application.add(attr2Label);
        application.add(attr3Label);
        application.add(attr4Label);
        application.add(attr5Label);
        application.add(attr6Label);
        application.add(figure1);
        for (int i = 0; i < 6; i++)
            application.add(textFieldLinkedList.get(i));
        application.add(figure2);
        for (int i = 6; i < 12; i++)
            application.add(textFieldLinkedList.get(i));
        application.add(figure3);
        for (int i = 12; i < 18; i++)
            application.add(textFieldLinkedList.get(i));
        application.add(figure4);
        for (int i = 18; i < 24; i++)
            application.add(textFieldLinkedList.get(i));
        application.add(figure5);
        for (int i = 24; i < 30; i++)
            application.add(textFieldLinkedList.get(i));
        application.add(figure6);
        for (int i = 30; i < 36; i++)
            application.add(textFieldLinkedList.get(i));
        application.add(setButton);
        application.add(calButton);

        application.setSize(900,650);
        application.setVisible(true);

        //设置监听
        TextFieldHandler handler = new TextFieldHandler();
        setButton.addActionListener(handler);
        calButton.addActionListener(handler);
    }

    //获取要处理的对象标识符
    private String getJLabel1()
    {
        return jLabel1.getText();
    }

    private String getJLabel2()
    {
        return jLabel2.getText();
    }

    //获取对象属性
    public String[][] getTextFromInput()
    {
        String[][] valueCollection = new String[6][6];
        int listIndex = 0;

        for (int i = 0; i < 6; i++)
        {
            for (int j = 0; j < 6; j++)
            {
                valueCollection[i][j] = textFieldLinkedList.get(listIndex).getText();
                listIndex++;
            }
        }
        return valueCollection;
    }


    private class TextFieldHandler implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent event)
        {
            if(event.getSource() == calButton)
            {
                MatrixCalculate calculate = new MatrixCalculate();
                double[][] result = calculate.buildMixedMatrix();
                String resultString = new String("混合属性差异性矩阵为：\n");

                for (int i = 0; i < 6; i++) {
                    for (int j = 0; j < 6; j++) {
                        resultString = resultString + Double.toString(result[i][j]) + "     ";
                    }
                    resultString = resultString + "\n";
                }
                // 设置按钮显示效果
                UIManager.put("OptionPane.buttonFont", new FontUIResource(new Font("宋体", Font.PLAIN, 20)));
                // 设置文本显示效果
                UIManager.put("OptionPane.messageFont", new FontUIResource(new Font("宋体", Font.PLAIN, 20)));
                JOptionPane.showMessageDialog(null, resultString);
            }
            else if (event.getSource() == setButton)
            {
                //自动填充数值
                textFieldLinkedList.get(0).setText("A");
                textFieldLinkedList.get(1).setText("1");
                textFieldLinkedList.get(2).setText("0");
                textFieldLinkedList.get(3).setText("1");
                textFieldLinkedList.get(4).setText("优秀");
                textFieldLinkedList.get(5).setText("89");

                textFieldLinkedList.get(6).setText("C");
                textFieldLinkedList.get(7).setText("1");
                textFieldLinkedList.get(8).setText("1");
                textFieldLinkedList.get(9).setText("1");
                textFieldLinkedList.get(10).setText("良好");
                textFieldLinkedList.get(11).setText("82");

                textFieldLinkedList.get(12).setText("B");
                textFieldLinkedList.get(13).setText("0");
                textFieldLinkedList.get(14).setText("1");
                textFieldLinkedList.get(15).setText("0");
                textFieldLinkedList.get(16).setText("不合格");
                textFieldLinkedList.get(17).setText("55");

                textFieldLinkedList.get(18).setText("B");
                textFieldLinkedList.get(19).setText("1");
                textFieldLinkedList.get(20).setText("1");
                textFieldLinkedList.get(21).setText("1");
                textFieldLinkedList.get(22).setText("合格");
                textFieldLinkedList.get(23).setText("76");

                textFieldLinkedList.get(24).setText("C");
                textFieldLinkedList.get(25).setText("1");
                textFieldLinkedList.get(26).setText("1");
                textFieldLinkedList.get(27).setText("1");
                textFieldLinkedList.get(28).setText("合格");
                textFieldLinkedList.get(29).setText("82");

                textFieldLinkedList.get(30).setText("B");
                textFieldLinkedList.get(31).setText("1");
                textFieldLinkedList.get(32).setText("1");
                textFieldLinkedList.get(33).setText("1");
                textFieldLinkedList.get(34).setText("合格");
                textFieldLinkedList.get(35).setText("78");
            }
        }
    }
}




