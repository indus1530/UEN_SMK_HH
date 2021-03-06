package edu.aku.hassannaqvi.uen_smk_hh.ui.sections;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.validatorcrawler.aliazaz.Clear;
import com.validatorcrawler.aliazaz.Validator;

import org.json.JSONException;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import edu.aku.hassannaqvi.uen_smk_hh.R;
import edu.aku.hassannaqvi.uen_smk_hh.contracts.AdolscentContract;
import edu.aku.hassannaqvi.uen_smk_hh.core.DatabaseHelper;
import edu.aku.hassannaqvi.uen_smk_hh.core.MainApp;
import edu.aku.hassannaqvi.uen_smk_hh.databinding.ActivitySectionAh1Binding;
import edu.aku.hassannaqvi.uen_smk_hh.utils.Util;

public class SectionAH1Activity extends AppCompatActivity {

    ActivitySectionAh1Binding bi;
    private DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bi = DataBindingUtil.setContentView(this, R.layout.activity_section_ah1);
        bi.setCallback(this);
        setupSkips();

        /*bi.txtLbl.setText(new StringBuilder(MainApp.selectedKishAdols.getName().toUpperCase()).append("\n")
                .append("Serial:")
                .append(MainApp.selectedKishAdols.getSerialno()));*/

        db = MainApp.appInfo.getDbHelper();
        List<String> adolescents = db.getAdolescent(MainApp.fc.get_UID());
        bi.adolescent.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_dropdown_item_1line, adolescents));
        bi.adolescent.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {

                if(!(bi.adolescent.getSelectedItem().toString() == "....")) {

                    // your code here
                    String merged_value = bi.adolescent.getSelectedItem().toString();
                    String[] merged_value_sep = merged_value.split(":");

                    Toast.makeText(getApplicationContext(), "Value1: " + merged_value_sep[0], Toast.LENGTH_SHORT).show();
                    Toast.makeText(getApplicationContext(), "Value2: " + merged_value_sep[1], Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                // your code here
            }

        });
    }

    private void setupSkips() {

        bi.ah1.setOnCheckedChangeListener(((radioGroup, i) -> {
            if (i == bi.ah1a.getId() || i == bi.ah1j.getId()) {
                Clear.clearAllFields(bi.fldGrpSecAH101);
            }
        }));

        bi.ah2.setOnCheckedChangeListener(((radioGroup, i) -> {
            if (i == bi.ah2b.getId()) {
                Clear.clearAllFields(bi.fldGrpCVah3);
            } else if (i == bi.ah2a.getId()) {
                Clear.clearAllFields(bi.fldGrpCVah4);
                Clear.clearAllFields(bi.fldGrpCVah7);
            }
        }));

        bi.ah1.setOnCheckedChangeListener(((radioGroup, i) -> {
            bi.ah3.clearCheck();

            bi.ah3a.setEnabled(true);
            bi.ah3b.setEnabled(true);
            bi.ah3c.setEnabled(true);
            bi.ah3d.setEnabled(true);
            bi.ah3e.setEnabled(true);
            bi.ah3f.setEnabled(true);

            if (i == bi.ah1c.getId()) {
                bi.ah3a.setEnabled(false);
            } else if (i == bi.ah1d.getId()) {
                bi.ah3a.setEnabled(false);
                bi.ah3b.setEnabled(false);
            } else if (i == bi.ah1e.getId()) {
                bi.ah3a.setEnabled(false);
                bi.ah3b.setEnabled(false);
                bi.ah3c.setEnabled(false);
            } else if (i == bi.ah1f.getId()) {
                bi.ah3a.setEnabled(false);
                bi.ah3b.setEnabled(false);
                bi.ah3c.setEnabled(false);
                bi.ah3d.setEnabled(false);
            } else if (i == bi.ah1g.getId()) {
                bi.ah3a.setEnabled(false);
                bi.ah3b.setEnabled(false);
                bi.ah3c.setEnabled(false);
                bi.ah3d.setEnabled(false);
                bi.ah3e.setEnabled(false);
            } else if (i == bi.ah1h.getId()) {
                bi.ah3a.setEnabled(false);
                bi.ah3b.setEnabled(false);
                bi.ah3c.setEnabled(false);
                bi.ah3d.setEnabled(false);
                bi.ah3e.setEnabled(false);
                bi.ah3f.setEnabled(false);
            }
        }));

        bi.ah796.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked)
                bi.ah796x.setVisibility(View.VISIBLE);
            else {
                Clear.clearAllFields(bi.ah796x);
                bi.ah796x.setVisibility(View.GONE);
            }
        });

        //h2080298
        bi.ah7i.setOnCheckedChangeListener((compoundButton, b) -> {

            if (b) {

                bi.ah7a.setChecked(false);
                bi.ah7b.setChecked(false);
                bi.ah7c.setChecked(false);
                bi.ah7d.setChecked(false);
                bi.ah7e.setChecked(false);
                bi.ah7f.setChecked(false);
                bi.ah7g.setChecked(false);
                bi.ah7h.setChecked(false);
                bi.ah796.setChecked(false);

                bi.ah7a.setEnabled(false);
                bi.ah7b.setEnabled(false);
                bi.ah7c.setEnabled(false);
                bi.ah7d.setEnabled(false);
                bi.ah7e.setEnabled(false);
                bi.ah7f.setEnabled(false);
                bi.ah7g.setEnabled(false);
                bi.ah7h.setEnabled(false);
                bi.ah796.setEnabled(false);

            } else {

                bi.ah7a.setEnabled(true);
                bi.ah7b.setEnabled(true);
                bi.ah7c.setEnabled(true);
                bi.ah7d.setEnabled(true);
                bi.ah7e.setEnabled(true);
                bi.ah7f.setEnabled(true);
                bi.ah7g.setEnabled(true);
                bi.ah7h.setEnabled(true);
                bi.ah796.setEnabled(true);
            }
        });
    }

    public void BtnContinue() {
        if (formValidation()) {
            try {
                SaveDraft();
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (UpdateDB()) {
                finish();
                startActivity(new Intent(this, SectionAH2Activity.class));
            } else {
                Toast.makeText(this, "Failed to Update Database!", Toast.LENGTH_SHORT).show();
            }
        }
    }

    public void BtnEnd() {

        Util.openEndActivity(this);
    }

    private boolean UpdateDB() {
        DatabaseHelper db = MainApp.appInfo.getDbHelper();
        long rowID = db.addAdolscent(MainApp.adolscent);
        if (rowID > 0) {
            MainApp.adolscent.set_ID(String.valueOf(rowID));
            MainApp.adolscent.setUID(MainApp.adolscent.getDeviceId() + MainApp.adolscent.get_ID());
            db.updatesAdolsColumn(AdolscentContract.SingleAdolscent.COLUMN_UID, MainApp.adolscent.getUID());
            return true;
        } else {
            Toast.makeText(this, "Updating Database... ERROR!", Toast.LENGTH_SHORT).show();
            return false;
        }
    }

    private void SaveDraft() throws JSONException {

        MainApp.adolscent = new AdolscentContract();
        MainApp.adolscent.set_UUID(MainApp.fc.get_UID());
        MainApp.adolscent.setDeviceId(MainApp.appInfo.getDeviceID());
        MainApp.adolscent.setDevicetagID(MainApp.fc.getDevicetagID());
        MainApp.adolscent.setFormDate(MainApp.fc.getFormDate());
        MainApp.adolscent.setUser(MainApp.fc.getUser());

        JSONObject json = new JSONObject();
        json.put("fm_uid", MainApp.selectedKishAdols.getUid());
        json.put("fm_serial", bi.adolescent.getSelectedItem().toString().split(":")[0].trim());
        json.put("fm_name", bi.adolescent.getSelectedItem().toString().split(":")[1].trim());
        json.put("hhno", MainApp.fc.getHhno());
        json.put("cluster_no", MainApp.fc.getClusterCode());
        json.put("_luid", MainApp.fc.getLuid());
        json.put("appversion", MainApp.appInfo.getAppVersion());
        json.put("sysdate", new SimpleDateFormat("dd-MM-yy HH:mm").format(new Date().getTime()));

        json.put("ah1", bi.ah1a.isChecked() ? "1"
                : bi.ah1b.isChecked() ? "2"
                : bi.ah1c.isChecked() ? "3"
                : bi.ah1d.isChecked() ? "4"
                : bi.ah1e.isChecked() ? "5"
                : bi.ah1f.isChecked() ? "6"
                : bi.ah1g.isChecked() ? "7"
                : bi.ah1h.isChecked() ? "8"
                : bi.ah1i.isChecked() ? "9"
                : bi.ah1j.isChecked() ? "99"
                : "-1");

        json.put("ah2", bi.ah2a.isChecked() ? "1"
                : bi.ah2b.isChecked() ? "2"
                : "-1");

        json.put("ah3", bi.ah3a.isChecked() ? "1"
                : bi.ah3b.isChecked() ? "2"
                : bi.ah3c.isChecked() ? "3"
                : bi.ah3d.isChecked() ? "4"
                : bi.ah3e.isChecked() ? "5"
                : bi.ah3f.isChecked() ? "6"
                : bi.ah3g.isChecked() ? "7"
                : bi.ah3other.isChecked() ? "96"
                : "-1");
        json.put("ah396x", bi.ah3otherx.getText().toString().trim().isEmpty() ? "-1" : bi.ah3otherx.getText().toString());

        json.put("ah4", bi.ah4.getText().toString().trim().isEmpty() ? "-1" : bi.ah4.getText().toString());

        json.put("ah5", bi.ah5a.isChecked() ? "1"
                : bi.ah5b.isChecked() ? "2"
                : "-1");

        json.put("ah6", bi.ah6a.isChecked() ? "1"
                : bi.ah6b.isChecked() ? "2"
                : bi.ah6c.isChecked() ? "3"
                : "-1");

        json.put("ah7a", bi.ah7a.isChecked() ? "1" : "-1");
        json.put("ah7b", bi.ah7b.isChecked() ? "2" : "-1");
        json.put("ah7c", bi.ah7c.isChecked() ? "3" : "-1");
        json.put("ah7d", bi.ah7d.isChecked() ? "4" : "-1");
        json.put("ah7e", bi.ah7e.isChecked() ? "5" : "-1");
        json.put("ah7f", bi.ah7f.isChecked() ? "6" : "-1");
        json.put("ah7g", bi.ah7g.isChecked() ? "7" : "-1");
        json.put("ah7h", bi.ah7h.isChecked() ? "8" : "-1");
        json.put("ah7i", bi.ah7i.isChecked() ? "9" : "-1");
        json.put("ah796", bi.ah796.isChecked() ? "96" : "-1");

        json.put("ah796x", bi.ah796x.getText().toString().trim().isEmpty() ? "-1" : bi.ah796x.getText().toString());

        MainApp.adolscent.setsAH1(String.valueOf(json));

    }

    private boolean formValidation() {
        return Validator.emptyCheckingContainer(this, bi.fldGrpSectionAH1);

    }

    @Override
    public void onBackPressed() {
        Toast.makeText(this, "You can't go back", Toast.LENGTH_SHORT).show();
    }
}
