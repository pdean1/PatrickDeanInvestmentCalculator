package edu.westga.cs6242.patrickdeaninvestmentcalculator;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;

import edu.westga.cs6242.patrickdeaninvestmentcalculator.model.InvestmentCalculator;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void calculateFutureAnnuity(View view) {
        EditText PeriodicPayment = (EditText) this.findViewById(R.id.etPeriodicPayment);
        EditText RatePerPeriod = (EditText) this.findViewById(R.id.etRatePerPeriod);
        EditText NumberOfPeriods = (EditText) this.findViewById(R.id.etNumberOfPeriods);
        TextView Results = (TextView) this.findViewById(R.id.tvResults);
        try
        {
            InvestmentCalculator fvc =
                    new InvestmentCalculator(Double.parseDouble(PeriodicPayment.getText().toString()),
                            Double.parseDouble(RatePerPeriod.getText().toString()),
                            Integer.parseInt(NumberOfPeriods.getText().toString()));
            DecimalFormat df = new DecimalFormat();
            df.setMaximumFractionDigits(2);
            Results.setText("$" + df.format(fvc.calculateFutureValueOfAnAnnuity()));
        } catch (Exception e) {
            Results.setText("An error occured and the calculation could\n not be performed.");
        }
    }
}
