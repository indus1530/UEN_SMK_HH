package edu.aku.hassannaqvi.uen_smk_hh.ui.sections;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.validatorcrawler.aliazaz.Clear;
import com.validatorcrawler.aliazaz.Validator;

import org.json.JSONException;
import org.json.JSONObject;

import edu.aku.hassannaqvi.uen_smk_hh.R;
import edu.aku.hassannaqvi.uen_smk_hh.contracts.AdolscentContract;
import edu.aku.hassannaqvi.uen_smk_hh.core.DatabaseHelper;
import edu.aku.hassannaqvi.uen_smk_hh.core.MainApp;
import edu.aku.hassannaqvi.uen_smk_hh.databinding.ActivitySectionAh2Binding;
import edu.aku.hassannaqvi.uen_smk_hh.utils.JSONUtils;
import edu.aku.hassannaqvi.uen_smk_hh.utils.Util;

public class SectionAH2Activity extends AppCompatActivity {

    ActivitySectionAh2Binding bi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bi = DataBindingUtil.setContentView(this, R.layout.activity_section_ah2);
        bi.setCallback(this);
        setupSkips();

    }

    private void setupSkips() {

        bi.ah8.setOnCheckedChangeListener(((radioGroup, i) -> {
            if (i == bi.ah8c.getId()) {
                Clear.clearAllFields(bi.fldGrpSecAH201);
            }
        }));

        bi.ah12.setOnCheckedChangeListener(((radioGroup, i) -> {

            if (i == bi.ah12a.getId()) {

                Clear.clearAllFields(bi.fldGrpCVah13);
                bi.fldGrpCVah13.setVisibility(View.GONE);
                bi.fldGrpCVah13aa.setVisibility(View.VISIBLE);

            } else {

                Clear.clearAllFields(bi.fldGrpCVah13aa);
                bi.fldGrpCVah13aa.setVisibility(View.GONE);
                bi.fldGrpCVah13.setVisibility(View.VISIBLE);
            }

        }));

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
                startActivity(new Intent(this, SectionAH3Activity.class));
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
        int updcount = db.updatesAdolsColumn(AdolscentContract.SingleAdolscent.COLUMN_SAH1, MainApp.adolscent.getsAH1());
        if (updcount == 1) {
            return true;
        } else {
            Toast.makeText(this, "Updating Database... ERROR!", Toast.LENGTH_SHORT).show();
            return false;
        }
    }

    private void SaveDraft() throws JSONException {

        JSONObject json = new JSONObject();

        json.put("ah8", bi.ah8a.isChecked() ? "1"
                : bi.ah8b.isChecked() ? "2"
                : bi.ah8c.isChecked() ? "3"
                : "-1");

        json.put("ah9", bi.ah9a.isChecked() ? "1"
                : bi.ah9b.isChecked() ? "2"
                : bi.ah9c.isChecked() ? "3"
                : bi.ah9d.isChecked() ? "4"
                : bi.ah9e.isChecked() ? "5"
                : bi.ah9f.isChecked() ? "6"
                : bi.ah9g.isChecked() ? "7"
                : bi.ah9h.isChecked() ? "8"
                : "-1");

        json.put("ah10", bi.ah10a.isChecked() ? "1"
                : bi.ah10b.isChecked() ? "2"
                : bi.ah10c.isChecked() ? "3"
                : bi.ah10d.isChecked() ? "4"
                : "-1");

        json.put("ah11", bi.ah11a.getText().toString().trim().isEmpty() ? "-1" : bi.ah11a.getText().toString());

        json.put("ah12", bi.ah12a.isChecked() ? "1"
                : bi.ah12b.isChecked() ? "2"
                : "-1");

        json.put("ah13", bi.ah13a.isChecked() ? "1"
                : bi.ah13b.isChecked() ? "2"
                : "-1");

        json.put("ah1301", bi.ah13aaa.isChecked() ? "1"
                : bi.ah13aab.isChecked() ? "2"
                : bi.ah13aac.isChecked() ? "3"
                : "-1");

        try {

            JSONObject json_merge = JSONUtils.mergeJSONObjects(new JSONObject(MainApp.adolscent.getsAH1()), json);
            MainApp.adolscent.setsAH1(String.valueOf(json_merge));

        } catch (JSONException e) {
            e.printStackTrace();
        }

    }

    private boolean formValidation() {
        return Validator.emptyCheckingContainer(this, bi.fldGrpSectionAH2);

    }

    @Override
    public void onBackPressed() {
        Toast.makeText(this, "You can't go back", Toast.LENGTH_SHORT).show();
    }
}
