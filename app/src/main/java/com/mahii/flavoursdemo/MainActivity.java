package com.mahii.flavoursdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    TextView nameTV, typeTV;
    ListView itemsList;
    MyAdapter adapter;
    ArrayList<MyModel> myModels;
    String name, type;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initUI();
        makeCall();
    }

    protected void initUI() {
        nameTV = (TextView) findViewById(R.id.nameTV);
        typeTV = (TextView) findViewById(R.id.typeTV);
        itemsList = (ListView) findViewById(R.id.itemsList);
        myModels = new ArrayList<>();
    }

    public void makeCall() {
        CallService service = new CallService(MainActivity.this, Constants.BaseUrl, "GET", new CallService.OnServiceCall() {
            @Override
            public void onServiceCall(String response) {
                try {
                    JSONArray jsonArray = new JSONArray(response);
                    JSONObject jsonObject = jsonArray.getJSONObject(0);
                    name = jsonObject.getString("name");
                    type = jsonObject.getString("type");
                    JSONArray jArr = jsonObject.getJSONArray("item");
                    for (int i = 0; i < jArr.length(); i++) {
                        JSONObject innerJObj = jArr.getJSONObject(i);
                        MyModel myModel = new MyModel();
                        myModel.setGain(innerJObj.getString("gain"));
                        myModel.setItemNo(innerJObj.getString("itemNo"));
                        myModels.add(myModel);
                    }
                    nameTV.setText(String.format("Name : %s", name));
                    typeTV.setText(String.format("Type : %s", type));
                    adapter = new MyAdapter(MainActivity.this, myModels);
                    itemsList.setAdapter(adapter);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        });
        service.execute();
    }

}
