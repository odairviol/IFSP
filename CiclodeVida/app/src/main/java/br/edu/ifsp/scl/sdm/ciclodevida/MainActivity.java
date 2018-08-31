package br.edu.ifsp.scl.sdm.ciclodevida;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private final String CDV_LOGCAT_TAG =  "CDV_LOGCAT_TAG";

    private TextView telefoneTextView;
    private EditText telefoneEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        telefoneTextView = new TextView(this);
        telefoneTextView.setText("Telefone");

        telefoneEditText = new EditText(this);
        telefoneTextView.setInputType(InputType.TYPE_CLASS_PHONE);

        if(savedInstanceState != null){
            String telefone = savedInstanceState.getString("TELEFONE", null);
            if(telefone != null){
                telefoneEditText.setText(telefone);
            }
        }

        LinearLayout linearLayout = findViewById(R.id.linearLayout);
        linearLayout.addView(telefoneTextView);
        linearLayout.addView(telefoneEditText);

        //Iniciando o ciclo de vida COMPLETO
        Log.v(CDV_LOGCAT_TAG, "onCreate: Iniciando ciclo COMPLETO");
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        if(savedInstanceState != null){
            String telefone = savedInstanceState.getString("TELEFONE", null);
            if(telefone != null){
                telefoneEditText.setText(telefone);
            }
        }
    }

    @Override
    protected void onStart() {
        super.onStart();

        //Iniciando o ciclo de vida VISÍVEL
        Log.v(CDV_LOGCAT_TAG, "onStart: Iniciando ciclo VISÍVEL");
    }

    @Override
    protected void onResume() {
        super.onResume();

        //Iniciando o ciclo de vida em PRIMEIRO PLANO
        Log.v(CDV_LOGCAT_TAG, "onResume: Iniciando ciclo EM PRIMEIRO PLANO");
    }

    @Override
    protected void onPause() {
        super.onPause();

        //Finalizando ciclo de vida em PRIMEIRO PLANO
        Log.v(CDV_LOGCAT_TAG, "onPause: Finalizando ciclo EM PRIMEIRO PLANO");
    }

    @Override
    protected void onStop() {
        super.onStop();

        //Finalizando o ciclo de vida VISÍVEL
        Log.v(CDV_LOGCAT_TAG, "onStop: Finalizando cliclo VISÍVEL");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        //Finalizando o cliclo de vida COMPLETO
        Log.v(CDV_LOGCAT_TAG, "onDestroy: Finalizando ciclo COMPLETO");
    }

    @Override
    protected void onRestart() {
        super.onRestart();

        //Preparando execução do onStart
        Log.v(CDV_LOGCAT_TAG, "onRestart: Preparando execução do onStart");
    }

    public void fecharTela(View botao){
        if(botao.getId() == R.id.button){
            finish();
        }
    }
}
