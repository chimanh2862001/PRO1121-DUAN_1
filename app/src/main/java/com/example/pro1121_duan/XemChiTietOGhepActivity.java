package com.example.pro1121_duan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class XemChiTietOGhepActivity extends AppCompatActivity {

    TextView tvTieuDe, tvGia, tvDiaChi, tvMoTa, tvLienHe, tvGioiTinh;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xem_chi_tiet_o_ghep);

        Intent intent = getIntent();

        tvTieuDe = findViewById(R.id.tvTieuDeOG);
        tvGia = findViewById(R.id.tvGiaOG);
        tvGioiTinh = findViewById(R.id.tvGioiTinhOG);
        tvDiaChi = findViewById(R.id.tvDiaChiOG);
        tvMoTa = findViewById(R.id.tvMoTaOG);

        String td = intent.getExtras().getString("TieuDe");
        String gt = intent.getExtras().getString("GioiTinh");
        Double gia = Double.parseDouble(String.valueOf(intent.getExtras().getDouble("Gia")));
        String dc = intent.getExtras().getString("DiaChi");
        String mt = intent.getExtras().getString("MoTa");
        String lh = intent.getExtras().getString("LienHe");

        tvTieuDe.setText(td);
        tvGia.setText(gia+"");
        tvGioiTinh.setText(gt);
        tvDiaChi.setText(dc);
        tvMoTa.setText(mt);
    }
}