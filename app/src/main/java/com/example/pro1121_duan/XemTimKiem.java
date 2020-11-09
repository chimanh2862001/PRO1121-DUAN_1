package com.example.pro1121_duan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.pro1121_duan.Adapter.PhongAdapter;
import com.example.pro1121_duan.DAO.DangTinDao;
import com.example.pro1121_duan.Model.DangTin;
import com.example.pro1121_duan.SQLite.MySQLite;

import java.util.List;

public class XemTimKiem extends AppCompatActivity {
   MySQLite mySQLite;
   String [] fall={"Không Tìm Thấy Kết Quả Nào!! Sorry"};
   ListView Lv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xem_tim_kiem);
        Lv=findViewById(R.id.Lv);
        mySQLite=new MySQLite(XemTimKiem.this);
        Intent intent=getIntent();
        String tim=intent.getExtras().getString("timkiem");
        DangTinDao dangTinDao=new DangTinDao(mySQLite);
        List<DangTin> dangTinList=dangTinDao.timKiem(tim);

        if (dangTinList.size()==0){
            ArrayAdapter<String> arrayAdapter=new ArrayAdapter<>(XemTimKiem.this, android.R.layout.simple_list_item_1,fall);
            Lv.setAdapter(arrayAdapter);

        }else {
            PhongAdapter phongAdapter=new PhongAdapter(dangTinList);
            Lv.setAdapter(phongAdapter);
        }

    }
}