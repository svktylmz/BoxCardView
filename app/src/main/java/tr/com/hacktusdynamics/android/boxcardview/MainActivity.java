package tr.com.hacktusdynamics.android.boxcardview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import tr.com.hacktusdynamics.android.boxcardview.view.BoxCardView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BoxCardView cardView1 = (BoxCardView) findViewById(R.id.cardView1);
        cardView1.setOnNormalButtonClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Card1 normal btn clicked", Toast.LENGTH_SHORT).show();
            }
        });

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
