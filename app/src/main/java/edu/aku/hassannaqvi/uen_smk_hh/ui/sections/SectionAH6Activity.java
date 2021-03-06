package edu.aku.hassannaqvi.uen_smk_hh.ui.sections;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
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
import edu.aku.hassannaqvi.uen_smk_hh.databinding.ActivitySectionAh6Binding;
import edu.aku.hassannaqvi.uen_smk_hh.utils.Util;

public class SectionAH6Activity extends AppCompatActivity {

    ActivitySectionAh6Binding bi;
    boolean ah37_flag;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bi = DataBindingUtil.setContentView(this, R.layout.activity_section_ah6);
        bi.setCallback(this);
        setupSkips();
        setUIComponent();

    }

    private void setupSkips() {

        bi.ah41.setOnCheckedChangeListener(((radioGroup, i) -> {
            if (i == bi.ah41a.getId()) {
                bi.fldGrpCVah42.setVisibility(View.GONE);
                Clear.clearAllFields(bi.fldGrpCVah42);
            } else {
                bi.fldGrpCVah42.setVisibility(View.VISIBLE);
            }
        }));


        bi.ah42.setOnCheckedChangeListener(((radioGroup, i) -> {
            if (i == bi.ah42b.getId() || i == bi.ah42c.getId()) {
                bi.fldGrpCVah43.setVisibility(View.GONE);
                Clear.clearAllFields(bi.fldGrpCVah43);
            } else {
                bi.fldGrpCVah43.setVisibility(View.VISIBLE);
            }
        }));

        bi.ah43.setOnCheckedChangeListener(((radioGroup, i) -> {
            if (i == bi.ah43a.getId()) {
                Clear.clearAllFields(bi.fldGrpCVah44);
            }
        }));

        bi.ah45.setOnCheckedChangeListener(((radioGroup, i) -> {
            if (i != bi.ah45a.getId()) {
                Clear.clearAllFields(bi.fldGrpSecAH601);
            }
        }));

    }

    private void setUIComponent() {
        bi.ah37ac.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (TextUtils.isEmpty(bi.ah37ac.getText())) return;
                if (Integer.parseInt(bi.ah37ac.getText().toString()) >= 14) {
                    ah37_flag = true;
                    bi.fldGrpSecAH602.setVisibility(View.VISIBLE);

                } else {
                    bi.fldGrpSecAH602.setVisibility(View.GONE);
                    Clear.clearAllFields(bi.fldGrpSecAH602);
                    ah37_flag = false;
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
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
                startActivity(new Intent(this, ah37_flag ? SectionAH7Activity.class : SectionMActivity.class));
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
        int updcount = db.updatesAdolsColumn(AdolscentContract.SingleAdolscent.COLUMN_SAH3, MainApp.adolscent.getsAH3());
        if (updcount == 1) {
            return true;
        } else {
            Toast.makeText(this, "Updating Database... ERROR!", Toast.LENGTH_SHORT).show();
            return false;
        }
    }

    private void SaveDraft() throws JSONException {

        JSONObject json = new JSONObject();

        json.put("ah3701a", bi.ah3701a.isChecked() ? "1" : "-1");
        json.put("ah3701b", bi.ah3701b.isChecked() ? "2" : "-1");
        json.put("ah3701c", bi.ah3701c.isChecked() ? "3" : "-1");
        json.put("ah3701d", bi.ah3701d.isChecked() ? "4" : "-1");
        json.put("ah3701e", bi.ah3701e.isChecked() ? "5" : "-1");
        json.put("ah370196", bi.ah370196.isChecked() ? "96" : "-1");
        json.put("ah370196x", bi.ah370196x.getText().toString().trim().isEmpty() ? "-1" : bi.ah370196x.getText().toString());

        json.put("ah3702a", bi.ah3702a.isChecked() ? "1" : "-1");
        json.put("ah3702b", bi.ah3702b.isChecked() ? "2" : "-1");
        json.put("ah3702c", bi.ah3702c.isChecked() ? "3" : "-1");
        json.put("ah3702d", bi.ah3702d.isChecked() ? "4" : "-1");
        json.put("ah3702e", bi.ah3702e.isChecked() ? "5" : "-1");
        json.put("ah370296", bi.ah370296.isChecked() ? "96" : "-1");
        json.put("ah370296x", bi.ah370296x.getText().toString().trim().isEmpty() ? "-1" : bi.ah370296x.getText().toString());

        json.put("ah3703a", bi.ah3703a.isChecked() ? "1" : "-1");
        json.put("ah3703b", bi.ah3703b.isChecked() ? "2" : "-1");
        json.put("ah3703c", bi.ah3703c.isChecked() ? "3" : "-1");
        json.put("ah3703d", bi.ah3703d.isChecked() ? "4" : "-1");
        json.put("ah3703e", bi.ah3703e.isChecked() ? "5" : "-1");
        json.put("ah370396", bi.ah370396.isChecked() ? "96" : "-1");
        json.put("ah370396x", bi.ah370396x.getText().toString().trim().isEmpty() ? "-1" : bi.ah370396x.getText().toString());

        json.put("ah3704a", bi.ah3704a.isChecked() ? "1" : "-1");
        json.put("ah3704b", bi.ah3704b.isChecked() ? "2" : "-1");
        json.put("ah3704c", bi.ah3704c.isChecked() ? "3" : "-1");
        json.put("ah3704d", bi.ah3704d.isChecked() ? "4" : "-1");
        json.put("ah3704e", bi.ah3704e.isChecked() ? "5" : "-1");
        json.put("ah370496", bi.ah370496.isChecked() ? "96" : "-1");
        json.put("ah370496x", bi.ah370496x.getText().toString().trim().isEmpty() ? "-1" : bi.ah370496x.getText().toString());

        json.put("ah3705a", bi.ah3705a.isChecked() ? "1" : "-1");
        json.put("ah3705b", bi.ah3705b.isChecked() ? "2" : "-1");
        json.put("ah3705c", bi.ah3705c.isChecked() ? "3" : "-1");
        json.put("ah3705d", bi.ah3705d.isChecked() ? "4" : "-1");
        json.put("ah3705e", bi.ah3705e.isChecked() ? "5" : "-1");
        json.put("ah370596", bi.ah370596.isChecked() ? "96" : "-1");
        json.put("ah370596x", bi.ah370596x.getText().toString().trim().isEmpty() ? "-1" : bi.ah370596x.getText().toString());

        json.put("ah3706a", bi.ah3706a.isChecked() ? "1" : "-1");
        json.put("ah3706b", bi.ah3706b.isChecked() ? "2" : "-1");
        json.put("ah3706c", bi.ah3706c.isChecked() ? "3" : "-1");
        json.put("ah3706d", bi.ah3706d.isChecked() ? "4" : "-1");
        json.put("ah3706e", bi.ah3706e.isChecked() ? "5" : "-1");
        json.put("ah370696", bi.ah370696.isChecked() ? "96" : "-1");
        json.put("ah370696x", bi.ah370696x.getText().toString().trim().isEmpty() ? "-1" : bi.ah370696x.getText().toString());

        //    json.put("ah37aa", bi.ah37aa.getText().toString());
        json.put("ah37aa", bi.ah37aa.getText().toString().trim().isEmpty() ? "-1" : bi.ah37aa.getText().toString());
        json.put("ah37ab", bi.ah37ab.getText().toString().trim().isEmpty() ? "-1" : bi.ah37ab.getText().toString());
        json.put("ah37ac", bi.ah37ac.getText().toString().trim().isEmpty() ? "-1" : bi.ah37ac.getText().toString());

        json.put("ah38", bi.ah38a.isChecked() ? "1"
                : bi.ah38b.isChecked() ? "2"
                : "-1");

        json.put("ah3801", bi.ah3801a.isChecked() ? "1"
                : bi.ah3801b.isChecked() ? "2"
                : "-1");

        json.put("ah39a", bi.ah39a.isChecked() ? "1" : "-1");
        json.put("ah39b", bi.ah39b.isChecked() ? "2" : "-1");
        json.put("ah39c", bi.ah39c.isChecked() ? "3" : "-1");
        json.put("ah39d", bi.ah39d.isChecked() ? "4" : "-1");
        json.put("ah3996", bi.ah3996.isChecked() ? "96" : "-1");
        json.put("ah3996x", bi.ah3996x.getText().toString().trim().isEmpty() ? "-1" : bi.ah3996x.getText().toString());

        json.put("ah40a", bi.ah40a.isChecked() ? "1" : "-1");
        json.put("ah40b", bi.ah40b.isChecked() ? "2" : "-1");
        json.put("ah40c", bi.ah40c.isChecked() ? "3" : "-1");
        json.put("ah40d", bi.ah40d.isChecked() ? "4" : "-1");
        json.put("ah40e", bi.ah40e.isChecked() ? "5" : "-1");
        json.put("ah40f", bi.ah40f.isChecked() ? "6" : "-1");
        json.put("ah40g", bi.ah40g.isChecked() ? "7" : "-1");
        json.put("ah40h", bi.ah40h.isChecked() ? "8" : "-1");
        json.put("ah4096", bi.ah4096.isChecked() ? "96" : "-1");
        json.put("ah4096x", bi.ah4096x.getText().toString().trim().isEmpty() ? "-1" : bi.ah4096x.getText().toString());

        json.put("ah4001", bi.ah40aaa.isChecked() ? "1"
                : bi.ah40aab.isChecked() ? "2"
                : bi.ah40aac.isChecked() ? "3"
                : bi.ah40aad.isChecked() ? "4"
                : bi.ah40aae.isChecked() ? "5"
                : bi.ah40aaf.isChecked() ? "6"
                : bi.ah40aag.isChecked() ? "7"
                : bi.ah40aah.isChecked() ? "8"
                : bi.ah40aa96.isChecked() ? "96" : "-1");

        json.put("ah400196x", bi.ah40aa96x.getText().toString().trim().isEmpty() ? "-1" : bi.ah40aa96x.getText().toString());

        json.put("ah41", bi.ah41a.isChecked() ? "1"
                : bi.ah41b.isChecked() ? "2"
                : bi.ah41c.isChecked() ? "3"
                : "-1");

        json.put("ah42", bi.ah42a.isChecked() ? "1"
                : bi.ah42b.isChecked() ? "2"
                : bi.ah42c.isChecked() ? "3"
                : "-1");

        json.put("ah43", bi.ah43a.isChecked() ? "1"
                : bi.ah43b.isChecked() ? "2"
                : "-1");

        json.put("ah44a", bi.ah44a.isChecked() ? "1" : "-1");
        json.put("ah44b", bi.ah44b.isChecked() ? "2" : "-1");
        json.put("ah44c", bi.ah44c.isChecked() ? "3" : "-1");
        json.put("ah44d", bi.ah44d.isChecked() ? "4" : "-1");
        json.put("ah44e", bi.ah44e.isChecked() ? "5" : "-1");
        json.put("ah44f", bi.ah44f.isChecked() ? "6" : "-1");
        json.put("ah44g", bi.ah44g.isChecked() ? "7" : "-1");
        json.put("ah44h", bi.ah44h.isChecked() ? "8" : "-1");
        json.put("ah44i", bi.ah44i.isChecked() ? "9" : "-1");

        json.put("ah45", bi.ah45a.isChecked() ? "1"
                : bi.ah45b.isChecked() ? "2"
                : bi.ah45c.isChecked() ? "98"
                : "-1");

        json.put("ah46", bi.ah46a.isChecked() ? "1"
                : bi.ah46b.isChecked() ? "2"
                : bi.ah46c.isChecked() ? "98"
                : "-1");

        json.put("ah47", bi.ah47a.isChecked() ? "1"
                : bi.ah47b.isChecked() ? "2"
                : bi.ah47c.isChecked() ? "98"
                : "-1");

        json.put("ah48", bi.ah48a.isChecked() ? "1"
                : bi.ah48b.isChecked() ? "2"
                : bi.ah48c.isChecked() ? "3"
                : bi.ah48d.isChecked() ? "4"
                : "-1");

        MainApp.adolscent.setsAH3(String.valueOf(json));
    }

    private boolean formValidation() {
        return Validator.emptyCheckingContainer(this, bi.fldGrpSectionAH6);

    }

    @Override
    public void onBackPressed() {
        Toast.makeText(this, "You can't go back", Toast.LENGTH_SHORT).show();
    }
}
