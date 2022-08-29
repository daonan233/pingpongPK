import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionEvent;
import java.io.BufferedReader;
import javax.swing.JFrame;
//                           一：awt_container 容器

//Component作为基类，提供了如下常用的方法来设置组建的大小，位置，可见性等
        //setLocation(int x,int y)设置组件的位置
        //setSize(int width,int height)设置组建的大小
        //setBounds(int x,int y,int width,int height)同时设置组建的位置，大小
        //setVisible(Boolean b)设置该组建的可见性

//Container作为容器跟类，提供了如下方法来访问容器中的组件
        //Component add(Component comp)向容器中添加其他组件（该组件可以是普通组件，也可以是容器），并返回别添加的组件
        //Component getComponentAt(int x,int y)返回指定点的组件
        //int getComponentCount() 返回该容器中组建的数量
        //Component[] getComponents()返回该容器内的所有组件

//                           演示1，简单窗口
/*public class main{
    public static void main(String[] args) {

        //1.创建一个窗口对象
        Frame f =new Frame("道难的第一个窗口");
        //2.设置窗口的位置，大小
        f.setLocation(100,100);
        f.setSize(500,300);
        //3.设置窗口对象可见
        f.setVisible(true);
    }
}*/

//                           演示2,Panel容器

/*public class main{
    public static void main(String[] args) {
        //创建一个window对象，因为panel和其他的容器，都不能独立才能在，必须依附于window存在
        Frame f=new Frame("道难的Panel演示");
        //创建一个panel对象
        Panel p= new Panel();
        //创建一个文本框和一个按钮，并把他们放入panel容器中
        p.add((new TextField("请在此输入文字")));
        p.add(new Button("上传"));
        //把panel放入window中，设置window的大小位置
        f.add(p);
        f.setLocation(100,100);
        f.setSize(500,300);
        //让window可见
        f.setVisible(true);
    }
}*/


//                         演示3，滑块对象
/*
public class main
{
    public static void main(String[] args) {
        Frame f=new Frame("这里演示ScrollPane");
        //1.创建一个ScrollPane对象
        ScrollPane sp =new ScrollPane(ScrollPane.SCROLLBARS_ALWAYS);
        //2.往ScrollPane中添加内容
        sp.add(new TextField("在此输入文本"));
        sp.add(new Button("测试按钮"));
        //把ScrollPane添加到Frame中
        f.add(sp);

        f.setBounds(100,1002,500,300);
        f.setVisible(true);
    }
}*/


//                   LayoutManager布局管理器


//1.LayoutManer布局管理器，可以根据运行平台来自动调整组件大小，程序员不用再手动设置组建的大小和位置了，只要为容器选择合适的布局管理器即可（可以调整到最佳大小）

//FlowLayout布局管理器中，组件像水流一样向某方向流动（排列），遇到障碍边界就这会，从头开始排列
//在默认情况下，FlowLayout布局从左向右排列所有组件，遇到边界就折回下一行重新开始
    //FlowLayout()使用默认的对齐方式和默认你的垂直间距
    //FlowLayout(int align) 使用指定的对齐方式和默认的垂直间距，水平间距创建FlowLayout布局管理器
    //FLowLayout（int align ,int hgap,int vgap) 使用指定的对齐方式,垂直间距和水平间距创建FlowLayout布局管理器
/*
public class main{
    public static void main(String[] args) {
        Frame f=new Frame("测试FlowLayout");

        //通过setLayout方法设置容器的布局管理器
        f.setLayout(new FlowLayout(FlowLayout.LEFT,20,30));//对齐方式有LEFT，CENTER，RIGHT。
        //添加多个按钮到Frame中
        for (int i = 0; i < 10; i++) {
            f.add(new Button("按钮"+i));
            f.add(new TextField("爱玩"));
        }
        //设置最佳大小，pack方法
        f.pack();
        f.setVisible(true);

    }
}*/


//2.BorderLayout 将容器分为EAST，WEST，NORTH，SOUTH，CENTER五个区域，默认为Center

//如果想同一个区域中放入多个组件是，后放入的会覆盖先放入的组件
//     BorderLayout();使用默认得水平间距，垂直间距创建BorderLayout布局管理器
//     BorderLayout(int hgap,int vgap);使用指定的...

