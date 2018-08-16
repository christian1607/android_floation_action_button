package ftc.sunafil.com.floatingactionbutton;

import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

public class MainActivity extends AppCompatActivity {
    private FloatingActionButton fabPlus;
    private FloatingActionButton fabAgregarEvidencia;
    private FloatingActionButton fabRegistrarContraste;

    Animation fabOpen,fabClose,fabRotate,fabRotateInverse;
    boolean isOpen;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fabPlus=findViewById(R.id.fabOpciones);
        fabAgregarEvidencia=findViewById(R.id.fabAgregarEvidencias);
        fabRegistrarContraste=findViewById(R.id.fabRegistrarContraste);

        fabOpen= AnimationUtils.loadAnimation(this,R.anim.fab_open);
        fabClose= AnimationUtils.loadAnimation(this,R.anim.fab_close);
        fabRotate= AnimationUtils.loadAnimation(this,R.anim.fab_rotate);
        fabRotateInverse= AnimationUtils.loadAnimation(this,R.anim.fab_inverse_rotate);


        fabPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(isOpen){
                    fabAgregarEvidencia.startAnimation(fabClose);
                    fabRegistrarContraste.startAnimation(fabClose);
                    fabPlus.startAnimation(fabRotateInverse);

                    fabAgregarEvidencia.setClickable(false);
                    fabRegistrarContraste.setClickable(false);
                    isOpen=false;
                }else{
                    fabAgregarEvidencia.startAnimation(fabOpen);
                    fabRegistrarContraste.startAnimation(fabOpen);
                    fabPlus.startAnimation(fabRotate);

                    fabAgregarEvidencia.setClickable(true);
                    fabRegistrarContraste.setClickable(true);
                    isOpen=true;
                }
            }
        });

    }
}
