package com.example.android.calc;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.view.View;
import android.view.View.OnClickListener;

public class CalcActivity extends Activity implements OnClickListener {
	
	private TextView display;
	private Button b0, b1, b2, b3, b4, b5, b6, b7, b8, b9;
	private Button add, sub, mul, div;
	private Button dot;
	private Button ans;
	private Button clr, acl;

	private Calc calc;
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        calc = new Calc();
        
        display = (TextView)findViewById(R.id.display);
        display.setText(calc.getDisplay());
        
        
        b0 = (Button)findViewById(R.id.button_0);
        b1 = (Button)findViewById(R.id.button_1);
        b2 = (Button)findViewById(R.id.button_2);
        b3 = (Button)findViewById(R.id.button_3);
        b4 = (Button)findViewById(R.id.button_4);
        b5 = (Button)findViewById(R.id.button_5);
        b6 = (Button)findViewById(R.id.button_6);
        b7 = (Button)findViewById(R.id.button_7);
        b8 = (Button)findViewById(R.id.button_8);
        b9 = (Button)findViewById(R.id.button_9);
        add = (Button)findViewById(R.id.add);
        sub = (Button)findViewById(R.id.sub);
        mul = (Button)findViewById(R.id.mul);
        div = (Button)findViewById(R.id.div);
        dot = (Button)findViewById(R.id.dot);
        ans = (Button)findViewById(R.id.ans);
        clr = (Button)findViewById(R.id.clear);
        acl = (Button)findViewById(R.id.all_clear);
        
        b0.setOnClickListener(this);
        b1.setOnClickListener(this);
        b2.setOnClickListener(this);
        b3.setOnClickListener(this);
        b4.setOnClickListener(this);
        b5.setOnClickListener(this);
        b6.setOnClickListener(this);
        b7.setOnClickListener(this);
        b8.setOnClickListener(this);
        b9.setOnClickListener(this);
        add.setOnClickListener(this);
        sub.setOnClickListener(this);
        mul.setOnClickListener(this);
        div.setOnClickListener(this);
        dot.setOnClickListener(this);
        ans.setOnClickListener(this);
        clr.setOnClickListener(this);
        acl.setOnClickListener(this);
         
    }
    
    public void onClick(View v) {
    	if (v == b0) calc.numberInput("0");
    	else if (v == b1) calc.numberInput("1");
    	else if (v == b2) calc.numberInput("2");
    	else if (v == b3) calc.numberInput("3");
    	else if (v == b4) calc.numberInput("4");
    	else if (v == b5) calc.numberInput("5");
    	else if (v == b6) calc.numberInput("6");
    	else if (v == b7) calc.numberInput("7");
    	else if (v == b8) calc.numberInput("8");
    	else if (v == b9) calc.numberInput("9");
    	else if (v == dot) calc.dotInput();
    	else if (v == add) calc.operatorInput(Calc.OP_ADD);
    	else if (v == sub) calc.operatorInput(Calc.OP_SUB);
    	else if (v == mul) calc.operatorInput(Calc.OP_MUL);
    	else if (v == div) calc.operatorInput(Calc.OP_DIV);
    	else if (v == ans) calc.operatorInput(Calc.OP_NON);
    	else if (v == clr) calc.clear();
    	else calc.clear();
    	
		display.setText(calc.getDisplay());
     }

}