/*public class main{
    public static void main(String[] args) {
        Frame f=new Frame("试试BroderLayout");
        //1.给f设置borderLayout布局管理器
        f.setLayout(new BorderLayout(30,10));
        //2.往f的指定区域添加组件
        f.add(new Button("北侧"),BorderLayout.NORTH);
        f.add(new Button("南侧"),BorderLayout.SOUTH);
        f.add(new Button("东侧"),BorderLayout.EAST);
        f.add(new Button("西侧"),BorderLayout.WEST);

//        f.add(new Button("中间"),BorderLayout.CENTER);
//        f.add(new TextField("这里可以写内容！"));//这个会覆盖之前的中间的组件

        //那我们就使用Panel来实现把两个装一起的，如果某个位置没有组件，就会优先占领这个位置
        Panel p= new Panel();
        p.add(new TextField("测试文本框"));
        p.add(new Button("中间按钮"));
        f.add(p);

        f.pack();
        f.setVisible(true);
    }
}*/


//3.GridLayout布局管理器将容器分割成纵横分隔的网格，每个网格所占的区域大小相同。默认从古走向有，从上向下依次添加到每个网格中
//GridLayout布局管理器中的各组件的大小由组件所在的区域决定，（每个组件将自动占满整个区域)。
//GridLayout (int rows,int cols) 指定行数、列数
//GridLayout（int rows ,int cols,int hgap,int vgap) 指定行数、列数、横向间距，纵向间距
/*
public class main {
    public static void main(String[] args) {
        Frame f=new Frame("计算器");
        //创建一个Panel对象，里面存放一个TextField组件
        Panel p =new Panel();
        p.add(new TextField("在此处写入算式"));
        //把当前的这个Panel添加到f的北边区域
        f.add(p,BorderLayout.NORTH);
        //创建一个Panel对象，并且设置他的布局管理器为GridLayout
        Panel p2=new Panel();
        p2.setLayout(new GridLayout(5,3,5,5));

        //往Panel中添加内容
        for (int i = 0; i < 10; i++) {
            p2.add(new Button(i+""));
        }
        p2.add(new Button("+"));
        p2.add(new Button("-"));
        p2.add(new Button("*"));
        p2.add(new Button("÷"));
        p2.add(new Button("="));
        //把当前Panel添加到frame中
        f.add(p2);

        f.pack();
        f.setVisible(true);

    }
}
*/


//GridBagLayout一个组件可以跨越一个或多个网格，并可以设置各网格的大小互不相同，从而增加了布局的灵活性
//这个复杂，不好用，后面有更好用的

//CardLayout 布局管理器以时间而非空间来管理它里面的组件，他将加入容器的所有组件看成一叠卡片（每个卡片其实就是一张卡片）每次只有最上面的Component可见
//CardLayout() 创建默认的CardLayour布局管理器
//CardLayout（int hgap,int vgap)指定左右边界的间距和上下边界的间距
//first（Container target）显示target容器中的第一张卡片
//last（Container target）显示target容器中的最后一张卡片
//previous（Container target) 显示target容器中的前一张卡片
//next（Container target）显示target容器中德后一张卡片
//show（Container target，String name)显示target容器中指定名字的卡片
/*
public class main{
    public static void main(String[] args) {
        Frame f=new Frame("可以翻页咯");
        //创建一个Panel，用来存储多张卡片
        Panel p1=new Panel();
        //创建CardLayout对象，兵器把该对象设置给之前创建的容器
        CardLayout cardLayout = new CardLayout();
        p1.setLayout(cardLayout);
        //往p中存储多个组件
        String [] names ={"第一张","第二张","第三张","第四张","第五张"};
        for (int i = 0; i < 5; i++) {
            p1.add(names[i],new Button(names[i]));
        }
        //把p放到f的中间区域
        f.add(p1);
        //创建另外一个Panel p2，用来存储多个和按钮组件
        Panel p2 = new Panel();
        //创建5个按钮组件
        Button b1 = new Button("上一张");
        Button b2 = new Button("下一张");
        Button b3 = new Button("第一张");
        Button b4 = new Button("最后一张");
        Button b5 = new Button("第三张");

        //创建一个时间监听器，监听按钮的点击动作
        ActionListener listener =new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String actionCommand = e.getActionCommand();//这个字符串其实就是按钮上的文字
                switch (actionCommand){
                    case"上一张":
                        cardLayout.previous(p1);
                        break;
                    case"下一张":
                        cardLayout.next(p1);
                        break;
                    case"第一张":
                        cardLayout.first(p1);
                        break;
                    case"最后一张":
                        cardLayout.last(p1);
                        break;
                    case"第三张":
                        cardLayout.show(p1,"第三张");
                        break;
                }
            }
        };
        //把当前的事件监听器和多个按钮绑定到一起
        b1.addActionListener(listener);
        b2.addActionListener(listener);
        b3.addActionListener(listener);
        b4.addActionListener(listener);
        b5.addActionListener(listener);
        //把按钮添加到p2中
        p2.add(b1);
        p2.add(b2);
        p2.add(b3);
        p2.add(b4);
        p2.add(b5);
        //把p2放到f的南边区域
        f.add(p2,BorderLayout.SOUTH);

        f.pack();
        f.setVisible(true);
    }
}
 */


