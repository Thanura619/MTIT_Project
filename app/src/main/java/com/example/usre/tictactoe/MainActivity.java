package com.example.usre.tictactoe;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.ButtonBarLayout;
import android.view.View;
import android.widget.Button;
import android.view.View.OnClickListener;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements OnClickListener{
    Button a1,a2,a3,b1,b2,b3,c1,c2,c3;
    Button btngame;
    Button[] bArray;

    boolean turn = true;
    int turn_count =0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        a1 = (Button)findViewById(R.id.A1);
        a2 = (Button)findViewById(R.id.A2);
        a3 = (Button)findViewById(R.id.A3);
        b1 = (Button)findViewById(R.id.B1);
        b2 = (Button)findViewById(R.id.B2);
        b3 = (Button)findViewById(R.id.B3);
        c1 = (Button)findViewById(R.id.C1);
        c2 = (Button)findViewById(R.id.C2);
        c3 = (Button)findViewById(R.id.C3);
        btngame = (Button)findViewById(R.id.newGame);

        bArray = new Button[]{a1,a2,a3,b1,b2,b3,c1,c2,c3};

        for(Button b :bArray){
            b.setOnClickListener(this);

        }

        btngame.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {

                turn = true;
                turn_count=0;
                AllButtonsAction(true); //make this method. its purpose is to change color of button when clicked
            }
        });

    }


    @Override
    public void onClick(View v) {
        Button b = (Button) v;
        buttonClicked(b);       //make this method. its purpose change the button text to X or O

    }



    private void checkForWinner(){
        boolean winner = false;

        if(a1.getText()==a2.getText() && a2.getText()==a3.getText() && !a1.isClickable()){
            winner=true;

        }else if(b1.getText()==b2.getText() && b2.getText()==b3.getText() && !b1.isClickable()){
            winner=true;

        }else if(c1.getText()==c2.getText() && c2.getText()==c3.getText() && !c1.isClickable()){
            winner=true;

        }
        else if(a1.getText()==b1.getText() && b1.getText()== c1.getText() && !a1.isClickable()){
            winner=true;

        }else if(a2.getText()==b2.getText() && b2.getText()== c2.getText() && !b2.isClickable()){
            winner=true;

        }else if(a3.getText()==b3.getText() && b3.getText()== c3.getText() && !c3.isClickable()){
            winner=true;

        }else if(a1.getText()==b2.getText() && b2.getText()== c3.getText() && !a1.isClickable()){
            winner=true;

        }else if(a3.getText()==b2.getText() && b2.getText()== c1.getText() && !b2.isClickable()){
            winner=true;
        }

        if(winner){
            if(!turn){
                toast("X WINS");    //make this method. its purpose is to show messages
            }else{
                toast("O WINS");
            }
            AllButtonsAction(false);

        }else if(turn_count ==9 ){
            toast("DRAW");

        }


    }

    private void AllButtonsAction(boolean enable) {
        for(Button b: bArray){

            b.setClickable(enable);

            if(enable){
                b.setBackgroundColor(Color.parseColor("#33b5e5"));
                b.setText("");

            }else{
                b.setBackgroundColor(Color.LTGRAY);
            }

        }
    }
    public void buttonClicked(Button b){

        if(turn) {
            b.setText("X");

        }else{
            b.setText("O");

        }
        turn_count++;

        b.setBackgroundColor(Color.LTGRAY);
        b.setClickable(false);
        turn = !turn;

        checkForWinner();

    }

    private void toast(String message){
        Toast.makeText(getApplicationContext(),message, Toast.LENGTH_SHORT).show();

    }





}
