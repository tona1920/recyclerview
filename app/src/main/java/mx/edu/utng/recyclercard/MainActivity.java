package mx.edu.utng.recyclercard;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    //Declarar un Recycler y un Adaptador
    RecyclerView recyclerUsuarios;
    UsuarioAdaptador usuarioAdaptador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inicializarElementos();
    }

    private void inicializarElementos() {
        recyclerUsuarios = findViewById(R.id.recycler); // se asocia a la vista xml
        recyclerUsuarios.setLayoutManager(new LinearLayoutManager(this));

        List<Usuario> usuarioList = new ArrayList<>(); // se define la estructura de datos
        //para usar los metodos como add entre otros de la clase list

        //se cargaran los datos de prueba mediante un ciclo for
        //este ciclo puede cargar los datos de una fuente de datos como una base de datos
        for(int i=0; i<20; i++){
            usuarioList.add(new Usuario(i,
                    ("Nombre......"+ i),"ApellidoX", "mail@gmail.com",
                    "https://s22.postimg.cc/572fvlmg1/vlad-baranov-767980-unsplash.jpg"));
            Log.d("Msg","Se ha creado el objeto: "+usuarioList.size());
        }
        usuarioAdaptador = new UsuarioAdaptador(usuarioList,this);
        recyclerUsuarios.setAdapter(usuarioAdaptador);
        Log.d("Msg","El tamaño de la lista es: "+usuarioList.size());
    }
}