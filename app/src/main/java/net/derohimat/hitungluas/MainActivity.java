package net.derohimat.hitungluas;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * derohimat 18-10-2016
 * rohimatdeni@gmail.com
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setTitle("Hitung Luas Persegi Panjang");

        final EditText inpPanjang = (EditText) findViewById(R.id.inp_panjang);
        final EditText inpLebar = (EditText) findViewById(R.id.inp_lebar);
        final TextView txtLuas = (TextView) findViewById(R.id.txt_luas);
        Button btnHitung = (Button) findViewById(R.id.btn_hitung);

        btnHitung.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String panjang = inpPanjang.getText().toString().trim();
                String lebar = inpLebar.getText().toString().trim();

                if (panjang.equals(".")) {
                    inpPanjang.setError("Inputan Panjang salah");
                    inpPanjang.setFocusable(true);
                    return;
                }
                if (lebar.equals(".")) {
                    inpLebar.setError("Inputan Lebar salah");
                    inpLebar.setFocusable(true);
                    return;
                }

                if (TextUtils.isEmpty(panjang)) {
                    inpPanjang.setError("Panjang masih kosong");
                    inpPanjang.setFocusable(true);
                    return;
                }
                if (TextUtils.isEmpty(lebar)) {
                    inpLebar.setError("Lebar masih kosong");
                    inpLebar.setFocusable(true);
                    return;
                }

                double p = Double.parseDouble(panjang);
                double l = Double.parseDouble(lebar);

                double luas = p * l;

                txtLuas.setVisibility(View.VISIBLE);
                txtLuas.setText("Luas : " + luas);
            }
        });
    }
}