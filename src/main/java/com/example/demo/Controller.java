package com.example.demo;


import java.net.URL;
import java.util.ResourceBundle;

import eu.hansolo.tilesfx.addons.Switch;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class Controller {

    private String strnum="";
    private float firstNumber;
    private char operation;

    @FXML
    private ResourceBundle resources;

    @FXML
    private Label lable_field;

    @FXML
    private URL location;

    @FXML
    private Button btn_0;

    @FXML
    private Button btn_1;

    @FXML
    private Button btn_2;

    @FXML
    private Button btn_3;

    @FXML
    private Button btn_4;

    @FXML
    private Button btn_5;

    @FXML
    private Button btn_6;

    @FXML
    private Button btn_7;

    @FXML
    private Button btn_8;

    @FXML
    private Button btn_9;

    @FXML
    private Button btn_comma;

    @FXML
    private Button btn_del;

    @FXML
    private Button btn_div;

    @FXML
    private Button btn_equ;

    @FXML
    private Button btn_min;

    @FXML
    private Button btn_mul;

    @FXML
    private Button btn_per;

    @FXML
    private Button btn_plus;

    @FXML
    private Button btn_pm;

    @FXML
    void initialize() {
        btn_0.setOnAction(actionEvent -> {
            AddNumber(0);
        });
        btn_1.setOnAction(actionEvent -> {
            AddNumber(1);
        });
        btn_2.setOnAction(actionEvent -> {
            AddNumber(2);
        });
        btn_3.setOnAction(actionEvent -> {
            AddNumber(3);
        });
        btn_4.setOnAction(actionEvent -> {
            AddNumber(4);
        });
        btn_5.setOnAction(actionEvent -> {
            AddNumber(5);
        });
        btn_6.setOnAction(actionEvent -> {
            AddNumber(6);
        });
        btn_7.setOnAction(actionEvent -> {
            AddNumber(7);
        });
        btn_8.setOnAction(actionEvent -> {
            AddNumber(8);
        });
        btn_9.setOnAction(actionEvent -> {
            AddNumber(9);
        });
        btn_plus.setOnAction(actionEvent -> {
            MathAction('+');
        });
        btn_min.setOnAction(actionEvent -> {
            MathAction('-');
        });
        btn_mul.setOnAction(actionEvent -> {
            MathAction('*');
        });
        btn_div.setOnAction(actionEvent -> {
            MathAction('/');
        });
        btn_equ.setOnAction(actionEvent -> {
            if (this.operation == '+' || this.operation == '-'
                    || this.operation == '*' || this.operation == '/')
                equalMethod();
        });
        btn_comma.setOnAction(actionEvent -> {
            if (!this.strnum.contains(".")){
                this.strnum += ".";
                lable_field.setText(strnum);
            }
        });
        btn_per.setOnAction(actionEvent -> {
            if (this.strnum != "") {
                float pr = Float.parseFloat(strnum) * 0.1f;
                this.strnum = Float.toString(pr);
                lable_field.setText(strnum);
                strnum = "";
            }
        });
        btn_pm.setOnAction(actionEvent -> {
            if (this.strnum != "") {
                float pr = Float.parseFloat(strnum) * -1;
                this.strnum = Float.toString(pr);
                lable_field.setText(strnum);

            }
        });
        btn_del .setOnAction(actionEvent -> {
            lable_field.setText("0");
            this.strnum = "";
            this.firstNumber = 0;
            this.operation = 'A';
        });

    }
    void  equalMethod (){
        float res = 0;
        switch (this.operation) {
            case '+':
                res = this.firstNumber + Float.parseFloat(this.strnum);
                break;
            case '-':
                res = this.firstNumber - Float.parseFloat(this.strnum);
                break;
            case '*':
                res = this.firstNumber * Float.parseFloat(this.strnum);
                break;
            case '/':
                if (Integer.parseInt(this.strnum) != 0)
                    res = this.firstNumber / Float.parseFloat(this.strnum);
                else
                    res = 0;
                break;
        }
        lable_field.setText(Float.toString(res));
        this.strnum="";
        this.firstNumber = 0;
        this.operation = 'A';
    }
    void MathAction(char operation){
        if (this.operation != '+' && this.operation != '-'
            && this.operation != '*' && this.operation != '/'){
            this.firstNumber = Float.parseFloat(this.strnum);
            lable_field.setText(String.valueOf(operation));
            this.strnum = "";
            this.operation = operation;
        }

    }
    void AddNumber(int number){
        this.strnum += Integer.toHexString(number);
        lable_field.setText(strnum);

    }

}
