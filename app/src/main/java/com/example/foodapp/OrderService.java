package com.example.foodapp;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.widget.EditText;
import android.widget.Toast;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class OrderService extends Service {
    public OrderService() {
    }

    Map<String, String> m = new HashMap<>();
    int Count1=0,Count2=0,Count3=0,Count4=0;
    int payment1=0,payment2=0,payment3=0,payment4=0;
    int total=0;

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");

    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        m.put("1. Masala Dosa", "60");
        m.put("2. Chicken Biriyani", "150");
        m.put("3. Paneer Butter Masala", "130");
        m.put("4. Burger combo", "110");
        m.put("Submit", "1");
        String fooditem = Objects.requireNonNull(intent.getExtras()).getString("food");
        String cost1 = intent.getExtras().getString("rate");

        assert cost1 != null;
        int cost = Integer.parseInt(cost1);

        if (m.containsKey(fooditem)) {
            assert fooditem != null;
            if (fooditem.equals("1. Masala Dosa")) {
                Count1 += 1;
                payment1 = Count1 * cost;
            }
            if (fooditem.equals("2. Chicken Biriyani")) {
                Count2 += 1;
                payment2 = Count2 * cost;
            }
            if (fooditem.equals("3. Paneer Butter Masala")) {
                Count3 += 1;
                payment3 = Count3 * cost;
            }
            if (fooditem.equals("4. Burger combo")) {
                Count4 += 1;
                payment4 = Count4 * cost;
            }
            if (fooditem.equals("Submit")) {
                total = payment1 + payment2 + payment3 + payment4;
                Toast.makeText(this, "Submitted", Toast.LENGTH_LONG).show();
                String result = Integer.valueOf(total).toString();
                Toast.makeText(this, result, Toast.LENGTH_LONG).show();
                Intent t2 = new Intent(this, ResultActivity.class);
                t2.putExtra("amount",result);
                t2.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(t2);
            }
        }
        return START_STICKY;
    }
}

