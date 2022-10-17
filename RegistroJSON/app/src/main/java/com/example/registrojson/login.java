package com.example.registrojson;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONException;

public class login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FIRST_SUB_WINDOW);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(login.this, registro.class);
                startActivity(intent);
                finish();
            }
        }, 8000);

        if (savedInstanceState == null) {
            getFragmentManager().beginTransaction()
                    .add(R.id.container, new PlaceholderFragment())
                    .commit();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public static class PlaceholderFragment extends Fragment implements View.OnClickListener {

        private TextView resultView;

        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.login, container, false);
            Button btn = (Button) rootView.findViewById(R.id.okID);
            btn.setOnClickListener(this);
            resultView = (TextView) rootView.findViewById(R.id.json_result);
            return rootView;
        }

        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.okID:

                    String result;
                    result = "";
                    TextView usuario = (TextView) getActivity().findViewById(R.id.passID);
                    TextView contraseña = (TextView) getActivity().findViewById(R.id.nameID);

                    String a, b;

                    a = usuario.getText().toString();
                    b = contraseña.getText().toString();

                    JSONObject json = new JSONObject();

                    try {
                        json.put("usuario", a);
                        json.put("contraseña", b);

                    } catch (JSONException error) {
                    }


                    resultView.setText(json.toString());
                    break;
            }

        }

    }
}