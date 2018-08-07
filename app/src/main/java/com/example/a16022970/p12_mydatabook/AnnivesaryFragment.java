package com.example.a16022970.p12_mydatabook;

import android.content.Context;
import android.content.DialogInterface;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class AnnivesaryFragment extends Fragment {
private Button btnEdit;
private TextView tvAnnivesary;
    public AnnivesaryFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_annivesary, container, false);
        btnEdit = (Button)v.findViewById(R.id.btnEdit);
        tvAnnivesary = (TextView)v.findViewById(R.id.tvAnnivesary);


        btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LayoutInflater inflater = (LayoutInflater)
                        getActivity().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                LinearLayout anniEdit =
                        (LinearLayout) inflater.inflate(R.layout.annivesary, null);
                final EditText anni = (EditText) anniEdit
                        .findViewById(R.id.etAnni);

                AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                builder.setView(anniEdit)
                        .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int id) {
                                String anniEdited = anni.getText().toString();
                                tvAnnivesary.setText(anniEdited);
                            }
                        })
                        .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.dismiss();
                            }
                        });
                AlertDialog alertDialog = builder.create();
                alertDialog.show();
            }
        });

        // Inflate the layout for this fragment
        return v;

    }
}
