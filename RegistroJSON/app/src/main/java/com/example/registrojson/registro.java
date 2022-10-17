package com.example.registrojson;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.app.Activity;
import android.app.ActionBar;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.os.Build;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONException;

public class registro extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registro);
        if (savedInstanceState == null) {
        getFragmentManager().beginTransaction()
                .add(R.id.container, new login.PlaceholderFragment())
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
        Button btn = (Button) rootView.findViewById(R.id.okID2);
        btn.setOnClickListener(this);
        resultView = (TextView) rootView.findViewById(R.id.json_result);
        return rootView;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.okID2:

                String result;
                result = "";
                TextView usuarior = (EditText) getActivity().findViewById(R.id.IDnombre);
                TextView contraseñar = (EditText) getActivity().findViewById(R.id.idpass);
                TextView emailr = (EditText) getActivity().findViewById(R.id.email);
                TextView numeror = (EditText) getActivity().findViewById(R.id.IDtel);
                RadioButton hombre = (RadioButton) getActivity().findViewById(R.id.radioButton);
                RadioButton mujer = (RadioButton) getActivity().findViewById(R.id.radioButton2);
                RadioButton ninguno = (RadioButton) getActivity().findViewById(R.id.radioButton3);
                EditText nacimientor = (EditText) getActivity().findViewById(R.id.editTextDate);
                CheckBox alumno = (CheckBox) getActivity().findViewById(R.id.checkBox);
                CheckBox docente = (CheckBox) getActivity().findViewById(R.id.checkBox2);
                CheckBox personal = (CheckBox) getActivity().findViewById(R.id.checkBox3);

                String c, d, e, g, h, i, j, k, l, m;
                int f;

                c = usuarior.getText().toString();
                d = contraseñar.getText().toString();
                e = emailr.getText().toString();
                f = Integer.parseInt(numeror.getText().toString());
                g = hombre.getText().toString();
                h = mujer.getText().toString();
                i = ninguno.getText().toString();
                j = nacimientor.getText().toString();
                k = alumno.getText().toString();
                l = docente.getText().toString();
                m = personal.getText().toString();


                JSONObject json = new JSONObject();

                try {
                    json.put("usuario", c);
                    json.put("contraseña", d);
                    json.put("email", e);
                    json.put("número", f);
                    json.put("género", g);
                    json.put("género", h);
                    json.put("género", i);
                    json.put("nacimiento", j);
                    json.put("tipo", k);
                    json.put("tipo", l);
                    json.put("tipo", m);

                } catch (JSONException error) {
                }


                resultView.setText(json.toString());
                break;
        }

    }

}
}