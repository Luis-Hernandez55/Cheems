package mx.itson.cheems;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    public int ubicacion = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        iniciar();

        Button btnIniciar = (Button) findViewById(R.id.btnReiniciar);
        btnIniciar.setOnClickListener(this);

        for (int i = 1; i <= 6; i++) {
            ImageButton btnSeleccion = (ImageButton) findViewById((
                    getResources().getIdentifier("opcion" + i, "id", this.getPackageName())));

            btnSeleccion.setOnClickListener(this);
        }
    }

    public void iniciar() {
        (findViewById(R.id.opcion1)).setBackgroundResource(R.drawable.icon_pregunta);
        (findViewById(R.id.opcion2)).setBackgroundResource(R.drawable.icon_pregunta);
        (findViewById(R.id.opcion3)).setBackgroundResource(R.drawable.icon_pregunta);
        (findViewById(R.id.opcion4)).setBackgroundResource(R.drawable.icon_pregunta);
        (findViewById(R.id.opcion5)).setBackgroundResource(R.drawable.icon_pregunta);
        (findViewById(R.id.opcion6)).setBackgroundResource(R.drawable.icon_pregunta);

        Random random = new Random();
        ubicacion = random.nextInt(5) + 1;
    }

    public void destapar(int opcion) {
        if (opcion == ubicacion) {
            //Ya perdió
            Toast.makeText(this, "¡PERDISTE!", Toast.LENGTH_LONG).show();

            for (int i = 1; i <= 6; i++) {
                // Iteramos cada carta (o botón)
                ImageButton btnSeleccion = (ImageButton) findViewById((
                        getResources().getIdentifier("opcion" + i, "id", this.getPackageName())));

                if (i == opcion) {
                    // Se destapa la carta mala del cheems llorando
                    btnSeleccion.setBackgroundResource(R.drawable.icon_cheems_llora);
                } else {
                    // Todas las cartas se destapan con el cheems normal
                    btnSeleccion.setBackgroundResource(R.drawable.icon_cheems);
                }
            }
        } else {
            // No perdió todavia, por lo tanto se destapa esa carta con el cheems normal
            ImageButton btnSeleccion = (ImageButton) findViewById((
                    getResources().getIdentifier("opcion" + opcion, "id", this.getPackageName())));
            btnSeleccion.setBackgroundResource(R.drawable.icon_cheems);
        }
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.opcion1) {
            destapar(1);
        } else if (view.getId() == R.id.opcion2) {
            destapar(2);
        } else if (view.getId() == R.id.opcion3) {
            destapar(3);
        } else if (view.getId() == R.id.opcion4) {
            destapar(4);
        } else if (view.getId() == R.id.opcion5) {
            destapar(5);
        } else if (view.getId() == R.id.opcion6) {
            destapar(6);
        }else if (view.getId() == R.id.btnReiniciar){
            iniciar();
        }
    }
}