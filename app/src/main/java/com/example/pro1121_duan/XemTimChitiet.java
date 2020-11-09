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

public class XemTimChitiet extends AppCompatActivity {
  String [] all={"Không Tìm Thấy Dữ Liệu Cần Tìm!!!"};
  ListView Lv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xem_tim_chitiet);
        Lv=findViewById(R.id.Lv);

        Intent intent=getIntent();

        String loaiphong = intent.getExtras().getString("loaiphong");

        String khuvuc=intent.getExtras().getString("khuvuc");

        String mucgia=intent.getExtras().getString("mucgia");

        String dientich=intent.getExtras().getString("dientich");

        System.out.println(mucgia);
        System.out.println(dientich);
        System.out.println(loaiphong);
        System.out.println(khuvuc);

        MySQLite mySQLite=new MySQLite(XemTimChitiet.this);
        DangTinDao dangTinDao=new DangTinDao(mySQLite);

//        List<DangTin> dangTinList=dangTinDao.timchiTiet(loaiphong,khuvuc,mucgia,dientich);
//        if (dangTinList.size()==0){
//            ArrayAdapter<String> arrayAdapter=new ArrayAdapter<>(XemTimChitiet.this, android.R.layout.simple_list_item_1,all);
//            Lv.setAdapter(arrayAdapter);
//        }else {
//            PhongAdapter phongAdapter=new PhongAdapter(dangTinList);
//            Lv.setAdapter(phongAdapter);
//        }

         ///1.1
        if (mucgia.equals("1200000")&& dientich.equals("25")){
             List<DangTin> dangTinList=dangTinDao.timchitiet11(loaiphong,khuvuc);
            ///1.1
            if (dangTinList.size()==0){
                ArrayAdapter<String> arrayAdapter=new ArrayAdapter<>(XemTimChitiet.this, android.R.layout.simple_list_item_1,all);
                Lv.setAdapter(arrayAdapter);
            }else {
              PhongAdapter phongAdapter=new PhongAdapter(dangTinList);
              Lv.setAdapter(phongAdapter);
            }

        }
        if (mucgia.equals("1200000")&& dientich.equals("35")){
            //1/2
            List<DangTin> dangTinList=dangTinDao.timchitiet12(loaiphong,khuvuc);
            if (dangTinList.size()==0){
                ArrayAdapter<String> arrayAdapter=new ArrayAdapter<>(XemTimChitiet.this, android.R.layout.simple_list_item_1,all);
                Lv.setAdapter(arrayAdapter);
            }else {
                PhongAdapter phongAdapter=new PhongAdapter(dangTinList);
                Lv.setAdapter(phongAdapter);
            }
        }
        if(mucgia.equals("1200000")&& dientich.equals("55")){
            //1.3
            List<DangTin> dangTinList=dangTinDao.timchitiet13(loaiphong,khuvuc);
            if (dangTinList.size()==0){
                ArrayAdapter<String> arrayAdapter=new ArrayAdapter<>(XemTimChitiet.this, android.R.layout.simple_list_item_1,all);
                Lv.setAdapter(arrayAdapter);
            }else {
                PhongAdapter phongAdapter=new PhongAdapter(dangTinList);
                Lv.setAdapter(phongAdapter);
            }
        }
        if (mucgia.equals("2000000") && dientich.equals("25")){

            //2.1
            List<DangTin> dangTinList=dangTinDao.timchitiet21(loaiphong,khuvuc);
            if (dangTinList.size()==0){
                ArrayAdapter<String> arrayAdapter=new ArrayAdapter<>(XemTimChitiet.this, android.R.layout.simple_list_item_1,all);
                Lv.setAdapter(arrayAdapter);
            }else {
                PhongAdapter phongAdapter=new PhongAdapter(dangTinList);
                Lv.setAdapter(phongAdapter);
            }
        }
        if (mucgia.equals("2000000") && dientich.equals("35")){
            ///2.2
            List<DangTin> dangTinList=dangTinDao.timchitiet22(loaiphong,khuvuc);
            if (dangTinList.size()==0){
                ArrayAdapter<String> arrayAdapter=new ArrayAdapter<>(XemTimChitiet.this, android.R.layout.simple_list_item_1,all);
                Lv.setAdapter(arrayAdapter);
            }else {
                PhongAdapter phongAdapter=new PhongAdapter(dangTinList);
                Lv.setAdapter(phongAdapter);
            }
        }

        if (mucgia.equals("2000000") && dientich.equals("55")){

            //2.3
            List<DangTin> dangTinList=dangTinDao.timchitiet23(loaiphong,khuvuc);
            if (dangTinList.size()==0){
                ArrayAdapter<String> arrayAdapter=new ArrayAdapter<>(XemTimChitiet.this, android.R.layout.simple_list_item_1,all);
                Lv.setAdapter(arrayAdapter);
            }else {
                PhongAdapter phongAdapter=new PhongAdapter(dangTinList);
                Lv.setAdapter(phongAdapter);
            }

        }

        if (mucgia.equals("3500000") && dientich.equals("25")){
            //3.1
            List<DangTin> dangTinList=dangTinDao.timkiem31(loaiphong,khuvuc);
            if (dangTinList.size()==0){
                ArrayAdapter<String> arrayAdapter=new ArrayAdapter<>(XemTimChitiet.this, android.R.layout.simple_list_item_1,all);
                Lv.setAdapter(arrayAdapter);
            }else {
                PhongAdapter phongAdapter=new PhongAdapter(dangTinList);
                Lv.setAdapter(phongAdapter);
            }
        }

        if (mucgia.equals("3500000") && dientich.equals("35")){

            List<DangTin> dangTinList=dangTinDao.timkiem32(loaiphong,khuvuc);
            if (dangTinList.size()==0){
                ArrayAdapter<String> arrayAdapter=new ArrayAdapter<>(XemTimChitiet.this, android.R.layout.simple_list_item_1,all);
                Lv.setAdapter(arrayAdapter);
            }else {
                PhongAdapter phongAdapter=new PhongAdapter(dangTinList);
                Lv.setAdapter(phongAdapter);
            }
        }
        if (mucgia.equals("3500000") && dientich.equals("55")){
            List<DangTin> dangTinList = dangTinDao.timkiem33(loaiphong,khuvuc);
            if (dangTinList.size()==0){
                ArrayAdapter<String> arrayAdapter=new ArrayAdapter<>(XemTimChitiet.this, android.R.layout.simple_list_item_1,all);
                Lv.setAdapter(arrayAdapter);
            }else {
                PhongAdapter phongAdapter=new PhongAdapter(dangTinList);
                Lv.setAdapter(phongAdapter);
            }
        }


    }
}