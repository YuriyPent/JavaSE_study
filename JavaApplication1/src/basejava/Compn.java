package basejava;

import java.awt.*;
import java.awt.event.*;

public class Compn extends Frame implements
        ActionListener, ItemListener, MouseListener {

    Button exit = new Button("Exit");
//    объявление группы флажков
    CheckboxGroup gr = new CheckboxGroup();
//    объявление первого флажка
    Checkbox op1 = new Checkbox("One");
//    объявление второго флажка
    Checkbox op2 = new Checkbox("Two");
//    объявление выпадающего списка
    Choice ch = new Choice();
//    объявление ярлыка
    Label lb = new Label("YourChoise");
//    объявление текстового поля
    TextField tf = new TextField("To edit ...");

    Compn() {
//        Размещаем элементы вручную
        setLayout(null);
//        Добавляем на форму кнопку
        add(exit);
//        Добавляем выпадающий список
        add(ch);
//        Добавляем ярлык
        add(lb);
//        Добавляем текстовое поле
        add(tf);
//        Добавляем элемент в выпадающий список
        ch.add("Good");
//        Добавляем элемент в выпадающий список
        ch.add("Very Good");
        ch.add("Excellence");
//        Присваиваем флажку группу
        op1.setCheckboxGroup(gr);
//        Присваиваем второму флажку ту же группу
        op2.setCheckboxGroup(gr);
//        Добавляем первый фложок
        add(op1);
//        Добавляем второй флажок
        add(op2);
//        Задаем размеры и координаты флажка
        op1.setBounds(10, 80, 100, 20);
        op2.setBounds(120, 80, 100, 20);
//        Задаем размеры и координаты списка
        ch.setBounds(10, 110, 60, 70);
//        Задаем размеры и координаты ярлыка
        lb.setBounds(130, 110, 100, 20);
//        Устанавливаем белый фон ярлыка
        lb.setBackground(Color.white);
//          Задаем размеры и координаты текстового поля
        tf.setBounds(130, 140, 100, 20);
//          Разрешаем редактирование текста в текстовом поле
        tf.setEditable(true);
//        Задаем фон текстового поля
        tf.setBackground(Color.yellow);
//          Добавляем прослушиватель выпадающего списка
        ch.addItemListener(this);
//        Добавляем прослушиватель флажка
        op1.addItemListener(this);
//        Добавляем прослушиватель текстового поля, который реагирует на ENTER
        op2.addItemListener(this);
//        Добавляем прослушиватель событий от ярлыка, который реагирует на щелчок
        tf.addActionListener(this);
        lb.addMouseListener(this);
        exit.addActionListener(this);//Добавляем прослушиватель для кнопки
//        Устанавливаем координаты и размеры кнопки
        exit.setBounds(10, 20, 100, 20);
    }
//Переопределяем методы интерфейса MouseListener

    @Override
    public void mouseClicked(MouseEvent ev) {
//        При щелчке на ярлыке его содержимое изменяется и 
//        устанавливается из текстового поля tf
        if (ev.getSource() == lb) {
            lb.setText(tf.getText());
        }
    }

    @Override
    public void mousePressed(MouseEvent ev) {
    }

    @Override
    public void mouseReleased(MouseEvent ev) {
    }

    @Override
    public void mouseEntered(MouseEvent ev) {
    }

    @Override
    public void mouseExited(MouseEvent ev) {
    }

    @Override
    public void actionPerformed(ActionEvent e) {
//  Обработка событий от кнопки и текстового поля
        if (e.getSource() == exit) {
//  Выход из приложения
            System.exit(0);
        } else {
            if (e.getSource() == tf) {
//  Сброс содержимого текстового поля при нажатии на ENTER
                tf.setText("");
            }
        }

    }

    @Override
    public void itemStateChanged(ItemEvent ie) {
//  реакция на выбор флажка
        if (ie.getSource() == op1) {
            setBackground(Color.red);
//  при выборе первого флажка изменить цвет формы на красный
        } else {
            if (ie.getSource() == op2) {
                setBackground(Color.green);
//  при выборе второго флажка изменить цвет формы на зеленый
            } else {
                if (ie.getSource() == ch) {
//  при выборе элемента выпыдающего списка установить содержимое 
//  ярлыка равным выбранному значению
                    lb.setText(ch.getSelectedItem());
                }
            }
        }

    }

    public static void main(String[] args) {
        Compn cm = new Compn();
        cm.resize(300, 300);
        cm.setBackground(new Color(200, 0, 180));
        cm.setVisible(true);
    }

}
