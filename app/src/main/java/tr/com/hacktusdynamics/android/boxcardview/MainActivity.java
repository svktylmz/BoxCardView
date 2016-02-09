package tr.com.hacktusdynamics.android.boxcardview;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.amulyakhare.textdrawable.TextDrawable;

import tr.com.hacktusdynamics.android.boxcardview.view.BoxCardView;

public class MainActivity extends AppCompatActivity {

    private ImageView iv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BoxCardView cardView1 = (BoxCardView) findViewById(R.id.cardView1);

        TextDrawable td = TextDrawable.builder()
                .beginConfig()
                    .width(60)
                    .height(60)
                .endConfig()
                .buildRound("3", Color.GREEN);
        cardView1.setImageDrawable(td);
        cardView1.setOnNormalButtonClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Card1 normal btn clicked", Toast.LENGTH_SHORT).show();
            }
        });

        iv =(ImageView) findViewById(R.id.iv);
        iv.setImageDrawable(td);

        final BoxCardView cardView2 =(BoxCardView) findViewById(R.id.cardView2);
        cardView2.setOnHighlightButtonClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Card2 Highlight btn clicked", Toast.LENGTH_SHORT).show();
                cardView2.setTitle("Highlight Title");
            }
        });
    }
}