//BoxLayout 可以在垂直和水平两个方向上拜访GUI组件
//BoxLayout(Container target,int axis) 组件按axis方向排列，其中有BoxLayout.x_AXIS(横向）和BoxLayout.Y_AXIS(纵向)
/*
public class main{
    public static void main(String[] args) {
        Frame f=new Frame("BoxLayout对象");
        //基于f容器，创建一个BoxLayout对象，并且该对象存放组件是垂直存放
        BoxLayout boxLayout = new BoxLayout(f, BoxLayout.Y_AXIS);
        //把BoxLayout对象设置给f
        f.setLayout(boxLayout);
        //往f中添加两个按钮组件
        f.add(new Button("第一"));
        f.add(new Button("第二"));

        f.pack();
        f.setVisible(true);
    }
}
*/


//                        Box容器
//在java.swing包中，提供了一个新的容器Box，默认布局管理器是BoxLayout。
//大多数情况下，使用Box容器去容纳多个GUI组件，然后再把Box容器作为一个组件，添加到其他的容器中，从而形成这个题窗口布局
//static Box createHorizontalBox() 创建一个水平排列组件的Box容器
//static Box createVerticalBox() 创建一个垂直排列组件的Box容器
/*public class main{
    public static void main(String[] args) {
        Frame f=new Frame("这里测试BoxLayout");
        //创建一个水平排列组件的Box容器
        Box hBox = Box.createHorizontalBox();
        //往当前容器中添加两个按钮
        hBox.add(new Button("你好"));
        hBox.add(new Button("世界"));
        //创建一个垂直排列的Box容器
        Box vBox = Box.createVerticalBox();
        //往当前容器中添加两个按钮
        vBox.add(new Button("java"));
        vBox.add(new Button("狗都不学"));
        //把两个Box容器其添加到f中
        f.add(hBox,BorderLayout.NORTH);
        f.add(vBox);

        f.pack();
        f.setVisible(true);
    }
}*/

//BoxLayout给组件设置间距
//static Component createHorizontalGlue() 创建一条水平Glue(在两个方向上同时拉伸的间距）
//static Component createVerticalGlue()  创建一条垂直Glue(...)
//static Component createHorizontalStrut(int width) 创建一条指定宽度（宽度固定了，不能拉伸）的水平Strut
//static Component createVerticalStrut(int height)创建一条指定高度的垂直Strut
/*public class main{
    public static void main(String[] args) {
        Frame f= new Frame("这里测试BoxLayout");
        //创建水平排列的Box容器 hBox
        Box hBox = Box.createHorizontalBox();
        //往hBox容器中添加按钮,还需要在多个按钮之间添加分割
        hBox.add(new Button("水平1"));
        hBox.add(Box.createHorizontalGlue());//该分割在两个方向上都可以拉伸
        hBox.add(new Button("水平2"));
        hBox.add(Box.createHorizontalStrut(20));
        hBox.add(new Button("水平3"));
        //创建垂直排列的Box容器 vBox
        Box vBox = Box.createVerticalBox();
        //往vBox容器中添加按钮，还需要在多个按钮之间添加分割
        vBox.add(new Button("垂直1"));
        vBox.add(Box.createVerticalGlue());
        vBox.add(new Button("垂直2"));
        vBox.add(Box.createVerticalStrut(20));
        vBox.add(new Button("垂直3"));
        //把box容器添加到f中
        f.add(hBox,BorderLayout.NORTH);//先写的记得加位置，不然会被后面的覆盖
        f.add(vBox);

        f.pack();
        f.setVisible(true);
    }
}*/


