package com.example.scientificcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import org.mariuszgromada.math.mxparser.*;

public class MainActivity extends AppCompatActivity {

    private TextView precedentCalcul;
    private EditText afficher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        precedentCalcul = findViewById(R.id.previousCalculationView);
        afficher = findViewById(R.id.displayEditText);

        afficher.setShowSoftInputOnFocus(false);
    }

    private void updateText(String strToAdd){
        String oldStr = afficher.getText().toString();
        int cursorPos = afficher.getSelectionStart();
        String leftStr = oldStr.substring(0, cursorPos);
        String rightStr = oldStr.substring(cursorPos);

        afficher.setText(String.format("%s%s%s", leftStr, strToAdd, rightStr));
        afficher.setSelection(cursorPos + strToAdd.length());
    }

    public void zeroBTN(View view){
        updateText(getResources().getString(R.string.zeroText));
    }

    public void oneBTN(View view){
        updateText(getResources().getString(R.string.oneText));
    }

    public void twoBTN(View view){
        updateText(getResources().getString(R.string.twoText));
    }

    public void threeBTN(View view){
        updateText(getResources().getString(R.string.threeText));
    }

    public void fourBTNPush(View view){
        updateText(getResources().getString(R.string.fourText));
    }

    public void fiveBTNPush(View view){
        updateText(getResources().getString(R.string.fiveText));
    }

    public void sixBTNPush(View view){
        updateText(getResources().getString(R.string.sixText));
    }

    public void sevenBTNPush(View view){
        updateText(getResources().getString(R.string.sevenText));
    }

    public void eightBTNPush(View view){
        updateText(getResources().getString(R.string.eightText));
    }

    public void nineBTNPush(View view){
        updateText(getResources().getString(R.string.nineText));
    }

    public void multiplyBTNPush(View view){
        updateText(getResources().getString(R.string.multiplyText));
    }

    public void divideBTNPush(View view){
        updateText(getResources().getString(R.string.divideText));
    }

    public void subtractBTNPush(View view){
        updateText(getResources().getString(R.string.subtractText));
    }

    public void addBTNPush(View view){
        updateText(getResources().getString(R.string.addText));
    }

    public void clearBTNPush(View view){
        afficher.setText("");
        precedentCalcul.setText("");
    }

    public void parOpenBTNPush(View view){
        updateText(getResources().getString(R.string.parenthesesOpenText));
    }

    public void parCloseBTNPush(View view){
        updateText(getResources().getString(R.string.parenthesesCloseText));
    }

    public void decimalBTNPush(View view){
        updateText(getResources().getString(R.string.decimalText));
    }

    public void equalBTNPush(View view){
        String userExp = afficher.getText().toString();

        precedentCalcul.setText(userExp);

        userExp = userExp.replaceAll(getResources().getString(R.string.divideText), "/");
        userExp = userExp.replaceAll(getResources().getString(R.string.multiplyText), "*");

        Expression exp = new Expression(userExp);
        String result = String.valueOf(exp.calculate());

        afficher.setText(result);
        afficher.setSelection(result.length());
    }

    public void backspaceBTNPush(View view){
        int cursorPos = afficher.getSelectionStart();
        int textLen = afficher.getText().length();

        if (cursorPos != 0 && textLen != 0){
            SpannableStringBuilder selection = (SpannableStringBuilder) afficher.getText();
            selection.replace(cursorPos-1, cursorPos, "");
            afficher.setText(selection);
            afficher.setSelection(cursorPos-1);
        }
    }

    public void trigSinBTNPush(View view){
        updateText("sin(");
    }

    public void trigCosBTNPush(View view){
        updateText("cos(");
    }

    public void trigTanBTNPush(View view){
        updateText("tan(");
    }

    public void trigArcSinBTNPush(View view){
        updateText("arcsin(");
    }

    public void trigArcCosBTNPush(View view){
        updateText("arccos(");
    }

    public void trigArcTanBTNPush(View view){
        updateText("arctan(");
    }

    public void naturalLogBTNPush(View view){
        updateText("ln(");
    }

    public void logBTNPush(View view){
        updateText("log(");
    }

    public void sqrtBTNPush(View view){
        updateText("sqrt(");
    }

    public void absBTNPush(View view){
        updateText("abs(");
    }

    public void piBTNPush(View view){
        updateText("pi");
    }

    public void eBTNPush(View view){
        updateText("e");
    }

    public void xSquaredBTNPush(View view){
        updateText("^(2)");
    }

    public void xPowerYBTNPush(View view){
        updateText("^(");
    }

    public void primeBTNPush(View view){
        updateText("ispr(");
    }




}