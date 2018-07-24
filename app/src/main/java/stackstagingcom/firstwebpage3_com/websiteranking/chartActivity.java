package stackstagingcom.firstwebpage3_com.websiteranking;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;

public class chartActivity extends AppCompatActivity {

    public static String TAG = "chartActivity";
    String [] siteName;
    float[] visitors;

    PieChart pieChart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chart);
        Log.d(TAG, "*** OnCreate method ***");

        pieChart = findViewById(R.id.pieChart);

        Description description = new Description();
        description.setTextColor(ColorTemplate.VORDIPLOM_COLORS[2]); description.setText("Sites by visit");
        pieChart.setDescription(description);
        pieChart.setRotationEnabled(true);
        pieChart.setHoleRadius(5f);
        pieChart.setTransparentCircleAlpha(0);
        pieChart.setCenterText("Sites by visit");
        pieChart.setCenterTextSize(14);
        pieChart.setCenterTextColor(000000);
        pieChart.setDrawEntryLabels(true);

        addDataSet();
    }

    public chartActivity(String[] siteName, float[] visitors) {
        this.siteName = siteName;
        this.visitors = visitors;
    }

    public void addDataSet() {
        Log.d(TAG, "*** addDataSet function ***");
        ArrayList<PieEntry> yEntry = new ArrayList<>();
        ArrayList<String> xEntry = new ArrayList<>();

        for (int i = 0; i<visitors.length; i++){
            yEntry.add(new PieEntry(visitors[i]));
        }

        for (int i = 0; i<siteName.length; i++){
            xEntry.add(siteName[i]);
        }

        //Data set
        PieDataSet pieDataSet = new PieDataSet(yEntry, "Sites by visit");
        pieDataSet.setSliceSpace(2);
        pieDataSet.setValueTextSize(12);

        //Data set colors
        ArrayList<Integer> colors = new ArrayList<>();
        colors.add(Color.BLUE);
        colors.add(Color.RED);
        colors.add(Color.GREEN);

        pieDataSet.setColors(colors);

        //Legend
        Legend legend = pieChart.getLegend();
        legend.setForm(Legend.LegendForm.CIRCLE);
        legend.setPosition(Legend.LegendPosition.LEFT_OF_CHART);

        //Pie data object
        PieData pieData = new PieData(pieDataSet);
        pieChart.setData(pieData);
        pieChart.invalidate();
    }
}