//各种组件的使用->一个简单案例
/*public class main{
    Frame f=new Frame("这里测试基本组件");
    TextArea ta =new TextArea(5,20);
    Choice colorChooser =new Choice();
    CheckboxGroup cbg=new CheckboxGroup();
    Checkbox ck1 =new Checkbox("♂",cbg,true);
    Checkbox ck2 =new Checkbox("♀",cbg,false);

    Checkbox isMarried =new Checkbox("是否已婚");//可选

    TextField tf=new TextField(50);
    Button ok =new Button("确认");

    List colorList =new List(6,true);//可以多选

    public void init(){
        //组装界面

        //组装底部
        Box bBox =Box.createHorizontalBox();
        bBox.add(tf);
        bBox.add(ok);

        f.add(bBox,BorderLayout.SOUTH);

        //组装选择部分
        colorChooser.add("红色");
        colorChooser.add("蓝色");
        colorChooser.add("绿色");
        Box cBox=Box.createHorizontalBox();
        cBox.add(colorChooser);
        cBox.add(ck1);
        cBox.add(ck2);
        cBox.add(isMarried);

        //组装文本域和选择部分
        Box topLeft=Box.createVerticalBox();
        topLeft.add(ta);
        topLeft.add(cBox);

        //组装顶部左边和列表框
        colorList.add("红色");
        colorList.add("蓝色");
        colorList.add("绿色");
        Box top =Box.createHorizontalBox();
        top.add(topLeft);
        top.add(colorList);
        f.add(top);

        f.pack();
        f.setVisible(true);

    }

    public static void main(String[] args) {
        new main().init();
    }
}*/


//对话框Dialog是window类的子类，是一个容器类，属于特殊组件。对话框是可以独立存在的顶级窗口
//对话框通常依赖于其他窗口，就是通常需要一个父窗口
//对话框有模式对话框（modal）和非模式（non-modal）两种。当某个模式对话框被打开后，该模式对话框中是位于他的父窗口之上，在模式对话框被关闭之前，父窗口无法获得焦点
//       Dialog(Frame owner String title ,boolen modal)创建一个对话框对象，owner：当前对话框的父窗口，title：当前对话框的标题，modal：当前对话框是否是模式对话框
/*public class main{
    public static void main(String[] args) {
        Frame f= new Frame("这里测试Dialog");
        //创建两个对话框Dialog对象，一个模式的，一个非模式的
        Dialog trueModal = new Dialog(f, "modal", true);
        Dialog falseModal = new Dialog(f, "non-modal,false");

        //通过setBounds方法设置Dialog的位置和大小
        trueModal.setBounds(20,30,300,200);
        falseModal.setBounds(20,30,300,200);
        //创建两个按钮
        Button b1 = new Button("打开模式对话框");
        Button b2 = new Button("打开非模式对话框");

        //创建一个垂直的Box容器，把一个文本框和一个按钮添加到Box容器中
        Box vBox =Box.createVerticalBox();
        vBox.add(new TextField(30));
        vBox.add(new Button("确认"));

        //把Box容器添加到Dialog中
        trueModal.add(vBox);

        //给这两个按钮添加点击后的行为
        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                trueModal.setVisible(true);
            }
        });
        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                falseModal.setVisible(true);
            }
        });
        //把按钮添加到f中
        f.add(b1,BorderLayout.NORTH);
        f.add(b2,BorderLayout.SOUTH);

        f.pack();
        f.setVisible(true);
    }
}*/


