package com.example.connecttoesp8266;

import androidx.appcompat.app.AppCompatActivity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiManager;
import android.net.wifi.p2p.WifiP2pManager;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

public class CONNECTTOBOARD extends AppCompatActivity {
    WifiManager wifiManager;
    TextView TextView2, connectionStatusview;
    ListView listView;
    Button discoverybtn, wifibtn;
    WifiP2pManager mManager;
    private int size = 0;
    private List<ScanResult> results;
    private ArrayList<String> arrayList = new ArrayList<>();
    private ArrayAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_c_o_n_n_e_c_t_t_o_b_o_a_r_d);
        initialwork();
        exqlistener();
    }

    private void exqlistener() {
        wifibtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (wifiManager.isWifiEnabled()) {
                    wifibtn.setText("turn_wifi_off");
                    wifiManager.setWifiEnabled(false);
                } else if (!wifiManager.isWifiEnabled()) {
                    wifibtn.setText("turn_wifi_on");
                    wifiManager.setWifiEnabled(true);
                }
            }
        });
    }

    private void initialwork() {
        final Button wifibtn = (Button) findViewById(R.id.wifibtn);
        Button Discovery = (Button) findViewById(R.id.discoverybtn);
        wifiManager = (WifiManager) getApplicationContext().getSystemService(Context.WIFI_SERVICE);
        mManager = (WifiP2pManager) getSystemService(Context.WIFI_P2P_SERVICE);
    }
}



