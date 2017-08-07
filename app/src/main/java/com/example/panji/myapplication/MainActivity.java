package com.example.panji.myapplication;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.*;
import butterknife.BindView;
import  butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    public static final String URL = "http://sulistiyanto.000webhostapp.com/";
    private RadioButton radioSexButton;
    private ProgressDialog progress;
    //bind semua value dari layout dengan butterknife
    @BindView(R.id.radioSessi)RadioGroup radioGroup;
    @BindView(R.id.editTextNama) EditText editTextNama;
    @BindView(R.id.editTextNPM) EditText editTextNPM;
    @BindView(R.id.editTextKelas)EditText editTextKelas;
    @OnClick(R.id.buttonLihat) void lihat(){
        startActivity(new Intent(MainActivity.this,ViewActivity.class));
    }
    //gunakan onclick dari butter knife
    //yang di bind ke button daftar

    @OnClick(R.id.buttonDaftar) void datftar(){
        //jalankan progress dialog
        progress = new ProgressDialog(this);
        progress.setCancelable(false);
        progress.setMessage("...Loading");
        progress.show();
        //masukan nilai yg sudah di bind dari butter knife
        //ke variabel
        String npm = editTextNPM.getText().toString();
        String nama  = editTextNama.getText().toString();
        String kelas= editTextKelas.getText().toString();
        //ambil id radiogroup yang di select kondisinya
        int selectedId = radioGroup.getCheckedRadioButtonId();
        //inisialisasi radio yang id nya
        radioSexButton = (RadioButton)findViewById(selectedId);
        //ambil nilai dari radio yg di select

        String sesi = radioSexButton.getText().toString();
        //inisialisasi retrofite
        Retrofit retrofit = new Retrofit.Builder()
                            .baseUrl(URL)
                            .addConverterFactory(GsonConverterFactory.create())
                            .build();
        //panggil destinasi retrofite di interface RegisterAPI
        RegisterAPI api = retrofit.create(RegisterAPI.class);
        //panngil fungsi daftar di interface RegisterAPI dan masukan variabel yg sudah dimasukan variabel
        //Call<Value> tampung hasilnya di class Value
        Call<Value> call =api.daftar(npm,nama,sesi,kelas);
        //tampung di class Value
        call.enqueue(new Callback<Value>() {
            //ini tidak perlu semuanya diketik bisa generate dari code override
            @Override
            public void onResponse(Call<Value> call, Response<Value> response) {
                //panggil function getvalue yg menyimpan response value di Class value
                String value = response.body().getValue();
                //panggil function getmessage yg menyimpan response message di Class value
                String message = response.body().getMessage();
                //matikan progress
                progress.dismiss();
                //bilai nilai json value return 1
                if(value.equals("1")){
                    Toast.makeText(MainActivity.this,message,Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(MainActivity.this,message,Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<Value> call, Throwable t) {
                t.printStackTrace();
                progress.dismiss();
                Toast.makeText(MainActivity.this,"kesalahan jaringan",Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //bind butter knife disini
        ButterKnife.bind(this);


    }
}
