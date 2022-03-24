package com.aom.money;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.PopupMenu;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.Calendar;

public class AddlistActivity extends AppCompatActivity implements DatePickerDialog.OnDateSetListener {
    RadioButton mIncome, mExpenses;
    EditText mContent,mMoney;
    ImageButton mSpinnerType;
    TextView mDate;
    Button mSave;
    String dataContent, dataMoney;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_addlist);
        super.onCreate(savedInstanceState);
        setparamiter();

        mDate.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                showDatePickerDigilog();
            }
        });

        mSpinnerType.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mIncome.isChecked()){

                }
                else if(mExpenses.isChecked()){
                    showTypeExpensesDialog(v);
                }
            }
        });

    }
//สร้างตัวเลือกรายละเอียกรายการ
    private void  showTypeExpensesDialog(View v){
        PopupMenu popupMenu = new PopupMenu(this, v);
        popupMenu.inflate(R.menu.pupup_menu);
        popupMenu.setOnMenuItemClickListener(
                new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        if(item.getItemId()==R.id.menu_1){
                            mContent.setText("");
                        }
                        if(item.getItemId()==R.id.menu_2){
                            mContent.setText("ค่าเดินทาง");
                        }
                        if(item.getItemId()==R.id.menu_3){
                            mContent.setText("ค่าอาหาร");
                        }
                        if(item.getItemId()==R.id.menu_4){
                            mContent.setText("ค่าบ้าน");
                        }
                        if(item.getItemId()==R.id.menu_5){
                            mContent.setText("ค่าประกัน");
                        }
                        if(item.getItemId()==R.id.menu_6){
                            mContent.setText("ค่าเน็ต/โทรศัพท์");
                        }
                        return true;
                    }
                }
        );
        popupMenu.show();
    }

    private void showDatePickerDigilog(){
        DatePickerDialog dataPickerDigilog = new DatePickerDialog(
                this,
                this,
                Calendar.getInstance().get(Calendar.YEAR),
                Calendar.getInstance().get(Calendar.MONTH),
                Calendar.getInstance().get(Calendar.DAY_OF_MONTH)
        );
        dataPickerDigilog.show();
    }

    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        String date = dayOfMonth+"/"+month + "/"+year;
        mDate.setText(date);
    }
    private void setparamiter(){
        mIncome = (RadioButton)findViewById(R.id.checkIncome);
        mExpenses = (RadioButton)findViewById(R.id.checkExpenses);
        mDate = findViewById(R.id.textviewDate);
        mContent = findViewById(R.id.editTextcontent);
        mSpinnerType = findViewById(R.id.btDataType);
        mMoney = findViewById(R.id.editTextMoney);
        mSave = findViewById(R.id.btSave);
    }
}