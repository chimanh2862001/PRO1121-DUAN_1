package com.example.pro1121_duan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.pro1121_duan.DAO.DangTinDao;
import com.example.pro1121_duan.Model.DangTin;
import com.example.pro1121_duan.SQLite.MySQLite;

import java.util.ArrayList;

public class ThemTin extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dang_tin);
        Spinner loaiphong = findViewById(R.id.loaiphong);
        Spinner thanhpho = findViewById(R.id.thanhpho);
        Spinner quanhuyen = findViewById(R.id.quanhuyen);

        ArrayList<String> arrayList = new ArrayList<String>();
        arrayList.add("Loai Phong");
        arrayList.add("Can Ho");
        arrayList.add("Phong Tro");
        arrayList.add("Chung Cu");
        ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item,arrayList);
        loaiphong.setAdapter(arrayAdapter);

        ArrayList<String> arrayList1 = new ArrayList<String>();
        arrayList1.add("Thanh Pho");
        arrayList1.add("Ha Noi");

        ArrayAdapter arrayAdapter1 = new ArrayAdapter(this, android.R.layout.simple_spinner_item,arrayList1);
        thanhpho.setAdapter(arrayAdapter1);

        ArrayList<String> arrayList2 = new ArrayList<String>();
        arrayList2.add("Quan");
        arrayList2.add("Nam Tu Liem");
        arrayList2.add("Bac Tu Liem");

        ArrayAdapter arrayAdapter2 = new ArrayAdapter(this, android.R.layout.simple_spinner_item,arrayList2);
        quanhuyen.setAdapter(arrayAdapter2);

        EditText id = findViewById(R.id.id);
        EditText phongngu = findViewById(R.id.edtphong);
        EditText vesinh = findViewById(R.id.vesinh);
        EditText dientich = findViewById(R.id.dientich);
        EditText gia = findViewById(R.id.gia);

        EditText tenphuong = findViewById(R.id.tenphuong);
        EditText tenduong = findViewById(R.id.tenduong);
        EditText sonha = findViewById(R.id.sonha);


        EditText tieude = findViewById(R.id.tieude);
        EditText lienhe = findViewById(R.id.lienhe);
        EditText mota = findViewById(R.id.mota);

        EditText kinhdo = findViewById(R.id.kinhdo);
        EditText vido = findViewById(R.id.vido);

        Button add = findViewById(R.id.them);
        Button huy = findViewById(R.id.huy);

        huy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ThemTin.this, FragmentTimKiemActivity.class);
                startActivity(intent);
            }
        });

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (loaiphong.getSelectedItem().equals("LoaiPhong") || thanhpho.getSelectedItem().equals("ThanhPho") || quanhuyen.getSelectedItem().equals("Quan")
                        || id.getText().toString().length() == 0 || phongngu.getText().toString().length() == 0 || vesinh.getText().toString().length() == 0 || dientich.getText().toString().length() == 0 ||
                        gia.getText().toString().length() == 0 || tenphuong.getText().toString().length() == 0 || tenduong.getText().toString().length() == 0 || sonha.getText().toString().length() == 0 ||
                        tieude.getText().toString().length() == 0 || lienhe.getText().toString().length() == 0 || mota.getText().toString().length() == 0 || kinhdo.getText().toString().length() == 0 ||
                        vido.getText().toString().length() == 0){

                    Toast.makeText(getApplicationContext(), "Bạn Chưa Nhập Đầy Đủ Thông Tin", Toast.LENGTH_LONG).show();

                }else {
                    DangTin tt = new DangTin();
                    tt.setLoaiPhong(loaiphong.getSelectedItem().toString().trim());
                    tt.setThanhPho(thanhpho.getSelectedItem().toString().trim());
                    tt.setQuanHuyen(quanhuyen.getSelectedItem().toString().trim());
                    tt.setId(id.getText().toString().trim());
                    tt.setTieuDe(tieude.getText().toString());
                    tt.setTenDiaDiem(tenphuong.getText().toString());
                    tt.setTenDuong(tenduong.getText().toString());
                    tt.setSoNha(sonha.getText().toString());
                    tt.setKinhDo(Double.parseDouble(kinhdo.getText().toString()));
                    tt.setViDo(Double.parseDouble(vido.getText().toString()));

                    tt.setVeSinh(Integer.parseInt(vesinh.getText().toString()));
                    tt.setPhongNgu(Integer.parseInt(phongngu.getText().toString()));
                    tt.setGia(Integer.parseInt(gia.getText().toString()));
                    tt.setDienTich(Integer.parseInt(dientich.getText().toString()));
                    tt.setLienHe(lienhe.getText().toString());
                    tt.setMoTa(mota.getText().toString());

                    MySQLite mySQLite = new MySQLite(ThemTin.this);
                    DangTinDao dangTinDao = new DangTinDao(mySQLite);
                    dangTinDao.insert(tt);
                    Toast.makeText(ThemTin.this, "Them Phong Thanh Cong", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(ThemTin.this,MainActivity.class));
                }

            }
        });

    }
}