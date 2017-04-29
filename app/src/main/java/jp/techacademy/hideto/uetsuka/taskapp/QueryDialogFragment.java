package jp.techacademy.hideto.uetsuka.taskapp;

import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

import io.realm.Realm;
import io.realm.RealmResults;

/**
 * Created by Airhead-Kangaroo on 2017/04/29.
 */

public class QueryDialogFragment extends android.app.DialogFragment {
    Spinner spinner;
    Button backBtn;
    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        View view = LayoutInflater.from(getActivity()).inflate(R.layout.querydialogfragment,null);
        spinner = (Spinner)view.findViewById(R.id.category_list);
        backBtn = (Button)view.findViewById(R.id.backBtn);
        setSpinner(spinner);
        setButton(backBtn);

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        return builder.setTitle("カテゴリー選択")
                .setView(view)
                .create();
    }

    private ArrayAdapter<String> getAdapter(){
        Realm realm = Realm.getDefaultInstance();
        RealmResults<Task> results = realm.where(Task.class).findAll();
        List<String> list = new ArrayList<>();
        for(int i=0;i<results.size();i++){
            boolean flag = true;
            for(int j=0;j<list.size();j++){
                if(list.get(j).equals(results.get(i).getCategory())){
                    flag = false;
                }
            }
            if(flag){
                list.add(results.get(i).getCategory());
            }
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<>(getActivity(),android.R.layout.simple_spinner_dropdown_item,list);
        return adapter;
    }

    private void setSpinner(Spinner spinner){
        spinner.setAdapter(getAdapter());
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Spinner sp = (Spinner)parent;
                MainActivity mainActivity = (MainActivity)getActivity();
                mainActivity.queryByCategory(String.valueOf(parent.getSelectedItem()));
                //dismiss();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    private void setButton(Button button){
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });
    }

}
