package edu.westga.cs6242.patrickdeaninvestmentcalculator;

import android.test.ActivityInstrumentationTestCase2;
import android.test.TouchUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivityTest extends ActivityInstrumentationTestCase2<MainActivity> {
    public MainActivityTest() {
         super(MainActivity.class);
    }

    /**
     * Tests to make sure the main actitivity exists
     */
    public void testActivityExists() {
        MainActivity a = new MainActivity();
        assertNotNull(a);
    }

    public void testCalculateFutureValueActionError() {
        MainActivity a = getActivity();
        final EditText PeriodicPayment = (EditText) a.findViewById(R.id.etPeriodicPayment);
        final EditText RatePerPeriod = (EditText) a.findViewById(R.id.etRatePerPeriod);
        final EditText NumberOfPeriods = (EditText) a.findViewById(R.id.etNumberOfPeriods);
        TextView Results = (TextView) a.findViewById(R.id.tvResults);
        getInstrumentation().runOnMainSync(new Runnable() {
            @Override
            public void run() {
                PeriodicPayment.requestFocus();
            }
        });
        getInstrumentation().waitForIdleSync();
        getInstrumentation().sendStringSync("0");
        getInstrumentation().waitForIdleSync();
        getInstrumentation().runOnMainSync(new Runnable() {
            @Override
            public void run() {
                RatePerPeriod.requestFocus();
            }
        });
        getInstrumentation().waitForIdleSync();
        getInstrumentation().sendStringSync("0.02");
        getInstrumentation().waitForIdleSync();
        getInstrumentation().runOnMainSync(new Runnable() {
            @Override
            public void run() {
                NumberOfPeriods.requestFocus();
            }
        });
        getInstrumentation().waitForIdleSync();
        getInstrumentation().sendStringSync("5");
        getInstrumentation().waitForIdleSync();
        Button btn = (Button) a.findViewById(R.id.btnCalculate);
        TouchUtils.clickView(this, btn);
        String results = Results.getText().toString();
        assertEquals("An error occured and the calculation could\n" +
                " not be performed.", results);
    }

    public void testCalculateFutureValueAction() {
        MainActivity a = getActivity();
        final EditText PeriodicPayment = (EditText) a.findViewById(R.id.etPeriodicPayment);
        final EditText RatePerPeriod = (EditText) a.findViewById(R.id.etRatePerPeriod);
        final EditText NumberOfPeriods = (EditText) a.findViewById(R.id.etNumberOfPeriods);
        TextView Results = (TextView) a.findViewById(R.id.tvResults);
        getInstrumentation().runOnMainSync(new Runnable() {
            @Override
            public void run() {
                PeriodicPayment.requestFocus();
            }
        });
        getInstrumentation().waitForIdleSync();
        getInstrumentation().sendStringSync("1000");
        getInstrumentation().waitForIdleSync();
        getInstrumentation().runOnMainSync(new Runnable() {
            @Override
            public void run() {
                RatePerPeriod.requestFocus();
            }
        });
        getInstrumentation().waitForIdleSync();
        getInstrumentation().sendStringSync("0.02");
        getInstrumentation().waitForIdleSync();
        getInstrumentation().runOnMainSync(new Runnable() {
            @Override
            public void run() {
                NumberOfPeriods.requestFocus();
            }
        });
        getInstrumentation().waitForIdleSync();
        getInstrumentation().sendStringSync("5");
        getInstrumentation().waitForIdleSync();
        Button btn = (Button) a.findViewById(R.id.btnCalculate);
        TouchUtils.clickView(this, btn);
        String results = Results.getText().toString();
        assertEquals("$5,204.04", results);
    }
}
