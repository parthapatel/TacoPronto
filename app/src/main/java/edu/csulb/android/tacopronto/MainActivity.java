package edu.csulb.android.tacopronto;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button orderbutton;
    RadioButton large, medium, corn, flour ;
    CheckBox beef, chicken, whitefish, cheese, seafood, rice, beans, picodegallo, guacamole, lbt;
    CheckBox soda, cerveza, margarita, tequila;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        orderbutton = (Button) findViewById(R.id.orderbutton);
        orderbutton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        double price = 0;
        String msg = "Order Details: ";

        large = (RadioButton) findViewById(R.id.large_rb);
        medium = (RadioButton) findViewById(R.id.medium_rb);
        corn = (RadioButton) findViewById(R.id.corn_rb);
        flour = (RadioButton) findViewById(R.id.flour_rb);

        beef = (CheckBox) findViewById(R.id.beef_cb);
        chicken = (CheckBox) findViewById(R.id.chicken_cb);
        whitefish = (CheckBox) findViewById(R.id.whitefish_cb);
        cheese = (CheckBox) findViewById(R.id.cheese_cb);
        seafood = (CheckBox) findViewById(R.id.seafood_cb);
        rice = (CheckBox) findViewById(R.id.rice_cb);
        beans = (CheckBox) findViewById(R.id.beans_cb);
        picodegallo = (CheckBox) findViewById(R.id.picodegallo_cb);
        guacamole = (CheckBox) findViewById(R.id.guacamole_cb);
        lbt = (CheckBox) findViewById(R.id.lbt_cb);

        soda = (CheckBox) findViewById(R.id.soda_cb);
        cerveza = (CheckBox) findViewById(R.id.cerveza_cb);
        margarita = (CheckBox) findViewById(R.id.margarita_cb);
        tequila = (CheckBox) findViewById(R.id.tequila_cb);

        if(large.isChecked()){
            price += 4;
            msg += "Large Taco";
        }
        if(medium.isChecked()){
            price += 3;
            msg += "Medium Taco";
        }

        msg += " With ";
        if(beef.isChecked()){
            price += 0.50;
            msg += "Beef, ";
        }
        if(chicken.isChecked()){
            price += 0.50;
            msg += "Chicken, ";
        }
        if(whitefish.isChecked()){
            price += 0.50;
            msg += "White Fish, ";
        }
        if(cheese.isChecked()){
            price += 0.50;
            msg += "Cheese, ";
        }
        if(seafood.isChecked()){
            price += 0.50;
            msg += "Sea Food, ";
        }
        if(rice.isChecked()){
            price += 0.50;
            msg += "Rice, ";
        }
        if(beans.isChecked()){
            price += 0.50;
            msg += "Beans, ";
        }
        if(picodegallo.isChecked()){
            price += 1;
            msg += "Pico De Gallo, ";
        }
        if(guacamole.isChecked()){
            price += 1;
            msg += "Guacamole, ";
        }
        if(lbt.isChecked()){
            price += 0.50;
            msg += "LBT, ";
        }

        if(corn.isChecked()){
            price += 1.5;
            msg += "\nTortila type: Corn ";
        }
        if(flour.isChecked()){
            price += 1;
            msg += "\nTortila type : Flour ";
        }

        msg += "\nBeverages : ";

        if(soda.isChecked()){
            price += 1;
            msg += "Soda ";
        }
        if(cerveza.isChecked()){
            price += 1;
            msg += "Cerveza ";
        }
        if(margarita.isChecked()){
            price += 1;
            msg += "Margarita ";
        }
        if(tequila.isChecked()){
            price += 1;
            msg += "Tequla ";
        }

        Toast.makeText(getApplicationContext(), "Total Price: " + price + msg, Toast.LENGTH_SHORT).show();


        System.out.println(msg);
        try {
            SmsManager smsManager = SmsManager.getDefault();
      //      smsManager.sendTextMessage("5627879941", null,
      //              msg + "\nTotal Price : " + price, null, null);
            ArrayList<String> splittedMessage = smsManager.divideMessage(msg + "\nTotal Price :" + price);
            smsManager.sendMultipartTextMessage("5627879941", null, splittedMessage, null, null);
       //     Toast.makeText(getApplicationContext(),"Order Placed!",Toast.LENGTH_LONG).show();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

}
