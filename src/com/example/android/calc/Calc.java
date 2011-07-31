package com.example.android.calc;

public class Calc {
	
	private String input;
	private boolean isDecimal;
	
	private double operand;
	private double result;
	
	private String display;

	private int operator;
	private int state;
	
	public static final int OP_NON = 0;
	public static final int OP_ADD = 1;
	public static final int OP_SUB = 2;
	public static final int OP_MUL = 3;
	public static final int OP_DIV = 4;
	
	private static final int NORMAL_STATE = 0;
	private static final int INPUT_STATE = 1;

	// �R���X�g���N�^
	public Calc() {
		clear();
	}
	
	// �\�����擾
	public String getDisplay() {
		return display;
	}
	
	// ���������͂��ꂽ�ۂ̓���
	public void numberInput(String number) {
		if (state == NORMAL_STATE) {
			input = number;
			state = INPUT_STATE;
		} else {
			input = input + number;
		}
		operand = Double.parseDouble(input);
		display = String.valueOf(operand);
	}

	// �����_�����͂��ꂽ�ۂ̓���
	public void dotInput() {
		if (!isDecimal) {
			if (state == NORMAL_STATE) {
				input = "0.";
				state = INPUT_STATE;
			} else {
				input = input + ".";
			}
			isDecimal = true;
		}
		operand = Double.parseDouble(input);
		display = String.valueOf(operand);
	}
	
	// ���Z�q�����͂��ꂽ�ۂ̓���
	public void operatorInput(int op) {
		if (state == INPUT_STATE) {
			// �O��̉��Z�q�ɑΉ��������Z�����s����
			switch (operator) {
			case OP_NON : result = operand; break;
			case OP_ADD : result += operand; break;
			case OP_SUB : result -= operand; break; 
			case OP_MUL : result *= operand; break;
			case OP_DIV : if (operand != 0d) result /= operand; break;
			}
		}
		// ���Z�q��ݒ肷��
		operator = op;
		
		// ���͂��N���A����
		input = "0";
		isDecimal = false;
		operand = 0d;
		
		state = NORMAL_STATE;
	
		display = String.valueOf(result);
	}
	
	// �N���A���̓���
	public void clear() {
		input = "0";
		isDecimal = false;
		operand = 0d;
		result = 0d;

		operator = OP_NON;
		state = NORMAL_STATE;

		display = String.valueOf(operand);
	}
	
}
