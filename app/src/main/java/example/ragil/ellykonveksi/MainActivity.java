package example.ragil.ellykonveksi;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import example.ragil.ellykonveksi.dashboard.Dashboard;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void bukaDashboard(View view) {
        Intent dash = new Intent(this, Dashboard.class);
        startActivity(dash);
    }
}