//FileDialog组件，可以对文件进行处理
/*
public class main{
    public static void main(String[] args) {
        Frame frame =new Frame("这里测试Dialog");
        //创建两个FileDialog对象
        FileDialog f1= new FileDialog(frame,"选择要打开的文件",FileDialog.LOAD);
        FileDialog f2= new FileDialog(frame,"选择要打开的路径",FileDialog.SAVE);

        //创建两个按钮
        Button b1 = new Button("打开文件");
        Button b2 = new Button("保存文件");

        //给这两个按钮设置点击后的行为，获取打开或者保存的路径文件名
        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                f1.setVisible(true);//代码会阻塞到这里

                //获取选取的路径及文件
                String directory =f1.getDirectory();
                String file =f1.getFile();
                System.out.println("打开的路径名称为"+directory);
                System.out.println("打开的文件名称为"+file);
            }
        });
        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                f2.setVisible(true);

                String directory =f2.getDirectory();
                String file =f2.getFile();
                System.out.println("保存的路径名称为"+directory);
                System.out.println("保存的文件名称为"+file);
            }
        });

        frame.add(b1,BorderLayout.NORTH);
        frame.add(b2,BorderLayout.SOUTH);

        frame.pack();
        frame.setVisible(true);
    }
}*/



//事件处理机制    演示
/*
public class main{
        Frame frame =new Frame("这里测试事件处理");

        TextField tf=new TextField(30);
        JButton jb =new JButton("谁点谁傻逼");

        public void init (){
           //组装视图
            MyListener myListener = new MyListener();
            //注册监听
            jb.addActionListener(myListener);

            //把tf和ok放入frame中
            frame.add(tf,BorderLayout.NORTH);
            frame.add(jb);

            frame.pack();
            frame.setVisible(true);
        }
        private class MyListener implements  ActionListener{
            @Override
            public void actionPerformed(ActionEvent e) {
                tf.setText("你是傻逼");
                jb.setText("傻逼还真点");
            }
        }

    public static void main(String[] args) {

            new main().init();
    }
}*/


//GUI中常见事件和事件监听器
//低级事件
//ComponentEvent 组件实践，当组件尺寸发生变化，位置发生移动，显示/隐藏发生改变时触发该事件
//ContainerEvent 容器事件，当容器里发生添加组件，删除组件时触发该事件
//WindowEvent 窗口事件，当窗口状态发生改变时触发该事件
//FocusEvent 焦点事件，当组件得到焦点或失去焦点时出发该事件
//KeyEvent 键盘事件，当按键被按下、松开、单击时触发该事件
//Mouse Event 鼠标事件，当进行单击、按下、松开、移动鼠标时触发该事件
//PaintEvent 组件绘制时间，当GUI组件调用update/paint方法来呈现自身是出发该事件，并非专用于事件处理模型

//高级时间
//ActionEvent 动作时间，当按钮、菜单项被单击，在TextField中按Enter触发
//AdjustmentEvent 调节时间，在滑动条移动滑块时触发该事件
//ItemEvent 选项事件，当用户选中某项，或取消选中某项时触发该事件
//TextEvent 文本事件，当文本框、文本域里面的文本能发生改变时触发该事件

//事件监听器
//把上述的Event改成Listener即可。特例，MouseEvent改成MouseMotionListener

//案例1.
/*
public class main{
    public static void main(String[] args) {
        Frame frame =new Frame("这里我们测试");
        //创建组件（事件源）
        TextField tf = new TextField(30);
        Choice names =new Choice();
        names.add("daonan");
        names.add("liyuan");
        names.add("pjy");

        //给文本域添加TextListener,监听内容的变化
        tf.addTextListener(new TextListener() {
            @Override
            public void textValueChanged(TextEvent e) {
                String text = tf.getText();
                System.out.println("当前文本框中的内容为："+text);
            }
        });
        //给下拉选择框添加ItemListener，监听条目选项的变化
         names.addItemListener(new ItemListener() {
             @Override
             public void itemStateChanged(ItemEvent e) {
                Object item = e.getItem();
                 System.out.println("当前选中的条目为:"+item);
             }
         });
        //给frame注册ContainerListener监听器，监听容器中组件的添加与删除
        frame.addContainerListener(new ContainerListener() {
            @Override
            public void componentAdded(ContainerEvent e) {
               Object child = e.getChild();
                System.out.println("frame中添加了："+child);
            }

            @Override
            public void componentRemoved(ContainerEvent e) {
               Object child =e.getChild();
                System.out.println("frame中删除了："+child);
            }
        });

        //设置windowListener，监听用户点击X的动作，若点击则关闭窗口
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e ) {
                //停止当前程序
                System.exit(0);
            }
        });
        //添加到frame中
        Box hBox= Box.createHorizontalBox();
        hBox.add(names);
        hBox.add(tf);
        frame.add(hBox);

        frame.pack();
        frame.setVisible(true);
    }
}*/


