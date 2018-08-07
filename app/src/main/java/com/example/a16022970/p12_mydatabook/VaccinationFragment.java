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

import org.w3c.dom.Text;


public class VaccinationFragment extends Fragment {
    private Button btnEdit;
    private TextView tvVacc;

    public VaccinationFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_bio, container, false);
        btnEdit = (Button) v.findViewById(R.id.btnEdit);
        tvVacc = (TextView) v.findViewById(R.id.tvVacc);


        btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LayoutInflater inflater = (LayoutInflater)
                        getActivity().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                LinearLayout vaccEdit =
                        (LinearLayout) inflater.inflate(R.layout.vaccination, null);
                final EditText vacc = (EditText) vaccEdit
                        .findViewById(R.id.etBio);

                AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                builder.setView(vaccEdit)
                        .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int id) {
                                String vaccEdited = vacc.getText().toString();
                                tvVacc.setText(vaccEdited);
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
