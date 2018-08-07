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


public class AboutFragment extends Fragment {
    private Button btnEdit;
    private TextView tvAbout;
    public AboutFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_about, container, false);
//        btnEdit = (Button)v.findViewById(R.id.btnEdit);
//        tvAbout = (TextView)v.findViewById(R.id.tvAbout);
//
//
//        btnEdit.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                LayoutInflater inflater = (LayoutInflater)
//                        getActivity().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
//                LinearLayout aboutEdit =
//                        (LinearLayout) inflater.inflate(R.layout.edit, null);
//                final EditText bio = (EditText) aboutEdit
//                        .findViewById(R.id.etAbout);
//
//                AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
//                builder.setView(aboutEdit)
//                        .setPositiveButton("OK", new DialogInterface.OnClickListener() {
//                            @Override
//                            public void onClick(DialogInterface dialog, int id) {
//                                String bioEdited = bio.getText().toString();
//                                tvAbout.setText(bioEdited);
//                            }
//                        })
//                        .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
//                            @Override
//                            public void onClick(DialogInterface dialog, int id) {
//                                dialog.dismiss();
//                            }
//                        });
//                AlertDialog alertDialog = builder.create();
//                alertDialog.show();
//            }
//        });
//
//        // Inflate the layout for this fragment
        return v;


    }

}