//菜单组件
//MenuBar 菜单条，菜单的容器
//Menu菜单组件，菜单项的容器，他也是MenuItem的子类有，所以可以作为菜单项使用
//PopupMenu 上下文菜单组件（右键菜单组件）
//MenuItem 菜单项组件
//CheckboxMenuItem 复选框菜单项组件
/*
public class main{
    private Frame frame = new Frame("这里测试菜单相关组件");
    //创建菜单条
    MenuBar menuBar =new MenuBar();
    //创建菜单组件
    Menu fileMenu = new Menu("文件");
    Menu editMenu = new Menu("编辑");
    Menu formatMenu =new Menu("格式");

    //菜单项组件
    MenuItem auto =new MenuItem("自动换行");
    MenuItem copy =new MenuItem("复制");
    MenuItem paste =new MenuItem("粘贴");

    MenuItem comment =new MenuItem("注释 Ctrl+Shift+Q",new MenuShortcut(KeyEvent.VK_Q,true));//关联快捷键true
    MenuItem cancelComment =new MenuItem("取消注释");

    TextArea ta= new TextArea("啥玩意啊",6,40);


    //创建Panel容器
    Panel p =new Panel();
    //创建popupMenu
    PopupMenu ppM=new PopupMenu();
    //创建菜单项
    MenuItem daonan=new MenuItem("道难");
    MenuItem liyuan=new MenuItem("离鸢");
    MenuItem pjy = new MenuItem("七姐");
    MenuItem lyk = new MenuItem("刘宇尻");


    public void init() {
        //组装视图
        comment.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ta.append("您点击了菜单项"+e.getActionCommand());
            }
        });
        formatMenu .add(comment);
        formatMenu.add(cancelComment);

        //组装编辑菜单
        editMenu.add(auto);
        editMenu.add(copy);
        editMenu.add(paste);
        editMenu.add(formatMenu);

        //组装菜单条
        menuBar.add(fileMenu);
        menuBar.add(editMenu);

        //把菜单条放入Frame中
        frame.setMenuBar(menuBar);
        frame.add(ta);



        //组装popupMenu
        ppM.add(daonan);
        ppM.add(liyuan);
        ppM.add(pjy);
        ppM.add(lyk);

        p.add((ppM));

        //设置Panel的大小
        p.setPreferredSize(new Dimension(400,300));
        //给Panel注册鼠标事件，监听用户释放鼠标的动作，展示菜单
        p.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                boolean flag = e.isPopupTrigger();
                if(flag){
                    //显示popupMenu
                    ppM.show(p,e.getX(),e.getY());
                }
            }
        });

        frame.add(p,BorderLayout.SOUTH);

        frame.pack();
        frame.setVisible(true);66
    }

    public static void main(String[] args) {
        new main().init();
    }
}*/


//Graphics绘制图形
/*
public class main{
    private final String RECT_SHAPE="rect";
    private final String OVAL_SHAPE="oval";

    private Frame frame = new Frame("这里测试绘图");

    Button btnRect = new Button("绘制矩形");
    Button btnOval =new Button ("绘制椭圆");

    //定义一个变量，记录当前要绘制椭圆还是矩形
    private String shape ="";

    //自定义类，继承Canvas类，重写paint（Graphic g)方法完成画图
    private class MyCanvas extends Canvas{
        @Override
        public void paint(Graphics g) {
            //绘制不同的图形
            if (shape.equals(RECT_SHAPE)){
                //绘制矩形
                g.setColor(Color.BLACK);//设置画笔颜色为黑色
                g.drawRect(50,50,150,100);
            }else if(shape.equals(OVAL_SHAPE)){
                //绘制椭圆
                g.setColor(Color.RED);//设置画笔颜色为黑色
                g.drawOval(50,50,150,100);
            }
        }
    }
    //创建自定义的画布对象
    MyCanvas drawArea = new MyCanvas();

    //组装视图
    public void init()
    {
       btnRect.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
               //点击改标记
               shape = RECT_SHAPE;
               drawArea.repaint();
           }
       });
       btnOval.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
               shape =OVAL_SHAPE;
               drawArea.repaint();
           }
       });
       //创建Panel,承载按钮
        Panel p =new Panel();
        p.add(btnOval);
        p.add(btnRect);

        frame.add(p,BorderLayout.SOUTH);

        //drawArea的大小需要设置
        drawArea.setPreferredSize(new Dimension(300,200));
        frame.add(drawArea);

        frame.pack();
        frame.setVisible(true);

    }

    public static void main(String[] args) {
        new main().init();
    }
}
*/

