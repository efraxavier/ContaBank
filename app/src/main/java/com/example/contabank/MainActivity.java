package com.example.contabank;// MainActivity.java
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import com.example.contabank.R;

public class MainActivity extends AppCompatActivity {

    private ContaBancaria conta;
    private RadioGroup radioGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        radioGroup = findViewById(R.id.radioGroup);

        // Initialize a ContaPoupanca or ContaEspecial based on RadioButton selection
        findViewById(R.id.btnCriarConta).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int selectedId = radioGroup.getCheckedRadioButtonId();
                RadioButton selectedRadioButton = findViewById(selectedId);

                if (selectedRadioButton.getId() == R.id.radioPoupanca) {
                    conta = new ContaPoupanca("Cliente Poupanca", 12345, 1000.0f, 1);
                } else if (selectedRadioButton.getId() == R.id.radioEspecial) {
                    conta = new ContaEspecial("Cliente Especial", 54321, 1000.0f, 500.0f);
                }

                Toast.makeText(MainActivity.this, "Conta criada: " + conta, Toast.LENGTH_SHORT).show();
            }
        });

        findViewById(R.id.btnSacar).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (conta != null) {
                    // Simulação de saque
                    conta.sacar(200.0f);
                    Toast.makeText(MainActivity.this, "Novo saldo: " + conta.getSaldo(), Toast.LENGTH_SHORT).show();
                }
            }
        });

        findViewById(R.id.btnDepositar).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (conta != null) {
                    // Simulação de depósito
                    conta.depositar(300.0f);
                    Toast.makeText(MainActivity.this, "Novo saldo: " + conta.getSaldo(), Toast.LENGTH_SHORT).show();
                }
            }
        });

        findViewById(R.id.btnCalcularRendimento).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (conta instanceof ContaPoupanca) {
                    ((ContaPoupanca) conta).calcularNovoSaldo(0.05f); // 5% de rendimento
                    Toast.makeText(MainActivity.this, "Novo saldo com rendimento: " + conta.getSaldo(), Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
