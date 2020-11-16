package com.example.pro1121_duan;

import androidx.fragment.app.FragmentActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.TextView;

import com.example.pro1121_duan.Adapter.PhongAdapter;
import com.example.pro1121_duan.DAO.DangTinDao;
import com.example.pro1121_duan.Model.DangTin;
import com.example.pro1121_duan.SQLite.MySQLite;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;
import java.util.List;

public class ChiTietTro_Googlemap extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    TextView tvTitle,tvDientich,tvBed,tvToilet,tvTTMT, tvXCTLoaiPhong, tvMucGia, tvngayDang, tvDiaChi;
    double kinhdo,vido;
    String loaiPhong, thanhPho, quanHuyen, tenDiaDiem, tenDuong, soNha, moTa, lienHe;
    Integer gia;
    Button button2;

    GridView gridView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chi_tiet_tro__googlemap);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        button2=findViewById(R.id.button2);
        Intent intent = getIntent();
        tvTitle=findViewById(R.id.tvTitle);
        tvDientich=findViewById(R.id.tvDientich);
        tvBed=findViewById(R.id.tvBed);
        tvToilet=findViewById(R.id.tvToilet);
        tvTTMT=findViewById(R.id.tvTTMT);
        tvXCTLoaiPhong = findViewById(R.id.tvXCTLoaiPhong);
        tvMucGia = findViewById(R.id.tvMucGia);
        tvngayDang = findViewById(R.id.tvNgayDang);
        tvDiaChi = findViewById(R.id.tvDiaChi);

        gridView = findViewById(R.id.listGiongTieuChi);
        ///

        loaiPhong = intent.getExtras().getString("LoaiPhong");
        thanhPho = intent.getExtras().getString("ThanhPho");
        quanHuyen = intent.getExtras().getString("QuanHuyen");
        tenDiaDiem = intent.getExtras().getString("TenDiaDiem");
        tenDuong = intent.getExtras().getString("TenDuong");
        soNha = intent.getExtras().getString("SoNha");

        gia = Integer.parseInt(String.valueOf(intent.getExtras().getInt("Gia")));

        moTa = intent.getExtras().getString("MoTa");
        lienHe ="tel:"+intent.getExtras().getString("LienHe");

        Integer dientich=Integer.parseInt(String.valueOf(intent.getExtras().getInt("Dientich")));
        Integer phongngu=Integer.parseInt(String.valueOf(intent.getExtras().getInt("Phongngu")));
        Integer vesinh=Integer.parseInt(String.valueOf(intent.getExtras().getInt("Vesinh")));

        Double kinhdo1=Double.parseDouble(String.valueOf(intent.getExtras().getDouble("Kinhdo")));
        Double vido1=Double.parseDouble(String.valueOf(intent.getExtras().getDouble("Vido")));



        kinhdo = kinhdo1;
        vido = vido1;
        
        ///
        String tieude = intent.getExtras().getString("Tieude");
        tenDiaDiem = tieude;



        ////

        tvTitle.setText(intent.getExtras().getString("Tieude"));
        tvDientich.setText(dientich+" m2");
        tvBed.setText(phongngu+" pn");
        tvToilet.setText(vesinh+" vs");
        tvTTMT.setText(moTa);
        tvXCTLoaiPhong.setText(loaiPhong);
        tvMucGia.setText("Mức Giá: "+gia);
        tvngayDang.setText("?/?/?");
        tvDiaChi.setText(thanhPho + ", " + quanHuyen + ", " + tenDuong + ", " + soNha);

        MySQLite mySQLite = new MySQLite(ChiTietTro_Googlemap.this);
        DangTinDao dangTinDao = new DangTinDao(mySQLite);
        List<DangTin> dangTinList = dangTinDao.getAll();
        PhongAdapter phongAdapter = new PhongAdapter(dangTinList);
        gridView.setAdapter(phongAdapter);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                DangTin dangTin = dangTinList.get(position);
                tvTitle.setText(intent.getExtras().getString("Tieude"));
                tvDientich.setText(dientich+" m2");
                tvBed.setText(phongngu+" pn");
                tvToilet.setText(vesinh+" vs");
                tvTTMT.setText(moTa);
                tvXCTLoaiPhong.setText(loaiPhong);
                tvMucGia.setText("Mức Giá: "+gia);
                tvngayDang.setText("?/?/?");
                tvDiaChi.setText(thanhPho + ", " + quanHuyen + ", " + tenDuong + ", " + soNha);
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                  Intent intent1=new Intent(Intent.ACTION_DIAL);
                  intent1.setData(Uri.parse(lienHe));
                startActivity(intent1);
            }
        });

    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        LatLng sydney = new LatLng(kinhdo, vido);
        mMap.addMarker(new MarkerOptions().position(sydney).title(tenDiaDiem));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
    }
}