public class main{
        private Frame frame = new Frame("弹球游戏");
        //球桌
        private final int TABLE_WIDTH=300;
        private final int TABLE_HEIGHT=400;

        //球拍
        private final int RACKET_WIDTH = 60;
        private final int RACKET_HEIGHT = 20;

        //小球
        private final int BALL_SIZE = 16;

        //定义变量，记录小球的坐标；
        private int ballx=120;
        private int bally=20;

        //定义变量，记录小球在x和y上分别移动的速度
        private int speedy=10;
        private int speedx=10;

        //定义变量，记录球拍的坐标
        private int racketx = 120;
        private final int rackety = 340;

        //定义变量，标识游戏是否结束
        private boolean isOver = false;

        //声明一个定时器
        private Timer timer;

        //自定义一个类，继承Canvas，充当画布
        private class MyCanvas extends Canvas{
            @Override
            public void paint(Graphics g) {
                //TODO 在这里绘制内容

                if(isOver)
                {//游戏结束
                    g.setColor(Color.BLUE);
                    g.setFont(new Font("Times",Font.BOLD,30));
                    g.drawString("    你寄了！",50,200);
                }else {
                //游戏中
                    //绘制小球
                    g.setColor(Color.RED);
                    g.fillOval(ballx,bally,BALL_SIZE,BALL_SIZE);

                    //绘制球拍
                    g.setColor(Color.PINK);
                    g.fillRect(racketx,rackety,RACKET_WIDTH,RACKET_HEIGHT);

                }

            }
        }

        //创建绘画区域
        MyCanvas drawArea = new MyCanvas();


        public void init(){
            //组装视图，以及游戏逻辑设置

            //完成球拍坐标的变化
            KeyListener listener =new KeyAdapter() {
                @Override
                public void keyPressed(KeyEvent e) {
                    int keyCode = e.getKeyCode();
                    if(keyCode==KeyEvent.VK_LEFT){
                        //向左移动
                        if(racketx>0)
                            racketx-=25;
                    }
                    if(keyCode==KeyEvent.VK_RIGHT){
                        //向右移动
                        if(racketx<TABLE_WIDTH-RACKET_WIDTH)
                            racketx+=25;
                    }

                }
            };
            frame.addKeyListener(listener);
            drawArea.addKeyListener(listener);

            //小球坐标的控制
            ActionListener task =new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    //更新小球的坐标，重新给界面
                    ballx += speedx;
                    bally += speedy;
                    //重给页面
                    drawArea.repaint();
                    if (ballx <= 0 || ballx >= (TABLE_WIDTH - BALL_SIZE))
                        speedx = -speedx;
                    if (bally <= 0 || (bally > rackety-BALL_SIZE&& ballx < racketx+ RACKET_WIDTH && ballx > racketx))
                        speedy = -speedy;
                    if (bally > rackety - BALL_SIZE && (ballx < racketx || ballx > racketx + RACKET_WIDTH)) {
                        //当前校区超出了球拍的范围，游戏结束

                        //停止计时器
                        timer.stop();
                        //修改游戏是否结束的标记
                        isOver = true;
                        //重绘界面
                        drawArea.repaint();
                    }
                    //更新小球的坐标，重新给界面
                    ballx+=speedx;
                    bally+=speedy;
                    //重给界面
                    drawArea.repaint();
                }
            };
            timer= new Timer(100,task);
            timer.start();

            drawArea.setPreferredSize(new Dimension(TABLE_WIDTH,TABLE_HEIGHT));
            frame.add(drawArea);

            frame.pack();
            frame.setVisible(true);
        }

    public static void main(String[] args) {
        new main().init();
    }
}


